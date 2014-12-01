package com.facharbeit.main;

import javax.swing.*;

public class Frame extends javax.swing.JFrame
{

    private static final long serialVersionUID = 1L;

    private JComponent[] hoursComponents;
    private JComponent[] sqlComponents;

    public Frame()
    {
        initComponents();

        hoursComponents = new JComponent[]
        {
            hoursHeadLabel, hour1Label, hour2Label, hour3Label, hour4Label, hour5Label,
            hour6Label, hour7Label, hour8Label, hour9Label, hour10Label, hour1Txt,
            hour2Txt, hour3Txt, hour4Txt, hour5Txt, hour6Txt, hour7Txt, hour8Txt, hour9Txt, hour10Txt
        };
        sqlComponents = new JComponent[]
        {
            dbHostLabel, dbPortLabel, dbNameLabel, dbUserLabel, dbPwLabel, dbTableNameLabel,
            dbHostTxt, dbPortTxt, dbNameTxt, dbUserTxt, dbPwTxt, dbTableNameTxt,
            sqlModeLabel, sqlModeBtn
        };
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jColorChooser1 = new javax.swing.JColorChooser();
        jFileChooser1 = new javax.swing.JFileChooser();
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
        jLabel14 = new javax.swing.JLabel();
        speedPlanTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        speedMotdTxt = new javax.swing.JTextField();
        autoBackupCheck = new javax.swing.JCheckBox();
        autoDeleteSourceCheck = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        settingsSaveBtn = new javax.swing.JButton();
        hour10Txt = new javax.swing.JTextField();
        hour10Label = new javax.swing.JLabel();
        hour9Txt = new javax.swing.JTextField();
        hour9Label = new javax.swing.JLabel();
        hour7Label = new javax.swing.JLabel();
        hour7Txt = new javax.swing.JTextField();
        hour8Txt = new javax.swing.JTextField();
        hour6Txt = new javax.swing.JTextField();
        hour4Txt = new javax.swing.JTextField();
        hour2Txt = new javax.swing.JTextField();
        hour1Txt = new javax.swing.JTextField();
        hour3Txt = new javax.swing.JTextField();
        hour5Txt = new javax.swing.JTextField();
        hour5Label = new javax.swing.JLabel();
        hour3Label = new javax.swing.JLabel();
        hour1Label = new javax.swing.JLabel();
        hour2Label = new javax.swing.JLabel();
        hour4Label = new javax.swing.JLabel();
        hour6Label = new javax.swing.JLabel();
        hour8Label = new javax.swing.JLabel();
        hoursHeadLabel = new javax.swing.JLabel();
        useHoursCheck = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        PathPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        sourceTxt = new javax.swing.JTextField();
        selectSourceTodayBtn = new javax.swing.JButton();
        selectBackupBtn = new javax.swing.JButton();
        selectDestBtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        destArea = new javax.swing.JTextArea("");
        backupTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        savePathBtn = new javax.swing.JButton();
        customSourceCheck = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        sourceTodayTxt = new javax.swing.JTextField();
        sourceTomorrowTxt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        DesignPanel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        colorPlanCombo = new javax.swing.JComboBox();
        colorPlanPanel = new javax.swing.JPanel();
        colorMotdPanel = new javax.swing.JPanel();
        deleteColor = new javax.swing.JButton();
        addColorBtn = new javax.swing.JButton();
        colorNameTxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        colorMotdCombo = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        colorTableCombo = new javax.swing.JComboBox();
        colorTablePanel = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        colorBorderCombo = new javax.swing.JComboBox();
        colorBorderPanel = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        typeToEditCombo = new javax.swing.JComboBox();
        typeToEditTxt = new javax.swing.JTextField();
        addTypeBtn = new javax.swing.JButton();
        deleteTypeBtn = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        label = new javax.swing.JLabel();
        fontColorPanel = new javax.swing.JPanel();
        fontColorCombo = new javax.swing.JComboBox();
        jLabel23 = new javax.swing.JLabel();
        fontTypeTxt = new javax.swing.JTextField();
        fontSizeLabel = new javax.swing.JLabel();
        backgroundColorLabel = new javax.swing.JLabel();
        backgroundColorCombo = new javax.swing.JComboBox();
        backgroundColorPanel = new javax.swing.JPanel();
        fontSizeTxt = new javax.swing.JTextField();
        boldCheck = new javax.swing.JCheckBox();
        italicCheck = new javax.swing.JCheckBox();
        underlinedCheck = new javax.swing.JCheckBox();
        SQLPanel = new javax.swing.JPanel();
        useSQLCheck = new javax.swing.JCheckBox();
        sqlModeBtn = new javax.swing.JButton();
        sqlSaveBtn = new javax.swing.JButton();
        dbTableNameTxt = new javax.swing.JTextField();
        dbTableNameLabel = new javax.swing.JLabel();
        dbNameTxt = new javax.swing.JTextField();
        dbNameLabel = new javax.swing.JLabel();
        dbUserLabel = new javax.swing.JLabel();
        dbUserTxt = new javax.swing.JTextField();
        dbPwLabel = new javax.swing.JLabel();
        dbPwTxt = new javax.swing.JPasswordField();
        dbPortTxt = new javax.swing.JTextField();
        dbPortLabel = new javax.swing.JLabel();
        dbHostTxt = new javax.swing.JTextField();
        dbHostLabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        sqlModeLabel = new javax.swing.JLabel();

        jFileChooser1.setFileHidingEnabled(true);
        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

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
                            .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(genTodayBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(genTomorrowBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
                            .addComponent(genMotdBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(ControlPanelLayout.createSequentialGroup()
                            .addComponent(createBackupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(deleteSourceBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jLabel2)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(motdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(progBar, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
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
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jLabel14.setText("Scrollgeschwindigkeit");

        speedPlanTxt.setText("100");

        jLabel7.setText("Laufschriftgeschw.");

        speedMotdTxt.setText("100");

        autoBackupCheck.setText("Automatisches Backup");

        autoDeleteSourceCheck.setText("Auto Quellen löschen");

        jLabel20.setText("%");

        jLabel21.setText("%");

        settingsSaveBtn.setText("speichern");
        settingsSaveBtn.setToolTipText("");
        settingsSaveBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                settingsSaveBtnActionPerformed(evt);
            }
        });

        hour10Label.setText("10. Stunde");

        hour9Label.setText("9. Stunde");

        hour7Label.setText("7. Stunde");

        hour5Label.setText("5. Stunde");

        hour3Label.setText("3. Stunde");

        hour1Label.setText("1. Stunde");

        hour2Label.setText("2. Stunde");

        hour4Label.setText("4. Stunde");

        hour6Label.setText("6. Stunde");

        hour8Label.setText("8. Stunde");

        hoursHeadLabel.setText("Stunden ausblenden ab:");

        useHoursCheck.setText("Vergangene Vertretungen automatisch ausblenden");
        useHoursCheck.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                useHoursCheckStateChanged(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout SettingsPanelLayout = new javax.swing.GroupLayout(SettingsPanel);
        SettingsPanel.setLayout(SettingsPanelLayout);
        SettingsPanelLayout.setHorizontalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                        .addComponent(settingsSaveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SettingsPanelLayout.createSequentialGroup()
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(autoDeleteSourceCheck, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(autoBackupCheck, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                                .addGap(6, 6, 6))
                            .addGroup(SettingsPanelLayout.createSequentialGroup()
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(speedPlanTxt)
                                    .addComponent(speedMotdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20)
                                    .addComponent(jLabel21))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(hoursHeadLabel)
                            .addGroup(SettingsPanelLayout.createSequentialGroup()
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(hour9Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hour7Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hour5Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hour3Label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hour1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(hour3Txt)
                                    .addComponent(hour5Txt)
                                    .addComponent(hour7Txt)
                                    .addComponent(hour9Txt)
                                    .addComponent(hour1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                                        .addComponent(hour8Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hour8Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                                        .addComponent(hour10Label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hour10Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                                        .addComponent(hour6Label, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(hour6Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hour2Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(hour4Label, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(hour2Txt)
                                            .addComponent(hour4Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(useHoursCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                        .addGap(14, 14, 14))))
        );
        SettingsPanelLayout.setVerticalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                        .addComponent(useHoursCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hoursHeadLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hour1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour1Label)
                            .addComponent(hour2Label)
                            .addComponent(hour2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hour3Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour3Label)
                            .addComponent(hour4Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour4Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hour5Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour5Label)
                            .addComponent(hour6Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour6Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hour7Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour7Label)
                            .addComponent(hour8Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour8Label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hour9Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour9Label)
                            .addComponent(hour10Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hour10Label)))
                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                        .addComponent(autoBackupCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(autoDeleteSourceCheck)
                        .addGap(18, 18, 18)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(speedPlanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(speedMotdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel21)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(settingsSaveBtn)
                .addContainerGap())
        );

        Tabs.addTab("Einstellungen", SettingsPanel);

        jLabel6.setText("Quellpfad");

        selectSourceTodayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/ordner.png"))); // NOI18N
        selectSourceTodayBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectSourceTodayBtnActionPerformed(evt);
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

        selectDestBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/ordner.png"))); // NOI18N
        selectDestBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectDestBtnActionPerformed(evt);
            }
        });

        destArea.setColumns(20);
        destArea.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        destArea.setRows(5);
        jScrollPane2.setViewportView(destArea);

        jLabel8.setText("Backuppfad");

        jLabel9.setText("Zielpfade");

        savePathBtn.setText("speichern");
        savePathBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                savePathBtnActionPerformed(evt);
            }
        });

        customSourceCheck.setText("Benutzerdefiniert");
        customSourceCheck.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                customSourceCheckStateChanged(evt);
            }
        });

        jLabel10.setText("Heute");
        jLabel10.setEnabled(false);

        sourceTodayTxt.setEditable(false);

        sourceTomorrowTxt.setEditable(false);

        jLabel22.setText("Morgen");
        jLabel22.setEnabled(false);

        javax.swing.GroupLayout PathPanelLayout = new javax.swing.GroupLayout(PathPanel);
        PathPanel.setLayout(PathPanelLayout);
        PathPanelLayout.setHorizontalGroup(
            PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PathPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(savePathBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PathPanelLayout.createSequentialGroup()
                        .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PathPanelLayout.createSequentialGroup()
                                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sourceTxt)
                                    .addGroup(PathPanelLayout.createSequentialGroup()
                                        .addComponent(customSourceCheck)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sourceTodayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(sourceTomorrowTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(selectSourceTodayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PathPanelLayout.createSequentialGroup()
                                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(backupTxt))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selectDestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(selectBackupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        PathPanelLayout.setVerticalGroup(
            PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PathPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(sourceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(selectSourceTodayBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customSourceCheck)
                    .addComponent(jLabel10)
                    .addComponent(sourceTodayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(sourceTomorrowTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backupTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(selectBackupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(selectDestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addComponent(savePathBtn)
                .addContainerGap())
        );

        Tabs.addTab("Pfade", PathPanel);

        jLabel11.setText("Vertretungplan");

        colorPlanCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                colorPlanComboItemStateChanged(evt);
            }
        });

        colorPlanPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout colorPlanPanelLayout = new javax.swing.GroupLayout(colorPlanPanel);
        colorPlanPanel.setLayout(colorPlanPanelLayout);
        colorPlanPanelLayout.setHorizontalGroup(
            colorPlanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        colorPlanPanelLayout.setVerticalGroup(
            colorPlanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        colorMotdPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout colorMotdPanelLayout = new javax.swing.GroupLayout(colorMotdPanel);
        colorMotdPanel.setLayout(colorMotdPanelLayout);
        colorMotdPanelLayout.setHorizontalGroup(
            colorMotdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        colorMotdPanelLayout.setVerticalGroup(
            colorMotdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        deleteColor.setText("Farbe löschen");
        deleteColor.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteColorActionPerformed(evt);
            }
        });

        addColorBtn.setText("Farbe bearbeiten/hinzufügen");
        addColorBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addColorBtnActionPerformed(evt);
            }
        });

        colorNameTxt.setText("Farbenname");

        jLabel13.setText("Laufschrift");

        colorMotdCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                colorMotdComboItemStateChanged(evt);
            }
        });

        jLabel3.setText("Hintergrundfarben");

        jLabel12.setText("Tabelle");

        colorTableCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                colorTableComboItemStateChanged(evt);
            }
        });

        colorTablePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout colorTablePanelLayout = new javax.swing.GroupLayout(colorTablePanel);
        colorTablePanel.setLayout(colorTablePanelLayout);
        colorTablePanelLayout.setHorizontalGroup(
            colorTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        colorTablePanelLayout.setVerticalGroup(
            colorTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel15.setText("andere Farben");

        jLabel16.setText("Rahmen");

        colorBorderCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                colorBorderComboItemStateChanged(evt);
            }
        });

        colorBorderPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout colorBorderPanelLayout = new javax.swing.GroupLayout(colorBorderPanel);
        colorBorderPanel.setLayout(colorBorderPanelLayout);
        colorBorderPanelLayout.setHorizontalGroup(
            colorBorderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        colorBorderPanelLayout.setVerticalGroup(
            colorBorderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        jLabel17.setText("Text");

        typeToEditCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Überschrift", "Klassenname", "Laufschrift", "Tabelle", "Art: Raum-Vtr." }));
        typeToEditCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                typeToEditComboItemStateChanged(evt);
            }
        });

        typeToEditTxt.setText("Vertretungsart");

        addTypeBtn.setText("hinzufügen");

        deleteTypeBtn.setText("löschen");

        label.setText("Schriftfarbe");

        fontColorPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout fontColorPanelLayout = new javax.swing.GroupLayout(fontColorPanel);
        fontColorPanel.setLayout(fontColorPanelLayout);
        fontColorPanelLayout.setHorizontalGroup(
            fontColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        fontColorPanelLayout.setVerticalGroup(
            fontColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        fontColorCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                fontColorComboItemStateChanged(evt);
            }
        });

        jLabel23.setText("Schriftart");

        fontTypeTxt.setText("Schriftart");

        fontSizeLabel.setText("Schriftgröße");

        backgroundColorLabel.setText("Hintergrundfarbe");

        backgroundColorCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                backgroundColorComboItemStateChanged(evt);
            }
        });

        backgroundColorPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout backgroundColorPanelLayout = new javax.swing.GroupLayout(backgroundColorPanel);
        backgroundColorPanel.setLayout(backgroundColorPanelLayout);
        backgroundColorPanelLayout.setHorizontalGroup(
            backgroundColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        backgroundColorPanelLayout.setVerticalGroup(
            backgroundColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        fontSizeTxt.setText("12");

        boldCheck.setText("Fett");

        italicCheck.setText("Kursiv");

        underlinedCheck.setText("Unterstrichen");

        javax.swing.GroupLayout DesignPanelLayout = new javax.swing.GroupLayout(DesignPanel);
        DesignPanel.setLayout(DesignPanelLayout);
        DesignPanelLayout.setHorizontalGroup(
            DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesignPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator4)
                    .addGroup(DesignPanelLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorPlanCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colorPlanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 33, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(colorMotdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colorMotdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(10, 10, 10)
                        .addComponent(colorTableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colorTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DesignPanelLayout.createSequentialGroup()
                        .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DesignPanelLayout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(typeToEditCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DesignPanelLayout.createSequentialGroup()
                                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(DesignPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fontTypeTxt))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, DesignPanelLayout.createSequentialGroup()
                                        .addComponent(label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fontColorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fontColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DesignPanelLayout.createSequentialGroup()
                                        .addComponent(fontSizeLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fontSizeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(boldCheck)
                                        .addGap(18, 18, 18)
                                        .addComponent(italicCheck)
                                        .addGap(18, 18, 18)
                                        .addComponent(underlinedCheck))
                                    .addGroup(DesignPanelLayout.createSequentialGroup()
                                        .addComponent(backgroundColorLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(backgroundColorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(backgroundColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(DesignPanelLayout.createSequentialGroup()
                                        .addComponent(typeToEditTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(addTypeBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deleteTypeBtn))))
                            .addComponent(jLabel3)
                            .addGroup(DesignPanelLayout.createSequentialGroup()
                                .addComponent(colorNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addColorBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteColor))
                            .addComponent(jLabel15)
                            .addGroup(DesignPanelLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorBorderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorBorderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        DesignPanelLayout.setVerticalGroup(
            DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesignPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colorNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addColorBtn)
                    .addComponent(deleteColor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DesignPanelLayout.createSequentialGroup()
                        .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(colorMotdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(DesignPanelLayout.createSequentialGroup()
                                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(colorPlanCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(colorTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colorPlanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colorMotdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel16)
                                .addComponent(colorBorderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(colorBorderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(typeToEditCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(typeToEditTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addTypeBtn)
                            .addComponent(deleteTypeBtn)))
                    .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(colorTableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DesignPanelLayout.createSequentialGroup()
                        .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(backgroundColorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(backgroundColorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(fontColorPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(label, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(fontColorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(fontTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fontSizeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(fontSizeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(boldCheck)
                            .addComponent(italicCheck)
                            .addComponent(underlinedCheck))
                        .addGap(67, 67, 67))
                    .addGroup(DesignPanelLayout.createSequentialGroup()
                        .addComponent(backgroundColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        fontSizeTxt.getAccessibleContext().setAccessibleName("");

        Tabs.addTab("Design", DesignPanel);

        useSQLCheck.setText("SQL benutzen");
        useSQLCheck.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                useSQLCheckStateChanged(evt);
            }
        });

        sqlModeBtn.setText("schreiben");
        sqlModeBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sqlModeBtnActionPerformed(evt);
            }
        });

        sqlSaveBtn.setText("speichern");
        sqlSaveBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sqlSaveBtnActionPerformed(evt);
            }
        });

        dbTableNameLabel.setText("Tabellenname:");

        dbNameLabel.setText("Datenbankname:");

        dbUserLabel.setText("Benutzername:");

        dbPwLabel.setText("Passwort:");

        dbPortTxt.setText("1433");

        dbPortLabel.setText("Port:");

        dbHostTxt.setText("www.antonianum.de");
        dbHostTxt.setToolTipText("");

        dbHostLabel.setText("Datenbank Host:");

        sqlModeLabel.setText("Sql-Modus:");

        javax.swing.GroupLayout SQLPanelLayout = new javax.swing.GroupLayout(SQLPanel);
        SQLPanel.setLayout(SQLPanelLayout);
        SQLPanelLayout.setHorizontalGroup(
            SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SQLPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sqlSaveBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(useSQLCheck, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dbHostLabel, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SQLPanelLayout.createSequentialGroup()
                        .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dbNameLabel)
                            .addComponent(dbUserLabel))
                        .addGap(18, 18, 18)
                        .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(SQLPanelLayout.createSequentialGroup()
                                .addComponent(dbHostTxt)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dbPortLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dbPortTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SQLPanelLayout.createSequentialGroup()
                                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dbUserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dbNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dbTableNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dbPwLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dbTableNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(dbPwTxt)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, SQLPanelLayout.createSequentialGroup()
                        .addComponent(sqlModeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sqlModeBtn)))
                .addContainerGap())
        );
        SQLPanelLayout.setVerticalGroup(
            SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SQLPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(useSQLCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbHostLabel)
                    .addComponent(dbHostTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dbPortLabel)
                    .addComponent(dbPortTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbNameLabel)
                    .addComponent(dbNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dbTableNameLabel)
                    .addComponent(dbTableNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dbUserTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dbUserLabel)
                    .addComponent(dbPwLabel)
                    .addComponent(dbPwTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sqlModeBtn)
                    .addComponent(sqlModeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addComponent(sqlSaveBtn)
                .addContainerGap())
        );

        Tabs.addTab("SQL", SQLPanel);

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

    private void selectSourceTodayBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectSourceTodayBtnActionPerformed
    {//GEN-HEADEREND:event_selectSourceTodayBtnActionPerformed
        jFileChooser1.showOpenDialog(null);
        sourceTxt.setText(jFileChooser1.getSelectedFile().getPath());
    }//GEN-LAST:event_selectSourceTodayBtnActionPerformed

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

    private void savePathBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_savePathBtnActionPerformed
    {//GEN-HEADEREND:event_savePathBtnActionPerformed
        Application.addToQueue("savePathBtnActionPerformed", sourceTxt, backupTxt, destArea, sourceTodayTxt, sourceTomorrowTxt, customSourceCheck);
    }//GEN-LAST:event_savePathBtnActionPerformed

    private void addColorBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addColorBtnActionPerformed
    {//GEN-HEADEREND:event_addColorBtnActionPerformed
        Application.addToQueue("addColorBtnActionPerformed", jColorChooser1, colorNameTxt, colorPlanCombo, colorMotdCombo, colorTableCombo, colorBorderCombo);
    }//GEN-LAST:event_addColorBtnActionPerformed

    private void colorPlanComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorPlanComboItemStateChanged
    {//GEN-HEADEREND:event_colorPlanComboItemStateChanged
        Application.addToQueue("colorPlanComboItemStateChanged", colorPlanPanel, colorPlanCombo, evt);
    }//GEN-LAST:event_colorPlanComboItemStateChanged

    private void colorMotdComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorMotdComboItemStateChanged
    {//GEN-HEADEREND:event_colorMotdComboItemStateChanged
        Application.addToQueue("colorMotdComboItemStateChanged", colorMotdPanel, colorMotdCombo, evt);
    }//GEN-LAST:event_colorMotdComboItemStateChanged

    private void deleteColorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteColorActionPerformed
    {//GEN-HEADEREND:event_deleteColorActionPerformed
        Application.addToQueue("deleteColorBtnActionPerformed", colorNameTxt, colorPlanCombo, colorMotdCombo, colorTableCombo, colorBorderCombo);
    }//GEN-LAST:event_deleteColorActionPerformed

    private void useSQLCheckStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_useSQLCheckStateChanged
    {//GEN-HEADEREND:event_useSQLCheckStateChanged
        for(JComponent j : sqlComponents)
            j.setEnabled(useSQLCheck.isSelected());
    }//GEN-LAST:event_useSQLCheckStateChanged

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

    private void sqlSaveBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sqlSaveBtnActionPerformed
    {//GEN-HEADEREND:event_sqlSaveBtnActionPerformed
        Application.addToQueue("SQLsaveBtnActionPerformed", dbHostTxt, dbPortTxt, dbNameTxt,
                               dbUserTxt, dbPwTxt, dbTableNameTxt, useSQLCheck, sqlModeBtn);
    }//GEN-LAST:event_sqlSaveBtnActionPerformed

    private void settingsSaveBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_settingsSaveBtnActionPerformed
    {//GEN-HEADEREND:event_settingsSaveBtnActionPerformed
        Application.addToQueue("settingsSaveBtnActionPerformed", hour1Txt, hour2Txt, hour3Txt,
                               hour4Txt, hour5Txt, hour6Txt, hour7Txt, hour8Txt, hour9Txt, hour10Txt,
                               useHoursCheck, autoBackupCheck, autoDeleteSourceCheck, speedPlanTxt, speedMotdTxt);
    }//GEN-LAST:event_settingsSaveBtnActionPerformed

    private void sqlModeBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sqlModeBtnActionPerformed
    {//GEN-HEADEREND:event_sqlModeBtnActionPerformed
        if(sqlModeBtn.getText().equals("lesen"))
            sqlModeBtn.setText("schreiben");
        else
            sqlModeBtn.setText("lesen");
    }//GEN-LAST:event_sqlModeBtnActionPerformed

    private void useHoursCheckStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_useHoursCheckStateChanged
    {//GEN-HEADEREND:event_useHoursCheckStateChanged
        for(JComponent j : hoursComponents)
            j.setEnabled(useHoursCheck.isSelected());
    }//GEN-LAST:event_useHoursCheckStateChanged

    private void typeToEditComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_typeToEditComboItemStateChanged
    {//GEN-HEADEREND:event_typeToEditComboItemStateChanged
        backgroundColorLabel.setEnabled(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"));
        backgroundColorCombo.setEnabled(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"));
        backgroundColorPanel.setEnabled(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"));
    }//GEN-LAST:event_typeToEditComboItemStateChanged

    private void customSourceCheckStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_customSourceCheckStateChanged
    {//GEN-HEADEREND:event_customSourceCheckStateChanged
        sourceTodayTxt.setEnabled(customSourceCheck.isSelected());
        sourceTomorrowTxt.setEnabled(customSourceCheck.isSelected());
        jLabel10.setEnabled(customSourceCheck.isSelected());
        jLabel22.setEnabled(customSourceCheck.isSelected());
    }//GEN-LAST:event_customSourceCheckStateChanged

    private void colorTableComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorTableComboItemStateChanged
    {//GEN-HEADEREND:event_colorTableComboItemStateChanged
        Application.addToQueue("colorTableComboItemStateChanged", colorTablePanel, colorTableCombo, evt);
    }//GEN-LAST:event_colorTableComboItemStateChanged

    private void colorBorderComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorBorderComboItemStateChanged
    {//GEN-HEADEREND:event_colorBorderComboItemStateChanged
        Application.addToQueue("colorBorderComboItemStateChanged", colorBorderPanel, colorBorderCombo, evt);
    }//GEN-LAST:event_colorBorderComboItemStateChanged

    private void fontColorComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_fontColorComboItemStateChanged
    {//GEN-HEADEREND:event_fontColorComboItemStateChanged
        Application.addToQueue("fontColorComboItemStateChanged", fontColorPanel, fontColorCombo, typeToEditCombo, evt);
    }//GEN-LAST:event_fontColorComboItemStateChanged

    private void backgroundColorComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_backgroundColorComboItemStateChanged
    {//GEN-HEADEREND:event_backgroundColorComboItemStateChanged
        Application.addToQueue("backgroundColorComboItemStateChanged", backgroundColorPanel, backgroundColorCombo,
                               typeToEditCombo, typeToEditCombo, evt);
    }//GEN-LAST:event_backgroundColorComboItemStateChanged

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
                               hour4Txt, hour5Txt, hour6Txt, hour7Txt, hour8Txt, hour9Txt, hour10Txt, sqlModeBtn,
                               autoBackupCheck, autoDeleteSourceCheck, useHoursCheck, customSourceCheck, sourceTodayTxt,
                               sourceTomorrowTxt, colorTableCombo, colorBorderCombo, fontColorCombo, backgroundColorCombo);

        sourceTodayTxt.setEnabled(customSourceCheck.isSelected());
        sourceTomorrowTxt.setEnabled(customSourceCheck.isSelected());
        jLabel10.setEnabled(customSourceCheck.isSelected());
        jLabel22.setEnabled(customSourceCheck.isSelected());
        backgroundColorLabel.setEnabled(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"));
        backgroundColorCombo.setEnabled(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"));
        backgroundColorPanel.setEnabled(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"));

        for(JComponent j : sqlComponents)
            j.setEnabled(useSQLCheck.isSelected());

        for(JComponent j : hoursComponents)
            j.setEnabled(useHoursCheck.isSelected());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ControlPanel;
    private javax.swing.JPanel DesignPanel;
    private javax.swing.JPanel PathPanel;
    private javax.swing.JPanel SQLPanel;
    private javax.swing.JPanel SettingsPanel;
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JButton addColorBtn;
    private javax.swing.JButton addTypeBtn;
    private javax.swing.JCheckBox autoBackupCheck;
    private javax.swing.JCheckBox autoDeleteSourceCheck;
    private javax.swing.JComboBox backgroundColorCombo;
    private javax.swing.JLabel backgroundColorLabel;
    private javax.swing.JPanel backgroundColorPanel;
    private javax.swing.JTextField backupTxt;
    private javax.swing.JCheckBox boldCheck;
    private javax.swing.JComboBox colorBorderCombo;
    private javax.swing.JPanel colorBorderPanel;
    private javax.swing.JComboBox colorMotdCombo;
    private javax.swing.JPanel colorMotdPanel;
    private javax.swing.JTextField colorNameTxt;
    private javax.swing.JComboBox colorPlanCombo;
    private javax.swing.JPanel colorPlanPanel;
    private javax.swing.JComboBox colorTableCombo;
    private javax.swing.JPanel colorTablePanel;
    private javax.swing.JButton createBackupBtn;
    private javax.swing.JCheckBox customSourceCheck;
    private javax.swing.JLabel dbHostLabel;
    private javax.swing.JTextField dbHostTxt;
    private javax.swing.JLabel dbNameLabel;
    private javax.swing.JTextField dbNameTxt;
    private javax.swing.JLabel dbPortLabel;
    private javax.swing.JTextField dbPortTxt;
    private javax.swing.JLabel dbPwLabel;
    private javax.swing.JPasswordField dbPwTxt;
    private javax.swing.JLabel dbTableNameLabel;
    private javax.swing.JTextField dbTableNameTxt;
    private javax.swing.JLabel dbUserLabel;
    private javax.swing.JTextField dbUserTxt;
    private javax.swing.JButton deleteColor;
    private javax.swing.JButton deleteSourceBtn;
    private javax.swing.JButton deleteTypeBtn;
    private javax.swing.JTextArea destArea;
    private javax.swing.JComboBox fontColorCombo;
    private javax.swing.JPanel fontColorPanel;
    private javax.swing.JLabel fontSizeLabel;
    private javax.swing.JTextField fontSizeTxt;
    private javax.swing.JTextField fontTypeTxt;
    private javax.swing.JButton genAllBtn;
    private javax.swing.JButton genMotdBtn;
    private javax.swing.JButton genTodayBtn;
    private javax.swing.JButton genTomorrowBtn;
    private javax.swing.JLabel hour10Label;
    private javax.swing.JTextField hour10Txt;
    private javax.swing.JLabel hour1Label;
    private javax.swing.JTextField hour1Txt;
    private javax.swing.JLabel hour2Label;
    private javax.swing.JTextField hour2Txt;
    private javax.swing.JLabel hour3Label;
    private javax.swing.JTextField hour3Txt;
    private javax.swing.JLabel hour4Label;
    private javax.swing.JTextField hour4Txt;
    private javax.swing.JLabel hour5Label;
    private javax.swing.JTextField hour5Txt;
    private javax.swing.JLabel hour6Label;
    private javax.swing.JTextField hour6Txt;
    private javax.swing.JLabel hour7Label;
    private javax.swing.JTextField hour7Txt;
    private javax.swing.JLabel hour8Label;
    private javax.swing.JTextField hour8Txt;
    private javax.swing.JLabel hour9Label;
    private javax.swing.JTextField hour9Txt;
    private javax.swing.JLabel hoursHeadLabel;
    private javax.swing.JCheckBox italicCheck;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JLabel label;
    private javax.swing.JTextPane log;
    private javax.swing.JTextField motdTxt;
    private javax.swing.JProgressBar progBar;
    private javax.swing.JButton savePathBtn;
    private javax.swing.JButton selectBackupBtn;
    private javax.swing.JButton selectDestBtn;
    private javax.swing.JButton selectSourceTodayBtn;
    private javax.swing.JButton settingsSaveBtn;
    private javax.swing.JTextField sourceTodayTxt;
    private javax.swing.JTextField sourceTomorrowTxt;
    private javax.swing.JTextField sourceTxt;
    private javax.swing.JTextField speedMotdTxt;
    private javax.swing.JTextField speedPlanTxt;
    private javax.swing.JButton sqlModeBtn;
    private javax.swing.JLabel sqlModeLabel;
    private javax.swing.JButton sqlSaveBtn;
    private javax.swing.JComboBox typeToEditCombo;
    private javax.swing.JTextField typeToEditTxt;
    private javax.swing.JCheckBox underlinedCheck;
    private javax.swing.JCheckBox useHoursCheck;
    private javax.swing.JCheckBox useSQLCheck;
    // End of variables declaration//GEN-END:variables
}
