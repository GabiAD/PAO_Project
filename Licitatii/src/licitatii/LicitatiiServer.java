package licitatii;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LicitatiiServer {

    public static void main(String[] args) throws SQLException, IOException {

        // Setup server
        ServerSocket ss = new ServerSocket(8080);

        try {
            while (true) {
                new ServerHandler(ss.accept()).start();
            }
        } finally {
            ss.close();
        }
        
        
    }
    
}
