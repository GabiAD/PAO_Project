package licitatii.Pachete;

import java.io.Serializable;

public class SumaNouaLicitatiePacket implements Serializable{

    private int indexLicitatie = -1;
    private int sumaNoua = -1;
    private String name;
    
    public SumaNouaLicitatiePacket(int i, String n, int s) {
        indexLicitatie = i;
        sumaNoua = s;
        name = n;
    }

    public int getIndexLicitatie() {
        return indexLicitatie;
    }

    public int getSumaNoua() {
        return sumaNoua;
    }


    public String getName() {
        return name;
    }
}
