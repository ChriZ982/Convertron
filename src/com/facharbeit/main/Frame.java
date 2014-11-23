package com.facharbeit.main;

import com.facharbeit.io.SettingHandler;
import com.facharbeit.io.Settings;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Frame extends javax.swing.JFrame
{

    private static final long serialVersionUID = 1L;

    public Frame()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jColorChooser1 = new javax.swing.JColorChooser();
        jFileChooser1 = new javax.swing.JFileChooser();
        jCheckBox2 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        genToday = new javax.swing.JButton();
        genTomorrow = new javax.swing.JButton();
        genAll = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MOTD = new javax.swing.JTextField();
        genMOTD = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        createBackup = new javax.swing.JButton();
        deleteSource = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        deleteMOTD = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        sourceTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        backupTxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        destArea = new javax.swing.JTextArea("");
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        savePathBtn = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        colorPlanCombo = new javax.swing.JComboBox();
        setColorPlanBtn = new javax.swing.JButton();
        selectBackupBtn = new javax.swing.JButton();
        selectSourceBtn = new javax.swing.JButton();
        selectDestBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        colorMotdCombo = new javax.swing.JComboBox();
        setColorMotdBtn = new javax.swing.JButton();
        addColorBtn = new javax.swing.JButton();
        deleteColor = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        speedPlanTxt = new javax.swing.JTextField();
        setSpeedPlanBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        speedMotdTxt = new javax.swing.JTextField();
        setSpeedMotdBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        colorMotdPanel = new javax.swing.JPanel();
        colorPlanPanel = new javax.swing.JPanel();
        colorNameTxt = new javax.swing.JTextField();
        autoBackupCheck = new javax.swing.JCheckBox();
        autoDeleteSourceCheck = new javax.swing.JCheckBox();
        useSQLCheck = new javax.swing.JCheckBox();
        configureSQLBtn = new javax.swing.JButton();

        jFileChooser1.setFileHidingEnabled(true);
        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        jCheckBox2.setText("jCheckBox2");

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vertretungsplan Vfinalepicness");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        log.setFocusable(false);
        jScrollPane1.setViewportView(log);

        jLabel1.setText("Status:");

        genToday.setText("heutigen Plan generieren");

        genTomorrow.setText("morgigen Plan generieren");

        genAll.setText("Pläne generieren");

        jLabel2.setText("Vertretungplan:");

        jLabel3.setText("Laufschrift:");

        MOTD.setText("Laufschrift");

        genMOTD.setText("Laufschrift generieren");

        jLabel4.setText("Fortschritt:");

        createBackup.setText("Backup erstellen");

        deleteSource.setText("Quellpläne löschen");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/antonianumLogo.jpg"))); // NOI18N

        deleteMOTD.setText("Laufschrift löschen");

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MOTD)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(createBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteSource, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(genAll, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(genToday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(genTomorrow, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(genMOTD, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteMOTD, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator6)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(genAll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(genToday)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(genTomorrow)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createBackup)
                            .addComponent(deleteSource))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(MOTD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genMOTD)
                            .addComponent(deleteMOTD)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Control", jPanel1);

        jLabel6.setText("Quellpfad");

        destArea.setColumns(20);
        destArea.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        destArea.setRows(5);
        jScrollPane2.setViewportView(destArea);

        jLabel8.setText("Backuppfad");

        jLabel9.setText("Zielpfade");

        savePathBtn.setText("Pfade speichern");
        savePathBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                savePathBtnActionPerformed(evt);
            }
        });

        jLabel11.setText("Vertretungplan");

        colorPlanCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                colorPlanComboItemStateChanged(evt);
            }
        });

        setColorPlanBtn.setText("setze Farbe");
        setColorPlanBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                setColorPlanBtnActionPerformed(evt);
            }
        });

        selectBackupBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/ordner.png"))); // NOI18N
        selectBackupBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectBackupBtnActionPerformed(evt);
            }
        });

        selectSourceBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/ordner.png"))); // NOI18N
        selectSourceBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectSourceBtnActionPerformed(evt);
            }
        });

        selectDestBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/ordner.png"))); // NOI18N
        selectDestBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectDestBtnActionPerformed(evt);
            }
        });

        jLabel13.setText("Laufschrift");

        colorMotdCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                colorMotdComboItemStateChanged(evt);
            }
        });

        setColorMotdBtn.setText("setze Farbe");
        setColorMotdBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                setColorMotdBtnActionPerformed(evt);
            }
        });

        addColorBtn.setText("Farbe wählen");
        addColorBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addColorBtnActionPerformed(evt);
            }
        });

        deleteColor.setText("Farbe löschen");
        deleteColor.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteColorActionPerformed(evt);
            }
        });

        jLabel14.setText("Scrollgeschwindigkeit");

        speedPlanTxt.setText("10");

        setSpeedPlanBtn.setText("setze Geschw.");
        setSpeedPlanBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                setSpeedPlanBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Laufschriftgeschw.");

        speedMotdTxt.setText("10");

        setSpeedMotdBtn.setText("setze Geschw.");
        setSpeedMotdBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                setSpeedMotdBtnActionPerformed(evt);
            }
        });

        jLabel10.setText("GAAAAAANZ VIIIEEEL PLAATZ");

        jSeparator7.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout colorMotdPanelLayout = new javax.swing.GroupLayout(colorMotdPanel);
        colorMotdPanel.setLayout(colorMotdPanelLayout);
        colorMotdPanelLayout.setHorizontalGroup(
            colorMotdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );
        colorMotdPanelLayout.setVerticalGroup(
            colorMotdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout colorPlanPanelLayout = new javax.swing.GroupLayout(colorPlanPanel);
        colorPlanPanel.setLayout(colorPlanPanelLayout);
        colorPlanPanelLayout.setHorizontalGroup(
            colorPlanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );
        colorPlanPanelLayout.setVerticalGroup(
            colorPlanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        colorNameTxt.setText("Farbenname");
        colorNameTxt.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                colorNameTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                colorNameTxtFocusLost(evt);
            }
        });

        autoBackupCheck.setText("Automatisches Backup");

        autoDeleteSourceCheck.setText("Auto Quellen löschen");

        useSQLCheck.setText("SQL benutzen");
        useSQLCheck.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                useSQLCheckStateChanged(evt);
            }
        });

        configureSQLBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/Settings16.png"))); // NOI18N
        configureSQLBtn.setEnabled(false);
        configureSQLBtn.setEnabled(useSQLCheck.isSelected());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(sourceTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectSourceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(savePathBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(backupTxt)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectBackupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(selectDestBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(speedPlanTxt)
                                    .addComponent(speedMotdTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(setSpeedPlanBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(setSpeedMotdBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jSeparator4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(colorMotdCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(colorPlanCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(colorPlanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(colorMotdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(colorNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(addColorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(deleteColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(setColorPlanBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(setColorMotdBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(configureSQLBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(autoBackupCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(autoDeleteSourceCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(useSQLCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sourceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(selectSourceBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backupTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(selectBackupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(selectDestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(savePathBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(colorPlanCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(setColorPlanBtn))
                            .addComponent(colorPlanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(colorMotdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(setColorMotdBtn))
                            .addComponent(colorMotdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addColorBtn)
                            .addComponent(deleteColor)
                            .addComponent(colorNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(speedPlanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setSpeedPlanBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(speedMotdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(setSpeedMotdBtn)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(autoBackupCheck)
                            .addComponent(autoDeleteSourceCheck))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(useSQLCheck)
                            .addComponent(configureSQLBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Settings", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectSourceBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectSourceBtnActionPerformed
    {//GEN-HEADEREND:event_selectSourceBtnActionPerformed
        jFileChooser1.showOpenDialog(null);
        sourceTxt.setText(jFileChooser1.getSelectedFile().getPath());

        Application.addToQueue("selectSourceBtnActionPerformed", jFileChooser1, sourceTxt, evt);
    }//GEN-LAST:event_selectSourceBtnActionPerformed

    private void selectBackupBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectBackupBtnActionPerformed
    {//GEN-HEADEREND:event_selectBackupBtnActionPerformed
        jFileChooser1.showOpenDialog(null);
        backupTxt.setText(jFileChooser1.getSelectedFile().getPath());
    }//GEN-LAST:event_selectBackupBtnActionPerformed

    private void selectDestBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectDestBtnActionPerformed
    {//GEN-HEADEREND:event_selectDestBtnActionPerformed
        jFileChooser1.showOpenDialog(null);

        if(!destArea.getText().endsWith("\n") && destArea.getText().contains("\n"))
            destArea.setText(destArea.getText() + "\n");

        destArea.append(jFileChooser1.getSelectedFile().getPath() + "\n");
    }//GEN-LAST:event_selectDestBtnActionPerformed

    @SuppressWarnings("empty-statement")
    private void savePathBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_savePathBtnActionPerformed
    {//GEN-HEADEREND:event_savePathBtnActionPerformed
        SettingHandler.savePathBtnActionPerformed(sourceTxt, backupTxt, destArea, evt);
    }//GEN-LAST:event_savePathBtnActionPerformed

    private void setSpeedPlanBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_setSpeedPlanBtnActionPerformed
    {//GEN-HEADEREND:event_setSpeedPlanBtnActionPerformed
        SettingHandler.setSpeedPlanBtnActionPerformed(speedPlanTxt, evt);
    }//GEN-LAST:event_setSpeedPlanBtnActionPerformed

    private void setSpeedMotdBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_setSpeedMotdBtnActionPerformed
    {//GEN-HEADEREND:event_setSpeedMotdBtnActionPerformed
        SettingHandler.setSpeedMotdBtnActionPerformed(speedMotdTxt, evt);
    }//GEN-LAST:event_setSpeedMotdBtnActionPerformed

    private void addColorBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addColorBtnActionPerformed
    {//GEN-HEADEREND:event_addColorBtnActionPerformed
        SettingHandler.addColorBtnActionPerformed(jColorChooser1, colorNameTxt, colorPlanCombo, colorMotdCombo, evt);
    }//GEN-LAST:event_addColorBtnActionPerformed

    private void colorPlanComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorPlanComboItemStateChanged
    {//GEN-HEADEREND:event_colorPlanComboItemStateChanged
        SettingHandler.colorPlanComboItemStateChanged(colorPlanPanel, colorPlanCombo, evt);
    }//GEN-LAST:event_colorPlanComboItemStateChanged

    private void setColorPlanBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_setColorPlanBtnActionPerformed
    {//GEN-HEADEREND:event_setColorPlanBtnActionPerformed
        SettingHandler.setColorPlanBtnActionPerformed(colorPlanCombo, evt);
    }//GEN-LAST:event_setColorPlanBtnActionPerformed

    private void colorMotdComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorMotdComboItemStateChanged
    {//GEN-HEADEREND:event_colorMotdComboItemStateChanged
        SettingHandler.colorMotdComboItemStateChanged(colorMotdPanel, colorMotdCombo, evt);
    }//GEN-LAST:event_colorMotdComboItemStateChanged

    private void setColorMotdBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_setColorMotdBtnActionPerformed
    {//GEN-HEADEREND:event_setColorMotdBtnActionPerformed
        SettingHandler.setColorMotdBtnActionPerformed(colorMotdCombo, evt);
    }//GEN-LAST:event_setColorMotdBtnActionPerformed

    private void colorNameTxtFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_colorNameTxtFocusGained
    {//GEN-HEADEREND:event_colorNameTxtFocusGained
        if(colorNameTxt.getText().equals("Farbenname"))
            colorNameTxt.setText("");
    }//GEN-LAST:event_colorNameTxtFocusGained

    private void colorNameTxtFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_colorNameTxtFocusLost
    {//GEN-HEADEREND:event_colorNameTxtFocusLost
        if(colorNameTxt.getText().equals(""))
            colorNameTxt.setText("Farbenname");
    }//GEN-LAST:event_colorNameTxtFocusLost

    private void deleteColorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteColorActionPerformed
    {//GEN-HEADEREND:event_deleteColorActionPerformed
        SettingHandler.deleteColorBtnActionPerformed(colorNameTxt, colorPlanCombo, colorMotdCombo, evt);
    }//GEN-LAST:event_deleteColorActionPerformed

    private void useSQLCheckStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_useSQLCheckStateChanged
    {//GEN-HEADEREND:event_useSQLCheckStateChanged
        configureSQLBtn.setEnabled(useSQLCheck.isSelected());
    }//GEN-LAST:event_useSQLCheckStateChanged

    public JTextPane getStatusPane()
    {
        return log;
    }

    public void loadSettings()
    {
        load(sourceTxt, "sourcePath");
        load(backupTxt, "backupPath");

        String name = "destPath1";
        if(Settings.getLineOf(name) == -1)
            Settings.load(name);

        for(int i = 1; Settings.getLineOf(name) != -1; i++)
        {
            String s = Settings.load(name);
            destArea.append(s + "\n");
            name = "destPath" + (i + 1);
        }

        load(speedPlanTxt, "planSpeed");
        load(speedMotdTxt, "motdSpeed");

        name = "color1";
        for(int i = 1; Settings.getLineOf(name) != -1; i++)
        {
            colorPlanCombo.addItem(name);
            colorMotdCombo.addItem(name);
            name = "color" + (i + 1);
        }

        colorPlanCombo.setSelectedItem(Settings.load("colorPlan"));
        colorMotdCombo.setSelectedItem(Settings.load("colorMotd"));
    }

    private void saveIfNotNull(JTextField field, String name)
    {
        if(field.getText().equals(""))
            Settings.delete(name);
        else
            Settings.save(name, field.getText());
    }

    private void load(JTextField field, String name)
    {
        field.setText(Settings.load(name));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField MOTD;
    private javax.swing.JButton addColorBtn;
    private javax.swing.JCheckBox autoBackupCheck;
    private javax.swing.JCheckBox autoDeleteSourceCheck;
    private javax.swing.JTextField backupTxt;
    private javax.swing.JComboBox colorMotdCombo;
    private javax.swing.JPanel colorMotdPanel;
    private javax.swing.JTextField colorNameTxt;
    private javax.swing.JComboBox colorPlanCombo;
    private javax.swing.JPanel colorPlanPanel;
    private javax.swing.JButton configureSQLBtn;
    private javax.swing.JButton createBackup;
    private javax.swing.JButton deleteColor;
    private javax.swing.JButton deleteMOTD;
    private javax.swing.JButton deleteSource;
    private javax.swing.JTextArea destArea;
    private javax.swing.JButton genAll;
    private javax.swing.JButton genMOTD;
    private javax.swing.JButton genToday;
    private javax.swing.JButton genTomorrow;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextPane log;
    private javax.swing.JButton savePathBtn;
    private javax.swing.JButton selectBackupBtn;
    private javax.swing.JButton selectDestBtn;
    private javax.swing.JButton selectSourceBtn;
    private javax.swing.JButton setColorMotdBtn;
    private javax.swing.JButton setColorPlanBtn;
    private javax.swing.JButton setSpeedMotdBtn;
    private javax.swing.JButton setSpeedPlanBtn;
    private javax.swing.JTextField sourceTxt;
    private javax.swing.JTextField speedMotdTxt;
    private javax.swing.JTextField speedPlanTxt;
    private javax.swing.JCheckBox useSQLCheck;
    // End of variables declaration//GEN-END:variables
}
