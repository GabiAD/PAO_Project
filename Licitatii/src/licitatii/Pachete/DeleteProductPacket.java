package licitatii.Pachete;


import java.io.Serializable;

public class DeleteProductPacket implements Serializable{
    private int productId;
    
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
