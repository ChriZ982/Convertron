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

public class QueueableMethods
{
    // Übersicht
    public static void genAllBtnActionPerformed()
    {
        HtmlWriter.generatePlanToday(HtmlReader.sortArray(HtmlReader.readInToday()), 50, 65);
        HtmlWriter.generatePlanTomorrow(HtmlReader.sortArray(HtmlReader.readInTomorrow()), 65, 80);
        HtmlWriter.generateModt(80, 95);
        HtmlWriter.generateStyle();
        backupToDestPaths();
        Logger.setProgress(100);
        if(Settings.load("autoBackup").equals("true"))
            createBackupBtnActionPerformed();
        if(Settings.load("autoDeleteSources").equals("true"))
            deleteSourceBtnActionPerformed();
        Logger.setProgress(0);
    }

    public static void genTodayBtnActionPerformed()
    {
        HtmlWriter.generatePlanToday(HtmlReader.sortArray(HtmlReader.readInToday()), 50, 95);
        HtmlWriter.generateStyle();
        backupToDestPaths();
        Logger.setProgress(100);
        if(Settings.load("autoBackup").equals("true"))
            createBackupBtnActionPerformed();
        if(Settings.load("autoDeleteSources").equals("true"))
            deleteSourceBtnActionPerformed();
        Logger.setProgress(0);
    }

    public static void genTomorrowBtnActionPerformed()
    {
        HtmlWriter.generatePlanTomorrow(HtmlReader.sortArray(HtmlReader.readInTomorrow()), 50, 95);
        HtmlWriter.generateStyle();
        backupToDestPaths();
        Logger.setProgress(100);
        if(Settings.load("autoBackup").equals("true"))
            createBackupBtnActionPerformed();
        if(Settings.load("autoDeleteSources").equals("true"))
            deleteSourceBtnActionPerformed();
        Logger.setProgress(0);
    }

    public static void genMotdBtnActionPerformed(JTextField motdTxt)
    {
        Settings.save("motdText", motdTxt.getText());
        HtmlWriter.generateModt(0, 100);
        HtmlWriter.generateStyle();
        backupToDestPaths();
        if(Settings.load("autoBackup").equals("true"))
            createBackupBtnActionPerformed();
        if(Settings.load("autoDeleteSources").equals("true"))
            deleteSourceBtnActionPerformed();
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
                                                      JCheckBox autoDeleteSourceCheck, JTextField speedPlanTxt,
                                                      JTextField speedMotdTxt)
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

