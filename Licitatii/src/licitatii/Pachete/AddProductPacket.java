package licitatii.Pachete;

import licitatii.Models.Product;

import java.io.Serializable;

/**
 * Created by alex on 5/9/17.
 */
public class AddProductPacket implements Serializable {
    private Product p;

    public AddProductPacket(Product p) {
        this.p = p;
    }
}
