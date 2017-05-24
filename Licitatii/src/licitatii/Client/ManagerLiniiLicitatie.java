package licitatii.Client;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ManagerLiniiLicitatie {
    
    private GridBagConstraints c;
    private ArrayList<LinieLicitatie> listaLinii = new ArrayList<LinieLicitatie>();
    private JPanel listaLicitatii;
    private Client client = null;
    
    public ManagerLiniiLicitatie(JPanel listaLicitatii){
        this.listaLicitatii = listaLicitatii;

        c = new GridBagConstraints();
    }
    
    
    public void addLine(LinieLicitatie linieLicitatie){       
        listaLinii.add(linieLicitatie);
        listaLinii.get(listaLinii.size()-1).addActions(client);
        listaLinii.get(listaLinii.size()-1).addToPanel(listaLicitatii, c, listaLinii.size()-1);
    }


    public void removeAll() {


        for(LinieLicitatie linie: listaLinii){
            linie.removeFromPanel(listaLicitatii);
        }
        listaLinii.clear(); // = new ArrayList<LinieLicitatie>();

        listaLicitatii.revalidate();
        listaLicitatii.repaint();
        
    }
    
    public void setClient(Client client){
        this.client = client;
    }
    
}
