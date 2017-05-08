/*

Raspuns cu "Y"(acceptat) / "N"(respins)
Trimis cu writeUTF("Y" / "N");

*/

package licitatii;

import java.io.Serializable;

public class LoginPacket implements Serializable{

    private String username;
    private String password;
    
    LoginPacket(String un, String ps){
        username = un;
        password = ps;
        
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
    
    
}
