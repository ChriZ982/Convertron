package com.facharbeit.main;

import com.facharbeit.io.*;
import com.facharbeit.tools.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.*;
import javax.swing.*;

/**
 * Diese Klasse beinhaltet alle wichtigen Methoden, die in die Warteschlange der Anwendung angehängt werden können.
 * Hier wird kein Try-Catch verwendet, da alle Fehler durch die invoke-Methode aufgefangen werden
 */
public class QueueableMethods
{
    // Übersicht
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
        Settings.save("motdText", motdTxt.getText());
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

    public static void deleteSourceBtnActionPerformed()
    {
        try
        {
            Files.walkFileTree(Paths.get(Settings.load("pathSource") + "\\"), new SimpleFileVisitor<Path>()
                       {
                           @Override
                           public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                                   throws IOException
                           {
                               Files.delete(file);
                               return FileVisitResult.CONTINUE;
                           }

                           @Override
                           public FileVisitResult postVisitDirectory(Path dir, IOException e)
                                   throws IOException
                           {
                               if(e == null)
                               {
                                   Files.delete(dir);
                                   return FileVisitResult.CONTINUE;
                               } else
                                   // directory iteration failed
                                   throw e;
                           }
            });
        } catch(IOException ex)
        {
            Logger.log("Quellpläne konnten nicht gelöscht werden!", 2);
            return;
        }
        Logger.log("Quellpläne wurden gelöscht", 0);
    }

    // Einstellungen
    public static void settingsSaveBtnActionPerformed(JTextField hour1Txt, JTextField hour2Txt, JTextField hour3Txt,
                                                      JTextField hour4Txt, JTextField hour5Txt, JTextField hour6Txt,
                                                      JTextField hour7Txt, JTextField hour8Txt, JTextField hour9Txt,
                                                      JTextField hour10Txt, JCheckBox useHoursCheck, JCheckBox autoBackupCheck,
                                                      JTextField speedPlanTxt, JTextField speedMotdTxt, JTable table,
                                                      JTextField weekTxt, JTextField sourceTodayTxt, JTextField sourceTomorrowTxt,
                                                      JCheckBox customSourceCheck)
    {
        saveIfNotNull(hour1Txt, "lesson1");
        saveIfNotNull(hour2Txt, "lesson2");
        saveIfNotNull(hour3Txt, "lesson3");
        saveIfNotNull(hour4Txt, "lesson4");
        saveIfNotNull(hour5Txt, "lesson5");
        saveIfNotNull(hour6Txt, "lesson6");
        saveIfNotNull(hour7Txt, "lesson7");
        saveIfNotNull(hour8Txt, "lesson8");
        saveIfNotNull(hour9Txt, "lesson9");
        saveIfNotNull(hour10Txt, "lesson10");
        saveIfNotNull(speedPlanTxt, "planSpeed");
        saveIfNotNull(speedMotdTxt, "motdSpeed");
        saveIfNotNull(weekTxt, "customWeek");
        saveIfNotNull(sourceTodayTxt, "customToday");
        saveIfNotNull(sourceTomorrowTxt, "customTomorrow");

        Settings.save("customDate", String.valueOf(customSourceCheck.isSelected()));

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
        Settings.save("lessonUse", String.valueOf(useHoursCheck.isSelected()));
        Settings.save("autoBackup", String.valueOf(autoBackupCheck.isSelected()));
    }

    // Pfade
    @SuppressWarnings("empty-statement")
    public static void savePathBtnActionPerformed(JTextField sourceTxt, JTextField backupTxt, JTextArea destArea)
    {
        saveIfNotNull(sourceTxt, "pathSource");
        saveIfNotNull(backupTxt, "pathBackup");

        ArrayList<String> destPaths = new ArrayList<String>();
        destPaths.addAll(Arrays.asList(destArea.getText().split("\n")));

        for(int i = 0; Settings.delete("pathDest" + (i + 1)); i++);

        if(!destArea.getText().equals(""))
            for(int i = 0; i < destPaths.size(); i++)
                Settings.save("pathDest" + (i + 1), destPaths.get(i));
    }

