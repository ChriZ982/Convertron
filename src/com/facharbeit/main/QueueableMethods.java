package com.facharbeit.main;

import com.facharbeit.io.*;
import com.facharbeit.tools.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * Diese Klasse beinhaltet alle wichtigen Methoden, die in die Warteschlange der Anwendung angehängt werden können.
 * Hier wird kein Try-Catch verwendet, da alle Fehler durch die invoke-Methode aufgefangen werden
 */
public class QueueableMethods
{
    // ================================================== ÜBERSICHT ==================================================
    public static void genAllBtnActionPerformed()
    {
        HtmlWriter.today(HtmlReader.sort(HtmlReader.today()), 50, 65);
        HtmlWriter.tomorrow(HtmlReader.sort(HtmlReader.tomorrow()), 65, 80);
        HtmlWriter.motd(80, 95);
        HtmlWriter.style();

        if(Settings.load("sqlMode").contains("schreiben") && Settings.load("sqlUse").equals("true"))
            HtmlWriter.sql();

        backupToDestPaths();
        Logger.setProgress(100);
        if(Settings.load("autoBackup").equals("true"))
            createBackupBtnActionPerformed();
        Logger.setProgress(0);
    }

    public static void genTodayBtnActionPerformed()
    {
        HtmlWriter.today(HtmlReader.sort(HtmlReader.today()), 50, 95);
        HtmlWriter.style();

        if(Settings.load("sqlMode").contains("schreiben") && Settings.load("sqlUse").equals("true"))
            HtmlWriter.sql();

        backupToDestPaths();
        Logger.setProgress(100);
        if(Settings.load("autoBackup").equals("true"))
            createBackupBtnActionPerformed();
        Logger.setProgress(0);
    }

    public static void genTomorrowBtnActionPerformed()
    {
        HtmlWriter.tomorrow(HtmlReader.sort(HtmlReader.tomorrow()), 50, 95);
        HtmlWriter.style();

        if(Settings.load("sqlMode").contains("schreiben") && Settings.load("sqlUse").equals("true"))
            HtmlWriter.sql();

        backupToDestPaths();
        Logger.setProgress(100);
        if(Settings.load("autoBackup").equals("true"))
            createBackupBtnActionPerformed();
        Logger.setProgress(0);
    }

    public static void genMotdBtnActionPerformed(JTextField motdTxt)
    {
        saveText(motdTxt, "motdText");
        HtmlWriter.motd(0, 100);
        HtmlWriter.style();
        backupToDestPaths();
        if(Settings.load("autoBackup").equals("true"))
            createBackupBtnActionPerformed();
        Logger.setProgress(0);
    }

    public static void createBackupBtnActionPerformed()
    {
        String path = Settings.load("pathBackup");
        backupAll(path);
        Logger.log("Backup wurde fertiggestellt", 0);
    }

    public static void copySourceBtnActionPerformed()
    {
        Logger.setLogging(false);
        FolderHandler folder = new FolderHandler(Settings.load("pathSource"));
        if(!folder.isEmpty())
        {
            new FolderHandler("./Data/Source/").deleteContent();
            folder.copyContent("./Data/Source/");
            folder.deleteContent();
        }
        Logger.setLogging(true);
        Logger.log("Quellpläne wurden kopiert", 0);
    }

