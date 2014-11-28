package com.facharbeit.main;

import javax.swing.*;

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
        SQLFrame = new javax.swing.JFrame();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        dbHostTxt = new javax.swing.JTextField();
        dbPortTxt = new javax.swing.JTextField();
        dbPwTxt = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        dbUserTxt = new javax.swing.JTextField();
        dbNameTxt = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        dbTableNameTxt = new javax.swing.JTextField();
        SQLsaveBtn = new javax.swing.JButton();
        SQLabortBtn = new javax.swing.JButton();
        hoursFrame = new javax.swing.JFrame();
        hour1Txt = new javax.swing.JTextField();
        hour2Txt = new javax.swing.JTextField();
        hour3Txt = new javax.swing.JTextField();
        hour5Txt = new javax.swing.JTextField();
        hour7Txt = new javax.swing.JTextField();
        hour9Txt = new javax.swing.JTextField();
        hour4Txt = new javax.swing.JTextField();
        hour6Txt = new javax.swing.JTextField();
        hour8Txt = new javax.swing.JTextField();
        hour10Txt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        hoursSaveBtn = new javax.swing.JButton();
        hoursAbortBtn = new javax.swing.JButton();
        Tabs = new javax.swing.JTabbedPane();
        ControlPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        genTodayBtn = new javax.swing.JButton();
        genTomorrowBtn = new javax.swing.JButton();
        genAllBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        motdTxt = new javax.swing.JTextField();
        genMotdBtn = new javax.swing.JButton();
        progBar = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        createBackupBtn = new javax.swing.JButton();
        deleteSourceBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        SettingsPanel = new javax.swing.JPanel();
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
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();

        jFileChooser1.setFileHidingEnabled(true);
        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        jCheckBox2.setText("jCheckBox2");

        jTextField1.setText("jTextField1");

        SQLFrame.setTitle("SQLEinstellungen");
        SQLFrame.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        SQLFrame.setResizable(false);

        jLabel12.setText("Datenbank Host:");

        jLabel15.setText(":");

        dbHostTxt.setText("www.antonianum.de");
        dbHostTxt.setToolTipText("");

        dbPortTxt.setText("1433");

        jLabel16.setText("Benutzername:");

        jLabel17.setText("Passwort:");

        jLabel18.setText("Datenbankname:");

        jLabel19.setText("Tabellenname:");

        SQLsaveBtn.setText("speichern");
        SQLsaveBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                SQLsaveBtnActionPerformed(evt);
            }
        });

        SQLabortBtn.setText("abbrechen");
        SQLabortBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                SQLabortBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SQLFrameLayout = new javax.swing.GroupLayout(SQLFrame.getContentPane());
        SQLFrame.getContentPane().setLayout(SQLFrameLayout);
        SQLFrameLayout.setHorizontalGroup(
            SQLFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SQLFrameLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(SQLFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SQLFrameLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(5, 5, 5)
                        .addComponent(dbHostTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel15)
                        .addGap(4, 4, 4)
                        .addComponent(dbPortTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SQLFrameLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(13, 13, 13)
                        .addComponent(dbUserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(dbPwTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SQLFrameLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(4, 4, 4)
                        .addComponent(dbNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel19)
                        .addGap(4, 4, 4)
                        .addComponent(dbTableNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SQLFrameLayout.createSequentialGroup()
                        .addComponent(SQLsaveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(SQLabortBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        SQLFrameLayout.setVerticalGroup(
            SQLFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SQLFrameLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(SQLFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dbHostTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dbPortTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SQLFrameLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(SQLFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15))))
                .addGap(6, 6, 6)
                .addGroup(SQLFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dbUserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dbPwTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SQLFrameLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(SQLFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))))
                .addGap(6, 6, 6)
                .addGroup(SQLFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dbNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dbTableNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SQLFrameLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(SQLFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19))))
                .addGap(6, 6, 6)
                .addGroup(SQLFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SQLsaveBtn)
                    .addComponent(SQLabortBtn)))
        );

        SQLFrame.pack();

        hoursFrame.setTitle("Stunden Ausblendung");
        hoursFrame.setAlwaysOnTop(true);
        hoursFrame.setResizable(false);

        jLabel22.setText("Stunde ausblenden ab:");

        jLabel23.setText("1. Stunde");

        jLabel24.setText("3. Stunde");

        jLabel25.setText("5. Stunde");

        jLabel26.setText("7. Stunde");

        jLabel27.setText("9. Stunde");

        jLabel28.setText("2. Stunde");

        jLabel29.setText("4. Stunde");

        jLabel30.setText("6. Stunde");

        jLabel31.setText("8. Stunde");

        jLabel32.setText("10. Stunde");

        hoursSaveBtn.setText("speichern");
        hoursSaveBtn.setToolTipText("");
        hoursSaveBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                hoursSaveBtnActionPerformed(evt);
            }
        });

        hoursAbortBtn.setText("abbrechen");
        hoursAbortBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                hoursAbortBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hoursFrameLayout = new javax.swing.GroupLayout(hoursFrame.getContentPane());
        hoursFrame.getContentPane().setLayout(hoursFrameLayout);
        hoursFrameLayout.setHorizontalGroup(
            hoursFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hoursFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hoursFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hoursFrameLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(hoursFrameLayout.createSequentialGroup()
                        .addGroup(hoursFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(hoursSaveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addGroup(hoursFrameLayout.createSequentialGroup()
                                .addGroup(hoursFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(hoursFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hour3Txt)
                                    .addComponent(hour5Txt)
                                    .addComponent(hour7Txt)
                                    .addComponent(hour9Txt)
                                    .addComponent(hour1Txt, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(hoursFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(hoursFrameLayout.createSequentialGroup()
                                .addComponent(jLabel32)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hour10Txt))
                            .addGroup(hoursFrameLayout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hour8Txt))
                            .addGroup(hoursFrameLayout.createSequentialGroup()
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hour6Txt))
                            .addGroup(hoursFrameLayout.createSequentialGroup()
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hour4Txt))
                            .addGroup(hoursFrameLayout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hour2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(hoursAbortBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        hoursFrameLayout.setVerticalGroup(
            hoursFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hoursFrameLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hoursFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hour1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel28)
                    .addComponent(hour2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hoursFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hour3Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24)
                    .addComponent(hour4Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hoursFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hour5Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(hour6Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hoursFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hour7Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(hour8Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hoursFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hour9Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27)
                    .addComponent(hour10Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(hoursFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hoursSaveBtn)
                    .addComponent(hoursAbortBtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        hoursFrame.pack();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Vertretungsplan");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        log.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        log.setFocusable(false);
        jScrollPane1.setViewportView(log);

        jLabel1.setText("Status:");

        genTodayBtn.setText("heutigen Plan generieren");
        genTodayBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                genTodayBtnActionPerformed(evt);
            }
        });

        genTomorrowBtn.setText("morgigen Plan generieren");
        genTomorrowBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                genTomorrowBtnActionPerformed(evt);
            }
        });

        genAllBtn.setText("Alles generieren");
        genAllBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                genAllBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Vertretungplan:");

        motdTxt.setText("Laufschrift");

        genMotdBtn.setText("Laufschrift generieren");
        genMotdBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                genMotdBtnActionPerformed(evt);
            }
        });

        jLabel4.setText("Fortschritt:");

        createBackupBtn.setText("Backup erstellen");
        createBackupBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                createBackupBtnActionPerformed(evt);
            }
        });

        deleteSourceBtn.setText("Quellpläne löschen");
        deleteSourceBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteSourceBtnActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/antonianumLogo.jpg"))); // NOI18N

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout ControlPanelLayout = new javax.swing.GroupLayout(ControlPanel);
        ControlPanel.setLayout(ControlPanelLayout);
        ControlPanelLayout.setHorizontalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addComponent(genAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ControlPanelLayout.createSequentialGroup()
                                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(genTodayBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(genTomorrowBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(ControlPanelLayout.createSequentialGroup()
                                .addComponent(genMotdBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(ControlPanelLayout.createSequentialGroup()
                                    .addComponent(createBackupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(deleteSourceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2)
                                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(motdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progBar, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        ControlPanelLayout.setVerticalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator6)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, ControlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ControlPanelLayout.createSequentialGroup()
                                .addComponent(genTodayBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(genTomorrowBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(genMotdBtn))
                            .addComponent(genAllBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(motdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createBackupBtn)
                            .addComponent(deleteSourceBtn)))
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(progBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        Tabs.addTab("Übersicht", ControlPanel);

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

        speedPlanTxt.setText("100");

        setSpeedPlanBtn.setText("setze Geschw.");
        setSpeedPlanBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                setSpeedPlanBtnActionPerformed(evt);
            }
        });

        jLabel7.setText("Laufschriftgeschw.");

        speedMotdTxt.setText("100");

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
        configureSQLBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                configureSQLBtnActionPerformed(evt);
            }
        });

        jLabel20.setText("%");

        jLabel21.setText("%");

        jToggleButton1.setText("SQL schreiben");

        jButton1.setText("Ausblendung konfigurieren");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SettingsPanelLayout = new javax.swing.GroupLayout(SettingsPanel);
        SettingsPanel.setLayout(SettingsPanelLayout);
        SettingsPanelLayout.setHorizontalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SettingsPanelLayout.createSequentialGroup()
                                .addComponent(sourceTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectSourceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SettingsPanelLayout.createSequentialGroup()
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(savePathBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(backupTxt)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectBackupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(selectDestBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SettingsPanelLayout.createSequentialGroup()
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SettingsPanelLayout.createSequentialGroup()
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(speedPlanTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                    .addComponent(speedMotdTxt))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(setSpeedPlanBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(setSpeedMotdBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jSeparator4)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SettingsPanelLayout.createSequentialGroup()
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(SettingsPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(colorMotdCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(SettingsPanelLayout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(colorPlanCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(colorPlanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(colorMotdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SettingsPanelLayout.createSequentialGroup()
                                        .addComponent(colorNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(addColorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(deleteColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(setColorPlanBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(setColorMotdBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SettingsPanelLayout.createSequentialGroup()
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(configureSQLBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(autoBackupCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(autoDeleteSourceCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SettingsPanelLayout.createSequentialGroup()
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                                        .addComponent(useSQLCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(53, 53, 53)
                                        .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        SettingsPanelLayout.setVerticalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sourceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(selectSourceBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backupTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(selectBackupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(selectDestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(savePathBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SettingsPanelLayout.createSequentialGroup()
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(colorPlanCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(setColorPlanBtn))
                            .addComponent(colorPlanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(colorMotdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(setColorMotdBtn))
                            .addComponent(colorMotdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addColorBtn)
                            .addComponent(deleteColor)
                            .addComponent(colorNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(speedPlanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setSpeedPlanBtn)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(speedMotdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(setSpeedMotdBtn)
                            .addComponent(jLabel21)))
                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(autoBackupCheck)
                            .addComponent(autoDeleteSourceCheck))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(useSQLCheck)
                                .addComponent(configureSQLBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SettingsPanelLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jToggleButton1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        Tabs.addTab("Einstellungen", SettingsPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabs)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Tabs)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectSourceBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectSourceBtnActionPerformed
    {//GEN-HEADEREND:event_selectSourceBtnActionPerformed
        jFileChooser1.showOpenDialog(null);
        sourceTxt.setText(jFileChooser1.getSelectedFile().getPath());
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
        Application.addToQueue("savePathBtnActionPerformed", sourceTxt, backupTxt, destArea);
    }//GEN-LAST:event_savePathBtnActionPerformed

    private void setSpeedPlanBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_setSpeedPlanBtnActionPerformed
    {//GEN-HEADEREND:event_setSpeedPlanBtnActionPerformed
        Application.addToQueue("setSpeedPlanBtnActionPerformed", speedPlanTxt);
    }//GEN-LAST:event_setSpeedPlanBtnActionPerformed

    private void setSpeedMotdBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_setSpeedMotdBtnActionPerformed
    {//GEN-HEADEREND:event_setSpeedMotdBtnActionPerformed
        Application.addToQueue("setSpeedMotdBtnActionPerformed", speedMotdTxt);
    }//GEN-LAST:event_setSpeedMotdBtnActionPerformed

    private void addColorBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addColorBtnActionPerformed
    {//GEN-HEADEREND:event_addColorBtnActionPerformed
        Application.addToQueue("addColorBtnActionPerformed", jColorChooser1, colorNameTxt, colorPlanCombo, colorMotdCombo);
    }//GEN-LAST:event_addColorBtnActionPerformed

    private void colorPlanComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorPlanComboItemStateChanged
    {//GEN-HEADEREND:event_colorPlanComboItemStateChanged
        Application.addToQueue("colorPlanComboItemStateChanged", colorPlanPanel, colorPlanCombo, evt);
    }//GEN-LAST:event_colorPlanComboItemStateChanged

    private void setColorPlanBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_setColorPlanBtnActionPerformed
    {//GEN-HEADEREND:event_setColorPlanBtnActionPerformed
        Application.addToQueue("setColorPlanBtnActionPerformed", colorPlanCombo);
    }//GEN-LAST:event_setColorPlanBtnActionPerformed

    private void colorMotdComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorMotdComboItemStateChanged
    {//GEN-HEADEREND:event_colorMotdComboItemStateChanged
        Application.addToQueue("colorMotdComboItemStateChanged", colorMotdPanel, colorMotdCombo, evt);
    }//GEN-LAST:event_colorMotdComboItemStateChanged

    private void setColorMotdBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_setColorMotdBtnActionPerformed
    {//GEN-HEADEREND:event_setColorMotdBtnActionPerformed
        Application.addToQueue("setColorMotdBtnActionPerformed", colorMotdCombo);
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
        Application.addToQueue("deleteColorBtnActionPerformed", colorNameTxt, colorPlanCombo, colorMotdCombo);
    }//GEN-LAST:event_deleteColorActionPerformed

    private void useSQLCheckStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_useSQLCheckStateChanged
    {//GEN-HEADEREND:event_useSQLCheckStateChanged
        configureSQLBtn.setEnabled(useSQLCheck.isSelected());
        Application.addToQueue("useSQLCheckStateChanged", useSQLCheck);
    }//GEN-LAST:event_useSQLCheckStateChanged

    private void configureSQLBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_configureSQLBtnActionPerformed
    {//GEN-HEADEREND:event_configureSQLBtnActionPerformed
        SQLFrame.setVisible(true);
    }//GEN-LAST:event_configureSQLBtnActionPerformed

    private void SQLabortBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_SQLabortBtnActionPerformed
    {//GEN-HEADEREND:event_SQLabortBtnActionPerformed
        SQLFrame.setVisible(false);
    }//GEN-LAST:event_SQLabortBtnActionPerformed

    private void genAllBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_genAllBtnActionPerformed
    {//GEN-HEADEREND:event_genAllBtnActionPerformed
        Application.addToQueue("genAllBtnActionPerformed");
    }//GEN-LAST:event_genAllBtnActionPerformed

    private void genTodayBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_genTodayBtnActionPerformed
    {//GEN-HEADEREND:event_genTodayBtnActionPerformed
        Application.addToQueue("genTodayBtnActionPerformed");
    }//GEN-LAST:event_genTodayBtnActionPerformed

    private void genTomorrowBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_genTomorrowBtnActionPerformed
    {//GEN-HEADEREND:event_genTomorrowBtnActionPerformed
        Application.addToQueue("genTomorrowBtnActionPerformed");
    }//GEN-LAST:event_genTomorrowBtnActionPerformed

    private void createBackupBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_createBackupBtnActionPerformed
    {//GEN-HEADEREND:event_createBackupBtnActionPerformed
        Application.addToQueue("createBackupBtnActionPerformed");
    }//GEN-LAST:event_createBackupBtnActionPerformed

    private void deleteSourceBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteSourceBtnActionPerformed
    {//GEN-HEADEREND:event_deleteSourceBtnActionPerformed
        Application.addToQueue("deleteSourceBtnActionPerformed");
    }//GEN-LAST:event_deleteSourceBtnActionPerformed

    private void genMotdBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_genMotdBtnActionPerformed
    {//GEN-HEADEREND:event_genMotdBtnActionPerformed
        Application.addToQueue("genMotdBtnActionPerformed", motdTxt);
    }//GEN-LAST:event_genMotdBtnActionPerformed

    private void SQLsaveBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_SQLsaveBtnActionPerformed
    {//GEN-HEADEREND:event_SQLsaveBtnActionPerformed
        Application.addToQueue("SQLsaveBtnActionPerformed", dbHostTxt, dbPortTxt, dbNameTxt,
                               dbUserTxt, dbPwTxt, dbTableNameTxt);
    }//GEN-LAST:event_SQLsaveBtnActionPerformed

    private void hoursSaveBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_hoursSaveBtnActionPerformed
    {//GEN-HEADEREND:event_hoursSaveBtnActionPerformed
        Application.addToQueue("hoursSaveBtnActionPerformed", hour1Txt, hour2Txt, hour3Txt,
                               hour4Txt, hour5Txt, hour6Txt, hour7Txt, hour8Txt, hour9Txt, hour10Txt);
    }//GEN-LAST:event_hoursSaveBtnActionPerformed

    private void hoursAbortBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_hoursAbortBtnActionPerformed
    {//GEN-HEADEREND:event_hoursAbortBtnActionPerformed
        hoursFrame.setVisible(false);
    }//GEN-LAST:event_hoursAbortBtnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        hoursFrame.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public JTextPane getStatusPane()
    {
        return log;
    }

    public JProgressBar getProgBar()
    {
        return progBar;
    }

    public void loadSettings()
    {
        Application.addToQueue("loadSettings", sourceTxt, backupTxt, destArea, speedPlanTxt, speedMotdTxt,
                               colorPlanCombo, colorMotdCombo, motdTxt, useSQLCheck, dbHostTxt, dbPortTxt,
                               dbNameTxt, dbUserTxt, dbPwTxt, dbTableNameTxt, hour1Txt, hour2Txt, hour3Txt,
                               hour4Txt, hour5Txt, hour6Txt, hour7Txt, hour8Txt, hour9Txt, hour10Txt);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ControlPanel;
    private javax.swing.JFrame SQLFrame;
    private javax.swing.JButton SQLabortBtn;
    private javax.swing.JButton SQLsaveBtn;
    private javax.swing.JPanel SettingsPanel;
    private javax.swing.JTabbedPane Tabs;
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
    private javax.swing.JButton createBackupBtn;
    private javax.swing.JTextField dbHostTxt;
    private javax.swing.JTextField dbNameTxt;
    private javax.swing.JTextField dbPortTxt;
    private javax.swing.JPasswordField dbPwTxt;
    private javax.swing.JTextField dbTableNameTxt;
    private javax.swing.JTextField dbUserTxt;
    private javax.swing.JButton deleteColor;
    private javax.swing.JButton deleteSourceBtn;
    private javax.swing.JTextArea destArea;
    private javax.swing.JButton genAllBtn;
    private javax.swing.JButton genMotdBtn;
    private javax.swing.JButton genTodayBtn;
    private javax.swing.JButton genTomorrowBtn;
    private javax.swing.JTextField hour10Txt;
    private javax.swing.JTextField hour1Txt;
    private javax.swing.JTextField hour2Txt;
    private javax.swing.JTextField hour3Txt;
    private javax.swing.JTextField hour4Txt;
    private javax.swing.JTextField hour5Txt;
    private javax.swing.JTextField hour6Txt;
    private javax.swing.JTextField hour7Txt;
    private javax.swing.JTextField hour8Txt;
    private javax.swing.JTextField hour9Txt;
    private javax.swing.JButton hoursAbortBtn;
    private javax.swing.JFrame hoursFrame;
    private javax.swing.JButton hoursSaveBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextPane log;
    private javax.swing.JTextField motdTxt;
    private javax.swing.JProgressBar progBar;
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
