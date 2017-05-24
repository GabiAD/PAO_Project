package licitatii.Pachete;

import licitatii.Models.Licitation;
import licitatii.Models.Product;

import java.io.Serializable;

public class LinieLicitatiePacket implements Serializable {

    private Licitation licitatie; // licitatia
    private Product produs; // produsul din licitatie

    public LinieLicitatiePacket(Licitation l, Product p){
        licitatie = l;
        produs = p;
    }

    public Licitation getLicitatie() {
        return licitatie;
    }

    public Product getProdus() {
        return produs;
    }

}
