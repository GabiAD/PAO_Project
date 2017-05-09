package licitatii;

import com.mysql.jdbc.Statement;
import licitatii.Models.User;
import licitatii.Pachete.AdminLoginPacket;
import licitatii.Pachete.LoginFailedPacket;
import licitatii.Pachete.LoginPacket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by alex on 5/9/17.
 */
public class ServerHandler extends Thread {

    private Connection con;
    private String name;
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Boolean admin;
    private Boolean loggedId = false;

    public ServerHandler(Socket socket, Connection con) {
        this.socket = socket;
        this.con = con;
        System.out.println("Server Created");
    }

    public void run(){
        try {
            in = new ObjectInputStream(socket.getInputStream());
            out = new ObjectOutputStream(socket.getOutputStream());

            while (true) {
                Object message = in.readObject();
                if(!loggedId) {
                    String handlerResponse = loginHandler(message);
                    out.writeUTF(handlerResponse);
                    out.flush();
                }
                else {
                    if(admin){

                    } else {

                    }
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
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
            }
        }
    }
    private String loginHandler(Object message) throws SQLException, IOException {
        if (message instanceof LoginPacket) {
            LoginPacket loginMessage = (LoginPacket) message;

            Statement st = (Statement) this.con.createStatement();
            ResultSet rs = st.executeQuery(String.format("SELECT * FROM users " +
                    "WHERE username=\"%s\" " +
                    "AND password=\"%s\";", loginMessage.getUsername(), loginMessage.getPassword()));

            if (rs.first()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("id"));
                User user = new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("username"),
                    rs.getString("password")
                );
                loginMessage.setUser(user);
                // return object
                return "Y";
            } else {
                LoginFailedPacket failMessage = new LoginFailedPacket("Invalid Credentials");
                // return object
                return "N";
            }
        }
        if (message instanceof AdminLoginPacket){
            AdminLoginPacket loginMessage = (AdminLoginPacket) message;
            this.admin = true;

            ArrayList<User> users = new ArrayList<User>();
            Statement st = (Statement) this.con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM users");
            while(rs.next()){
                users.add(new User(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("username"),
                    rs.getString("password")
                ));
            }
            loginMessage.setUsers(users);
            // return object
            return "Y";
        }
        LoginFailedPacket failMessage = new LoginFailedPacket("Invalid Message from Client");
        // return object
        return "N";
    }

    private void adminOperationsHandler(){

    }

    private void basicOperationHandler(){

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
