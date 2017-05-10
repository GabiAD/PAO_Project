package licitatii.Server;

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
    private static final String password = "OmpasDBMaster33";

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
                    out.writeObject(handlerResponse);
                    out.flush();
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e){
            System.out.println(e);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.commit();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
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
                // return object
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

            ArrayList<User> users = User.queryUsers(con);

            loginMessage.setUsers(users);
            // return object
            return "Y";
        }
        LoginFailedPacket failMessage = new LoginFailedPacket("Invalid Message from Client");
        // return object
        return "N";
    }

    private Object adminOperationsHandler(Object message){
        return null;
    }

    private Object basicOperationHandler(Object message){
        if(message instanceof AddProductPacket){

        }
        else if(message instanceof GetProductsPacket){

        }
        return null;
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
