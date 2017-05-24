package licitatii.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;

public class LicitatiiServer {

    public static void main(String[] args) throws SQLException, IOException {

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
