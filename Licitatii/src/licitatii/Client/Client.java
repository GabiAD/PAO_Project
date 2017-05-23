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
import javax.swing.JTextField;

import licitatii.Models.Licitation;
import licitatii.Models.Product;
import licitatii.Models.User;
import licitatii.Pachete.*;

public class Client {

    private Socket socket = null;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private boolean conexiuneStabilita = false;
    private Thread liniiLicitatieThread;
    private ManagerLiniiLicitatie managerLiniiLicitatie;
    private User user = null;
    private ArrayList<User> useri;
    private JTextField numeClientParticipantAbsentTF = null;
    private JPanel listaLicitatii;
    
    public Client(ManagerLiniiLicitatie managerLiniiLicitatie, JPanel listaLicitatii){
        
        this.managerLiniiLicitatie = managerLiniiLicitatie;
        this.managerLiniiLicitatie.setClient(this);
        this.listaLicitatii = listaLicitatii;
        
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
    
    
    public boolean adminLogin(JTextField numeClientParticipantAbsent){
        
        this.numeClientParticipantAbsentTF = numeClientParticipantAbsent;
        System.out.println(":o    " + (numeClientParticipantAbsentTF == null));
        
        try {
            
            AdminLoginPacket lp = new AdminLoginPacket();
            oos.writeObject(lp);
            oos.flush();
            
            Object raspuns = ois.readObject();
            
            if(raspuns.getClass() == LoginFailedPacket.class){
                JOptionPane.showMessageDialog(null, ((LoginFailedPacket)raspuns).getMessage());
                return false;
            }
            else if(raspuns.getClass() == AdminLoginPacket.class){
                System.out.println("asdsadads");
                //useri = ((AdminLoginPacket)raspuns).getUsers();
                
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
        
        SumaNouaLicitatiePacket snlp = null;
                
        if(user != null)
            snlp = new SumaNouaLicitatiePacket(index, user.getName(), suma);
        else
            snlp = new SumaNouaLicitatiePacket(index, numeClientParticipantAbsentTF.getText(), suma);
        
        try {
            oos.writeObject(snlp);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void updateEcranLicitatii(){
        
        System.out.println("Ecran: updateing...");
        
        //synchronized(this){

            managerLiniiLicitatie.removeAll();

            
            GetLicitationsPacket pachetLicitatii = new GetLicitationsPacket();

            try {
                
                oos.writeObject(pachetLicitatii);
                oos.flush();
                
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {

                pachetLicitatii = (GetLicitationsPacket)ois.readObject();
                
                for (LinieLicitatiePacket llp:pachetLicitatii.getLicitationLine()) {

                    LinieLicitatie ll = new LinieLicitatie(llp.getProdus().getTitle(),
                            llp.getLicitatie().getLast_licitation_price(), llp.getProdus().getIcon(),
                            llp.getLicitatie().getProductId());

                    ll.setNumeLastUser(llp.getLicitatie().getWinner_name()); // ¯\\_(ツ)_/¯
                    
                    managerLiniiLicitatie.addLine(ll);
                }
                
                
            } catch (IOException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            listaLicitatii.revalidate();
            listaLicitatii.repaint();
            
        //}        
        
    }
    
    public void pornesteEcranLicitatii() {
        System.out.println("EcranLicitatii Pornit");
        
        updateEcranLicitatii();
        
        /*
        liniiLicitatieThread = new Thread(new Runnable(){
            
            @Override
            public void run() {
                while(true){
                    try {
                        
                            Object mesaj = ois.readObject();
                            //if(mesaj.getClass() == LinieLicitatie.class)
                            //    managerLiniiLicitatie.addLine((LinieLicitatie) mesaj);
                        
                        
                    } catch (IOException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }
        
        });
        */
        
        //liniiLicitatieThread.start();
        
//        LinieLicitatie ll = client.primesteLinieLicitatie();
//        manLiniiLic.addLine(ll);
       
    }
    
    public void opresteEcranLicitatii(){
        System.out.println("EcranLicitatii Oprit");
        /*
        if(!liniiLicitatieThread.isInterrupted()){
            liniiLicitatieThread.interrupt();    
        }
        */
    }
    

    public void adaugaProdus(String titlu, int pret, String descriere, Icon icon) {
        try {
            Product produs = new Product(titlu, pret, "#NUME HARDCODAT",descriere, icon);
            oos.writeObject(produs);
            oos.flush();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    public ArrayList<Product> getProducts() {
        
        GetProductsPacket produse = new GetProductsPacket();

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

    public void sendNewLicitation(Product produs, Date data) {

        AddLicitationPacket licitPack = new AddLicitationPacket(new Licitation(produs.getId(), data));
            
        try {

            oos.writeObject(licitPack);
            oos.flush();

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }



        
    }
    

    public void stergeProdus(Product prod) {
        
        try {
            DeleteProductPacket delProd = new DeleteProductPacket();
            delProd.setP(prod);
            
            oos.writeObject(delProd);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }


    public void logout() {

        try {

            oos.writeObject(new LogoutPacket());
            oos.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void anuntaSumaNoua(int indexLicitatie, int sumaNoua) {
        //System.out.println(indexLicitatie + " " + sumaNoua + " " + numeClientParticipantAbsentTF.getText());
        
        SumaNouaLicitatiePacket sumaNouaPack = null;
        
        if(user != null)
            sumaNouaPack = new SumaNouaLicitatiePacket(indexLicitatie, user.getName(), sumaNoua);
        else
            sumaNouaPack = new SumaNouaLicitatiePacket(indexLicitatie, numeClientParticipantAbsentTF.getText(), sumaNoua);
        
        try {
            
            oos.writeObject(sumaNouaPack);
            oos.flush();
        
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            Object pachetPrimit = ois.readObject();
            
            
            if(pachetPrimit instanceof ConfirmLicitatiePacket){
                ConfirmLicitatiePacket confirmare = (ConfirmLicitatiePacket)pachetPrimit;
                System.out.println("Confirmat");
                
            }
            else if(pachetPrimit instanceof DenyLicitatiePacket){
                JOptionPane.showMessageDialog(null, ((DenyLicitatiePacket)pachetPrimit).getMessage());
                
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        updateEcranLicitatii();
        
    }
}