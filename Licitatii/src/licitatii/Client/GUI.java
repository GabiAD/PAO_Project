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
public class GUI extends javax.swing.JFrame{

    private CardLayout cl;
    private JFileChooser fc;
    private Component licitatieUserComponent;
    private boolean anBisect = false;
    private String utilizator;
    private DefaultListModel listaProduseModel;
    private Client client;
    private ArrayList<Product> listaProduse = new ArrayList<Product>();
    private ManagerLiniiLicitatie manLiniiLic;
    
    public GUI() {
        initComponents();
        resetAddObject();
        
        cl = (CardLayout)container.getLayout();
        
        licitatieUserComponent = tabContainer.getComponentAt(2);
//        licitatieGuestComponent = tabContainer.getComponentAt(3);
        
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        Date date = new Date();
        
        programareAnBox.addItem(dateFormat.format(date));
        programareAnBox.addItem(Integer.toString(Integer.parseInt(dateFormat.format(date))+1));
        programareAnBox.addItem(Integer.toString(Integer.parseInt(dateFormat.format(date))+2));
        programareAnBox.addItem(Integer.toString(Integer.parseInt(dateFormat.format(date))+3));
        
        setZile(31);
        
        jListProduseProgramare.setModel(new DefaultListModel());
        listaProduseModel = (DefaultListModel) jListProduseProgramare.getModel();
        
        
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
        tabContainer = new javax.swing.JTabbedPane();
        licitatieUserPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaLicitatii = new javax.swing.JPanel();
        numeCumparatorLabel = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
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
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        programareAnBox = new javax.swing.JComboBox<>();
        programareLunaBox = new javax.swing.JComboBox<>();
        programareZiBox = new javax.swing.JComboBox<>();
        programareOraBox = new javax.swing.JComboBox<>();
        programeazaButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jListProduseProgramare = new javax.swing.JList<>();
        stergeProdusProgramareButton = new javax.swing.JButton();
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
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE)
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

