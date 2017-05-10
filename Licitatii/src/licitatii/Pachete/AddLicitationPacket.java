package licitatii.Pachete;

import licitatii.Models.Licitation;

import java.io.Serializable;

/**
 * Created by alex on 5/9/17.
 */
public class AddLicitationPacket implements Serializable {
    private Licitation l;

    public AddLicitationPacket(Licitation l) {
        this.l = l;
    }
}
