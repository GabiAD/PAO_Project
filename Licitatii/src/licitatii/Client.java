
package licitatii;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

public class Client {

    private Socket socket = null;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    private boolean conexiuneStabilita = false;
    
    
    public boolean connectToServer(){
        
        
        try {
            socket = new Socket("localhost", 8080);
            
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        
        } catch (IOException ex) {
            
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
            
            if(ois.readUTF().compareTo("Y") != 0){
                JOptionPane.showMessageDialog(null, "Cont inexistent.");
                return false;
            }
        
        } catch (IOException ex) {
            ex.printStackTrace();
            
        }
        
     
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
    
    
}