    // ================================================== EINSTELLUNGEN ==================================================
    public static void settingsSaveBtnActionPerformed(JTextField hour1Txt, JTextField hour2Txt, JTextField hour3Txt,
                                                      JTextField hour4Txt, JTextField hour5Txt, JTextField hour6Txt,
                                                      JTextField hour7Txt, JTextField hour8Txt, JTextField hour9Txt,
                                                      JTextField hour10Txt, JCheckBox useHoursCheck, JCheckBox autoBackupCheck,
                                                      JTextField speedPlanTxt, JTextField speedMotdTxt, JTable table,
                                                      JTextField weekTxt, JTextField sourceTodayTxt, JTextField sourceTomorrowTxt,
                                                      JCheckBox customSourceCheck)
    {
        saveText(hour1Txt, "lesson01");
        saveText(hour2Txt, "lesson02");
        saveText(hour3Txt, "lesson03");
        saveText(hour4Txt, "lesson04");
        saveText(hour5Txt, "lesson05");
        saveText(hour6Txt, "lesson06");
        saveText(hour7Txt, "lesson07");
        saveText(hour8Txt, "lesson08");
        saveText(hour9Txt, "lesson09");
        saveText(hour10Txt, "lesson10");
        saveText(speedPlanTxt, "planSpeed");
        saveText(speedMotdTxt, "motdSpeed");
        saveText(weekTxt, "customWeek");
        saveText(sourceTodayTxt, "customToday");
        saveText(sourceTomorrowTxt, "customTomorrow");

        saveCheck(customSourceCheck, "customDate");

        String[] order = new String[7];
        for(int i = 0; i < 7; i++)
            switch(table.getColumnName(i))
            {
                case "Vertreter":
                    order[i] = "0";
                    break;
                case "Raum":
                    order[i] = "1";
                    break;
                case "Art":
                    order[i] = "2";
                    break;
                case "Fach":
                    order[i] = "3";
                    break;
                case "Lehrer":
                    order[i] = "4";
                    break;
                case "Verl. von":
                    order[i] = "5";
                    break;
                case "Hinweise":
                    order[i] = "6";
                    break;
                default:
                    Logger.log("Fehler beim sortieren der Daten!", 2);
                    return;
            }

        String setting = order[0] + ","
                         + order[1] + ","
                         + order[2] + ","
                         + order[3] + ","
                         + order[4] + ","
                         + order[5] + ","
                         + order[6];

        Settings.save("lessonOrder", setting);
        saveCheck(useHoursCheck, "lessonUse");
        saveCheck(autoBackupCheck, "autoBackup");
    }

    // ================================================== PFADE ==================================================
    public static void savePathBtnActionPerformed(JTextField sourceTxt, JTextField backupTxt, JTextArea destArea,
                                                  JTextField fileNamePrefixTxt, JTextField fileNameSuffixTxt)
    {
        saveText(sourceTxt, "pathSource");
        saveText(backupTxt, "pathBackup");
        saveText(fileNamePrefixTxt, "fileNamePrefix");
        saveText(fileNameSuffixTxt, "fileNameSuffix");

        ArrayList<String> destPaths = new ArrayList<String>();
        destPaths.addAll(Arrays.asList(destArea.getText().split("\n")));

        for(int i = 0; Settings.delete("pathDest" + (i + 1)); i++)
        {
        }

        if(!destArea.getText().equals(""))
            for(int i = 0; i < destPaths.size(); i++)
                Settings.save("pathDest" + (i + 1), destPaths.get(i));
    }

    // ================================================== DESIGN ==================================================
    public static void addColorBtnActionPerformed(JColorChooser colorChooser, JTextField colorNameTxt, JComboBox<String> colorPlanCombo,
                                                  JComboBox<String> colorMotdCombo, JComboBox<String> colorTableCombo, JComboBox<String> colorBorderCombo,
                                                  JComboBox<String> fontColorCombo, JComboBox<String> backgroundColorCombo)
    {
        Color c = JColorChooser.showDialog(colorChooser, "Neue Farbe anlegen", Color.BLUE);
        if(c != null)
        {
            Settings.save("color" + colorNameTxt.getText(), "#" + Integer.toHexString(c.getRGB()).substring(2));
            loadColors(colorPlanCombo, colorMotdCombo, colorTableCombo, colorBorderCombo, fontColorCombo, backgroundColorCombo);

            loadCombo(colorPlanCombo, "planColor");
            loadCombo(colorMotdCombo, "motdColor");
            loadCombo(colorTableCombo, "tableColor");
            loadCombo(colorBorderCombo, "borderColor");
        }
    }

