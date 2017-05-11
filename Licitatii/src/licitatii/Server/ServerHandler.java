package licitatii.Server;

import licitatii.Models.Licitation;
import licitatii.Models.Product;
import licitatii.Models.User;
import licitatii.Pachete.*;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by alex on 5/9/17.
 */
public class ServerHandler extends Thread {

    private static final String url = "jdbc:mysql://localhost/pao";
    private static final String user = "root";
    private static final String password = "root";

    private Connection con;
    private String name;
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Boolean admin;
    private Boolean loggedId = false;

    public ServerHandler(Socket socket) throws SQLException {
        this.socket = socket;
        // Establish connection with mysql
        this.con = DriverManager.getConnection(url, user, password);
        
    }

    public void run(){
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                Object message = in.readObject();
                if(!loggedId) {
                    Object handlerResponse = loginHandler(message);
                    out.writeObject(handlerResponse);
                    out.flush();
                }
                else {
                    Object handlerResponse;
                    if(admin){
                        handlerResponse = adminOperationsHandler(message);
                    } else {
                        handlerResponse = basicOperationHandler(message);
                    }
                    if (handlerResponse != null) {
                        out.writeObject(handlerResponse);
                        out.flush();
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Unexpected error on client input/output streams");
        } catch (ClassNotFoundException e){
            System.out.println("There was a problem decoding message from client");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Mysql exception");
        } finally {
            try {
                con.commit();
            } catch (SQLException e) {
                System.out.println("Failed to commit session");
            }

            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Failed to close mysql connection");
            }

            try {
                in.close();
                out.close();
            } catch (IOException e) {
                System.out.println("Failed to close socket files");
            }

            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Failed to close socket");
            }
        }
    }
    private Object loginHandler(Object message) throws SQLException, IOException {
        if (message instanceof LoginPacket) {
            LoginPacket loginMessage = (LoginPacket) message;

            User user = User.queryUser(
                loginMessage.getUsername(),
                loginMessage.getPassword(),
                con
            );

            if(user != null){
                loggedId = true;
                admin = false;
                return user;
            } else {
                LoginFailedPacket failMessage = new LoginFailedPacket("Invalid Credentials");
                // return object
                return failMessage;
            }
        }
        else if (message instanceof AdminLoginPacket){
            AdminLoginPacket loginMessage = (AdminLoginPacket) message;
            this.admin = true;
            this.loggedId = true;
            ArrayList<User> users = User.queryUsers(con);

            loginMessage.setUsers(users);
            // return object
            return loginMessage;
        }
        LoginFailedPacket failMessage = new LoginFailedPacket("Invalid Message from Client");
        // return object
        return failMessage;
    }

    private Object adminOperationsHandler(Object message){
        return null;
    }

    private Object basicOperationHandler(Object message) throws SQLException {
        if(message instanceof Product){
            Product productMessage = (Product) message;
            Product.addProduct(productMessage, con);
            return null;
        } else if(message instanceof GetProductsPacket){
            GetProductsPacket getProductsMessage = (GetProductsPacket) message;
            getProductsMessage.setProducts(
                Product.queryProducts(
                    getProductsMessage.getUser_id(),
                    con
                )
            );
            return getProductsMessage;
        } else if(message instanceof AddLicitationPacket){
            AddLicitationPacket addLicitationMessage = (AddLicitationPacket) message;
            Licitation.AddLiciatie(addLicitationMessage.getL(), con);
            return null;
        } else if(message instanceof GetLicitationsPacket){
            GetLicitationsPacket getLicitationsMessage = (GetLicitationsPacket) message;
            ArrayList<Licitation> licitations = Licitation.getLicitations(con);
            ArrayList<LinieLicitatiePacket> licitationPackets = new ArrayList<LinieLicitatiePacket>();
            for(Licitation l:licitations){
                User u = null;
                if(l.getUser_id() != 0)
                    u = User.queryUserByID(l.getUser_id(), con);
                Product p = Product.queryProduct(l.getProductId(), con);

                LinieLicitatiePacket llp = new LinieLicitatiePacket(null, l, u, p);
                licitationPackets.add(llp);
            }
            getLicitationsMessage.setLicitationLine(licitationPackets);
            return getLicitationsMessage;
        } else if(message instanceof  DeleteProductPacket){
            DeleteProductPacket deleteProductMessage = (DeleteProductPacket) message;
            Product.removeProduct(deleteProductMessage.getProductId(), con);
            return null;
        } else {
            return null;
        }
    }


    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String user = resultSet.getString("username");
            String website = resultSet.getString("password");
            String summary = resultSet.getString("name");
            System.out.println("User: " + user);
            System.out.println("Website: " + website);
            System.out.println("summary: " + summary);
        }
    }
}
