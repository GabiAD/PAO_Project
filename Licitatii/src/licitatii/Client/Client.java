
package licitatii.Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import licitatii.ManagerLiniiLicitatie;
import licitatii.Models.User;
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
        
        newThreadPrimesteMesaje();
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
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void newThreadPrimesteMesaje() {
        
        liniiLicitatieThread = new Thread(new Runnable(){
            
            @Override
            public void run() {
                while(true){
                    
                    try {
                        
                        Object mesaj = ois.readObject();
                        
                        if(mesaj.getClass() == LinieLicitatie.class)
                            managerLiniiLicitatie.addLine((LinieLicitatie) mesaj);
                        
                        
                        
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
    
    
}