    public static void deleteColorBtnActionPerformed(JTextField colorNameTxt, JComboBox<String> colorPlanCombo, JComboBox<String> colorMotdCombo,
                                                     JComboBox<String> colorTableCombo, JComboBox<String> colorBorderCombo, JComboBox<String> fontColorCombo,
                                                     JComboBox<String> backgroundColorCombo)
    {
        Settings.delete("color" + colorNameTxt.getText());
        loadColors(colorPlanCombo, colorMotdCombo, colorTableCombo, colorBorderCombo, fontColorCombo, backgroundColorCombo);

        loadCombo(colorPlanCombo, "planColor");
        loadCombo(colorMotdCombo, "motdColor");
        loadCombo(colorTableCombo, "tableColor");
        loadCombo(colorBorderCombo, "borderColor");
    }

    public static void colorPlanComboItemStateChanged(JPanel colorPlanPanel, JComboBox colorPlanCombo, ItemEvent evt)
    {
        colorComboChanged("planColor", colorPlanPanel, colorPlanCombo, evt);
    }

    public static void colorMotdComboItemStateChanged(JPanel colorMotdPanel, JComboBox colorMotdCombo, ItemEvent evt)
    {
        colorComboChanged("motdColor", colorMotdPanel, colorMotdCombo, evt);
    }

    public static void colorTableComboItemStateChanged(JPanel colorTablePanel, JComboBox colorTableCombo, ItemEvent evt)
    {
        colorComboChanged("tableColor", colorTablePanel, colorTableCombo, evt);
    }

    public static void colorBorderComboItemStateChanged(JPanel colorBorderPanel, JComboBox colorBorderCombo, ItemEvent evt)
    {
        colorComboChanged("borderColor", colorBorderPanel, colorBorderCombo, evt);
    }

    public static void typeToEditComboItemStateChanged(JComboBox<String> typeToEditCombo, JComboBox<String> fontColorCombo,
                                                       JPanel fontColorPanel, JComboBox<String> backgroundColorCombo,
                                                       JPanel backgroundColorPanel, JTextField fontTypeTxt,
                                                       JTextField fontSizeTxt, JCheckBox boldCheck, JCheckBox italicCheck,
                                                       ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            fontTypeTxt.setText("");
            fontSizeTxt.setText("");
            boldCheck.setSelected(false);
            italicCheck.setSelected(false);
            fontColorCombo.setSelectedItem("Keine Farbe");
            backgroundColorCombo.setSelectedItem("Keine Farbe");

            String s = extractName(typeToEditCombo, "FontColor");
            loadCombo(fontColorCombo, Character.toLowerCase(s.charAt(0)) + s.substring(1));
            if(!fontColorCombo.getSelectedItem().equals("Keine Farbe"))
                fontColorPanel.setBackground(Color.decode(Settings.load("color" + fontColorCombo.getSelectedItem().toString())));

            if(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"))
            {
                s = "Art" + typeToEditCombo.getSelectedItem().toString().substring(5).replaceAll("\\.", "") + "BackColor";
                loadCombo(backgroundColorCombo, Character.toLowerCase(s.charAt(0)) + s.substring(1));
                if(!backgroundColorCombo.getSelectedItem().equals("Keine Farbe"))
                    backgroundColorPanel.setBackground(Color.decode(Settings.load("color" + backgroundColorCombo.getSelectedItem().toString())));
            }

            s = extractName(typeToEditCombo, "FontFamily");
            loadText(fontTypeTxt, Character.toLowerCase(s.charAt(0)) + s.substring(1));

            s = extractName(typeToEditCombo, "FontSize");
            loadText(fontSizeTxt, Character.toLowerCase(s.charAt(0)) + s.substring(1));

            s = extractName(typeToEditCombo, "FontStyle");
            String bool = Settings.load(Character.toLowerCase(s.charAt(0)) + s.substring(1));
            if(bool.equals("bold"))
                boldCheck.setSelected(true);
            else if(bool.equals("italic"))
                italicCheck.setSelected(true);
            else if(Settings.line(Character.toLowerCase(s.charAt(0)) + s.substring(1)) == -1)
                Settings.save(Character.toLowerCase(s.charAt(0)) + s.substring(1), "none");
        }
    }

