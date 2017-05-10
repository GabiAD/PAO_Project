package licitatii.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import licitatii.ManagerLiniiLicitatie;
import licitatii.Models.Licitation;
import licitatii.Models.Product;
import licitatii.Models.User;
import licitatii.Pachete.AddLicitationPacket;
import licitatii.Pachete.AdminLoginPacket;
import licitatii.Pachete.DeleteProductPacket;
import licitatii.Pachete.GetProductsPacket;
import licitatii.Pachete.LoginFailedPacket;
import licitatii.Pachete.LoginPacket;
import licitatii.Pachete.ProdusPacket;
import licitatii.Pachete.SumaNouaLicitatiePacket;

public class Client {

    private Socket socket = null;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private boolean conexiuneStabilita = false;
    private Thread liniiLicitatieThread;
    private ManagerLiniiLicitatie managerLiniiLicitatie;
    private User user = null;
    private int state = 0; // 0 = login; 1 = tab1; 2 = tab2; 3 = tab3;
    
    public Client(ManagerLiniiLicitatie managerLiniiLicitatie){
        this.managerLiniiLicitatie = managerLiniiLicitatie;
    }
    
    public boolean connectToServer(){
        
        
        try {
            socket = new Socket("localhost", 8080);
            
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            
        
        } catch (IOException ex) {
            ex.printStackTrace();
            conexiuneStabilita= false;
            
            JOptionPane.showMessageDialog(null, "Nu s-a putut face conexiunea la server. Incercati din nou mai tarziu.");
            return false;
            
        }
        
        conexiuneStabilita = true;
        
        return true;
    }
    
    public boolean login(String username, String password){
        
        try {
         
            LoginPacket lp = new LoginPacket(username, password);
            oos.writeObject(lp);
            oos.flush();
            
            Object raspuns = ois.readObject();
            
            if(raspuns.getClass() == LoginFailedPacket.class){
                JOptionPane.showMessageDialog(null, ((LoginFailedPacket)raspuns).getMessage());
                return false;
            }
            else{
                user = (User)raspuns;
                System.out.println(user.getName() + " " + user.getId());
            }
        
        } catch (IOException ex) {
            ex.printStackTrace();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pornesteEcranLicitatii();
        return true;
    }
    
    
    public boolean adminLogin(String username, String password){
        
        try {
         
            AdminLoginPacket lp = new AdminLoginPacket(username, password);
            oos.writeObject(lp);
            oos.flush();
            
            Object raspuns = ois.readObject();
            
            if(raspuns.getClass() == LoginFailedPacket.class){
                JOptionPane.showMessageDialog(null, ((LoginFailedPacket)raspuns).getMessage());
                return false;
            }
            else{
                user = (User)raspuns;
                System.out.println(user.getName());
            }
        
        } catch (IOException ex) {
            ex.printStackTrace();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        pornesteEcranLicitatii();
        return true;
    }
    
    public boolean conectat(){
        return conexiuneStabilita;
    }
    
    public void trimiteProduse(ArrayList<ProdusPacket> listaProduse){
        
        try {
            
            for (int i = 0; i < listaProduse.size(); i++) {
                oos.writeObject(listaProduse.get(i));
                oos.flush();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public LinieLicitatie primesteLinieLicitatie(){
        
        LinieLicitatie ll = null;
        
        try {
            
            ll = (LinieLicitatie)ois.readObject();
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ll;
    }
    
    public void trimiteSumaNouaLicitatiePacket(int index, int suma){
        SumaNouaLicitatiePacket snlp = new SumaNouaLicitatiePacket(index, suma);
        
        try {
            oos.writeObject(snlp);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void pornesteEcranLicitatii() {
        System.out.println("EcranLicitatii Pornit");
        
        liniiLicitatieThread = new Thread(new Runnable(){
            
            @Override
            public void run() {
                while(true){
                    try {
                        while(state == 1){
                            Object mesaj = ois.readObject();
                            if(mesaj.getClass() == LinieLicitatie.class)
                                managerLiniiLicitatie.addLine((LinieLicitatie) mesaj);
                        }
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        
        });
        
        liniiLicitatieThread.start();
        
//        LinieLicitatie ll = client.primesteLinieLicitatie();
//        manLiniiLic.addLine(ll);
       
    }
    
    public void opresteEcranLicitatii(){
        System.out.println("EcranLicitatii Oprit");
        
        if(!liniiLicitatieThread.isInterrupted()){
            liniiLicitatieThread.interrupt();    
        }
        
    }
    

    public void adaugaProdus(String titlu, int pret, String descriere, Icon icon) {
        try {
            
            Product produs = new Product(user.getId(), titlu, pret, descriere, icon);
            oos.writeObject(produs);
            oos.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public ArrayList<Product> getProducts() {
        
        GetProductsPacket produse = new GetProductsPacket();
        produse.setUser_id(user.getId());
        
        
        try {
            
            oos.writeObject(produse);
            oos.flush();
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            produse = (GetProductsPacket)ois.readObject();
        
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return produse.getProducts();
    }

    public void sendNewLicitation(ArrayList<Product> produse, Date data) {
        
        for (int i = 0; i < produse.size(); i++) {
            
            AddLicitationPacket licitPack = new AddLicitationPacket(new Licitation(produse.get(i).getId(), data));
            
            try {
            
                oos.writeObject(licitPack);
                oos.flush();
                
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }
    
    public void setState(int stateNou){
        state = stateNou;
    }

    public void stergeProdus(Product prod) {
        
        try {
            DeleteProductPacket delProd = new DeleteProductPacket();
            delProd.setProductId(prod.getUser_id());
            
            oos.writeObject(delProd);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}