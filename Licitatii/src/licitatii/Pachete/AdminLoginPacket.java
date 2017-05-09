package licitatii.Pachete;

import licitatii.Models.User;

import java.util.ArrayList;

/**
 * Created by alex on 5/9/17.
 */
public class AdminLoginPacket {

    private ArrayList<User> users;

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