    public static void fontColorComboItemStateChanged(JPanel fontColorPanel, JComboBox<String> fontColorCombo, JComboBox<String> typeToEditCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            if(!fontColorCombo.getSelectedItem().equals("Keine Farbe"))
                fontColorPanel.setBackground(Color.decode(Settings.load("color" + fontColorCombo.getSelectedItem().toString())));

            String s = extractName(typeToEditCombo, "FontColor");
            if(!Settings.load(Character.toLowerCase(s.charAt(0)) + s.substring(1)).equals(fontColorCombo.getSelectedItem().toString()) && !fontColorCombo.getSelectedItem().toString().equals("Keine Farbe"))
                Settings.save(Character.toLowerCase(s.charAt(0)) + s.substring(1), fontColorCombo.getSelectedItem().toString());
        }
    }

    public static void backgroundColorComboItemStateChanged(JPanel backgroundColorPanel, JComboBox<String> backgroundColorCombo, JComboBox<String> typeToEditCombo, ItemEvent evt)
    {
        if(!backgroundColorCombo.getSelectedItem().equals("Keine Farbe"))
            backgroundColorPanel.setBackground(Color.decode(Settings.load("color" + backgroundColorCombo.getSelectedItem().toString())));

        if(evt.getStateChange() == ItemEvent.SELECTED && typeToEditCombo.getSelectedItem().toString().startsWith("Art:"))
        {
            String s = extractName(typeToEditCombo, "BackColor");
            if(!Settings.load(Character.toLowerCase(s.charAt(0)) + s.substring(1)).equals(backgroundColorCombo.getSelectedItem().toString()) && !backgroundColorCombo.getSelectedItem().toString().equals("Keine Farbe"))
                Settings.save(Character.toLowerCase(s.charAt(0)) + s.substring(1), backgroundColorCombo.getSelectedItem().toString());
        }
    }

    public static void fontTypeTxtActionPerformed(JTextField fontTypeTxt, JComboBox<String> typeToEditCombo)
    {
        String s = extractName(typeToEditCombo, "FontFamily");
        if(!Settings.load(Character.toLowerCase(s.charAt(0)) + s.substring(1)).equals(fontTypeTxt.getText()))
            saveText(fontTypeTxt, Character.toLowerCase(s.charAt(0)) + s.substring(1));
    }

    public static void fontSizeTxtActionPerformed(JTextField fontSizeTxt, JComboBox<String> typeToEditCombo)
    {
        String s = extractName(typeToEditCombo, "FontSize");
        if(!Settings.load(Character.toLowerCase(s.charAt(0)) + s.substring(1)).equals(fontSizeTxt.getText()))
            saveText(fontSizeTxt, Character.toLowerCase(s.charAt(0)) + s.substring(1));
    }

    public static void styleCheckActionPerformed(JCheckBox boldCheck, JCheckBox italicCheck, JComboBox<String> typeToEditCombo)
    {
        String setting = "";
        String name = extractName(typeToEditCombo, "FontStyle");

        if(italicCheck.isSelected())
            setting += "italic";
        if(boldCheck.isSelected())
            setting += " bold";

        Settings.save(Character.toLowerCase(name.charAt(0)) + name.substring(1), setting);
    }

    public static void addTypeBtnActionPerformed(JTextField typeToEditTxt, JComboBox<String> typeToEditCombo)
    {
        typeToEditCombo.addItem("Art: " + typeToEditTxt.getText());
    }

    public static void deleteTypeBtnActionPerformed(JTextField typeToEditTxt, JComboBox typeToEditCombo)
    {
        typeToEditCombo.removeItem("Art: " + typeToEditTxt.getText());

        String[] setting = Settings.loadNames("art" + typeToEditTxt.getText());
        for(String s : setting)
            Settings.delete(s);
    }

    public static void saveDesignBtnActionPerformed()
    {
        HtmlWriter.style();
        backupToDestPaths();
        if(Settings.load("autoBackup").equals("true"))
            createBackupBtnActionPerformed();
    }

    // ================================================== SQL ==================================================
    public static void SQLsaveBtnActionPerformed(JTextField dbHostTxt, JTextField dbPortTxt, JTextField dbNameTxt,
                                                 JTextField dbUserTxt, JTextField dbPwTxt, JTextField dbTableNameTxt,
                                                 JCheckBox useSQLCheck, JRadioButton[] sqlMode)
    {
        saveCheck(useSQLCheck, "sqlUse");
        for(JRadioButton b : sqlMode)
            if(b.isSelected())
                Settings.save("sqlMode", b.getText());

        saveText(dbHostTxt, "sqlHost");
        saveText(dbPortTxt, "sqlPort");
        saveText(dbNameTxt, "sqlName");
        saveText(dbUserTxt, "sqlUser");
        saveText(dbPwTxt, "sqlPassw");
        saveText(dbTableNameTxt, "sqlTableName");
    }

    // ================================================== ANDERES ==================================================
    public static void loadSettings(JTextField sourceTxt, JTextField backupTxt, JTextArea destArea, JTextField fileNamePrefixTxt,
                                    JTextField fileNameSuffixTxt, JTextField speedPlanTxt, JTextField speedMotdTxt,
                                    JComboBox<String> colorPlanCombo, JComboBox<String> colorMotdCombo,
                                    JTextField motdTxt, JCheckBox useSQLCheck, JTextField dbHostTxt, JTextField dbPortTxt,
                                    JTextField dbNameTxt, JTextField dbUserTxt, JTextField dbPwTxt, JTextField dbTableNameTxt,
                                    JRadioButton[] sqlMode, JTextField hour1Txt, JTextField hour2Txt, JTextField hour3Txt, JTextField hour4Txt,
                                    JTextField hour5Txt, JTextField hour6Txt, JTextField hour7Txt, JTextField hour8Txt,
                                    JTextField hour9Txt, JTextField hour10Txt, JCheckBox autoBackupCheck,
                                    JCheckBox useHoursCheck, JCheckBox customSourceCheck, JTextField sourceTodayTxt,
                                    JTextField sourceTomorrowTxt, JComboBox<String> colorTableCombo, JComboBox<String> colorBorderCombo,
                                    JComboBox<String> fontColorCombo, JComboBox<String> backgroundColorCombo, JTextField fontTypeTxt,
                                    JTextField fontSizeTxt, JCheckBox boldCheck, JCheckBox italicCheck, JComboBox<String> typeToEditCombo,
                                    JTable table, JTextField weekTxt)
    {
        loadText(sourceTxt, "pathSource");
        loadText(backupTxt, "pathBackup");
        loadText(motdTxt, "motdText");
        loadText(speedPlanTxt, "planSpeed");
        loadText(speedMotdTxt, "motdSpeed");
        loadText(dbHostTxt, "sqlHost");
        loadText(dbPortTxt, "sqlPort");
        loadText(dbNameTxt, "sqlName");
        loadText(dbUserTxt, "sqlUser");
        loadText(dbPwTxt, "sqlPassw");
        loadText(dbTableNameTxt, "sqlTableName");
        loadText(hour1Txt, "lesson01");
        loadText(hour2Txt, "lesson02");
        loadText(hour3Txt, "lesson03");
        loadText(hour4Txt, "lesson04");
        loadText(hour5Txt, "lesson05");
        loadText(hour6Txt, "lesson06");
        loadText(hour7Txt, "lesson07");
        loadText(hour8Txt, "lesson08");
        loadText(hour9Txt, "lesson09");
        loadText(hour10Txt, "lesson10");
        loadText(sourceTodayTxt, "customToday");
        loadText(sourceTomorrowTxt, "customTomorrow");
        loadText(weekTxt, "customWeek");
        loadText(fileNamePrefixTxt, "fileNamePrefix");
        loadText(fileNameSuffixTxt, "fileNameSuffix");

        if(Settings.load("motdText").equals("") || Settings.load("motdText").equals("Laufschrift"))
            motdTxt.setForeground(Color.GRAY);

        loadCheck(useSQLCheck, "sqlUse");
        loadCheck(autoBackupCheck, "autoBackup");
        loadCheck(useHoursCheck, "lessonUse");
        loadCheck(customSourceCheck, "customDate");

        if(Settings.load("sqlMode").equals("lesen"))
            sqlMode[0].setSelected(true);
        else if(Settings.load("sqlMode").equals("löschen und schreiben"))
            sqlMode[2].setSelected(true);
        else
            sqlMode[1].setSelected(true);

        String name = "pathDest1";
        if(Settings.line(name) == -1)
            Settings.load(name);

        for(int i = 1; Settings.line(name) != -1; i++)
        {
            String s = Settings.load(name);
            destArea.append(s + "\n");
            name = "pathDest" + (i + 1);
        }

        loadColors(colorPlanCombo, colorMotdCombo, colorTableCombo, colorBorderCombo, fontColorCombo, backgroundColorCombo);

        loadCombo(colorPlanCombo, "planColor");
        loadCombo(colorMotdCombo, "motdColor");
        loadCombo(colorTableCombo, "tableColor");
        loadCombo(colorBorderCombo, "borderColor");
        loadCombo(fontColorCombo, "überschriftFontColor");

        loadText(fontTypeTxt, "überschriftFontFamily");
        loadText(fontSizeTxt, "überschriftFontSize");

        ArrayList<String> settingNames = new ArrayList<String>();
        String[] settings = Settings.loadNames("art");
        for(String s : settings)
        {
            if(s.contains("FontColor"))
                checkArt(settingNames, typeToEditCombo, s, "FontColor");
            else if(s.contains("BackColor"))
                checkArt(settingNames, typeToEditCombo, s, "BackColor");
            else if(s.contains("FontFamily"))
                checkArt(settingNames, typeToEditCombo, s, "FontFamily");
            else if(s.contains("FontSize"))
                checkArt(settingNames, typeToEditCombo, s, "FontSize");
            else if(s.contains("FontStyle"))
                checkArt(settingNames, typeToEditCombo, s, "FontStyle");
        }

        boldCheck.setSelected(false);
        italicCheck.setSelected(false);
        String bool = Settings.load("überschriftFontStyle");
        if(bool.equals("bold"))
            boldCheck.setSelected(true);
        else if(bool.equals("italic"))
            italicCheck.setSelected(true);

        String[] order = Settings.load("lessonOrder").split(",");
        for(int i = 0; i < 7; i++)
            switch(order[i])
            {
                case "0":
                    loadTable(table, i, 0, "Vertreter");
                    break;
                case "1":
                    loadTable(table, i, 1, "Raum");
                    break;
                case "2":
                    loadTable(table, i, 2, "Art");
                    break;
                case "3":
                    loadTable(table, i, 3, "Fach");
                    break;
                case "4":
                    loadTable(table, i, 4, "Lehrer");
                    break;
                case "5":
                    loadTable(table, i, 5, "Verl. von");
                    break;
                case "6":
                    loadTable(table, i, 6, "Hinweise");
                    break;
            }
    }

    /**
     * Aktualisiert eine ComboBox aufgrund ihrer Auswahl.
     *
     * @param name       Name der Einstellung
     * @param colorPanel Farb-Panel
     * @param colorCombo Farb-Combo
     * @param evt        Item-Event
     */
    private static void colorComboChanged(String name, JPanel colorPanel, JComboBox colorCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            if(!colorCombo.getSelectedItem().equals("Keine Farbe"))
                colorPanel.setBackground(Color.decode(Settings.load("color" + colorCombo.getSelectedItem().toString())));

            if(!Settings.load(name).equals(colorCombo.getSelectedItem().toString()) && !colorCombo.getSelectedItem().toString().equals("Keine Farbe"))
                Settings.save(name, colorCombo.getSelectedItem().toString());
        }
    }

    /**
     * Gibt den Namen des ausgewählten Items.
     *
     * @param combo Box die verwendet werden soll
     * @param type  Zu suchender Typ
     *
     * @return Name des ausgewählten Items
     */
    private static String extractName(JComboBox<String> combo, String type)
    {
        String s;
        if(combo.getSelectedItem().toString().startsWith("Art:"))
            s = "Art" + combo.getSelectedItem().toString().substring(5).replaceAll("\\.", "") + type;
        else
            s = combo.getSelectedItem().toString() + type;
        return s;
    }

    /**
     * Speichert die aktuelle Position des JFrames auf dem Bildschrim.
     *
     * @param frame Der Frame dessen Position gespeichert werden soll
     */
    public static void savePositionOfFrame(JFrame frame)
    {
        Settings.save("positionX", String.valueOf((int)frame.getLocation().getX()));
        Settings.save("positionY", String.valueOf((int)frame.getLocation().getY()));
    }

    /**
     * Prüft ob die Einstellung vom Typ "Art" ist.
     *
     * @param settingNames Zu prüfende Einstellungen.
     * @param combo        Zu bearbeitende ComboBox
     * @param setting      Einstellung
     * @param name         Name der Einstellung
     */
    private static void checkArt(ArrayList<String> settingNames, JComboBox<String> combo, String setting, String name)
    {
        if(!settingNames.contains(setting.substring(3, setting.indexOf(name))))
        {
            combo.addItem("Art: " + setting.substring(3, setting.indexOf(name)));
            settingNames.add(setting.substring(3, setting.indexOf(name)));
        }
    }

    /**
     * Lädt eine Tabellen-Spalte abhänging vom head.
     *
     * @param table    Tabelle
     * @param index    Index
     * @param newIndex Neuer Index
     * @param head     Name der Spalte
     */
    private static void loadTable(JTable table, int index, int newIndex, String head)
    {
        table.getColumnModel().getColumn(index).setHeaderValue(head);
        table.getColumnModel().getColumn(index).setModelIndex(newIndex);
    }

    /**
     * Lädt die Farben in die ComboBoxen.
     *
     * @param colorCombos ComboBoxen
     */
    @SafeVarargs
    private static void loadColors(JComboBox<String>... colorCombos)
    {
        for(JComboBox<String> cb : colorCombos)
        {
            cb.removeAllItems();
            cb.addItem("Keine Farbe");
            String[] colors = Settings.loadNames("color");
            for(String s : colors)
                if(!s.contains("colorOf"))
                    cb.addItem(s.substring(5));
        }
    }

    /**
     * Lädt eine Einstellung in ein Textfeld.
     *
     * @param field Textfeld
     * @param name  Name der Einstellung
     */
    private static void loadText(JTextField field, String name)
    {
        field.setText(Settings.load(name));
    }

    /**
     * Speichert eine Einstellung aus einem Textfeld.
     *
     * @param field Textfeld
     * @param name  Name der Einstellung
     */
    private static void saveText(JTextField field, String name)
    {
        Settings.save(name, field.getText());
    }

    /**
     * Lädt eine Einstellung in eine ComboBox.
     *
     * @param field ComboBox
     * @param name  Name der Einstellung
     */
    private static void loadCombo(JComboBox<String> box, String name)
    {
        box.setSelectedItem(Settings.load(name));
    }

    /**
     * Lädt eine Einstellung in eine CheckBox.
     *
     * @param field CheckBox
     * @param name  Name der Einstellung
     */
    private static void loadCheck(JCheckBox box, String name)
    {
        box.setSelected(Boolean.valueOf(Settings.load(name)));
    }

    /**
     * Speichert eine Einstellung aus einer CheckBox.
     *
     * @param field CheckBox
     * @param name  Name der Einstellung
     */
    private static void saveCheck(JCheckBox box, String name)
    {
        Settings.save(name, String.valueOf(box.isSelected()));
    }

    /**
     * Kopiert die generierten Dateien in die Zielpfade.
     */
    private static void backupToDestPaths()
    {
        String[] paths = Settings.loadMulti("pathDest");

        for(int i = 0; i < paths.length; i++)
            paths[i] = PathConverter.convert(paths[i]);

        for(String path : paths)
            backupAll(path);
    }

    /**
     * Kopiert alle wichtigen Dateien zu einem Pfad.
     *
     * @param path Pfad
     */
    private static void backupAll(String path)
    {
        Logger.setLogging(false);
        new FileHandler("Data/settings.ini").copy(path + "/");
        new FileHandler("Data/heute.html").copy(path + "/");
        new FileHandler("Data/morgen.html").copy(path + "/");
        new FileHandler("Data/laufschrift.html").copy(path + "/");
        new FileHandler("Data/style.css").copy(path + "/");
        new FileHandler("Data/antonianumLogo.png").copy(path + "/");
        new FileHandler("Data/VERTRETUNGSPLAN.html").copy(path + "/");
        Logger.setLogging(true);
    }
}
