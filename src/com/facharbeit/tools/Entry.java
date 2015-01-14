package com.facharbeit.tools;

import java.util.HashMap;
import java.util.Map;

/**
 * Einträge einer Schulklasse.
 */
public class Entry
{
    /**
     * Die Stunde, für den der Eintrag gilt.
     */
    private int lesson = -1;

    /**
     * Das Datum des Eintrags.
     */
    private String date = null;

    /**
     * Ist der Eintrag doppelstündig?.
     */
    private boolean doubleLesson;

    /**
     * Daten des Eintrags.
     */
    private Map<String, String> content;

    /**
     * Daten die für den Vertretungsplan relevant sind.
     */
    public static final String[] importantContent =
    {
        "Vertreter", "Raum", "Vertretungsart", "(Fach)", "(Lehrer)", "Verl. von", "Hinweise"
    };

    /**
     * Initialisiert einen neuen Eintrag.
     *
     * @param content Inhalt des Eintrags
     */
    public Entry(Map<String, String> content)
    {
        try
        {
            if(content.get("Std").indexOf("-") > 0)
            {
                doubleLesson = true;
                this.lesson = Integer.parseInt(content.get("Std").substring(0, content.get("Std").indexOf("-") - 1));
            }
            else if(!content.get("Std").equals(""))
                this.lesson = Integer.parseInt(content.get("Std"));

            this.date = content.get("Datum");

            this.content = new HashMap<String, String>();

            for(String ic : importantContent)
                this.content.put(ic, "");

            this.content.putAll(content);

        } catch(Exception ex)
        {
            Logger.log("Eintrag konnte nicht initialisiert werden", 2);
            Logger.error(ex);
        }
    }

    /**
     * Konvertiert den Eintrag als String.
     *
     * @param cssClass css-Klasse, die für den Eintrag gilt
     *
     * @return Eintrag als String
     */
    public String toString(String cssClass)
    {
        try
        {
            String s = "";
            s += "'            <tr class=\"" + cssClass + "\">'+\n";
            if(doubleLesson)
                s += "'                <td>" + lesson + "-" + (lesson + 1) + "</td>'+\n";
            else
                s += "'                <td>" + lesson + "</td>'+\n";

            for(String c : importantContent)
                s += "'                <td>" + content.get(c) + "</td>'+\n";

            s += "'            </tr>'+\n";
            return s;
        } catch(Exception ex)
        {
            Logger.log("Eintrag konnte nicht in String konvertiert werden", 2);
            Logger.error(ex);
            return null;
        }
    }

    /**
     * Gibt Datum.
     *
     * @return Datum
     */
    public String getDate()
    {
        return date;
    }

    /**
     * Gibt Stunde.
     *
     * @return Stunde
     */
    public int getLesson()
    {
        return lesson;
    }

    /**
     * Ist doppelte Stunde?.
     *
     * @return Doppelte Stunde?
     */
    public boolean isDoubleLesson()
    {
        return doubleLesson;
    }

    /**
     * Gibt Inhalt.
     *
     * @return Inhalt
     */
    public Map<String, String> getContent()
    {
        return content;
    }

    /**
     * Setzt Inhalt.
     *
     * @param content Neuer Inhalt
     */
    public void setContent(Map<String, String> content)
    {
        this.content = content;
    }

    /**
     * Gibt Inhalt.
     *
     * @return Inhalt
     */
    public String[] getImportantContent()
    {
        String[] c = new String[importantContent.length];
        for(int i = 0; i < c.length; i++)
            c[i] = content.get(importantContent[i]);
        return c;
    }

    public void setImportantContent(String[] c)
    {
        for(int i = 0; i < c.length; i++)
            content.put(importantContent[i], c[i]);
    }
}
