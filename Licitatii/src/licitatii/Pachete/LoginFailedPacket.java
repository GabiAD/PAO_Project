package licitatii.Pachete;

import sun.rmi.runtime.Log;

/**
 * Created by alex on 5/9/17.
 */
public class LoginFailedPacket {

    private String message;

    public LoginFailedPacket(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
