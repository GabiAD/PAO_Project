package licitatii.Pachete;

import licitatii.Models.Product;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by alex on 5/9/17.
 */
public class GetProductsPacket implements Serializable {

    private ArrayList<Product> products;

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
