package licitatii;


public class SumaNouaLicitatiePacket {

    private int indexLicitatie = -1;
    private int sumaNoua = -1;
    
    public SumaNouaLicitatiePacket(int i, int s) {
        indexLicitatie = i;
        sumaNoua = s;
    }

    public int getIndexLicitatie() {
        return indexLicitatie;
    }

    public int getSumaNoua() {
        return sumaNoua;
    }
    
    

    
    
}
