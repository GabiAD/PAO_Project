package licitatii.Pachete;

import licitatii.Models.Licitation;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by alex on 5/10/17.
 */
public class GetLicitationsPacket implements Serializable {
    private ArrayList<Licitation> licitations;

    public ArrayList<Licitation> getLicitations() {
        return licitations;
    }

    public void setLicitations(ArrayList<Licitation> licitations) {
        this.licitations = licitations;
    }
}
