/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licitatii.Client;

import licitatii.ManagerLiniiLicitatie;
import licitatii.Pachete.ProdusPacket;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import licitatii.Client.Client;
import licitatii.Models.Product;

/**
 *
 * @author gabiad
 */
public class GUI_Client extends javax.swing.JFrame{

    private CardLayout cl;
    private JFileChooser fc;
    private Component licitatieUserComponent;
    private boolean anBisect = false;
    private String utilizator;
    private DefaultListModel listaProduseModel;
    private Client client;
    private ArrayList<Product> listaProduse = new ArrayList<Product>();
    private ManagerLiniiLicitatie manLiniiLic;
    
    public GUI_Client() {
        initComponents();
        
        cl = (CardLayout)container.getLayout();
        
//        licitatieGuestComponent = tabContainer.getComponentAt(3);
        
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        
        manLiniiLic = new ManagerLiniiLicitatie(listaLicitatii);
        
        client = new Client(manLiniiLic);
        
//        manLiniiLic.addLine("asdafsdds", 10);
//        manLiniiLic.addLine("asdafsdds2ewfsdgfgdfgfg", 20);
//        manLiniiLic.addLine("asdafsdds2ewfsdgfgdfgfg", 30);
//        manLiniiLic.addLine("asdafsdds2ewfsdgfgdfgfg", 40);
//        manLiniiLic.addLine("asdafsdds2ewfsdgfgdfgfg", 50);
//        
//        manLiniiLic.removeAt(2);
//        
//        manLiniiLic.addLine("asdafsdds2ewfsdgfgdfgfg", 60);
        
//        LinieLicitatie ll = new LinieLicitatie(listaLicitatii, "Asdfg");
//        ll.addLine();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        container = new javax.swing.JPanel();
        loginCard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginTF = new javax.swing.JTextField();
        passwordTF = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        adminButton = new javax.swing.JButton();
        afterLoginCard = new javax.swing.JPanel();
        licitatieUserPanel1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        listaLicitatii1 = new javax.swing.JPanel();
        logoutButton = new javax.swing.JButton();
        userName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        container.setForeground(new java.awt.Color(204, 204, 255));
        container.setLayout(new java.awt.CardLayout());

        loginCard.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setBackground(new java.awt.Color(153, 102, 0));
        jLabel1.setFont(new java.awt.Font("URW Chancery L", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Welcome!");

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));
        jPanel2.setForeground(new java.awt.Color(204, 204, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Password:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 95, 0, 0);
        jPanel2.add(jLabel3, gridBagConstraints);

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Username:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 95, 0, 0);
        jPanel2.add(jLabel2, gridBagConstraints);

        loginTF.setText("test1");
        loginTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginTFActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 152;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(50, 18, 0, 95);
        jPanel2.add(loginTF, gridBagConstraints);

        passwordTF.setText("test1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 152;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 18, 0, 95);
        jPanel2.add(passwordTF, gridBagConstraints);

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(25, 0, 50, 0);
        jPanel2.add(loginButton, gridBagConstraints);

        adminButton.setText("Admin Login");
        adminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginCardLayout = new javax.swing.GroupLayout(loginCard);
        loginCard.setLayout(loginCardLayout);
        loginCardLayout.setHorizontalGroup(
            loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginCardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(adminButton)
                .addContainerGap())
        );
        loginCardLayout.setVerticalGroup(
            loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginCardLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(adminButton)
                .addContainerGap())
        );

        container.add(loginCard, "card2");

        afterLoginCard.setBackground(new java.awt.Color(51, 51, 51));
        afterLoginCard.setForeground(new java.awt.Color(204, 204, 255));

        listaLicitatii1.setLayout(new java.awt.GridBagLayout());
        jScrollPane7.setViewportView(listaLicitatii1);

