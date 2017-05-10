package licitatii.Pachete;

import javax.swing.Icon;

public class LinieLicitatiePacket {

    Icon icon;
    String titluStr;
    String descriere;
    int pretMaxim;
    int indexLicitatie;
    
    public LinieLicitatiePacket(Icon ic, String t, String d, int p, int in){
        icon = ic;
        titluStr = t;
        descriere = d;
        pretMaxim = p;
        indexLicitatie = in;
    }

    public Icon getIcon() {
        return icon;
    }

    public String getTitluStr() {
        return titluStr;
    }

    public String getDescriere() {
        return descriere;
    }

    public int getPretMaxim() {
        return pretMaxim;
    }

    public int getIndexLicitatie() {
        return indexLicitatie;
    }
    
}
