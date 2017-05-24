package licitatii.Models;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User implements Serializable {

    private int id;
    private String name;

    public User(int id, String name){
        this.id = id;
        this.name = name;
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
                        rs.getString("name")
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

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
