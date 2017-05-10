package licitatii;

import licitatii.Client.LinieLicitatie;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ManagerLiniiLicitatie {
    
    private GridBagConstraints c;
    private ArrayList<LinieLicitatie> listaLinii = new ArrayList<LinieLicitatie>();
    private JPanel listaLicitatii;
    
    public ManagerLiniiLicitatie(JPanel listaLicitatii){
        this.listaLicitatii = listaLicitatii;
        
        c = new GridBagConstraints();

    }
    
    
    public void addLine(LinieLicitatie linieLicitatie){
        listaLinii.add(linieLicitatie);
        listaLinii.get(listaLinii.size()-1).addToPanel(listaLicitatii, c, listaLinii.size()-1);
    }
    
    
    public void removeAt(int i){
        
        listaLinii.get(i).removeFromPanel(listaLicitatii);
        listaLinii.remove(i);
        
        for (int j = i; j < listaLinii.size(); j++) {
            listaLinii.get(j).move(listaLicitatii, c, listaLinii.get(j).getPozitie() - 1);
            
        }
        
    }
    
    
}
