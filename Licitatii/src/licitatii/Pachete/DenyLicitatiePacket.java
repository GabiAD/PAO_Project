package licitatii.Pachete;

import java.io.Serializable;

public class DenyLicitatiePacket implements Serializable{

    String message;

    public DenyLicitatiePacket(String message) {
        this.message = message;
    }
}