        javax.swing.GroupLayout licitatieUserPanel1Layout = new javax.swing.GroupLayout(licitatieUserPanel1);
        licitatieUserPanel1.setLayout(licitatieUserPanel1Layout);
        licitatieUserPanel1Layout.setHorizontalGroup(
            licitatieUserPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(licitatieUserPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                .addContainerGap())
        );
        licitatieUserPanel1Layout.setVerticalGroup(
            licitatieUserPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, licitatieUserPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        userName.setForeground(new java.awt.Color(255, 255, 255));
        userName.setText("Signed in as ...");

        javax.swing.GroupLayout afterLoginCardLayout = new javax.swing.GroupLayout(afterLoginCard);
        afterLoginCard.setLayout(afterLoginCardLayout);
        afterLoginCardLayout.setHorizontalGroup(
            afterLoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(afterLoginCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 617, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addContainerGap())
            .addGroup(afterLoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, afterLoginCardLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(licitatieUserPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        afterLoginCardLayout.setVerticalGroup(
            afterLoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(afterLoginCardLayout.createSequentialGroup()
                .addContainerGap(421, Short.MAX_VALUE)
                .addGroup(afterLoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton))
                .addContainerGap())
            .addGroup(afterLoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, afterLoginCardLayout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(licitatieUserPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(35, Short.MAX_VALUE)))
        );

        container.add(afterLoginCard, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_loginTFActionPerformed

    
    
    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        
        utilizator = loginTF.getText();
        
        if(!client.conectat()){
            client.connectToServer();
        }
        
        if(client.conectat() && client.login(utilizator, String.valueOf(passwordTF.getPassword()))){

            cl.show(container, "card3");        
            userName.setText("Logged in as ".concat(loginTF.getText()));


        }
//        tabContainer.remove(licitatieGuestComponent);
//        tabContainer.add("Liciteaza", licitatieUserComponent);
    }//GEN-LAST:event_loginButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        cl.show(container, "card2");
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void adminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButtonActionPerformed

        utilizator = loginTF.getText();

        if(!client.conectat()){
            client.connectToServer();
        }

        if(client.conectat() && client.adminLogin()){

            cl.show(container, "card3");
            userName.setText("Logged in as Admin");

            numeCumparatorLabel.setText("Licitati cu numele: ");
            jTextField1.setVisible(true);

        }
        //        tabContainer.remove(licitatieUserComponent);
        //        tabContainer.add("Liciteaza", licitatieGuestComponent);
    }//GEN-LAST:event_adminButtonActionPerformed

    private void setZile(int k){
        
        programareZiBox.removeAllItems();
        
        for (int i = 1; i <= k; i++) {
            programareZiBox.addItem(String.valueOf(i));
        }
    }
        
    // http://stackoverflow.com/questions/9417356/bufferedimage-resize
    public static BufferedImage getScaledImage(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }  

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Client().setVisible(true);
            }
        });
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminButton;
    private javax.swing.JPanel afterLoginCard;
    private javax.swing.JPanel container;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListProduseProgramare;
    private javax.swing.JList<String> jListProduseProgramare1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel licitatieUserPanel;
    private javax.swing.JPanel licitatieUserPanel1;
    private javax.swing.JPanel listaLicitatii;
    private javax.swing.JPanel listaLicitatii1;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginCard;
    private javax.swing.JTextField loginTF;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel numeCumparatorLabel;
    private javax.swing.JPasswordField passwordTF;
    private javax.swing.JComboBox<String> programareAnBox;
    private javax.swing.JComboBox<String> programareAnBox1;
    private javax.swing.JComboBox<String> programareLunaBox;
    private javax.swing.JComboBox<String> programareLunaBox1;
    private javax.swing.JComboBox<String> programareOraBox;
    private javax.swing.JComboBox<String> programareOraBox1;
    private javax.swing.JComboBox<String> programareZiBox;
    private javax.swing.JComboBox<String> programareZiBox1;
    private javax.swing.JButton programeazaButton;
    private javax.swing.JButton programeazaButton1;
    private javax.swing.JButton stergeProdusProgramareButton;
    private javax.swing.JButton stergeProdusProgramareButton1;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
}