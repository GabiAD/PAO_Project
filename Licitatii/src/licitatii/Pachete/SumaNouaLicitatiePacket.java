package licitatii.Pachete;

import java.io.Serializable;
import licitatii.Models.User;


public class SumaNouaLicitatiePacket implements Serializable{

    private int indexLicitatie = -1;
    private int sumaNoua = -1;
    private String nume;
    
    public SumaNouaLicitatiePacket(int i, String n, int s) {
        indexLicitatie = i;
        sumaNoua = s;
        nume = n;
    }

    public int getIndexLicitatie() {
        return indexLicitatie;
    }

    public int getSumaNoua() {
        return sumaNoua;
    }
    
    

    
    
}
