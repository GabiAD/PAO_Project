/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package licitatii;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/**
 *
 * @author gabiad
 */
public class GUI extends javax.swing.JFrame {

    private CardLayout cl;
    private JFileChooser fc;
    private Component licitatieUserComponent;
    private Component licitatieGuestComponent;
    private boolean anBisect = false;
    
    public GUI() {
        initComponents();
        resetAddObject();
        
        cl = (CardLayout)container.getLayout();
        
        licitatieUserComponent = tabContainer.getComponentAt(2);
        licitatieGuestComponent = tabContainer.getComponentAt(3);
        
        
        System.out.println("asad");
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        
        programareAnBox.addItem(dateFormat.format(date));
        programareAnBox.addItem(Integer.toString(Integer.parseInt(dateFormat.format(date))+1));
        programareAnBox.addItem(Integer.toString(Integer.parseInt(dateFormat.format(date))+2));
        programareAnBox.addItem(Integer.toString(Integer.parseInt(dateFormat.format(date))+3));
        
        setZile(31);
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
        jPasswordField2 = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        guestButton = new javax.swing.JButton();
        afterLoginCard = new javax.swing.JPanel();
        tabContainer = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        programareAnBox = new javax.swing.JComboBox<>();
        programareLunaBox = new javax.swing.JComboBox<>();
        programareZiBox = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        adaugaButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        imgLabel = new javax.swing.JLabel();
        titluTF = new javax.swing.JTextField();
        pretTF = new javax.swing.JTextField();
        numeVanzatorTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriereTF = new javax.swing.JTextArea();
        licitatieUserPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        licitatieGuestPanel = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
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
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 152;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 18, 0, 95);
        jPanel2.add(jPasswordField2, gridBagConstraints);

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

