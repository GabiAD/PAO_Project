package licitatii;

import java.awt.GridBagConstraints;
import java.util.ArrayList;
import javax.swing.JPanel;

public class ManagerLiniiLicitatie {
    
    private GridBagConstraints c;
    private ArrayList<LinieLicitatie> listaLinii = new ArrayList<LinieLicitatie>();
    private JPanel listaLicitatii;
    
    ManagerLiniiLicitatie(JPanel listaLicitatii){
        this.listaLicitatii = listaLicitatii;
        
        c = new GridBagConstraints();
        
    }
    
    
    public void addLine(String titlu, int pretStart){
        
        listaLinii.add(new LinieLicitatie(titlu, String.valueOf(pretStart)));
        listaLinii.get(listaLinii.size()-1).addToPanel(listaLicitatii, c, listaLinii.size()-1);
    }
    
    
}
