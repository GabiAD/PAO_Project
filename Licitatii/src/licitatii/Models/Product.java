package licitatii.Models;

import java.awt.*;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by alex on 5/9/17.
 */
public class Product implements Serializable {

    private int id;
    private int user_id;
    private String name;
    private int price;
    private String image_path = "";
    private String description = "";
    private int licitaion_id = -1;

    public Product(int user_id, String name,
        int price){
        this.user_id = id;
        this.name = name;
        this.price = price;
    }

    public static void removeProduct(Product p, Connection conn) throws SQLException {
        removeProduct(p.getId(), conn);
    }
    public static void removeProduct(int p_id, Connection conn) throws SQLException {
        Statement s = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement(
                "REMOVE FROM products WHERE id = ?"
        );
        ps.setInt(1, p_id);

        ps.executeUpdate();
    }

    public static void addProduct(Product p, Connection conn) throws SQLException {
        Statement s = conn.createStatement();
        //save product image_path
        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO products " +
                        "(user_id, name, price, image_path, description) " +
                        "VALUES " +
                        "(?, ?, ?, ?, ?)"
        );

        ps.setInt(1, p.getUser_id());
        ps.setString(2, p.getName());
        ps.setInt(3, p.getPrice());
        ps.setString(4, p.getImage_path());
        ps.setString(5, p.getDescription());

        ps.executeUpdate();
//        non static version
//        ps.setInt(1, user_id);
//        ps.setString(2, name);
//        ps.setInt(3, price);
//        ps.setString(4, image_path);
//        ps.setString(5, description);
    }

    public static ArrayList<Product> queryProduct(int user_id, Connection conn) throws SQLException {
        return fetchQuery(
            conn,
            String.format("SELECT * FROM products WHERE user_id = \"%s\";", user_id)
        );
    }

    public static ArrayList<Product> queryProduct(Connection conn) throws SQLException {
        return fetchQuery(conn,"SELECT * FROM products");
    }

    private static ArrayList<Product> fetchQuery(Connection conn, String q) throws SQLException {
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(q);
        ArrayList<Product> products = new ArrayList<Product>();
        while(rs.next()){
            Product p = new Product(
                    rs.getInt("user_id"),
                    rs.getString("name"),
                    rs.getInt("price")
            );
            p.setId(rs.getInt("id"));
            p.setDescription(rs.getString("description"));
            p.setImage_path(rs.getString("image_path"));
            products.add(p);
        }
        return products;
    }

    private void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImage_path() {
        return image_path;
    }

    public String getDescription() {
        return description;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLicitaion_id() {
        return licitaion_id;
    }

    public void setLicitaion_id(int licitaion_id) {
        this.licitaion_id = licitaion_id;
    }
}
