package com.facharbeit.main;

import javax.swing.*;

/**
 * Anzeige-Fenster der Anwendung.
 */
public class Frame extends javax.swing.JFrame
{
    /**
     * Zufallsgenerierter Schlüssel
     */
    private static final long serialVersionUID = 1841024231;

    /**
     * Erstellt ein neues Fenster.
     *
     * @throws java.lang.Exception Fehler
     */
    public Frame() throws Exception
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jColorChooser1 = new javax.swing.JColorChooser();
        jFileChooser1 = new javax.swing.JFileChooser();
        sqlMode = new javax.swing.ButtonGroup();
        Tabs = new javax.swing.JTabbedPane();
        ControlPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        log = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        genTodayBtn = new javax.swing.JButton();
        genTomorrowBtn = new javax.swing.JButton();
        genAllBtn = new javax.swing.JButton();
        genMotdBtn = new javax.swing.JButton();
        progBar = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        createBackupBtn = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        motdTxt = new javax.swing.JTextField();
        SettingsPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        speedPlanTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        speedMotdTxt = new javax.swing.JTextField();
        autoBackupCheck = new javax.swing.JCheckBox();
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
        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel18 = new javax.swing.JLabel();
        weekTxt = new javax.swing.JTextField();
        customSourceCheck = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        sourceTodayTxt = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        sourceTomorrowTxt = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel25 = new javax.swing.JLabel();
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
        jSeparator9 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        fileNamePrefixTxt = new javax.swing.JTextField();
        fileNameMiddle = new javax.swing.JTextField();
        fileNameSuffixTxt = new javax.swing.JTextField();
        DesignPanel = new javax.swing.JPanel();
        bgPlanLabel = new javax.swing.JLabel();
        colorPlanCombo = new javax.swing.JComboBox<String>();
        colorPlanPanel = new javax.swing.JPanel();
        colorMotdPanel = new javax.swing.JPanel();
        deleteColor = new javax.swing.JButton();
        addColorBtn = new javax.swing.JButton();
        colorNameTxt = new javax.swing.JTextField();
        bgMotdLabel = new javax.swing.JLabel();
        colorMotdCombo = new javax.swing.JComboBox<String>();
        backgroundColorsLabel = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        bgTableLabel = new javax.swing.JLabel();
        colorTableCombo = new javax.swing.JComboBox<String>();
        colorTablePanel = new javax.swing.JPanel();
        otherColorsLabel = new javax.swing.JLabel();
        otherBorderLabel = new javax.swing.JLabel();
        colorBorderCombo = new javax.swing.JComboBox<String>();
        colorBorderPanel = new javax.swing.JPanel();
        jSeparator7 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
        saveDesignBtn = new javax.swing.JButton();
        designTypeSubPanel = new javax.swing.JPanel();
        deleteTypeBtn = new javax.swing.JButton();
        addTypeBtn = new javax.swing.JButton();
        typeToEditTxt = new javax.swing.JTextField();
        typeToEditCombo = new javax.swing.JComboBox<String>();
        tteFontColorLabel = new javax.swing.JLabel();
        fontColorCombo = new javax.swing.JComboBox<String>();
        fontColorPanel = new javax.swing.JPanel();
        tteBgLabel = new javax.swing.JLabel();
        backgroundColorCombo = new javax.swing.JComboBox<String>();
        backgroundColorPanel = new javax.swing.JPanel();
        tteFontTypeLabel = new javax.swing.JLabel();
        fontTypeTxt = new javax.swing.JTextField();
        tteFontSizeLabel = new javax.swing.JLabel();
        fontSizeTxt = new javax.swing.JTextField();
        boldCheck = new javax.swing.JCheckBox();
        italicCheck = new javax.swing.JCheckBox();
        typeToEditLabel = new javax.swing.JLabel();
        SQLPanel = new javax.swing.JPanel();
        useSQLCheck = new javax.swing.JCheckBox();
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
        sqlModeReadRBtn = new javax.swing.JRadioButton();
        sqlModeWriteRBtn = new javax.swing.JRadioButton();
        sqlModeDelWriteRBtn = new javax.swing.JRadioButton();

        jFileChooser1.setFileHidingEnabled(true);
        jFileChooser1.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Vertretungsplan");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Tabs.setToolTipText("");

        ControlPanel.setToolTipText("");

        log.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        log.setToolTipText("Zeigt den Status des Programms an");
        log.setFocusable(false);
        jScrollPane1.setViewportView(log);

        jLabel1.setText("Status:");

