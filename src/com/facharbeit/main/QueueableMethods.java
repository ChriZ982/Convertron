package com.facharbeit.main;

import com.facharbeit.io.*;
import static com.facharbeit.main.Frame.*;
import com.facharbeit.sql.SqlMode;
import static com.facharbeit.sql.SqlMode.values;
import com.facharbeit.tools.*;
import java.awt.*;
import javax.swing.*;

/**
 * Diese Klasse beinhaltet alle wichtigen Methoden, die in die Warteschlange der Anwendung angehängt werden können.
 * Hier wird kein Try-Catch verwendet, da alle Fehler durch die invoke-Methode aufgefangen werden
 */
public class QueueableMethods
{
    // ================================================== ÜBERSICHT ==================================================
    public static void motdTxtFocusGained() throws Exception
    {
        if(motdTxt.getText().equals("Laufschrift"))
            motdTxt.setText("");
        motdTxt.setForeground(Color.BLACK);
    }

    public static void motdTxtFocusLost() throws Exception
    {
        if(motdTxt.getText().equals(""))
        {
            motdTxt.setText("Laufschrift");
            motdTxt.setForeground(Color.GRAY);
        }
        else
            motdTxt.setForeground(Color.BLACK);
    }

    public static void genAllBtnActionPerformed() throws Exception
    {
        copySourceBtnActionPerformed();
        Settings.save("laufschriftText", motdTxt);
        HtmlWriter.plan("heute", HtmlReader.sort(HtmlReader.today()));
        HtmlWriter.plan("morgen", HtmlReader.sort(HtmlReader.tomorrow()));
        HtmlWriter.motd();
        saveDesignBtnActionPerformed();
    }

    public static void genTodayBtnActionPerformed() throws Exception
    {
        copySourceBtnActionPerformed();
        HtmlWriter.plan("heute", HtmlReader.sort(HtmlReader.today()));
        saveDesignBtnActionPerformed();
    }

    public static void genTomorrowBtnActionPerformed() throws Exception
    {
        copySourceBtnActionPerformed();
        HtmlWriter.plan("morgen", HtmlReader.sort(HtmlReader.tomorrow()));
        saveDesignBtnActionPerformed();
    }

    public static void genMotdBtnActionPerformed() throws Exception
    {
        copySourceBtnActionPerformed();
        Settings.save("laufschriftText", motdTxt);
        HtmlWriter.motd();
        saveDesignBtnActionPerformed();
    }

    public static void createBackupBtnActionPerformed() throws Exception
    {
        String path = Settings.load("pathBackup");
        backupAll(path);
        Logger.log("Backup wurde fertiggestellt", 0);
    }

    public static void copySourceBtnActionPerformed() throws Exception
    {
        FolderHandler folder = new FolderHandler(Settings.load("pathSource"));
        if(folder.isEmpty())
            return;

        Logger.enable(false);
        new FolderHandler(Settings.load("pathData") + "/Source/").deleteContent();
        folder.copyContent(Settings.load("pathData") + "/Source/");
        folder.deleteContent();
        Logger.enable(true);
        Logger.log("Quellpläne wurden kopiert", 0);
    }

    // ================================================== EINSTELLUNGEN ==================================================
    public static void useHoursCheckStateChanged() throws Exception
    {
        setEnabled(useHoursCheck, hoursHeadLabel, hour1Label, hour2Label, hour3Label, hour4Label, hour5Label, hour6Label,
                   hour7Label, hour8Label, hour9Label, hour10Label, hour1Txt, hour2Txt, hour3Txt, hour4Txt, hour5Txt,
                   hour6Txt, hour7Txt, hour8Txt, hour9Txt, hour10Txt);
    }

    public static void customSourceCheckStateChanged() throws Exception
    {
        setEnabled(customSourceCheck, sourceTodayTxt, sourceTomorrowTxt, jLabel10, jLabel22);
    }

