package licitatii.Models;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class Licitation implements Serializable{

    private int product_id;
    private String dt;
    private int price;
    private int user_id;

    public Licitation(){}

    public Licitation(int product_id, Date dt ){
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.dt = sdf.format(dt);
        this.product_id = product_id;
    }

    public static void AddLiciatie(Licitation l, Connection conn) throws SQLException {
        l.price = GetStartingPrice(l.product_id, conn);
        PreparedStatement ps = conn.prepareStatement(
            "INSERT INTO licitations " +
                "(start_time, product_id, price) " +
                "VALUES " +
                "(?,?,?)"
        );
        ps.setString(1, l.dt);
        ps.setInt(2, l.product_id);
        ps.setInt(3, l.price);
        ps.executeUpdate();
        //conn.commit();
    }

    public static int GetStartingPrice(int product_id ,Connection conn) throws SQLException {
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT price FROM products WHERE id = \""+product_id+"\";");
        if(rs.first())
            return rs.getInt("price");
        return 0;
    }

    public static void UpdateLicitatie(Licitation l, int price, int user_id, Connection conn) throws SQLException {
        PreparedStatement ps = conn.prepareStatement(
                "UPDATE products " +
                        "SET price = ?, user_id = ? " +
                        "WHERE product_id = ?;");
        ps.setInt(1, price);
        ps.setInt(2, user_id);
        ps.setInt(3, l.product_id);
        ps.executeUpdate();
        //conn.commit();
    }

    public static Licitation GetLicitation(int product_id, Connection conn) throws SQLException {
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM products WHERE product_id = \""+product_id+"\";");
        if (rs.first()){
            Licitation l = new Licitation();
            l.price = rs.getInt("price");
            l.dt = rs.getString("start_time");
            l.product_id = rs.getInt("product_id");
            return l;
        }
        return null;
    }

    public static ArrayList<Licitation> getLicitations(Connection conn) throws SQLException {
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM licitations;");
        ArrayList<Licitation> licitations = new ArrayList<Licitation>();
        while (rs.next()){
            Licitation l = new Licitation();
            l.price = rs.getInt("price");
            l.dt = rs.getString("start_time");
            l.product_id = rs.getInt("product_id");
            l.user_id = rs.getInt("user_id");
            licitations.add(l);
        }
        return licitations;
    }


    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getProductId() {
        return product_id;
    }
}
