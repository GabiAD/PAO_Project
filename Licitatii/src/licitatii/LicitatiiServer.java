package licitatii;

import licitatii.Pachete.LoginPacket;
import licitatii.Pachete.ProdusPacket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LicitatiiServer {

    private static final String url = "jdbc:mysql://localhost/pao";
    private static final String user = "root";
    private static final String password = "root";
    
    public static void main(String[] args) throws SQLException, IOException {

        // Establish connection with mysql
        Connection con = DriverManager.getConnection(url, user, password);

        // Setup server
        ServerSocket ss = new ServerSocket(8080);

        try {
            while (true) {
                new ServerHandler(ss.accept(), con).start();
            }
        } finally {
            ss.close();
        }
        
        
    }
    
}
