package licitatii.Pachete;

import javax.swing.Icon;
import licitatii.Models.Licitation;
import licitatii.Models.Product;
import licitatii.Models.User;

import java.io.Serializable;

public class LinieLicitatiePacket implements Serializable {

    private Icon icon;  // icon-ul corespunzator imaginii din product
    // private String titluStr; --- Product
    // private String descriere; --- Product
    // private int pretMaxim; --- Licitation
    
    // !!!!!!!! // private int indexLicitatie; --- Licitation.id  <== Trebuie scris
    
    private Licitation licitatie; // licitatia
    private Product produs; // produsul din licitatie

    public LinieLicitatiePacket(Icon ic, Licitation l, Product p){
        icon = ic; //scoate icon de aici, este in produs
        licitatie = l;
        produs = p;
    }

    public Icon getIcon() {
        return icon;
    }

    public Licitation getLicitatie() {
        return licitatie;
    }

    public Product getProdus() {
        return produs;
    }

}