        genTodayBtn.setText("Heutigen Plan generieren");
        genTodayBtn.setToolTipText("Generiert nur den heutigen Plan");
        genTodayBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                genTodayBtnActionPerformed(evt);
            }
        });

        genTomorrowBtn.setText("Morgigen Plan generieren");
        genTomorrowBtn.setToolTipText("Generiert nur den morgigen Plan");
        genTomorrowBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                genTomorrowBtnActionPerformed(evt);
            }
        });

        genAllBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        genAllBtn.setText("<html><center>Alles<br>\ngenerieren</center></html>");
        genAllBtn.setToolTipText("Generiert den kompletten Plan");
        genAllBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        genAllBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                genAllBtnActionPerformed(evt);
            }
        });

        genMotdBtn.setText("Laufschrift generieren");
        genMotdBtn.setToolTipText("Generiert UND SPEICHERT nur die Laufschrift");
        genMotdBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                genMotdBtnActionPerformed(evt);
            }
        });

        progBar.setMaximum(1);
        progBar.setToolTipText("Zeigt den Fortschritt der Generierung an");

        jLabel4.setText("Arbeit:");

        createBackupBtn.setText("Backup erstellen");
        createBackupBtn.setToolTipText("Erstellt ein Backup des aktuellen Plans");
        createBackupBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                createBackupBtnActionPerformed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/antonianumLogo.jpg"))); // NOI18N
        jLabel5.setToolTipText("Antonianum Logo");

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane4.setAutoscrolls(true);
        jScrollPane4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        motdTxt.setText("Laufschrift");
        motdTxt.setToolTipText("Text, der als Laufschrift angezeigt werden soll z.B. \"Dies ist eine Laufschrift\"");
        motdTxt.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 5));
        motdTxt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        motdTxt.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                motdTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                motdTxtFocusLost(evt);
            }
        });
        jScrollPane4.setViewportView(motdTxt);

        javax.swing.GroupLayout ControlPanelLayout = new javax.swing.GroupLayout(ControlPanel);
        ControlPanel.setLayout(ControlPanelLayout);
        ControlPanelLayout.setHorizontalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ControlPanelLayout.createSequentialGroup()
                            .addComponent(genAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(genTodayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(genTomorrowBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(genMotdBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(createBackupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(progBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        ControlPanelLayout.setVerticalGroup(
            ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ControlPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(progBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ControlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ControlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ControlPanelLayout.createSequentialGroup()
                                .addComponent(genTodayBtn)
                                .addGap(6, 6, 6)
                                .addComponent(genTomorrowBtn)
                                .addGap(6, 6, 6)
                                .addComponent(genMotdBtn)
                                .addGap(8, 8, 8)
                                .addComponent(createBackupBtn))
                            .addComponent(genAllBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Tabs.addTab("Übersicht", ControlPanel);

        jLabel14.setText("Scrollgeschwindigkeit");

        speedPlanTxt.setToolTipText("Scrollgeschwindigkeit des Plans in % z.B. \"100\"");

        jLabel7.setText("Laufschriftgeschw.");

        speedMotdTxt.setToolTipText("Scrollgeschwindigkeit der Laufschrift in % z.B. \"100\"");

        autoBackupCheck.setText("Automatisches Backup");
        autoBackupCheck.setToolTipText("Soll ein automatisches Backup beim Generieren erstellt werden?");

        jLabel20.setText("%");

        jLabel21.setText("%");

        settingsSaveBtn.setText("speichern");
        settingsSaveBtn.setToolTipText("Speichert die Einstellungen der gesamten Seite, wendet sie aber nicht an");
        settingsSaveBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                settingsSaveBtnActionPerformed(evt);
            }
        });

        hour10Txt.setToolTipText("Zeit, nach der die zehnte Stunde gelöscht wird z.B. \"9:25\"");

        hour10Label.setText("10. Stunde");

        hour9Txt.setToolTipText("Zeit, nach der die neunte Stunde gelöscht wird z.B. \"9:25\"");

        hour9Label.setText("9. Stunde");

        hour7Label.setText("7. Stunde");

        hour7Txt.setToolTipText("Zeit, nach der die siebte Stunde gelöscht wird z.B. \"9:25\"");

        hour8Txt.setToolTipText("Zeit, nach der die achte Stunde gelöscht wird z.B. \"9:25\"");

        hour6Txt.setToolTipText("Zeit, nach der die sechste Stunde gelöscht wird z.B. \"9:25\"");

        hour4Txt.setToolTipText("Zeit, nach der die vierte Stunde gelöscht wird z.B. \"9:25\"");

        hour2Txt.setToolTipText("Zeit, nach der die zweite Stunde gelöscht wird z.B. \"9:25\"");

        hour1Txt.setToolTipText("Zeit, nach der die erste Stunde gelöscht wird z.B. \"9:25\"");

        hour3Txt.setToolTipText("Zeit, nach der die dritte Stunde gelöscht wird z.B. \"9:25\"");

        hour5Txt.setToolTipText("Zeit, nach der die fünfte Stunde gelöscht wird z.B. \"9:25\"");

        hour5Label.setText("5. Stunde");

        hour3Label.setText("3. Stunde");

        hour1Label.setText("1. Stunde");

        hour2Label.setText("2. Stunde");

        hour4Label.setText("4. Stunde");

        hour6Label.setText("6. Stunde");

        hour8Label.setText("8. Stunde");

        hoursHeadLabel.setText("Stunden ausblenden ab:");

        useHoursCheck.setText("Vergangene Vertretungen automatisch ausblenden");
        useHoursCheck.setToolTipText("Sollen vergangene Stunden ausgeblendet werden?");
        useHoursCheck.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                useHoursCheckStateChanged(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {"ker", "info1", "Raum-Vtr.", "IF-LK1", "ker", "", "Raumänderung"}
            },
            new String []
            {
                "Vertreter", "Raum", "Art", "Fach", "Lehrer", "Verl. von", "Hinweise"
            }
        )
        {
            boolean[] canEdit = new boolean []
            {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit [columnIndex];
            }
        });
        table.setToolTipText("Verändern der Spalten-Sortierung und -Größe auf dem Vertretungsplan");
        jScrollPane3.setViewportView(table);

        jLabel18.setText("Gerade Woche");

        weekTxt.setToolTipText("Buchstaben für die Gerade Woche definieren z.B. \"B\"");

        customSourceCheck.setText("Benutzerdefiniertes Datum");
        customSourceCheck.setToolTipText("Soll ein benutzerdefiniertes Datum für heute und morgen angenommen werden?");
        customSourceCheck.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                customSourceCheckStateChanged(evt);
            }
        });

        jLabel10.setText("Heute");
        jLabel10.setEnabled(false);

        sourceTodayTxt.setToolTipText("Neues Datum für den heutigen Plan z.B. \"24.12.\"");
        sourceTodayTxt.setEnabled(false);

        jLabel22.setText("Morgen");
        jLabel22.setEnabled(false);

        sourceTomorrowTxt.setToolTipText("Neues Datum für den morgigen Plan z.B. \"25.12.\"");
        sourceTomorrowTxt.setEnabled(false);

        jLabel25.setText("Spaltensortierung:");

        javax.swing.GroupLayout SettingsPanelLayout = new javax.swing.GroupLayout(SettingsPanel);
        SettingsPanel.setLayout(SettingsPanelLayout);
        SettingsPanelLayout.setHorizontalGroup(
            SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SettingsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SettingsPanelLayout.createSequentialGroup()
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SettingsPanelLayout.createSequentialGroup()
                                .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(customSourceCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(autoBackupCheck, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE)
                                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel18))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(speedPlanTxt)
                                            .addComponent(speedMotdTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                            .addComponent(weekTxt))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(SettingsPanelLayout.createSequentialGroup()
                                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(sourceTodayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(sourceTomorrowTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                                        .addGap(18, 18, 18)
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
                                    .addComponent(useHoursCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jSeparator8)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(settingsSaveBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
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
                        .addGap(18, 18, 18)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(speedPlanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(speedMotdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(weekTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customSourceCheck)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(sourceTodayTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(SettingsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sourceTomorrowTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 24, Short.MAX_VALUE)
                .addComponent(settingsSaveBtn)
                .addContainerGap())
        );

        Tabs.addTab("Einstellungen", SettingsPanel);

        jLabel6.setText("Quellpfad");

        sourceTxt.setToolTipText("Quellpfad für die Vertretungs-Dateien");

        selectSourceTodayBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/ordner.png"))); // NOI18N
        selectSourceTodayBtn.setToolTipText("Quellpfad auswählen");
        selectSourceTodayBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectSourceTodayBtnActionPerformed(evt);
            }
        });

        selectBackupBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/ordner.png"))); // NOI18N
        selectBackupBtn.setToolTipText("Backuppfad auswählen");
        selectBackupBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectBackupBtnActionPerformed(evt);
            }
        });

        selectDestBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/facharbeit/ressources/ordner.png"))); // NOI18N
        selectDestBtn.setToolTipText("Zielpfad hinzufügen");
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
        destArea.setToolTipText("Zielpfade in die der Plan automatisch kopiert wird; Ein Pfad pro Zeile");
        jScrollPane2.setViewportView(destArea);

        backupTxt.setToolTipText("Backuppfad für den generierten Plan");

        jLabel8.setText("Backuppfad");

        jLabel9.setText("Zielpfade");

        savePathBtn.setText("speichern");
        savePathBtn.setToolTipText("Speichert alle Pfade");
        savePathBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                savePathBtnActionPerformed(evt);
            }
        });

        jLabel3.setText("Dateiname:");

        fileNamePrefixTxt.setText("Druck_Klasse_");
        fileNamePrefixTxt.setToolTipText("Prefix für die Dateinamen");

        fileNameMiddle.setEditable(false);
        fileNameMiddle.setText("05a");

        fileNameSuffixTxt.setText(".htm");
        fileNameSuffixTxt.setToolTipText("Suffix für die Dateinamen");

        javax.swing.GroupLayout PathPanelLayout = new javax.swing.GroupLayout(PathPanel);
        PathPanel.setLayout(PathPanelLayout);
        PathPanelLayout.setHorizontalGroup(
            PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PathPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator9)
                    .addComponent(savePathBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PathPanelLayout.createSequentialGroup()
                        .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                            .addComponent(sourceTxt)
                            .addComponent(backupTxt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(selectBackupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectDestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectSourceTodayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PathPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PathPanelLayout.createSequentialGroup()
                        .addComponent(fileNamePrefixTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileNameMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fileNameSuffixTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)))
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
                    .addComponent(selectSourceTodayBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(backupTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(selectBackupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(selectDestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PathPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNamePrefixTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileNameMiddle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileNameSuffixTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(savePathBtn)
                .addContainerGap())
        );

        Tabs.addTab("Pfade", PathPanel);

        bgPlanLabel.setText("Vertretungplan");

        colorPlanCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Keine Farbe" }));
        colorPlanCombo.setToolTipText("Hintergrundfarbe des Vertretungsplans");
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
        deleteColor.setToolTipText("Angegebene Farbe löschen");
        deleteColor.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteColorActionPerformed(evt);
            }
        });

        addColorBtn.setText("Farbe bearbeiten/hinzufügen");
        addColorBtn.setToolTipText("Angegebene Farbe bearbeiten/hinzufügen");
        addColorBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addColorBtnActionPerformed(evt);
            }
        });

        colorNameTxt.setForeground(java.awt.Color.gray);
        colorNameTxt.setText("Farbenname");
        colorNameTxt.setToolTipText("Name der Farbe, die hinzugefügt/bearbeitet werden soll z.B. \"Antonsblau\"");
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

        bgMotdLabel.setText("Laufschrift");

        colorMotdCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Keine Farbe" }));
        colorMotdCombo.setToolTipText("Hintergrundfarbe der Laufschrift");
        colorMotdCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                colorMotdComboItemStateChanged(evt);
            }
        });

        backgroundColorsLabel.setText("Hintergrundfarben");

        bgTableLabel.setText("Tabelle");

        colorTableCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Keine Farbe" }));
        colorTableCombo.setToolTipText("Hintergrundfarbe der Tabelle");
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

        otherColorsLabel.setText("andere Farben");

        otherBorderLabel.setText("Rahmen");

        colorBorderCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Keine Farbe" }));
        colorBorderCombo.setToolTipText("Farbe des Rahmens, der um die Frames angezeigt wird");
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

        saveDesignBtn.setText("Style anwenden");
        saveDesignBtn.setToolTipText("Den, oben eingestellten, Style für den Plan anwenden");
        saveDesignBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                saveDesignBtnActionPerformed(evt);
            }
        });

        deleteTypeBtn.setText("löschen");
        deleteTypeBtn.setToolTipText("Eine Vertretungsart löschen");
        deleteTypeBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                deleteTypeBtnActionPerformed(evt);
            }
        });

        addTypeBtn.setText("hinzufügen");
        addTypeBtn.setToolTipText("Eine neue, zu differenzierende, Vertretungsart erstellen");
        addTypeBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addTypeBtnActionPerformed(evt);
            }
        });

        typeToEditTxt.setForeground(java.awt.Color.gray);
        typeToEditTxt.setText("Vertretungsart");
        typeToEditTxt.setToolTipText("Name einer neuen, zu differenzierenden, Vertretungsart z.B. \"Raum-Vtr.\"");
        typeToEditTxt.addFocusListener(new java.awt.event.FocusAdapter()
        {
            public void focusGained(java.awt.event.FocusEvent evt)
            {
                typeToEditTxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt)
            {
                typeToEditTxtFocusLost(evt);
            }
        });

        typeToEditCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Überschrift", "Stufenname", "Laufschrift", "Tabelle" }));
        typeToEditCombo.setToolTipText("Bereich des Designs der bearbeitet werden soll");
        typeToEditCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                typeToEditComboItemStateChanged(evt);
            }
        });

        tteFontColorLabel.setText("Schriftfarbe");

        fontColorCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Keine Farbe" }));
        fontColorCombo.setToolTipText("Schriftfarbe für den gewählten Bereich festlegen");
        fontColorCombo.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                fontColorComboItemStateChanged(evt);
            }
        });

        fontColorPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout fontColorPanelLayout = new javax.swing.GroupLayout(fontColorPanel);
        fontColorPanel.setLayout(fontColorPanelLayout);
        fontColorPanelLayout.setHorizontalGroup(
            fontColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );
        fontColorPanelLayout.setVerticalGroup(
            fontColorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 18, Short.MAX_VALUE)
        );

        tteBgLabel.setText("Hintergrundfarbe");

        backgroundColorCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Keine Farbe" }));
        backgroundColorCombo.setToolTipText("Hintergrundfarbe für den gewählten Bereich festlegen");
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

        tteFontTypeLabel.setText("Schriftart");

        fontTypeTxt.setToolTipText("Schriftart für den gewählten Bereich festlegen z.B. \"calibri\"");
        fontTypeTxt.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                fontTypeTxtMouseExited(evt);
            }
        });

        tteFontSizeLabel.setText("Schriftgröße");

        fontSizeTxt.setToolTipText("Schriftgröße für den gewählten Bereich festlegen z.B. \"12\"");
        fontSizeTxt.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                fontSizeTxtMouseExited(evt);
            }
        });

        boldCheck.setText("Fett");
        boldCheck.setToolTipText("Soll die Schrift des gewählten Bereichs fett gedruckt werden?");
        boldCheck.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                boldCheckActionPerformed(evt);
            }
        });

        italicCheck.setText("Kursiv");
        italicCheck.setToolTipText("Soll die Schrift des gewählten Bereichs kursiv gedruckt werden?");
        italicCheck.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                italicCheckActionPerformed(evt);
            }
        });

        typeToEditLabel.setText("Text");

        javax.swing.GroupLayout designTypeSubPanelLayout = new javax.swing.GroupLayout(designTypeSubPanel);
        designTypeSubPanel.setLayout(designTypeSubPanelLayout);
        designTypeSubPanelLayout.setHorizontalGroup(
            designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(designTypeSubPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(designTypeSubPanelLayout.createSequentialGroup()
                        .addComponent(tteFontTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fontTypeTxt))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, designTypeSubPanelLayout.createSequentialGroup()
                        .addGroup(designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tteFontColorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(typeToEditLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(typeToEditCombo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, designTypeSubPanelLayout.createSequentialGroup()
                                .addComponent(fontColorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fontColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(designTypeSubPanelLayout.createSequentialGroup()
                        .addComponent(typeToEditTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(designTypeSubPanelLayout.createSequentialGroup()
                                .addComponent(addTypeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteTypeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(designTypeSubPanelLayout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(designTypeSubPanelLayout.createSequentialGroup()
                                        .addComponent(boldCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(italicCheck, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(designTypeSubPanelLayout.createSequentialGroup()
                                        .addComponent(backgroundColorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(backgroundColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, designTypeSubPanelLayout.createSequentialGroup()
                            .addComponent(tteFontSizeLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fontSizeTxt))
                        .addComponent(tteBgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        designTypeSubPanelLayout.setVerticalGroup(
            designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(designTypeSubPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeToEditCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeToEditTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTypeBtn)
                    .addComponent(deleteTypeBtn)
                    .addComponent(typeToEditLabel))
                .addGap(18, 18, 18)
                .addGroup(designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tteFontColorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(fontColorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(designTypeSubPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(fontColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(designTypeSubPanelLayout.createSequentialGroup()
                        .addGroup(designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(backgroundColorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tteBgLabel)
                                .addComponent(backgroundColorCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tteFontTypeLabel)
                    .addGroup(designTypeSubPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fontTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tteFontSizeLabel)
                        .addComponent(fontSizeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(boldCheck)
                        .addComponent(italicCheck)))
                .addGap(0, 0, 0))
        );

        fontSizeTxt.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout DesignPanelLayout = new javax.swing.GroupLayout(DesignPanel);
        DesignPanel.setLayout(DesignPanelLayout);
        DesignPanelLayout.setHorizontalGroup(
            DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesignPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator7)
                    .addComponent(jSeparator4)
                    .addComponent(saveDesignBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(DesignPanelLayout.createSequentialGroup()
                        .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backgroundColorsLabel)
                            .addGroup(DesignPanelLayout.createSequentialGroup()
                                .addComponent(bgPlanLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(colorPlanCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorPlanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bgMotdLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorMotdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorMotdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bgTableLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorTableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DesignPanelLayout.createSequentialGroup()
                                .addComponent(colorNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(addColorBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(deleteColor))
                            .addComponent(otherColorsLabel)
                            .addGroup(DesignPanelLayout.createSequentialGroup()
                                .addComponent(otherBorderLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorBorderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(colorBorderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19))
                        .addGap(25, 25, 25))
                    .addComponent(designTypeSubPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backgroundColorsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DesignPanelLayout.createSequentialGroup()
                        .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(colorMotdCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bgMotdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(DesignPanelLayout.createSequentialGroup()
                                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(bgPlanLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(colorPlanCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(colorPlanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colorMotdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(DesignPanelLayout.createSequentialGroup()
                                .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(colorTableCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bgTableLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(11, 11, 11)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(otherColorsLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DesignPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(otherBorderLabel)
                                .addComponent(colorBorderCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(colorBorderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(DesignPanelLayout.createSequentialGroup()
                        .addComponent(colorTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(designTypeSubPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(saveDesignBtn)
                .addContainerGap())
        );

        Tabs.addTab("Design", DesignPanel);

        useSQLCheck.setText("SQL benutzen");
        useSQLCheck.setToolTipText("Soll die SQL-Unterstützung aktiviert werden?");
        useSQLCheck.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                useSQLCheckStateChanged(evt);
            }
        });

        sqlSaveBtn.setText("speichern");
        sqlSaveBtn.setToolTipText("Speichert die SQL Einstellungen");
        sqlSaveBtn.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                sqlSaveBtnActionPerformed(evt);
            }
        });

        dbTableNameTxt.setToolTipText("Tabellen Name z.B. \"Vertretungen\"");

        dbTableNameLabel.setText("Tabellenname:");

        dbNameTxt.setToolTipText("Datenbank Name z.B. \"Schuldatenbank\"");

        dbNameLabel.setText("Datenbankname:");

        dbUserLabel.setText("Benutzername:");

        dbUserTxt.setToolTipText("Benutzername z.B. \"admin\"");

        dbPwLabel.setText("Passwort:");

        dbPwTxt.setToolTipText("Passwort z.B. \"passw\"");

        dbPortTxt.setToolTipText("Datenbank Port; Standard:\"3306\"");

        dbPortLabel.setText("Port:");

        dbHostTxt.setToolTipText("Datenbank Host z.B. \"www.antonianum.de\"");

        dbHostLabel.setText("Datenbank Host:");

        sqlModeLabel.setText("Sql-Modus:");

        sqlMode.add(sqlModeReadRBtn);
        sqlModeReadRBtn.setText("lesen");
        sqlModeReadRBtn.setToolTipText("Aus der angegebenen Datenbank lesen, überschreibt HTML-Auslesen");

        sqlMode.add(sqlModeWriteRBtn);
        sqlModeWriteRBtn.setText("anhängen");
        sqlModeWriteRBtn.setToolTipText("Die Vertretungen an die Datenbank anhängen");

        sqlMode.add(sqlModeDelWriteRBtn);
        sqlModeDelWriteRBtn.setText("leeren und schreiben");
        sqlModeDelWriteRBtn.setToolTipText("Die Datenbank leeren und danach neu füllen");

        javax.swing.GroupLayout SQLPanelLayout = new javax.swing.GroupLayout(SQLPanel);
        SQLPanel.setLayout(SQLPanelLayout);
        SQLPanelLayout.setHorizontalGroup(
            SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SQLPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sqlSaveBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addGroup(SQLPanelLayout.createSequentialGroup()
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
                                    .addComponent(dbUserTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                    .addComponent(dbNameTxt))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dbTableNameLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(dbPwLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dbTableNameTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                    .addComponent(dbPwTxt)))))
                    .addGroup(SQLPanelLayout.createSequentialGroup()
                        .addGroup(SQLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(useSQLCheck)
                            .addComponent(dbHostLabel)
                            .addComponent(sqlModeLabel))
                        .addGap(0, 529, Short.MAX_VALUE))
                    .addComponent(sqlModeReadRBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sqlModeWriteRBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(sqlModeDelWriteRBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(sqlModeLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sqlModeReadRBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sqlModeWriteRBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sqlModeDelWriteRBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
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

    // <editor-fold defaultstate="collapsed" desc="Action Listeners">
    private void selectSourceTodayBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectSourceTodayBtnActionPerformed
    {//GEN-HEADEREND:event_selectSourceTodayBtnActionPerformed
        Application.addToQueue("selectSourceTodayBtnActionPerformed");
    }//GEN-LAST:event_selectSourceTodayBtnActionPerformed

    private void selectBackupBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectBackupBtnActionPerformed
    {//GEN-HEADEREND:event_selectBackupBtnActionPerformed
        Application.addToQueue("selectBackupBtnActionPerformed");
    }//GEN-LAST:event_selectBackupBtnActionPerformed

    private void selectDestBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectDestBtnActionPerformed
    {//GEN-HEADEREND:event_selectDestBtnActionPerformed
        Application.addToQueue("selectDestBtnActionPerformed");
    }//GEN-LAST:event_selectDestBtnActionPerformed

    private void savePathBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_savePathBtnActionPerformed
    {//GEN-HEADEREND:event_savePathBtnActionPerformed
        Application.addToQueue("savePathBtnActionPerformed");
    }//GEN-LAST:event_savePathBtnActionPerformed

    private void useSQLCheckStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_useSQLCheckStateChanged
    {//GEN-HEADEREND:event_useSQLCheckStateChanged
        Application.addToQueue("useSQLCheckStateChanged");
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

    private void genMotdBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_genMotdBtnActionPerformed
    {//GEN-HEADEREND:event_genMotdBtnActionPerformed
        Application.addToQueue("genMotdBtnActionPerformed");
    }//GEN-LAST:event_genMotdBtnActionPerformed

    private void sqlSaveBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_sqlSaveBtnActionPerformed
    {//GEN-HEADEREND:event_sqlSaveBtnActionPerformed
        Application.addToQueue("SQLsaveBtnActionPerformed");
    }//GEN-LAST:event_sqlSaveBtnActionPerformed

    private void settingsSaveBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_settingsSaveBtnActionPerformed
    {//GEN-HEADEREND:event_settingsSaveBtnActionPerformed
        Application.addToQueue("settingsSaveBtnActionPerformed");
    }//GEN-LAST:event_settingsSaveBtnActionPerformed

    private void useHoursCheckStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_useHoursCheckStateChanged
    {//GEN-HEADEREND:event_useHoursCheckStateChanged
        Application.addToQueue("useHoursCheckStateChanged");
    }//GEN-LAST:event_useHoursCheckStateChanged

    private void customSourceCheckStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_customSourceCheckStateChanged
    {//GEN-HEADEREND:event_customSourceCheckStateChanged
        Application.addToQueue("customSourceCheckStateChanged");
    }//GEN-LAST:event_customSourceCheckStateChanged

    private void motdTxtFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_motdTxtFocusGained
    {//GEN-HEADEREND:event_motdTxtFocusGained
        Application.addToQueue("motdTxtFocusGained");
    }//GEN-LAST:event_motdTxtFocusGained

    private void motdTxtFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_motdTxtFocusLost
    {//GEN-HEADEREND:event_motdTxtFocusLost
        Application.addToQueue("motdTxtFocusLost");
    }//GEN-LAST:event_motdTxtFocusLost

    private void italicCheckActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_italicCheckActionPerformed
    {//GEN-HEADEREND:event_italicCheckActionPerformed
        Application.addToQueue("styleCheckActionPerformed");
    }//GEN-LAST:event_italicCheckActionPerformed

    private void boldCheckActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_boldCheckActionPerformed
    {//GEN-HEADEREND:event_boldCheckActionPerformed
        Application.addToQueue("styleCheckActionPerformed");
    }//GEN-LAST:event_boldCheckActionPerformed

    private void fontSizeTxtMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_fontSizeTxtMouseExited
    {//GEN-HEADEREND:event_fontSizeTxtMouseExited
        Application.addToQueue("fontSizeTxtActionPerformed");
    }//GEN-LAST:event_fontSizeTxtMouseExited

    private void fontTypeTxtMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_fontTypeTxtMouseExited
    {//GEN-HEADEREND:event_fontTypeTxtMouseExited
        Application.addToQueue("fontTypeTxtActionPerformed");
    }//GEN-LAST:event_fontTypeTxtMouseExited

    private void backgroundColorComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_backgroundColorComboItemStateChanged
    {//GEN-HEADEREND:event_backgroundColorComboItemStateChanged
        Application.addToQueue("backgroundColorComboItemStateChanged");
    }//GEN-LAST:event_backgroundColorComboItemStateChanged

    private void fontColorComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_fontColorComboItemStateChanged
    {//GEN-HEADEREND:event_fontColorComboItemStateChanged
        Application.addToQueue("fontColorComboItemStateChanged");
    }//GEN-LAST:event_fontColorComboItemStateChanged

    private void typeToEditComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_typeToEditComboItemStateChanged
    {//GEN-HEADEREND:event_typeToEditComboItemStateChanged
        Application.addToQueue("typeToEditComboItemStateChanged");
    }//GEN-LAST:event_typeToEditComboItemStateChanged

    private void typeToEditTxtFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_typeToEditTxtFocusLost
    {//GEN-HEADEREND:event_typeToEditTxtFocusLost
        Application.addToQueue("typeToEditTxtFocusLost");
    }//GEN-LAST:event_typeToEditTxtFocusLost

    private void typeToEditTxtFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_typeToEditTxtFocusGained
    {//GEN-HEADEREND:event_typeToEditTxtFocusGained
        Application.addToQueue("typeToEditTxtFocusGained");
    }//GEN-LAST:event_typeToEditTxtFocusGained

    private void addTypeBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addTypeBtnActionPerformed
    {//GEN-HEADEREND:event_addTypeBtnActionPerformed
        Application.addToQueue("addTypeBtnActionPerformed");
    }//GEN-LAST:event_addTypeBtnActionPerformed

    private void deleteTypeBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteTypeBtnActionPerformed
    {//GEN-HEADEREND:event_deleteTypeBtnActionPerformed
        Application.addToQueue("deleteTypeBtnActionPerformed");
    }//GEN-LAST:event_deleteTypeBtnActionPerformed

    private void saveDesignBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_saveDesignBtnActionPerformed
    {//GEN-HEADEREND:event_saveDesignBtnActionPerformed
        Application.addToQueue("saveDesignBtnActionPerformed");
    }//GEN-LAST:event_saveDesignBtnActionPerformed

    private void colorBorderComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorBorderComboItemStateChanged
    {//GEN-HEADEREND:event_colorBorderComboItemStateChanged
        Application.addToQueue("colorBorderComboItemStateChanged");
    }//GEN-LAST:event_colorBorderComboItemStateChanged

    private void colorTableComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorTableComboItemStateChanged
    {//GEN-HEADEREND:event_colorTableComboItemStateChanged
        Application.addToQueue("colorTableComboItemStateChanged");
    }//GEN-LAST:event_colorTableComboItemStateChanged

    private void colorMotdComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorMotdComboItemStateChanged
    {//GEN-HEADEREND:event_colorMotdComboItemStateChanged
        Application.addToQueue("colorMotdComboItemStateChanged");
    }//GEN-LAST:event_colorMotdComboItemStateChanged

    private void colorNameTxtFocusLost(java.awt.event.FocusEvent evt)//GEN-FIRST:event_colorNameTxtFocusLost
    {//GEN-HEADEREND:event_colorNameTxtFocusLost
        Application.addToQueue("colorNameTxtFocusLost");
    }//GEN-LAST:event_colorNameTxtFocusLost

    private void colorNameTxtFocusGained(java.awt.event.FocusEvent evt)//GEN-FIRST:event_colorNameTxtFocusGained
    {//GEN-HEADEREND:event_colorNameTxtFocusGained
        Application.addToQueue("colorNameTxtFocusGained");
    }//GEN-LAST:event_colorNameTxtFocusGained

    private void addColorBtnActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addColorBtnActionPerformed
    {//GEN-HEADEREND:event_addColorBtnActionPerformed
        Application.addToQueue("addColorBtnActionPerformed");
    }//GEN-LAST:event_addColorBtnActionPerformed

    private void deleteColorActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_deleteColorActionPerformed
    {//GEN-HEADEREND:event_deleteColorActionPerformed
        Application.addToQueue("deleteColorBtnActionPerformed");
    }//GEN-LAST:event_deleteColorActionPerformed

    private void colorPlanComboItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_colorPlanComboItemStateChanged
    {//GEN-HEADEREND:event_colorPlanComboItemStateChanged
        Application.addToQueue("colorPlanComboItemStateChanged");
    }//GEN-LAST:event_colorPlanComboItemStateChanged
    // </editor-fold>

    public JTextPane getStatusPane()
    {
        return log;
    }

    public JProgressBar getProgBar()
    {
        return progBar;
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
    protected static javax.swing.JCheckBox autoBackupCheck;
    protected static javax.swing.JComboBox<String> backgroundColorCombo;
    protected static javax.swing.JPanel backgroundColorPanel;
    private javax.swing.JLabel backgroundColorsLabel;
    protected static javax.swing.JTextField backupTxt;
    private javax.swing.JLabel bgMotdLabel;
    private javax.swing.JLabel bgPlanLabel;
    private javax.swing.JLabel bgTableLabel;
    protected static javax.swing.JCheckBox boldCheck;
    protected static javax.swing.JComboBox<String> colorBorderCombo;
    protected static javax.swing.JPanel colorBorderPanel;
    protected static javax.swing.JComboBox<String> colorMotdCombo;
    protected static javax.swing.JPanel colorMotdPanel;
    protected static javax.swing.JTextField colorNameTxt;
    protected static javax.swing.JComboBox<String> colorPlanCombo;
    protected static javax.swing.JPanel colorPlanPanel;
    protected static javax.swing.JComboBox<String> colorTableCombo;
    protected static javax.swing.JPanel colorTablePanel;
    private javax.swing.JButton createBackupBtn;
    protected static javax.swing.JCheckBox customSourceCheck;
    protected static javax.swing.JLabel dbHostLabel;
    protected static javax.swing.JTextField dbHostTxt;
    protected static javax.swing.JLabel dbNameLabel;
    protected static javax.swing.JTextField dbNameTxt;
    protected static javax.swing.JLabel dbPortLabel;
    protected static javax.swing.JTextField dbPortTxt;
    protected static javax.swing.JLabel dbPwLabel;
    protected static javax.swing.JPasswordField dbPwTxt;
    protected static javax.swing.JLabel dbTableNameLabel;
    protected static javax.swing.JTextField dbTableNameTxt;
    protected static javax.swing.JLabel dbUserLabel;
    protected static javax.swing.JTextField dbUserTxt;
    private javax.swing.JButton deleteColor;
    private javax.swing.JButton deleteTypeBtn;
    private javax.swing.JPanel designTypeSubPanel;
    protected static javax.swing.JTextArea destArea;
    private javax.swing.JTextField fileNameMiddle;
    protected static javax.swing.JTextField fileNamePrefixTxt;
    protected static javax.swing.JTextField fileNameSuffixTxt;
    protected static javax.swing.JComboBox<String> fontColorCombo;
    protected static javax.swing.JPanel fontColorPanel;
    protected static javax.swing.JTextField fontSizeTxt;
    protected static javax.swing.JTextField fontTypeTxt;
    private javax.swing.JButton genAllBtn;
    private javax.swing.JButton genMotdBtn;
    private javax.swing.JButton genTodayBtn;
    private javax.swing.JButton genTomorrowBtn;
    protected static javax.swing.JLabel hour10Label;
    protected static javax.swing.JTextField hour10Txt;
    protected static javax.swing.JLabel hour1Label;
    protected static javax.swing.JTextField hour1Txt;
    protected static javax.swing.JLabel hour2Label;
    protected static javax.swing.JTextField hour2Txt;
    protected static javax.swing.JLabel hour3Label;
    protected static javax.swing.JTextField hour3Txt;
    protected static javax.swing.JLabel hour4Label;
    protected static javax.swing.JTextField hour4Txt;
    protected static javax.swing.JLabel hour5Label;
    protected static javax.swing.JTextField hour5Txt;
    protected static javax.swing.JLabel hour6Label;
    protected static javax.swing.JTextField hour6Txt;
    protected static javax.swing.JLabel hour7Label;
    protected static javax.swing.JTextField hour7Txt;
    protected static javax.swing.JLabel hour8Label;
    protected static javax.swing.JTextField hour8Txt;
    protected static javax.swing.JLabel hour9Label;
    protected static javax.swing.JTextField hour9Txt;
    protected static javax.swing.JLabel hoursHeadLabel;
    protected static javax.swing.JCheckBox italicCheck;
    protected static javax.swing.JColorChooser jColorChooser1;
    protected static javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    protected static javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    protected static javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextPane log;
    protected static javax.swing.JTextField motdTxt;
    private javax.swing.JLabel otherBorderLabel;
    private javax.swing.JLabel otherColorsLabel;
    private javax.swing.JProgressBar progBar;
    private javax.swing.JButton saveDesignBtn;
    private javax.swing.JButton savePathBtn;
    private javax.swing.JButton selectBackupBtn;
    private javax.swing.JButton selectDestBtn;
    private javax.swing.JButton selectSourceTodayBtn;
    private javax.swing.JButton settingsSaveBtn;
    protected static javax.swing.JTextField sourceTodayTxt;
    protected static javax.swing.JTextField sourceTomorrowTxt;
    protected static javax.swing.JTextField sourceTxt;
    protected static javax.swing.JTextField speedMotdTxt;
    protected static javax.swing.JTextField speedPlanTxt;
    private javax.swing.ButtonGroup sqlMode;
    protected static javax.swing.JRadioButton sqlModeDelWriteRBtn;
    protected static javax.swing.JLabel sqlModeLabel;
    protected static javax.swing.JRadioButton sqlModeReadRBtn;
    protected static javax.swing.JRadioButton sqlModeWriteRBtn;
    private javax.swing.JButton sqlSaveBtn;
    protected static javax.swing.JTable table;
    protected static javax.swing.JLabel tteBgLabel;
    private javax.swing.JLabel tteFontColorLabel;
    private javax.swing.JLabel tteFontSizeLabel;
    private javax.swing.JLabel tteFontTypeLabel;
    protected static javax.swing.JComboBox<String> typeToEditCombo;
    private javax.swing.JLabel typeToEditLabel;
    protected static javax.swing.JTextField typeToEditTxt;
    protected static javax.swing.JCheckBox useHoursCheck;
    protected static javax.swing.JCheckBox useSQLCheck;
    protected static javax.swing.JTextField weekTxt;
    // End of variables declaration//GEN-END:variables
}
