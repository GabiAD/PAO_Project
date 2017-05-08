package licitatii;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LicitatiiServer {

    
    public static void main(String[] args) {

        ServerSocket ss = null;
        Socket socket = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        
        
        try {
            ss = new ServerSocket(8080);
            socket = ss.accept();
            
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            
            try {
                while(true){
                    LoginPacket lp = (LoginPacket)ois.readObject();

                    System.out.println(lp.getUsername() + " " + lp.getPassword());

                    oos.writeUTF("Y");
                    oos.flush();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LicitatiiServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        
        }
        catch (IOException ex) {
            try {
                ss.close();
                socket.close();
                ois.close();
            } catch (IOException ex1) {
                Logger.getLogger(LicitatiiServer.class.getName()).log(Level.SEVERE, null, ex1);
            }
            
        }
        
        try {
            ss.close();
            socket.close();
            ois.close();
        } catch (IOException ex1) {
            Logger.getLogger(LicitatiiServer.class.getName()).log(Level.SEVERE, null, ex1);
        }
        
        
    }
    
}
