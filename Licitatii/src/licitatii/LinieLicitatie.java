/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licitatii;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static licitatii.GUI.getScaledImage;

public class LinieLicitatie implements Serializable{
    
    private int indexLicitatie = -1;
    private JLabel imagine;
    private JLabel titlu;
    private JLabel pretMaxim;
    private JTextField pretClient;
    private JButton bidButton;
    private int pozitie = -1;
            
    LinieLicitatie(String titluStr, int pretMaximStr, Icon icon, int indexLicitatie){
        
        this.indexLicitatie = indexLicitatie;
        
        imagine = new JLabel();
        imagine.setPreferredSize(new Dimension(100, 100));
        
        BufferedImage bi = new BufferedImage(icon.getIconWidth(),
                                             icon.getIconHeight(),
                                             BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics();
        // paint the Icon to the BufferedImage.
        icon.paintIcon(null, g, 0,0);
        g.dispose();
        
           
        bi = getScaledImage(bi, 100, 100);
        imagine.setIcon(new ImageIcon(bi));

        
        titlu = new JLabel(titluStr);
        pretMaxim = new JLabel(String.valueOf(pretMaximStr));
        pretClient = new JTextField(6);
        bidButton = new JButton("Licitati");
        
    }
    
    public int getPozitie(){
        return pozitie;
    }
    
    public void addToPanel(JPanel listaLicitatii, GridBagConstraints c, int pozitie){
        
        this.pozitie = pozitie;
        
        c.insets = new Insets(10, 0, 10, 35);
        
        c.gridx = 0;
        c.gridy = pozitie;
        listaLicitatii.add(imagine, c);
        
        c.gridx = 1;
        c.gridy = pozitie;
        listaLicitatii.add(titlu, c);
        
        c.gridx = 2;
        c.gridy = pozitie;
        listaLicitatii.add(pretMaxim, c);
        
        c.gridx = 3;
        c.gridy = pozitie;
        listaLicitatii.add(pretClient, c);
        
        c.gridx = 4;
        c.gridy = pozitie;
        listaLicitatii.add(bidButton, c);
    }
    
    public void move(JPanel listaLicitatii, GridBagConstraints c, int pozitieNoua){
        removeFromPanel(listaLicitatii);
        addToPanel(listaLicitatii, c, pozitieNoua);
    }
    
    public void removeFromPanel(JPanel listaLicitatii){
        
        listaLicitatii.remove(imagine);
        listaLicitatii.remove(titlu);
        listaLicitatii.remove(pretMaxim);
        listaLicitatii.remove(pretClient);
        listaLicitatii.remove(bidButton);
    }
    
    public void setIndexLicitatie(int val){
        indexLicitatie = val;
    }
    
    public int getIndexLicitatie(){
        return indexLicitatie;
    }
    
    
    // http://stackoverflow.com/questions/9417356/bufferedimage-resize
    public BufferedImage getScaledImage(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
    
}