    public static void settingsSaveBtnActionPerformed() throws Exception
    {
        String[] size = new String[7];
        String[] order = new String[7];
        for(int i = 0; i < 7; i++)
            switch(table.getColumnName(i))
            {
                case "Vertreter":
                    order[i] = "0";
                    size[0] = String.valueOf((int)(table.getCellRect(0, i, true).getWidth() / (double)table.getWidth() * 87.0));
                    break;
                case "Raum":
                    order[i] = "1";
                    size[1] = String.valueOf((int)(table.getCellRect(0, i, true).getWidth() / (double)table.getWidth() * 87.0));
                    break;
                case "Art":
                    order[i] = "2";
                    size[2] = String.valueOf((int)(table.getCellRect(0, i, true).getWidth() / (double)table.getWidth() * 87.0));
                    break;
                case "Fach":
                    order[i] = "3";
                    size[3] = String.valueOf((int)(table.getCellRect(0, i, true).getWidth() / (double)table.getWidth() * 87.0));
                    break;
                case "Lehrer":
                    order[i] = "4";
                    size[4] = String.valueOf((int)(table.getCellRect(0, i, true).getWidth() / (double)table.getWidth() * 87.0));
                    break;
                case "Verl. von":
                    order[i] = "5";
                    size[5] = String.valueOf((int)(table.getCellRect(0, i, true).getWidth() / (double)table.getWidth() * 87.0));
                    break;
                case "Hinweise":
                    order[i] = "6";
                    size[6] = String.valueOf((int)(table.getCellRect(0, i, true).getWidth() / (double)table.getWidth() * 87.0));
                    break;
                default:
                    Logger.log("Fehler beim sortieren der Daten!", 2);
                    return;
            }
        Settings.save("customWeek", weekTxt);
        Settings.save("lessonUse", useHoursCheck);
        Settings.save("customUse", customSourceCheck);
        Settings.save("autoBackupUse", autoBackupCheck);
        Settings.saveArray("lessonSizes", size);
        Settings.saveArray("lessonOrder", order);
        Settings.saveArray("speed", speedPlanTxt, speedMotdTxt);
        Settings.saveArray("customDates", sourceTodayTxt, sourceTomorrowTxt);
        Settings.saveArray("lessons", hour1Txt, hour2Txt, hour3Txt, hour4Txt, hour5Txt,
                           hour6Txt, hour7Txt, hour8Txt, hour9Txt, hour10Txt);
    }

