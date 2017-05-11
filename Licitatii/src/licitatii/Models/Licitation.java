package licitatii.Models;

import licitatii.Client.LinieLicitatie;

import java.io.Serializable;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Licitation implements Serializable{

    private int product_id;
    private String start_time;
    private String last_lictation_time;
    private int last_licitation_price;
    private String winner_name;

    public Licitation(int product_id, Date start_time){
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.start_time = sdf.format(start_time);
        this.last_lictation_time = this.start_time;
        this.product_id = product_id;
    }

    public Licitation(int product_id, String start_time, String last_lictation_time, int last_licitation_price, String winner_name){
        this.product_id = product_id;
        this.start_time = start_time;
        this.last_lictation_time = last_lictation_time;
        this.last_licitation_price = last_licitation_price;
        this.winner_name = winner_name;
    }

    public void AddLiciatie(Connection conn) {
        last_licitation_price = GetLictationPrice(conn);
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(
                "INSERT INTO licitations " +
                    "(product_id, start_time, last_licitation_time, last_licitation_price) " +
                    "VALUES " +
                    "(?,?,?,?)"
            );
            ps.setInt(1, product_id);
            ps.setString(2, start_time);
            ps.setString(3, last_lictation_time);
            ps.setInt(4, last_licitation_price);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to add licitation");
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("Failed to close statment");
                e.printStackTrace();
            }
        }

    }

    private int GetLictationPrice(Connection conn){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement("SELECT price FROM products WHERE id = ?");
            ps.setInt(1,product_id);
            rs = ps.executeQuery();
            if(rs.first()) {
                int ret = rs.getInt("price");
                rs.close();
                return ret;
            }
            rs.close();
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
                ps.close();
            } catch (SQLException e) {
                System.out.println("Failed to close statment");
                e.printStackTrace();
            }
        }

        return 0;
    }

    public void UpdateLicitatie(int new_price, String user_name, Connection conn) {
        if (new_price <= GetLictationPrice(conn))
            return;
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date current_time = new Date();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(
                    "UPDATE products " +
                            "SET last_licitation_price = ?, last_licitation_time = ?, winner_name = ? " +
                            "WHERE product_id = ?;");
            ps.setInt(1, new_price);
            ps.setString(2, sdf.format(current_time));
            ps.setString(3, user_name);
            ps.setInt(4, this.product_id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to update lictation");
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("Failed to close statment");
                e.printStackTrace();
            }
        }
    }

    public static Licitation GetLicitation(int product_id, Connection conn) {
        Statement s = null;
        ResultSet rs = null;
        Licitation l = null;
        try {
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM products WHERE product_id = \""+product_id+"\";");
            if (rs.first()) {
                l = new Licitation(
                        rs.getInt("product_id"),
                        rs.getString("start_time"),
                        rs.getString("last_liciation_time"),
                        rs.getInt("last_licitation_price"),
                        rs.getString("winner_name")
                );
            }


        } catch (SQLException e) {
            System.out.println("Failed to get licitation");
            e.printStackTrace();
        } finally{
            try {
                s.close();
            } catch (SQLException e) {
                System.out.println("Failed to close statment");
                e.printStackTrace();
            }
            return l;
        }
    }

    public static ArrayList<Licitation> getLicitations(Connection conn){
        Statement s = null;
        ResultSet rs = null;
        ArrayList<Licitation> licitations = null;
        try {
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM licitations;");
            licitations = new ArrayList<Licitation>();
            while (rs.next()){
                licitations.add(new Licitation(
                        rs.getInt("product_id"),
                        rs.getString("start_time"),
                        rs.getString("last_liciation_time"),
                        rs.getInt("last_licitation_price"),
                        rs.getString("winner_name")
                ));
            }
        } catch (SQLException e) {
            System.out.println("Failed to get licitations");
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                System.out.println("Failed to close statment");
                e.printStackTrace();
            }
        }
        return licitations;
    }

    public int getProductId() {
        return product_id;
    }
}
