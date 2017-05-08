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
                
        try {
            ss = new ServerSocket(8080);
            socket = ss.accept();
            
            ois = new ObjectInputStream(socket.getInputStream());
            
            while(true)
                System.out.println(ois.readUTF());
        
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