        tabContainer.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        tabContainer.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabContainerStateChanged(evt);
            }
        });

        listaLicitatii.setLayout(new java.awt.GridBagLayout());
        jScrollPane2.setViewportView(listaLicitatii);

        numeCumparatorLabel.setText("Licitati cu numele:");

        javax.swing.GroupLayout licitatieUserPanelLayout = new javax.swing.GroupLayout(licitatieUserPanel);
        licitatieUserPanel.setLayout(licitatieUserPanelLayout);
        licitatieUserPanelLayout.setHorizontalGroup(
            licitatieUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(licitatieUserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(licitatieUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(licitatieUserPanelLayout.createSequentialGroup()
                        .addComponent(numeCumparatorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 512, Short.MAX_VALUE)))
                .addContainerGap())
        );
        licitatieUserPanelLayout.setVerticalGroup(
            licitatieUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, licitatieUserPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(licitatieUserPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeCumparatorLabel)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabContainer.addTab("Licitatii", licitatieUserPanel);

        jPanel1.setForeground(new java.awt.Color(204, 204, 255));

        adaugaButton.setText("Adaugati");
        adaugaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adaugaButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("*Titlu:");

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

        titluTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                titluTFKeyTyped(evt);
            }
        });

        pretTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                pretTFKeyTyped(evt);
            }
        });

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
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titluTF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                            .addComponent(pretTF)
                            .addComponent(numeVanzatorTF)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(12, 12, 12)))
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
                        .addComponent(imgLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
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

        jPanel3.setAutoscrolls(true);

        jLabel4.setText("Data:");

        jLabel9.setText("Ora:");

        programareAnBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programareAnBoxActionPerformed(evt);
            }
        });

        programareLunaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ian", "Feb", "Mar", "Apr", "Mai", "Iun", "Iul", "Aug", "Sep", "Oct", "Noi", "Dec" }));
        programareLunaBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programareLunaBoxActionPerformed(evt);
            }
        });

        programareZiBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Zi" }));

        programareOraBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00" }));
        programareOraBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programareOraBoxActionPerformed(evt);
            }
        });

        programeazaButton.setText("Programeaza");
        programeazaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programeazaButtonActionPerformed(evt);
            }
        });

        jListProduseProgramare.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jListProduseProgramare.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jListProduseProgramareMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jListProduseProgramare);

        stergeProdusProgramareButton.setText("Sterge produs");
        stergeProdusProgramareButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stergeProdusProgramareButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(programareOraBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(programareAnBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(programareLunaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(programareZiBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stergeProdusProgramareButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(programeazaButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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
                    .addComponent(programareOraBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(programeazaButton)
                    .addComponent(stergeProdusProgramareButton)))
        );

        programeazaButton.setEnabled(false);
        stergeProdusProgramareButton.setEnabled(false);

        tabContainer.addTab("Programare", jPanel3);

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
        
        utilizator = loginTF.getText();
        
        if(!client.conectat()){
            client.connectToServer();
        }
        
        if(client.conectat() && client.login(utilizator, String.valueOf(passwordTF.getPassword()))){

            titluTF.setText("");
            numeVanzatorTF.setText(utilizator);
            pretTF.setText("");
            descriereTF.setText("");

            cl.show(container, "card3");        
            userName.setText("Logged in as ".concat(loginTF.getText()));

            numeCumparatorLabel.setText("Licitati cu numele ".concat(utilizator).concat("."));
            jTextField1.setVisible(false);

        }
//        tabContainer.remove(licitatieGuestComponent);
//        tabContainer.add("Liciteaza", licitatieUserComponent);
    }//GEN-LAST:event_loginButtonActionPerformed

    private void adminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminButtonActionPerformed
        
        utilizator = loginTF.getText();
        
        if(!client.conectat()){
            client.connectToServer();
        }
        
        if(client.conectat() && client.adminLogin(utilizator, String.valueOf(passwordTF.getPassword()))){
            
            cl.show(container, "card3");        
            userName.setText("Logged in as Admin");

            numeCumparatorLabel.setText("Licitati cu numele: ");
            jTextField1.setVisible(true);

        }
//        tabContainer.remove(licitatieUserComponent);
//        tabContainer.add("Liciteaza", licitatieGuestComponent);
    }//GEN-LAST:event_adminButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        cl.show(container, "card2");
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void pretTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pretTFKeyTyped
        if(!(pretTF.getText().concat(String.valueOf(evt.getKeyChar()))).matches("[0-9]+")){
            evt.consume();
        }
    }//GEN-LAST:event_pretTFKeyTyped

    private void titluTFKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titluTFKeyTyped
        if(titluTF.getText().concat(String.valueOf(evt.getKeyChar())).equals(""))
        adaugaButton.setEnabled(false);
        else
        adaugaButton.setEnabled(true);
    }//GEN-LAST:event_titluTFKeyTyped

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
        
        String auxPret = pretTF.getText();
        while(auxPret.length() > 0 && auxPret.charAt(0) == '0'){
            auxPret = auxPret.substring(1);
        }
        if(auxPret.equals(""))
        auxPret = "0";
        
        client.adaugaProdus(titluTF.getText(), Integer.parseInt(auxPret), descriereTF.getText(), imgLabel.getIcon());
        
        //listaProduseModel.add(listaProduseModel.getSize(), String.join(": ", titluTF.getText(), auxPret));
        //listaProduse.add(new ProdusPacket(titluTF.getText(), Integer.parseInt(auxPret), numeVanzatorTF.getText(), descriereTF.getText(), imgLabel.getIcon()));
        
        resetAddObject();

        programeazaButton.setEnabled(true);
    }//GEN-LAST:event_adaugaButtonActionPerformed

    private void stergeProdusProgramareButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stergeProdusProgramareButtonActionPerformed

        if(jListProduseProgramare.getSelectedIndex() >= 0){
            
            client.stergeProdus(listaProduse.get(jListProduseProgramare.getSelectedIndex()));
            
            listaProduse.remove(jListProduseProgramare.getSelectedIndex());
            listaProduseModel.remove(jListProduseProgramare.getSelectedIndex());
        }
        
        if(listaProduseModel.getSize() == 0){
            programeazaButton.setEnabled(false);
            
        }

        stergeProdusProgramareButton.setEnabled(false);
    }//GEN-LAST:event_stergeProdusProgramareButtonActionPerformed

    private void jListProduseProgramareMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jListProduseProgramareMouseClicked

        if(jListProduseProgramare.getSelectedIndex() >= 0)
        stergeProdusProgramareButton.setEnabled(true);
    }//GEN-LAST:event_jListProduseProgramareMouseClicked

    private void programeazaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programeazaButtonActionPerformed

        int ora = Integer.parseInt(programareOraBox.getSelectedItem().toString().substring(0, programareOraBox.getSelectedItem().toString().indexOf(":")));
        
        Date data = new GregorianCalendar(Integer.parseInt(programareAnBox.getSelectedItem().toString()),
                                        programareLunaBox.getSelectedIndex() + 1,
                                        Integer.parseInt(programareZiBox.getSelectedItem().toString()), 
                                        ora, 0 ).getTime();
        
        client.sendNewLicitation(listaProduse, data);
        
        
        /*
        
        for (int i = 0; i < listaProduse.size(); i++) {
            listaProduse.get(i).setData(Integer.parseInt(programareZiBox.getSelectedItem().toString()),
                                        programareLunaBox.getSelectedItem().toString(), 
                                        Integer.parseInt(programareAnBox.getSelectedItem().toString()), 
                                        programareOraBox.getSelectedItem().toString());
        }
        
        client.trimiteProduse(listaProduse);
        
        */
        
        // TO DO: Thread special pentru asa ceva; asta e doar pentru test
