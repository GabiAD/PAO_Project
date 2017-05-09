/*

Raspuns cu "Y"(acceptat) / "N"(respins)
Trimis cu writeUTF("Y" / "N");

*/

package licitatii.Pachete;

import licitatii.Models.User;

import java.io.Serializable;

public class LoginPacket implements Serializable{

    private User user;
    private String username;
    private String password;
    
    public LoginPacket(String un, String ps){
        username = un;
        password = ps;
        
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
