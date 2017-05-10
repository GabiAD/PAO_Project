package licitatii.Pachete;

import licitatii.Models.Product;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by alex on 5/9/17.
 */
public class GetProductsPacket implements Serializable {

    private ArrayList<Product> products;
    private int user_id;
    
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
    
    
}
