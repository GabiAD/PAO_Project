package licitatii.Pachete;

import javax.swing.Icon;
import licitatii.Models.Licitation;
import licitatii.Models.Product;
import licitatii.Models.User;

public class LinieLicitatiePacket {

    private Icon icon;  // icon-ul corespunzator imaginii din product
    // private String titluStr; --- Product
    // private String descriere; --- Product
    // private int pretMaxim; --- Licitation
    
    // !!!!!!!! // private int indexLicitatie; --- Licitation.id  <== Trebuie scris
    
    private Licitation licitatie; // licitatia
    private Product produs; // produsul din licitatie
    private User user; // user-ul care a licitat cel mai mult
    
    public LinieLicitatiePacket(Icon ic, Licitation l, User u, Product p){
        icon = ic;
        licitatie = l;
        user = u;
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

    public User getUser() {
        return user;
    }

    
    
}