        guestButton.setText("Guest");
        guestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guestButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout loginCardLayout = new javax.swing.GroupLayout(loginCard);
        loginCard.setLayout(loginCardLayout);
        loginCardLayout.setHorizontalGroup(
            loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginCardLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );
        loginCardLayout.setVerticalGroup(
            loginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginCardLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(guestButton)
                .addContainerGap())
        );

        container.add(loginCard, "card2");

        afterLoginCard.setBackground(new java.awt.Color(51, 51, 51));
        afterLoginCard.setForeground(new java.awt.Color(204, 204, 255));

        tabContainer.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jPanel3.setAutoscrolls(true);

        jLabel4.setText("Data:");

        jLabel9.setText("Ora:");

        programareAnBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "An" }));
        programareAnBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programareAnBoxActionPerformed(evt);
            }
        });

        programareLunaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Luna", "Ian", "Feb", "Mar", "Apr", "Mai", "Iun", "Iul", "Aug", "Sep", "Oct", "Noi", "Dec" }));
        programareLunaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programareLunaBoxActionPerformed(evt);
            }
        });

        programareZiBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Zi" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jButton5.setText("Programeaza");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(programareAnBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(programareLunaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(programareZiBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(322, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(39, 39, 39))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(programareAnBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(programareLunaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(programareZiBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButton5))
        );

        tabContainer.addTab("Programare", jPanel3);

        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        adaugaButton.setText("Adaugati");
        adaugaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("Titlu:");

        jButton2.setText("Selectati poza");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectImage(evt);
            }
        });

        jLabel6.setText("Pret de pornire:");

        jLabel7.setText("Nume vanzator:");

        imgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgLabel.setPreferredSize(new java.awt.Dimension(622, 554));

        jLabel8.setText("Descriere");

        descriereTF.setColumns(20);
        descriereTF.setRows(5);
        jScrollPane1.setViewportView(descriereTF);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(adaugaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(titluTF)
                            .addComponent(pretTF, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(numeVanzatorTF, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(8, 8, 8)
                        .addComponent(titluTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pretTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeVanzatorTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adaugaButton)
                .addContainerGap())
        );

        tabContainer.addTab("Adauga produs", jPanel1);

        jButton1.setText("jButton1");

        javax.swing.GroupLayout licitatieUserPanelLayout = new javax.swing.GroupLayout(licitatieUserPanel);
        licitatieUserPanel.setLayout(licitatieUserPanelLayout);
        licitatieUserPanelLayout.setHorizontalGroup(
            licitatieUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(licitatieUserPanelLayout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jButton1)
                .addContainerGap(303, Short.MAX_VALUE))
        );
        licitatieUserPanelLayout.setVerticalGroup(
            licitatieUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(licitatieUserPanelLayout.createSequentialGroup()
                .addGap(120, 120, 120)
                .addComponent(jButton1)
                .addContainerGap(225, Short.MAX_VALUE))
        );

        tabContainer.addTab("Liciteaza", licitatieUserPanel);

        jButton3.setText("jButton3");

        jButton4.setText("jButton4");

        javax.swing.GroupLayout licitatieGuestPanelLayout = new javax.swing.GroupLayout(licitatieGuestPanel);
        licitatieGuestPanel.setLayout(licitatieGuestPanelLayout);
        licitatieGuestPanelLayout.setHorizontalGroup(
            licitatieGuestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(licitatieGuestPanelLayout.createSequentialGroup()
                .addGap(248, 248, 248)
                .addComponent(jButton3)
                .addContainerGap(264, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, licitatieGuestPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(201, 201, 201))
        );
        licitatieGuestPanelLayout.setVerticalGroup(
            licitatieGuestPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(licitatieGuestPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(238, Short.MAX_VALUE))
        );

        tabContainer.addTab("Liciteaza", licitatieGuestPanel);

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
            .addComponent(tabContainer)
            .addGroup(afterLoginCardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(userName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutButton)
                .addContainerGap())
        );
        afterLoginCardLayout.setVerticalGroup(
            afterLoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(afterLoginCardLayout.createSequentialGroup()
                .addComponent(tabContainer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(afterLoginCardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logoutButton))
                .addContainerGap())
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
        cl.show(container, "card3");        
        userName.setText("Logged in as ".concat(loginTF.getText()));
        
        tabContainer.remove(licitatieGuestComponent);
        tabContainer.add("Liciteaza", licitatieUserComponent);
    }//GEN-LAST:event_loginButtonActionPerformed

    private void guestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guestButtonActionPerformed
        cl.show(container, "card3");        
        userName.setText("Logged in as Guest");
        
        tabContainer.remove(licitatieUserComponent);
        tabContainer.add("Liciteaza", licitatieGuestComponent);
    }//GEN-LAST:event_guestButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        cl.show(container, "card2");
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void selectImage(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectImage

        fc = new JFileChooser();
        
        if(fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            try {
                BufferedImage bi = ImageIO.read(fc.getSelectedFile());
                bi = getScaledImage(bi, 300, 246);
                ImageIcon ii = new ImageIcon(bi);

                imgLabel.setIcon(ii);

            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_selectImage

    private void adaugaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adaugaButtonActionPerformed
        titluTF.setText("");
        numeVanzatorTF.setText("");
        pretTF.setText("");
        descriereTF.setText("");
    }//GEN-LAST:event_adaugaButtonActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void setZile(int k){
        
        programareZiBox.removeAllItems();
        
        for (int i = 1; i <= k; i++) {
            programareZiBox.addItem(i + "");
        }
    }
    
    private void programareAnBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programareAnBoxActionPerformed
        if(Integer.parseInt(programareAnBox.getSelectedItem().toString()) % 4 == 0){
            anBisect = true;
            
            if(Objects.equals(programareLunaBox.getSelectedItem().toString(), "Feb") &&
                    programareZiBox.getItemCount() == 28){
                programareZiBox.addItem("29");
            }
            
        }
        else{
            anBisect = false;
            
            if(Objects.equals(programareLunaBox.getSelectedItem().toString(), "Feb") && 
                    programareZiBox.getItemCount() == 29){
                
                 programareZiBox.removeItem("29");
            }
            
        }
    }//GEN-LAST:event_programareAnBoxActionPerformed

    private void programareLunaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programareLunaBoxActionPerformed
        
        switch(programareLunaBox.getSelectedIndex()){
            case 1: setZile(31); break;
            case 2: if(anBisect)
                        setZile(29);
                    else
                        setZile(28); break;
            case 3: setZile(31); break;
            case 4: setZile(30); break;
            case 5: setZile(31); break;
            case 6: setZile(30); break;
            case 7: setZile(31); break;
            case 8: setZile(31); break;
            case 9: setZile(30); break;
            case 10: setZile(31); break;
            case 11: setZile(30); break;
            case 12: setZile(31); break;
        }
        
        if(Objects.equals(programareLunaBox.getSelectedItem().toString(), "Feb") && 
                    Integer.parseInt(programareZiBox.getSelectedItem().toString()) > 28){
                
                setZile(28);
            }
    }//GEN-LAST:event_programareLunaBoxActionPerformed

    // http://stackoverflow.com/questions/9417356/bufferedimage-resize
    public static BufferedImage getScaledImage(BufferedImage img, int newW, int newH) { 
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }  

    private void resetAddObject(){
        BufferedImage bi = null;
        try 
        {
            bi = ImageIO.read(new File("defaultNewObjectImage.png"));
            
            bi = getScaledImage(bi, 300, 246);
            imgLabel.setIcon(new ImageIcon(bi));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adaugaButton;
    private javax.swing.JPanel afterLoginCard;
    private javax.swing.JPanel container;
    private javax.swing.JTextArea descriereTF;
    private javax.swing.JButton guestButton;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel licitatieGuestPanel;
    private javax.swing.JPanel licitatieUserPanel;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginCard;
    private javax.swing.JTextField loginTF;
    private javax.swing.JButton logoutButton;
    private javax.swing.JTextField numeVanzatorTF;
    private javax.swing.JTextField pretTF;
    private javax.swing.JComboBox<String> programareAnBox;
    private javax.swing.JComboBox<String> programareLunaBox;
    private javax.swing.JComboBox<String> programareZiBox;
    private javax.swing.JTabbedPane tabContainer;
    private javax.swing.JTextField titluTF;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
}