        Settings.save("lessonUse", String.valueOf(useHoursCheck.isSelected()));
        Settings.save("autoBackup", String.valueOf(autoBackupCheck.isSelected()));
        Settings.save("autoDeleteSources", String.valueOf(autoDeleteSourceCheck.isSelected()));
    }

    // Pfade
    @SuppressWarnings("empty-statement")
    public static void savePathBtnActionPerformed(JTextField sourceTxt, JTextField backupTxt, JTextArea destArea,
                                                  JTextField sourceTodayTxt, JTextField sourceTomorrowTxt,
                                                  JCheckBox customSourceCheck)
    {
        Settings.save("sourceCustom", String.valueOf(customSourceCheck.isSelected()));

        saveIfNotNull(sourceTxt, "pathSource");
        saveIfNotNull(backupTxt, "pathBackup");
        saveIfNotNull(sourceTodayTxt, "sourceTodayPath");
        saveIfNotNull(sourceTomorrowTxt, "sourceTomorrowPath");

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
            else if(Settings.getLineOf(Character.toLowerCase(s.charAt(0)) + s.substring(1)) == -1)
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
        String s;
        if(typeToEditCombo.getSelectedItem().toString().startsWith("Art:"))
            s = "Art" + typeToEditCombo.getSelectedItem().toString().substring(5).replaceAll("\\.", "") + "FontStyle";
        else
            s = typeToEditCombo.getSelectedItem().toString() + "FontStyle";

        if(boldCheck.isSelected() && !italicCheck.isSelected())
        {
            Settings.save(Character.toLowerCase(s.charAt(0)) + s.substring(1), "bold");
            italicCheck.setSelected(false);
        } else if(italicCheck.isSelected() && !boldCheck.isSelected())
        {
            Settings.save(Character.toLowerCase(s.charAt(0)) + s.substring(1), "italic");
            boldCheck.setSelected(false);
        } else
        {
            Settings.save(Character.toLowerCase(s.charAt(0)) + s.substring(1), "");
            boldCheck.setSelected(false);
            italicCheck.setSelected(false);
        }
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
        HtmlWriter.generateStyle();
    }

    // SQL
    public static void SQLsaveBtnActionPerformed(JTextField dbHostTxt, JTextField dbPortTxt, JTextField dbNameTxt,
                                                 JTextField dbUserTxt, JTextField dbPwTxt, JTextField dbTableNameTxt,
                                                 JCheckBox useSQLCheck, JButton sqlModeBtn)
    {
        Settings.save("sqlUse", String.valueOf(useSQLCheck.isSelected()));
        Settings.save("sqlMode", sqlModeBtn.getText());

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
                                    JTextField hour1Txt, JTextField hour2Txt, JTextField hour3Txt, JTextField hour4Txt,
                                    JTextField hour5Txt, JTextField hour6Txt, JTextField hour7Txt, JTextField hour8Txt,
                                    JTextField hour9Txt, JTextField hour10Txt, JButton SQLModeBtn, JCheckBox autoBackupCheck,
                                    JCheckBox autoDeleteSourceCheck, JCheckBox useHoursCheck, JCheckBox customSourceCheck,
                                    JTextField sourceTodayTxt, JTextField sourceTomorrowTxt, JComboBox colorTableCombo,
                                    JComboBox colorBorderCombo, JComboBox fontColorCombo, JComboBox backgroundColorCombo,
                                    JTextField fontTypeTxt, JTextField fontSizeTxt, JCheckBox boldCheck, JCheckBox italicCheck,
                                    JComboBox typeToEditCombo)
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
        load(sourceTodayTxt, "sourceTodayPath");
        load(sourceTomorrowTxt, "sourceTomorrowPath");

        useSQLCheck.setSelected(Boolean.valueOf(Settings.load("sqlUse")));
        autoBackupCheck.setSelected(Boolean.valueOf(Settings.load("autoBackup")));
        autoDeleteSourceCheck.setSelected(Boolean.valueOf(Settings.load("autoDeleteSources")));
        useHoursCheck.setSelected(Boolean.valueOf(Settings.load("lessonUse")));
        customSourceCheck.setSelected(Boolean.valueOf(Settings.load("sourceCustom")));

        String name = "pathDest1";
        if(Settings.getLineOf(name) == -1)
            Settings.load(name);

        for(int i = 1; Settings.getLineOf(name) != -1; i++)
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

        if(Settings.load("sqlMode").equals("write"))
            SQLModeBtn.setText("schreiben");
        else
            SQLModeBtn.setText("lesen");
    }

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

    private static void saveIfNotNull(JTextField field, String name)
    {
        if(field.getText().equals(""))
            Settings.delete(name);
        else
            Settings.save(name, field.getText());
    }

    private static void load(JTextField field, String name)
    {
        field.setText(Settings.load(name));
    }

    private static void backupToDestPaths()
    {
        String[] paths = Settings.loadValues("pathDest");
        for(String path : paths)
            backupAll(path);
    }

    private static void backupAll(String path)
    {
        backup(path, "heute.html", "morgen.html", "laufschrift.html",
               "VERTRETUNGSPLAN.html", "TEMPLATE heute morgen.html", "TEMPLATE laufschrift.html",
               "settings.ini", "style.css", "antonianumLogo.png");
    }

    private static void backup(String path, String... files)
    {
        for(String file : files)
            copy(file, path);
    }

    private static void copy(String file, String path)
    {
        try
        {
            if(!Files.exists(Paths.get(path)))
                Files.createDirectories(Paths.get(path));

            Files.copy(Paths.get("Data\\" + file), Paths.get(path + "\\" + file), StandardCopyOption.REPLACE_EXISTING);
        } catch(IOException ex)
        {
            Logger.log("\"" + file + "\" konnte nicht kopiert werden !", 2);
        }
    }
}
