package licitatii.Pachete;

import java.io.Serializable;

public class DenyLicitatiePacket implements Serializable{

    private String message;

    public String getMessage() {
        return message;
    }

    public DenyLicitatiePacket(String message) {
        this.message = message;
    }
}
