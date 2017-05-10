package licitatii.Pachete;

import licitatii.Models.Product;

/**
 * Created by alex on 5/10/17.
 */
public class DeleteProductPacket {
    private int productId;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
