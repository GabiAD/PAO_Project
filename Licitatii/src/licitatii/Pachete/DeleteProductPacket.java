package licitatii.Pachete;


import licitatii.Models.Product;

import java.io.Serializable;

public class DeleteProductPacket implements Serializable{
    private Product p;

    public Product getP() {
        return p;
    }

    public void setP(Product p) {
        this.p = p;
    }
}
