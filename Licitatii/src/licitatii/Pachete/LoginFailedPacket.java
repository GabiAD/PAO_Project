package licitatii.Pachete;

import sun.rmi.runtime.Log;

import java.io.Serializable;

/**
 * Created by alex on 5/9/17.
 */
public class LoginFailedPacket implements Serializable {

    private String message;

    public LoginFailedPacket(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
