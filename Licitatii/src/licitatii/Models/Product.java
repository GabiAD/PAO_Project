package licitatii.Models;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.nimbus.State;

/**
 * Created by alex on 5/9/17.
 */
public class Product implements Serializable {

    private int id;
    private int user_id;
    private String name;
    private int price;
    private Icon icon;
    private String image_path = "";
    private String description = "";

    public Product(int user_id, String name, int price){
        this.user_id = user_id;
        this.name = name;
        this.price = price;
    }

    public Product(int user_id, String name, int price, String decription, Icon icon){
        this.user_id = user_id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.icon = icon;
    }
    
    public static void removeProduct(Product p, Connection conn) throws SQLException {
        removeProduct(p.getId(), conn);
    }
    public static void removeProduct(int p_id, Connection conn) throws SQLException {
        Statement s = conn.createStatement();
        PreparedStatement ps = conn.prepareStatement(
                "DELETE FROM products WHERE id = ?"
        );
        ps.setInt(1, p_id);

        ps.executeUpdate();
        ps.close();

    }

    public static void addProduct(Product p, Connection conn) throws SQLException{
        //save product image_path
        ImageIcon i = (ImageIcon) p.getIcon();
        Image img = i.getImage();

        BufferedImage bi = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_3BYTE_BGR);

        Graphics2D g2 = bi.createGraphics();
        g2.drawImage(img, 0, 0, null);
        g2.dispose();
        String path = (System.currentTimeMillis())+ "_" + p.getUser_id() + ".jpg";
        try {
            ImageIO.write(bi, "jpg", new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        PreparedStatement ps = conn.prepareStatement(
                "INSERT INTO products " +
                        "(user_id, name, price, image_path, description) " +
                        "VALUES " +
                        "(?, ?, ?, ?, ?)"
        );

        ps.setInt(1, p.getUser_id());
        ps.setString(2, p.getName());
        ps.setInt(3, p.getPrice());
        ps.setString(4, path);
        ps.setString(5, p.getDescription());

        ps.executeUpdate();
        ps.close();
    }

    public static ArrayList<Product> queryProducts(int user_id, Connection conn) throws SQLException {
        return fetchQuery(
            conn,
            String.format("SELECT * FROM products WHERE user_id = \"%s\" AND id NOT IN " +
                    "(SELECT product_id FROM licitations)", user_id)
        );
    }

    public static ArrayList<Product> queryProducts(Connection conn) throws SQLException {
        return fetchQuery(conn,"SELECT * FROM products WHERE id NOT IN " +
                "(SELECT product_id FROM licitations)");
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
            p.setIcon(getIconFromFile(p.getImage_path()));
            products.add(p);
        }
        s.close();
        return products;
    }

    private void setIcon(Icon i) {
        icon = i;
    }

    private static Icon getIconFromFile(String path){
        BufferedImage bi = null;
        try
        {
            System.out.println(path);
            bi = ImageIO.read(new File(path));
            return new ImageIcon(bi);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static Product queryProduct(int productId, Connection conn) throws SQLException {
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT * FROM products WHERE id = \"+" + productId + "\";");
        if(rs.first()){
            Product p = new Product(
                    rs.getInt("user_id"),
                    rs.getString("name"),
                    rs.getInt("price")
            );
            p.setId(rs.getInt("id"));
            p.setDescription(rs.getString("description"));
            p.setIcon(getIconFromFile(rs.getString("image_path")));
            s.close();
            return p;
        }
        s.close();
        return null;
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

    public Icon getIcon() {
        return icon;
    }
}