    // Design
    public static void addColorBtnActionPerformed(JColorChooser colorChooser, JTextField colorNameTxt, JComboBox colorPlanCombo,
                                                  JComboBox colorMotdCombo, JComboBox colorTableCombo, JComboBox colorBorderCombo,
                                                  JComboBox fontColorCombo, JComboBox backgroundColorCombo)
    {
        Color c = JColorChooser.showDialog(colorChooser, "Neue Farbe anlegen", Color.BLUE);

        if(c != null)
        {
            Settings.save("color" + colorNameTxt.getText(), "#" + Integer.toHexString(c.getRGB()).substring(2));
            loadColors(colorPlanCombo, colorMotdCombo, colorTableCombo, colorBorderCombo, fontColorCombo, backgroundColorCombo);

            colorPlanCombo.setSelectedItem(Settings.load("planColor"));
            colorMotdCombo.setSelectedItem(Settings.load("motdColor"));
            colorTableCombo.setSelectedItem(Settings.load("tableColor"));
            colorBorderCombo.setSelectedItem(Settings.load("borderColor"));
        }
    }

    public static void deleteColorBtnActionPerformed(JTextField colorNameTxt, JComboBox colorPlanCombo, JComboBox colorMotdCombo,
                                                     JComboBox colorTableCombo, JComboBox colorBorderCombo, JComboBox fontColorCombo,
                                                     JComboBox backgroundColorCombo)
    {
        Settings.delete("color" + colorNameTxt.getText());
        loadColors(colorPlanCombo, colorMotdCombo, colorTableCombo, colorBorderCombo, fontColorCombo, backgroundColorCombo);

        colorPlanCombo.setSelectedItem(Settings.load("planColor"));
        colorMotdCombo.setSelectedItem(Settings.load("motdColor"));
        colorTableCombo.setSelectedItem(Settings.load("tableColor"));
        colorBorderCombo.setSelectedItem(Settings.load("borderColor"));
    }

