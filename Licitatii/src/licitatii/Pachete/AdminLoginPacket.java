package licitatii.Pachete;

import licitatii.Models.User;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by alex on 5/9/17.
 */
public class AdminLoginPacket implements Serializable {

    private ArrayList<User> users;
    private String username;
    private String password;
    
    public AdminLoginPacket(){
        
    }
    
    public AdminLoginPacket(String u, String p) {
        username = u;
        password = p;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
