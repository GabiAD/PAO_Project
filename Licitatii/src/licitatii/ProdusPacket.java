package licitatii;

import java.io.Serializable;
import javax.swing.Icon;
import javax.swing.JLabel;


public class ProdusPacket implements Serializable{

    private String titlu;
    private int pret;
    private String nume;
    private String descriere;
    private Icon icon;
    private int zi = 0;
    private String luna = "";
    private int an = 0;
    private String ora = "";
    
    ProdusPacket(String t, int p, String n, String d, Icon i){
        titlu = t;
        pret = p;
        nume = n;
        descriere = d;
        icon = i;
    }
    
    public void setData(int z, String l, int a, String o){
        zi = z;
        luna = l;
        an = a;
        ora = o;
    }

    public int getZi() {
        return zi;
    }

    public String getLuna() {
        return luna;
    }

    public int getAn() {
        return an;
    }

    public String getOra() {
        return ora;
    }

    public Icon getIcon() {
        return icon;
    }

    public String getTitlu() {
        return titlu;
    }

    public int getPret() {
        return pret;
    }

    public String getNume() {
        return nume;
    }

    public String getDescriere() {
        return descriere;
    }
    
    
    
}