//        LinieLicitatie ll = client.primesteLinieLicitatie();
//        manLiniiLic.addLine(ll);
        
        
        
        listaProduseModel.removeAllElements();
        listaProduse.clear();
        stergeProdusProgramareButton.setEnabled(false);
        programeazaButton.setEnabled(false);
    }//GEN-LAST:event_programeazaButtonActionPerformed

    private void programareOraBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programareOraBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_programareOraBoxActionPerformed

    private void programareLunaBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programareLunaBoxActionPerformed

        switch(programareLunaBox.getSelectedIndex()){
            case 0: setZile(31); break;
            case 1: if(anBisect)
            setZile(29);
            else
            setZile(28); break;
            case 2: setZile(31); break;
            case 3: setZile(30); break;
            case 4: setZile(31); break;
            case 5: setZile(30); break;
            case 6: setZile(31); break;
            case 7: setZile(31); break;
            case 8: setZile(30); break;
            case 9: setZile(31); break;
            case 10: setZile(30); break;
            case 11: setZile(31); break;
        }


        if(Objects.equals(programareLunaBox.getSelectedItem().toString(), "Feb") &&
            Integer.parseInt(programareZiBox.getSelectedItem().toString()) > 28){

            setZile(28);
        }
    }//GEN-LAST:event_programareLunaBoxActionPerformed

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

    private void tabContainerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tabContainerStateChanged
        
        if(client != null){
            if(tabContainer.getSelectedIndex() == 0){
                client.pornesteEcranLicitatii();
            }
            else
                client.opresteEcranLicitatii();
        }
        
        if(tabContainer.getSelectedIndex() == 2){
            
            //listaProduseModel.add(listaProduseModel.getSize(), String.join(": ", titluTF.getText(), auxPret));
            //listaProduse.add(new ProdusPacket(titluTF.getText(), Integer.parseInt(auxPret), numeVanzatorTF.getText(), descriereTF.getText(), imgLabel.getIcon()));
            
            listaProduseModel.removeAllElements();
            listaProduse.clear();
            
            listaProduse = client.getProducts();
            
            for (int i = 0; i < listaProduse.size(); i++) {
                listaProduseModel.add(listaProduseModel.size(), String.join(": ", listaProduse.get(i).getName(), String.valueOf(listaProduse.get(i).getPrice())));
            }
            
            if(listaProduse.size() > 0)
                programeazaButton.setEnabled(true);
            else
                programeazaButton.setEnabled(false);
            
        }
        
    }//GEN-LAST:event_tabContainerStateChanged

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

    private void resetAddObject(){
        titluTF.setText("");
        pretTF.setText("");
        descriereTF.setText("");
        
        adaugaButton.setEnabled(false);
        
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
    private javax.swing.JButton adminButton;
    private javax.swing.JPanel afterLoginCard;
    private javax.swing.JPanel container;
    private javax.swing.JTextArea descriereTF;
    private javax.swing.JLabel imgLabel;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jListProduseProgramare;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel licitatieUserPanel;
    private javax.swing.JPanel listaLicitatii;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel loginCard;
    private javax.swing.JTextField loginTF;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel numeCumparatorLabel;
    private javax.swing.JTextField numeVanzatorTF;
    private javax.swing.JPasswordField passwordTF;
    private javax.swing.JTextField pretTF;
    private javax.swing.JComboBox<String> programareAnBox;
    private javax.swing.JComboBox<String> programareLunaBox;
    private javax.swing.JComboBox<String> programareOraBox;
    private javax.swing.JComboBox<String> programareZiBox;
    private javax.swing.JButton programeazaButton;
    private javax.swing.JButton stergeProdusProgramareButton;
    private javax.swing.JTabbedPane tabContainer;
    private javax.swing.JTextField titluTF;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
}
