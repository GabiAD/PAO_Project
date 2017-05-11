package licitatii.Pachete;

import java.io.Serializable;
import java.util.ArrayList;

public class GetLicitationsPacket implements Serializable {
    private ArrayList<LinieLicitatiePacket> licitationLine;

    public ArrayList<LinieLicitatiePacket> getLicitationLine() {
        return licitationLine;
    }

    public void setLicitationLine(ArrayList<LinieLicitatiePacket> licitationLine) {
        this.licitationLine = licitationLine;
    }
}