    // ================================================== PFADE ==================================================
    public static void selectSourceTodayBtnActionPerformed() throws Exception
    {
        if(jFileChooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            sourceTxt.setText(jFileChooser1.getSelectedFile().getPath());
    }

    public static void selectBackupBtnActionPerformed() throws Exception
    {
        if(jFileChooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            backupTxt.setText(jFileChooser1.getSelectedFile().getPath());
    }

    public static void selectDataPathBtnActionPerformed() throws Exception
    {
        if(jFileChooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            dataPathTxt.setText(jFileChooser1.getSelectedFile().getPath());
    }

    public static void selectDestBtnActionPerformed() throws Exception
    {
        while(destArea.getText().startsWith("\n"))
            destArea.setText(destArea.getText().substring(1));

        if(jFileChooser1.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
        {
            if(!destArea.getText().endsWith("\n") && destArea.getText().contains("\n"))
                destArea.setText(destArea.getText() + "\n");
            destArea.append(jFileChooser1.getSelectedFile().getPath() + "\n");
        }
    }

    public static void savePathBtnActionPerformed() throws Exception
    {
        while(destArea.getText().startsWith("\n"))
            destArea.setText(destArea.getText().substring(1));

        Settings.save("pathSource", sourceTxt);
        Settings.save("pathBackup", backupTxt);
        Settings.saveArray("fileName", fileNamePrefixTxt, fileNameSuffixTxt);
        Settings.saveArray("pathDests", destArea);

        if(!dataPathTxt.getText().equals(Settings.load("pathData")))
        {
            new FolderHandler(Settings.load("pathData")).copyContent(dataPathTxt.getText());
            Settings.save("pathData", dataPathTxt);
        }
    }

    // ================================================== DESIGN ==================================================
    public static void typeToEditTxtFocusLost() throws Exception
    {
        if(typeToEditTxt.getText().equals(""))
        {
            typeToEditTxt.setText("Vertretungsart");
            typeToEditTxt.setForeground(Color.GRAY);
        }
        else
            typeToEditTxt.setForeground(Color.BLACK);
    }

    public static void typeToEditTxtFocusGained() throws Exception
    {
        if(typeToEditTxt.getText().equals("Vertretungsart"))
            typeToEditTxt.setText("");
        typeToEditTxt.setForeground(Color.BLACK);
    }

    public static void colorNameTxtFocusLost() throws Exception
    {
        if(colorNameTxt.getText().equals(""))
        {
            colorNameTxt.setText("Farbenname");
            colorNameTxt.setForeground(Color.GRAY);
        }
        else
            colorNameTxt.setForeground(Color.BLACK);
    }

    public static void colorNameTxtFocusGained() throws Exception
    {
        if(colorNameTxt.getText().equals("Farbenname"))
            colorNameTxt.setText("");
        colorNameTxt.setForeground(Color.BLACK);
    }

    public static void addColorBtnActionPerformed() throws Exception
    {
        if(colorNameTxt.getText().equals("Farbenname") || colorNameTxt.getText().equals(""))
            return;
        Color c = JColorChooser.showDialog(jColorChooser1, "Neue Farbe anlegen", Color.BLUE);
        if(c != null)
        {
            Settings.save("color" + colorNameTxt.getText(), "#" + Integer.toHexString(c.getRGB()).substring(2));
            loadColors(colorPlanCombo, colorMotdCombo, colorTableCombo, colorBorderCombo, fontColorCombo, backgroundColorCombo);
            Settings.load("planColor", colorPlanCombo);
            Settings.load("borderColor", colorBorderCombo);
            colorTableCombo.setSelectedItem(Settings.loadArrayIndex("tabelleFont", 4));
            colorMotdCombo.setSelectedItem(Settings.loadArrayIndex("laufschriftFont", 4));
        }
    }

    public static void deleteColorBtnActionPerformed() throws Exception
    {
        Settings.delete("color" + colorNameTxt.getText());
        loadColors(colorPlanCombo, colorMotdCombo, colorTableCombo, colorBorderCombo, fontColorCombo, backgroundColorCombo);
        Settings.load("planColor", colorPlanCombo);
        Settings.load("borderColor", colorBorderCombo);
        colorTableCombo.setSelectedItem(Settings.loadArrayIndex("tabelleFont", 4));
        colorMotdCombo.setSelectedItem(Settings.loadArrayIndex("laufschriftFont", 4));
    }

    public static void colorPlanComboItemStateChanged() throws Exception
    {
        if(colorPlanCombo.getSelectedItem().toString().equals("Keine Farbe"))
            return;
        colorPlanPanel.setBackground(Color.decode(Settings.load("color" + colorPlanCombo.getSelectedItem().toString())));
        if(!Settings.load("planColor").equals(colorPlanCombo.getSelectedItem().toString()))
            Settings.save("planColor", colorPlanCombo);
    }

    public static void colorMotdComboItemStateChanged() throws Exception
    {
        if(colorMotdCombo.getSelectedItem().toString().equals("Keine Farbe"))
            return;
        colorMotdPanel.setBackground(Color.decode(Settings.load("color" + colorMotdCombo.getSelectedItem().toString())));
        if(!Settings.loadArrayIndex("laufschriftFont", 4).equals(colorMotdCombo.getSelectedItem().toString()))
            Settings.saveArrayIndex("laufschriftFont", colorMotdCombo.getSelectedItem().toString(), 4);
    }

    public static void colorTableComboItemStateChanged() throws Exception
    {
        if(colorTableCombo.getSelectedItem().toString().equals("Keine Farbe"))
            return;
        colorTablePanel.setBackground(Color.decode(Settings.load("color" + colorTableCombo.getSelectedItem().toString())));
        if(!Settings.loadArrayIndex("tabelleFont", 4).equals(colorTableCombo.getSelectedItem().toString()))
            Settings.saveArrayIndex("tabelleFont", colorTableCombo.getSelectedItem().toString(), 4);
    }

    public static void colorBorderComboItemStateChanged() throws Exception
    {
        if(colorBorderCombo.getSelectedItem().toString().equals("Keine Farbe"))
            return;
        colorBorderPanel.setBackground(Color.decode(Settings.load("color" + colorBorderCombo.getSelectedItem().toString())));
        if(!Settings.load("borderColor").equals(colorBorderCombo.getSelectedItem().toString()))
            Settings.save("borderColor", colorBorderCombo);
    }

    public static void typeToEditComboItemStateChanged() throws Exception
    {
        fontTypeTxt.setText("");
        fontSizeTxt.setText("");
        boldCheck.setSelected(false);
        italicCheck.setSelected(false);
        fontColorPanel.setBackground(Color.GRAY);
        backgroundColorPanel.setBackground(Color.GRAY);
        fontColorCombo.setSelectedItem("Keine Farbe");
        backgroundColorCombo.setSelectedItem("Keine Farbe");
        setEnabled(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"), tteBgLabel, backgroundColorCombo, backgroundColorPanel);

        String[] font = Settings.loadArray(extractName(typeToEditCombo));
        if(font[0].equals("bold"))
            boldCheck.setSelected(true);
        else if(font[0].equals("italic"))
            italicCheck.setSelected(true);
        else if(font[0].equals("bold italic"))
        {
            boldCheck.setSelected(true);
            italicCheck.setSelected(true);
        }

        fontSizeTxt.setText(font[1]);
        fontTypeTxt.setText(font[2]);
        if(!font[3].isEmpty())
        {
            fontColorCombo.setSelectedItem(font[3]);
            fontColorPanel.setBackground(Color.decode(Settings.load("color" + font[3])));
        }
        if(typeToEditCombo.getSelectedItem().toString().startsWith("Art:") && !font[4].isEmpty())
        {
            backgroundColorCombo.setSelectedItem(font[4]);
            backgroundColorPanel.setBackground(Color.decode(Settings.load("color" + font[4])));
        }
    }

    public static void fontColorComboItemStateChanged() throws Exception
    {
        if(fontColorCombo.getSelectedItem().toString().equals("Keine Farbe"))
            return;
        fontColorPanel.setBackground(Color.decode(Settings.load("color" + fontColorCombo.getSelectedItem().toString())));
        if(!Settings.loadArrayIndex(extractName(typeToEditCombo), 3).equals(fontColorCombo.getSelectedItem().toString()))
            Settings.saveArrayIndex(extractName(typeToEditCombo), fontColorCombo.getSelectedItem().toString(), 3);
    }

    public static void backgroundColorComboItemStateChanged() throws Exception
    {
        if(backgroundColorCombo.getSelectedItem().toString().equals("Keine Farbe"))
            return;
        backgroundColorPanel.setBackground(Color.decode(Settings.load("color" + backgroundColorCombo.getSelectedItem().toString())));
        if(!Settings.loadArrayIndex(extractName(typeToEditCombo), 4).equals(backgroundColorCombo.getSelectedItem().toString()))
            Settings.saveArrayIndex(extractName(typeToEditCombo), backgroundColorCombo.getSelectedItem().toString(), 4);
    }

    public static void fontTypeTxtActionPerformed() throws Exception
    {
        Settings.saveArrayIndex(extractName(typeToEditCombo), fontTypeTxt.getText(), 2);
    }

    public static void fontSizeTxtActionPerformed() throws Exception
    {
        Settings.saveArrayIndex(extractName(typeToEditCombo), fontSizeTxt.getText(), 1);
    }

    public static void styleCheckActionPerformed() throws Exception
    {
        String setting = "";
        if(boldCheck.isSelected() && italicCheck.isSelected())
            setting = "bold italic";
        else if(boldCheck.isSelected())
            setting = "bold";
        else if(italicCheck.isSelected())
            setting = "italic";
        Settings.saveArrayIndex(extractName(typeToEditCombo), setting, 0);
    }

    public static void addTypeBtnActionPerformed() throws Exception
    {
        if(typeToEditTxt.getText().equals("Vertretungsart") || typeToEditTxt.getText().equals(""))
            return;
        typeToEditCombo.addItem("Art: " + typeToEditTxt.getText());
        Settings.saveArray("art" + typeToEditTxt.getText() + "Font",
                           new String[]
                           {
                               "", "", "", "", ""
                           });
    }

    public static void deleteTypeBtnActionPerformed() throws Exception
    {
        typeToEditCombo.removeItem("Art: " + typeToEditTxt.getText());
        Settings.delete("art" + typeToEditTxt.getText().replaceAll("\\.", "") + "Font");
    }

    public static void saveDesignBtnActionPerformed() throws Exception
    {
        HtmlWriter.style();
        if(Settings.load("sqlUse").equals("true")
           && (SqlMode.ADD.isActive() || SqlMode.OVERWRITE.isActive()))
            HtmlWriter.sql();
        backupToDestPaths();
        if(Settings.load("autoBackupUse").equals("true"))
            createBackupBtnActionPerformed();
    }

    // ================================================== SQL ==================================================
    public static void useSQLCheckStateChanged() throws Exception
    {
        setEnabled(useSQLCheck, dbHostLabel, dbPortLabel, dbNameLabel, dbUserLabel, dbPwLabel, dbTableNameLabel, dbHostTxt, dbPortTxt,
                   dbNameTxt, dbUserTxt, dbPwTxt, dbTableNameTxt, sqlModeLabel, sqlModeReadRBtn, sqlModeWriteRBtn, sqlModeDelWriteRBtn);
    }

    public static void SQLsaveBtnActionPerformed() throws Exception
    {
        Settings.save("sqlMode", (sqlModeReadRBtn.isSelected() ? SqlMode.READ : sqlModeDelWriteRBtn.isSelected() ? SqlMode.OVERWRITE : SqlMode.ADD).toString());
        Settings.save("sqlUse", useSQLCheck);
        Settings.saveArray("sql", dbHostTxt, dbPortTxt, dbNameTxt, dbTableNameTxt, dbUserTxt, dbPwTxt);
    }

    // ================================================== ANDERES ==================================================
    public static void loadSettings() throws Exception
    {
        boldCheck.setSelected(false);
        italicCheck.setSelected(false);
        loadColors(colorPlanCombo, colorMotdCombo, colorTableCombo, colorBorderCombo, fontColorCombo, backgroundColorCombo);

        Settings.load("customWeek", weekTxt);
        Settings.load("sqlUse", useSQLCheck);
        Settings.load("pathSource", sourceTxt);
        Settings.load("pathBackup", backupTxt);
        Settings.load("pathData", dataPathTxt);
        Settings.load("laufschriftText", motdTxt);
        Settings.load("lessonUse", useHoursCheck);
        Settings.load("planColor", colorPlanCombo);
        Settings.load("customUse", customSourceCheck);
        Settings.load("borderColor", colorBorderCombo);
        Settings.load("autoBackupUse", autoBackupCheck);
        Settings.loadArray("speed", speedPlanTxt, speedMotdTxt);
        Settings.loadArray("customDates", sourceTodayTxt, sourceTomorrowTxt);
        Settings.loadArray("fileName", fileNamePrefixTxt, fileNameSuffixTxt);
        Settings.loadArray("sql", dbHostTxt, dbPortTxt, dbNameTxt, dbTableNameTxt, dbUserTxt, dbPwTxt);
        Settings.loadArray("lessons", hour1Txt, hour2Txt, hour3Txt, hour4Txt, hour5Txt, hour6Txt, hour7Txt,
                           hour8Txt, hour9Txt, hour10Txt);
        colorTableCombo.setSelectedItem(Settings.loadArrayIndex("tabelleFont", 4));
        colorMotdCombo.setSelectedItem(Settings.loadArrayIndex("laufschriftFont", 4));
        typeToEditCombo.setSelectedItem("Tabelle");
        typeToEditCombo.setSelectedItem("Überschrift");

        for(String s : Settings.loadArray("pathDests"))
            destArea.append(s + "\n");

        for(String s : Settings.findNames("art"))
            typeToEditCombo.addItem("Art: " + s.substring(3, s.indexOf("Font")));

        //Vermeidung von Fehlern
        if(!validSqlMode(Settings.load("sqlMode")))
            Settings.save("sqlMode", SqlMode.ADD.toString());

        switch(SqlMode.valueOf(Settings.load("sqlMode")))
        {
            case READ:
                sqlModeReadRBtn.setSelected(true);
                break;
            case OVERWRITE:
                sqlModeDelWriteRBtn.setSelected(true);
                break;
            case ADD:
                sqlModeWriteRBtn.setSelected(true);
                break;
        }

        if(motdTxt.getText().equals("Laufschrift"))
            motdTxt.setForeground(Color.GRAY);

        setEnabled(customSourceCheck, sourceTodayTxt, sourceTomorrowTxt, jLabel10, jLabel22);
        setEnabled(useSQLCheck, dbHostLabel, dbPortLabel, dbNameLabel, dbUserLabel, dbPwLabel, dbTableNameLabel, dbHostTxt, dbPortTxt,
                   dbNameTxt, dbUserTxt, dbPwTxt, dbTableNameTxt, sqlModeLabel, sqlModeReadRBtn, sqlModeWriteRBtn, sqlModeDelWriteRBtn);
        setEnabled(useHoursCheck, hoursHeadLabel, hour1Label, hour2Label, hour3Label, hour4Label, hour5Label, hour6Label,
                   hour7Label, hour8Label, hour9Label, hour10Label, hour1Txt, hour2Txt, hour3Txt, hour4Txt, hour5Txt,
                   hour6Txt, hour7Txt, hour8Txt, hour9Txt, hour10Txt);

        String[] size = Settings.loadArray("lessonSizes");
        String[] order = Settings.loadArray("lessonOrder");
        for(int i = 0; i < 7; i++)
            switch(order[i])
            {
                case "0":
                    loadTable(table, i, 0, "Vertreter", size[0]);
                    break;
                case "1":
                    loadTable(table, i, 1, "Raum", size[1]);
                    break;
                case "2":
                    loadTable(table, i, 2, "Art", size[2]);
                    break;
                case "3":
                    loadTable(table, i, 3, "Fach", size[3]);
                    break;
                case "4":
                    loadTable(table, i, 4, "Lehrer", size[4]);
                    break;
                case "5":
                    loadTable(table, i, 5, "Verl. von", size[5]);
                    break;
                case "6":
                    loadTable(table, i, 6, "Hinweise", size[6]);
                    break;
            }
    }

    /**
     * Aktiviert oder Deaktiviert Komponenten aufgrund einer CheckBox
     *
     * @param components Die Komponenten mit CheckBox
     */
    private static void setEnabled(Object... components)
    {
        for(int i = 1; i < components.length; i++)
            if(components[0] instanceof JCheckBox)
                ((JComponent)components[i]).setEnabled(((JCheckBox)components[0]).isSelected());
            else if(components[0] instanceof Boolean)
                ((JComponent)components[i]).setEnabled(((Boolean)components[0]));
    }

    /**
     * Gibt den Namen des ausgewählten Items.
     *
     * @param combo Box die verwendet werden soll
     *
     * @return Name des ausgewählten Items
     */
    private static String extractName(JComboBox<String> combo) throws Exception
    {
        String s;
        if(combo.getSelectedItem().toString().startsWith("Art:"))
            s = "art" + combo.getSelectedItem().toString().substring(5).replaceAll("\\.", "") + "Font";
        else
            s = combo.getSelectedItem().toString() + "Font";
        return Character.toLowerCase(s.charAt(0)) + s.substring(1);
    }

    /**
     * Lädt die Farben in die ComboBoxen.
     *
     * @param colorCombos ComboBoxen
     */
    @SafeVarargs
    private static void loadColors(JComboBox<String>... colorCombos) throws Exception
    {
        for(JComboBox<String> cb : colorCombos)
        {
            cb.removeAllItems();
            cb.addItem("Keine Farbe");
            String[] colors = Settings.findNames("color");
            for(String s : colors)
                cb.addItem(s.substring(5));
        }
    }

    /**
     * Kopiert die generierten Dateien in die Zielpfade.
     */
    private static void backupToDestPaths() throws Exception
    {
        String[] paths = Settings.loadArray("pathDests");
        for(String path : paths)
            backupAll(PathConverter.convert(path));
    }

    /**
     * Kopiert alle wichtigen Dateien zu einem Pfad.
     *
     * @param path Pfad
     */
    private static void backupAll(String path) throws Exception
    {
        Logger.enable(false);
        new FileHandler("./settings.ini").copy(path + "/");
        new FileHandler(Settings.load("pathData") + "/heute.html").copy(path + "/");
        new FileHandler(Settings.load("pathData") + "/morgen.html").copy(path + "/");
        new FileHandler(Settings.load("pathData") + "/laufschrift.html").copy(path + "/");
        new FileHandler(Settings.load("pathData") + "/style.css").copy(path + "/");
        new FileHandler(Settings.load("pathData") + "/antonianumLogo.png").copy(path + "/");
        new FileHandler(Settings.load("pathData") + "/VERTRETUNGSPLAN.html").copy(path + "/");
        Logger.enable(true);
    }

    /**
     * Lädt eine Tabellen-Spalte abhängig vom head.
     *
     * @param table    Tabelle
     * @param index    Index
     * @param newIndex Neuer Index
     * @param head     Name der Spalte
     * @param setting  Größe der Spalte
     */
    private static void loadTable(JTable table, int index, int newIndex, String head, String setting) throws Exception
    {
        table.getColumnModel().getColumn(index).setHeaderValue(head);
        table.getColumnModel().getColumn(index).setModelIndex(newIndex);
        if(setting.equals(""))
            return;
        table.getColumnModel().getColumn(index).setPreferredWidth((Integer.parseInt(setting) * table.getWidth()) / 87);
        table.getColumnModel().getColumn(index).setWidth((Integer.parseInt(setting) * table.getWidth()) / 87);
    }

    private static boolean validSqlMode(String name)
    {
        for(SqlMode mode : values())
            if(mode.toString().equals(name))
                return true;
        return false;
    }
}
