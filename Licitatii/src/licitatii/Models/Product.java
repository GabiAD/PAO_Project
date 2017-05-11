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

/**
 * Created by alex on 5/9/17.
 */
public class Product implements Serializable {

    private int id;
    private String title;
    private String owner_name;
    private int starting_price;
    private Icon icon;
    private String image_path;
    private String description;

    private Product(String title, int starting_price, String owner_name, String description){
        this.title = title;
        this.starting_price = starting_price;
        this.owner_name = owner_name;
        this.description = description;
    }

    public Product(String title, int starting_price, String owner_name, String description, Icon icon){
        this(title, starting_price,owner_name, description);
        this.icon = icon;
    }

    public Product(String title, int starting_price, String owner_name, String description, String image_path){
        this(title, starting_price,owner_name, description);
        this.image_path = image_path;
    }

    public void removeProduct(Connection conn){

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(
                    "DELETE FROM products WHERE id = ?"
            );
            ps.setInt(1, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Failed to delete product");
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Failed to close prepared statement");
            }
        }
    }

    public void addProduct(Connection conn){
        String path;
        if(icon != null) {
            path = saveIconToFile(icon);
        } else {
            path = "defaultNewObjectImage.png";
        }

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(
                    "INSERT INTO products " +
                            "(owner_name, title, starting_price, image_path, description) " +
                            "VALUES " +
                            "(?, ?, ?, ?, ?)"
            );
            ps.setString(1, owner_name);
            ps.setString(2, title);
            ps.setInt(3, starting_price);
            ps.setString(4, path);
            ps.setString(5, description);

            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Failed to add product");
            e.printStackTrace();
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                System.out.println("Failed to close prepared statement");
                e.printStackTrace();
            }
        }
    }

    public static ArrayList<Product> queryProducts(Connection conn){
        ArrayList<Product> products = new ArrayList<Product>();
        Statement s = null;
        ResultSet rs = null;
        try {
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM products WHERE id NOT IN " +
                    "(SELECT product_id FROM licitations)");
            while(rs.next()){
                Product p = new Product(rs.getString("title"),
                        rs.getInt("starting_price"), rs.getString("owner_name"),
                        rs.getString("description"), rs.getString("image_path"));
                p.setIcon(getIconFromFile(p.getImage_path()));
                products.add(p);
            }
        } catch (SQLException e) {
            System.out.println("Failed to fetch Products");
            e.printStackTrace();
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("Failed to close result set");
                e.printStackTrace();
            }

            try {
                s.close();
            } catch (SQLException e) {
                System.out.println("Failed to close statment");
                e.printStackTrace();
            }
        }

        return products;
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

    private static String saveIconToFile(Icon i){
        //save product image_path
        Image img = ((ImageIcon) i).getImage();

        BufferedImage bi = new BufferedImage(img.getWidth(null),img.getHeight(null),BufferedImage.TYPE_3BYTE_BGR);

        Graphics2D g2 = bi.createGraphics();
        g2.drawImage(img, 0, 0, null);
        g2.dispose();
        String path = (System.currentTimeMillis()) + ".jpg";
        try {
            ImageIO.write(bi, "jpg", new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return path;
    }

    public static Product queryProduct(int productId, Connection conn){
        Statement s = null;
        ResultSet rs = null;
        Product p = null;
        try {
            s = conn.createStatement();
            rs = s.executeQuery("SELECT * FROM products WHERE id = \"+" + productId + "\";");
//            String title, int starting_price, String owner_name, String description, Icon icon
            if(rs.first()){
                p = new Product(
                        rs.getString("title"),
                        rs.getInt("starting_price"),
                        rs.getString("owner_name"),
                        rs.getString("description"),
                        getIconFromFile(rs.getString("image_path"))
                );

            }
        } catch (SQLException e) {
            System.out.println("Failed to query product");
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                System.out.println("Failed to close statment");
                e.printStackTrace();
            }
        }
        return p;
    }

    private void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return starting_price;
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

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
}