    public static void colorPlanComboItemStateChanged(JPanel colorPlanPanel, JComboBox colorPlanCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            colorPlanPanel.setBackground(Color.decode(Settings.load("color" + colorPlanCombo.getSelectedItem().toString())));

            if(!Settings.load("planColor").equals(colorPlanCombo.getSelectedItem().toString()))
                Settings.save("planColor", colorPlanCombo.getSelectedItem().toString());
        }
    }

    public static void colorMotdComboItemStateChanged(JPanel colorMotdPanel, JComboBox colorMotdCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            colorMotdPanel.setBackground(Color.decode(Settings.load("color" + colorMotdCombo.getSelectedItem().toString())));

            if(!Settings.load("motdColor").equals(colorMotdCombo.getSelectedItem().toString()))
                Settings.save("motdColor", colorMotdCombo.getSelectedItem().toString());
        }
    }

    public static void colorTableComboItemStateChanged(JPanel colorTablePanel, JComboBox colorTableCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            colorTablePanel.setBackground(Color.decode(Settings.load("color" + colorTableCombo.getSelectedItem().toString())));

            if(!Settings.load("tableColor").equals(colorTableCombo.getSelectedItem().toString()))
                Settings.save("tableColor", colorTableCombo.getSelectedItem().toString());
        }
    }

    public static void colorBorderComboItemStateChanged(JPanel colorBorderPanel, JComboBox colorBorderCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            colorBorderPanel.setBackground(Color.decode(Settings.load("color" + colorBorderCombo.getSelectedItem().toString())));

            if(!Settings.load("borderColor").equals(colorBorderCombo.getSelectedItem().toString()))
                Settings.save("borderColor", colorBorderCombo.getSelectedItem().toString());
        }
    }

    public static void typeToEditComboItemStateChanged(JComboBox typeToEditCombo, JComboBox fontColorCombo,
                                                       JPanel fontColorPanel, JComboBox backgroundColorCombo,
                                                       JPanel backgroundColorPanel, JTextField fontTypeTxt,
                                                       JTextField fontSizeTxt, JCheckBox boldCheck, JCheckBox italicCheck,
                                                       ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            String s;
            if(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"))
                s = "Art" + typeToEditCombo.getSelectedItem().toString().substring(5).replaceAll("\\.", "") + "FontColor";
            else
                s = typeToEditCombo.getSelectedItem().toString() + "FontColor";
            fontColorCombo.setSelectedItem(Settings.load(Character.toLowerCase(s.charAt(0)) + s.substring(1)));
            fontColorPanel.setBackground(Color.decode(Settings.load("color" + fontColorCombo.getSelectedItem().toString())));

            if(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"))
            {
                s = "Art" + typeToEditCombo.getSelectedItem().toString().substring(5).replaceAll("\\.", "") + "BackColor";
                backgroundColorCombo.setSelectedItem(Settings.load(Character.toLowerCase(s.charAt(0)) + s.substring(1)));
                backgroundColorPanel.setBackground(Color.decode(Settings.load("color" + backgroundColorCombo.getSelectedItem().toString())));
            }

            if(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"))
                s = "Art" + typeToEditCombo.getSelectedItem().toString().substring(5).replaceAll("\\.", "") + "FontFamily";
            else
                s = typeToEditCombo.getSelectedItem().toString() + "FontFamily";
            fontTypeTxt.setText(Settings.load(Character.toLowerCase(s.charAt(0)) + s.substring(1)));

            if(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"))
                s = "Art" + typeToEditCombo.getSelectedItem().toString().substring(5).replaceAll("\\.", "") + "FontSize";
            else
                s = typeToEditCombo.getSelectedItem().toString() + "FontSize";
            fontSizeTxt.setText(Settings.load(Character.toLowerCase(s.charAt(0)) + s.substring(1)));

            boldCheck.setSelected(false);
            italicCheck.setSelected(false);
            if(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"))
                s = "Art" + typeToEditCombo.getSelectedItem().toString().substring(5).replaceAll("\\.", "") + "FontStyle";
            else
                s = typeToEditCombo.getSelectedItem().toString() + "FontStyle";
            String bool = Settings.load(Character.toLowerCase(s.charAt(0)) + s.substring(1));
            if(bool.equals("bold"))
                boldCheck.setSelected(true);
            else if(bool.equals("italic"))
                italicCheck.setSelected(true);
            else if(Settings.line(Character.toLowerCase(s.charAt(0)) + s.substring(1)) == -1)
                Settings.save(Character.toLowerCase(s.charAt(0)) + s.substring(1), "");
        }
    }

    public static void fontColorComboItemStateChanged(JPanel fontColorPanel, JComboBox fontColorCombo, JComboBox typeToEditCombo, ItemEvent evt)
    {
        if(evt.getStateChange() == ItemEvent.SELECTED)
        {
            fontColorPanel.setBackground(Color.decode(Settings.load("color" + fontColorCombo.getSelectedItem().toString())));

            String s;
            if(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"))
                s = "Art" + typeToEditCombo.getSelectedItem().toString().substring(5).replaceAll("\\.", "") + "FontColor";
            else
                s = typeToEditCombo.getSelectedItem().toString() + "FontColor";
            if(!Settings.load(Character.toLowerCase(s.charAt(0)) + s.substring(1)).equals(fontColorCombo.getSelectedItem().toString()))
                Settings.save(Character.toLowerCase(s.charAt(0)) + s.substring(1), fontColorCombo.getSelectedItem().toString());
        }
    }

    public static void backgroundColorComboItemStateChanged(JPanel backgroundColorPanel, JComboBox backgroundColorCombo, JComboBox typeToEditCombo, ItemEvent evt)
    {
        backgroundColorPanel.setBackground(Color.decode(Settings.load("color" + backgroundColorCombo.getSelectedItem().toString())));

        if(evt.getStateChange() == ItemEvent.SELECTED && typeToEditCombo.getSelectedItem().toString().startsWith("Art:"))
        {
            String s;
            if(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"))
                s = "Art" + typeToEditCombo.getSelectedItem().toString().substring(5).replaceAll("\\.", "") + "BackColor";
            else
                s = typeToEditCombo.getSelectedItem().toString() + "BackColor";
            if(!Settings.load(Character.toLowerCase(s.charAt(0)) + s.substring(1)).equals(backgroundColorCombo.getSelectedItem().toString()))
                Settings.save(Character.toLowerCase(s.charAt(0)) + s.substring(1), backgroundColorCombo.getSelectedItem().toString());
        }
    }

    public static void fontTypeTxtActionPerformed(JTextField fontTypeTxt, JComboBox typeToEditCombo)
    {
        String s;
        if(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"))
            s = "Art" + typeToEditCombo.getSelectedItem().toString().substring(5).replaceAll("\\.", "") + "FontFamily";
        else
            s = typeToEditCombo.getSelectedItem().toString() + "FontFamily";

        if(!Settings.load(Character.toLowerCase(s.charAt(0)) + s.substring(1)).equals(fontTypeTxt.getText()))
            Settings.save(Character.toLowerCase(s.charAt(0)) + s.substring(1), fontTypeTxt.getText());
    }

    public static void fontSizeTxtActionPerformed(JTextField fontSizeTxt, JComboBox typeToEditCombo)
    {
        String s;
        if(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"))
            s = "Art" + typeToEditCombo.getSelectedItem().toString().substring(5).replaceAll("\\.", "") + "FontSize";
        else
            s = typeToEditCombo.getSelectedItem().toString() + "FontSize";

        if(!Settings.load(Character.toLowerCase(s.charAt(0)) + s.substring(1)).equals(fontSizeTxt.getText()))
            Settings.save(Character.toLowerCase(s.charAt(0)) + s.substring(1), fontSizeTxt.getText());
    }

    public static void styleCheckActionPerformed(JCheckBox boldCheck, JCheckBox italicCheck, JComboBox typeToEditCombo)
    {
        String name;
        String setting = "";
        if(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"))
            name = "Art" + typeToEditCombo.getSelectedItem().toString().substring(5).replaceAll("\\.", "") + "FontStyle";
        else
            name = typeToEditCombo.getSelectedItem().toString() + "FontStyle";

        if(italicCheck.isSelected())
            setting += "italic";
        if(boldCheck.isSelected())
            setting += " bold";

        Settings.save(Character.toLowerCase(name.charAt(0)) + name.substring(1), setting);
    }

    public static void addTypeBtnActionPerformed(JTextField typeToEditTxt, JComboBox typeToEditCombo)
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

    // SQL
    public static void SQLsaveBtnActionPerformed(JTextField dbHostTxt, JTextField dbPortTxt, JTextField dbNameTxt,
                                                 JTextField dbUserTxt, JTextField dbPwTxt, JTextField dbTableNameTxt,
                                                 JCheckBox useSQLCheck, JRadioButton[] sqlMode)
    {
        Settings.save("sqlUse", String.valueOf(useSQLCheck.isSelected()));
        for(JRadioButton b : sqlMode)
            if(b.isSelected())
                Settings.save("sqlMode", b.getText());

        saveIfNotNull(dbHostTxt, "sqlHost");
        saveIfNotNull(dbPortTxt, "sqlPort");
        saveIfNotNull(dbNameTxt, "sqlName");
        saveIfNotNull(dbUserTxt, "sqlUser");
        saveIfNotNull(dbPwTxt, "sqlPassw");
        saveIfNotNull(dbTableNameTxt, "sqlTableName");
    }

    // Anderes
    public static void loadSettings(JTextField sourceTxt, JTextField backupTxt, JTextArea destArea, JTextField speedPlanTxt,
                                    JTextField speedMotdTxt, JComboBox colorPlanCombo, JComboBox colorMotdCombo,
                                    JTextField motdTxt, JCheckBox useSQLCheck, JTextField dbHostTxt, JTextField dbPortTxt,
                                    JTextField dbNameTxt, JTextField dbUserTxt, JTextField dbPwTxt, JTextField dbTableNameTxt,
                                    JRadioButton[] sqlMode, JTextField hour1Txt, JTextField hour2Txt, JTextField hour3Txt, JTextField hour4Txt,
                                    JTextField hour5Txt, JTextField hour6Txt, JTextField hour7Txt, JTextField hour8Txt,
                                    JTextField hour9Txt, JTextField hour10Txt, JCheckBox autoBackupCheck,
                                    JCheckBox useHoursCheck, JCheckBox customSourceCheck, JTextField sourceTodayTxt,
                                    JTextField sourceTomorrowTxt, JComboBox colorTableCombo, JComboBox colorBorderCombo,
                                    JComboBox fontColorCombo, JComboBox backgroundColorCombo, JTextField fontTypeTxt,
                                    JTextField fontSizeTxt, JCheckBox boldCheck, JCheckBox italicCheck, JComboBox typeToEditCombo,
                                    JTable table, JTextField weekTxt)
    {
        load(sourceTxt, "pathSource");
        load(backupTxt, "pathBackup");
        load(motdTxt, "motdText");
        load(speedPlanTxt, "planSpeed");
        load(speedMotdTxt, "motdSpeed");
        load(dbHostTxt, "sqlHost");
        load(dbPortTxt, "sqlPort");
        load(dbNameTxt, "sqlName");
        load(dbUserTxt, "sqlUser");
        load(dbPwTxt, "sqlPassw");
        load(dbTableNameTxt, "sqlTableName");
        load(hour1Txt, "lesson1");
        load(hour2Txt, "lesson2");
        load(hour3Txt, "lesson3");
        load(hour4Txt, "lesson4");
        load(hour5Txt, "lesson5");
        load(hour6Txt, "lesson6");
        load(hour7Txt, "lesson7");
        load(hour8Txt, "lesson8");
        load(hour9Txt, "lesson9");
        load(hour10Txt, "lesson10");
        load(sourceTodayTxt, "customToday");
        load(sourceTomorrowTxt, "customTomorrow");
        load(weekTxt, "customWeek");

        useSQLCheck.setSelected(Boolean.valueOf(Settings.load("sqlUse")));
        autoBackupCheck.setSelected(Boolean.valueOf(Settings.load("autoBackup")));
        useHoursCheck.setSelected(Boolean.valueOf(Settings.load("lessonUse")));
        customSourceCheck.setSelected(Boolean.valueOf(Settings.load("customDate")));

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

        colorPlanCombo.setSelectedItem(Settings.load("planColor"));
        colorMotdCombo.setSelectedItem(Settings.load("motdColor"));
        colorTableCombo.setSelectedItem(Settings.load("tableColor"));
        colorBorderCombo.setSelectedItem(Settings.load("borderColor"));

        fontColorCombo.setSelectedItem(Settings.load("überschriftFontColor"));
        fontTypeTxt.setText(Settings.load("überschriftFontFamily"));
        fontSizeTxt.setText(Settings.load("überschriftFontSize"));

        String[] setting = Settings.loadNames("art");
        for(String s : setting)
            if(s.contains("FontColor"))
                typeToEditCombo.addItem("Art: " + s.substring(3, s.indexOf("FontColor")));

        boldCheck.setSelected(false);
        italicCheck.setSelected(false);
        String bool = Settings.load("überschriftFontStyle");
        if(bool.equals("bold"))
            boldCheck.setSelected(true);
        else if(bool.equals("italic"))
            italicCheck.setSelected(true);

        String[] order = Settings.load("lessonOrder").split(",");
        if(order.length == 7)
            for(int i = 0; i < 7; i++)
                switch(order[i])
                {
                    case "0":
                        table.getColumnModel().getColumn(i).setHeaderValue("Vertreter");
                        table.getColumnModel().getColumn(i).setModelIndex(0);
                        break;
                    case "1":
                        table.getColumnModel().getColumn(i).setHeaderValue("Raum");
                        table.getColumnModel().getColumn(i).setModelIndex(1);
                        break;
                    case "2":
                        table.getColumnModel().getColumn(i).setHeaderValue("Art");
                        table.getColumnModel().getColumn(i).setModelIndex(2);
                        break;
                    case "3":
                        table.getColumnModel().getColumn(i).setHeaderValue("Fach");
                        table.getColumnModel().getColumn(i).setModelIndex(3);
                        break;
                    case "4":
                        table.getColumnModel().getColumn(i).setHeaderValue("Lehrer");
                        table.getColumnModel().getColumn(i).setModelIndex(4);
                        break;
                    case "5":
                        table.getColumnModel().getColumn(i).setHeaderValue("Verl. von");
                        table.getColumnModel().getColumn(i).setModelIndex(5);
                        break;
                    case "6":
                        table.getColumnModel().getColumn(i).setHeaderValue("Hinweise");
                        table.getColumnModel().getColumn(i).setModelIndex(6);
                        break;
                }
    }

    /**
     * Lädt die Farben in die ComboBoxen.
     *
     * @param colorCombos ComboBoxen
     */
    private static void loadColors(JComboBox... colorCombos)
    {
        for(JComboBox cb : colorCombos)
        {
            cb.removeAllItems();

            String[] colors = Settings.loadNames("color");
            for(String s : colors)
                if(!s.contains("colorOf"))
                    cb.addItem(s.substring(5));
        }
    }

    /**
     * Speichert den Inhalt eines Textfeldes.
     *
     * @param field Textfeld
     * @param name  Name der Einstellung
     */
    private static void saveIfNotNull(JTextField field, String name)
    {
        if(field.getText().equals(""))
            Settings.delete(name);
        else
            Settings.save(name, field.getText());
    }

    /**
     * Lädt eine Einstellung in ein Textfeld.
     *
     * @param field Textfeld
     * @param name  Name der Einstellung
     */
    private static void load(JTextField field, String name)
    {
        field.setText(Settings.load(name));
    }

    /**
     * Kopiert die generierten Dateien in die Zielpfade.
     */
    private static void backupToDestPaths()
    {
        String[] paths = Settings.loadMulti("pathDest");
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
        backup(path, "heute.html", "morgen.html", "laufschrift.html",
               "VERTRETUNGSPLAN.html", "TEMPLATE heute morgen.html", "TEMPLATE laufschrift.html",
               "settings.ini", "style.css", "antonianumLogo.png");
    }

    /**
     * Kopiert angegebene Dateien zu einem Pfad.
     *
     * @param path  Pfad
     * @param files Dateien zum Kopieren
     */
    private static void backup(String path, String... files)
    {
        for(String file : files)
            copy(file, path);
    }

    /**
     * Kopiert eine Datei zu einem Pfad.
     *
     * @param file Dateiname
     * @param path Pfad
     */
    private static void copy(String file, String path)
    {
        try
        {
            if(!Files.exists(Paths.get(path)))
                Files.createDirectories(Paths.get(path));

            Files.copy(Paths.get("Data\\" + file), Paths.get(path + "\\" + file), StandardCopyOption.REPLACE_EXISTING);
        } catch(Exception ex)
        {
            Logger.log("\"" + file + "\" konnte nicht kopiert werden", 2);
            Logger.error(ex);
        }
    }
}
