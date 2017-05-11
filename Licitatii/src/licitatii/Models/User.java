package licitatii.Models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class User implements Serializable {

    private int id;
    private String name;
    private String username;
    private String password;

    public User(int id, String name, String username, String password){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public static User queryUser(String username, String password, Connection conn){
        Statement st = null;
        ResultSet rs = null;
        User u = null;
        try {
            st = conn.createStatement();
            rs = st.executeQuery(String.format("SELECT * FROM users " +
                    "WHERE username=\"%s\" " +
                    "AND password=\"%s\";", username, password));

            if (rs.first()) {
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("id"));
                u = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("password")
                );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Failed to close result set");
                e.printStackTrace();
            }

            try {
                st.close();
            } catch (SQLException e) {
                System.out.println("Failed to close statment");
                e.printStackTrace();
            }
        }

        return u;
    }

    public static ArrayList<User> queryUsers(Connection conn){
        ArrayList<User> users = new ArrayList<User>();
        Statement st = null;
        ResultSet rs = null;
        try {
            st = (Statement) conn.createStatement();
            rs = st.executeQuery("SELECT * FROM users");
            while(rs.next()){
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("username"),
                        rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Failed to close result set");
                e.printStackTrace();
            }

            try {
                st.close();
            } catch (SQLException e) {
                System.out.println("Failed to close statment");
                e.printStackTrace();
            }
        }

        return users;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

//    public static User queryUserByID(int user_id, Connection conn){
//        Statement st = null;
//        ResultSet rs = null;
//        User u = null;
//        try {
//            st = conn.createStatement();
//            rs = st.executeQuery("SELECT * FROM users WHERE id = \"" + user_id + "\";");
//            if( rs.first() ){
//                u = new User(
//                        rs.getInt("id"),
//                        rs.getString("name"),
//                        rs.getString("username"),
//                        rs.getString("password")
//                );
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                rs.close();
//            } catch (SQLException e) {
//                System.out.println("Failed to close result set");
//                e.printStackTrace();
//            }
//
//            try {
//                st.close();
//            } catch (SQLException e) {
//                System.out.println("Failed to close statment");
//                e.printStackTrace();
//            }
//        }
//
//        return u;
//    }
}
