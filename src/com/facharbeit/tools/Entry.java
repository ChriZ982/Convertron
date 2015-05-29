package com.facharbeit.tools;

import java.util.HashMap;
import java.util.Map;

/**
 * Einzelne Vertretung innerhalb einer Schulklasse.
 */
public class Entry
{
    /**
     * Daten die für den Vertretungsplan relevant sind, in der normalen Reihenfolge.
     */
    public static final String[] defaultImportantContentOrder =
    {
        "Vertreter", "Raum", "Vertretungsart", "(Fach)", "(Lehrer)", "Verl. von", "Hinweise"
    };

    /**
     * Die Stunde, für den der Eintrag gilt.
     */
    private int lesson = -1;

    /**
     * Das Datum, das zu dem Eintrag gehört.
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
     * Daten die für den Vertretungsplan relevant sind, in einer bestimmten Reihenfolge.
     */
    private String[] importantContentOrder = defaultImportantContentOrder;

    /**
     * Initialisiert einen neuen Eintrag.
     *
     * @param content Inhalt des Eintrags
     *
     * 
     */
    public Entry(Map<String, String> content)
    {
        if(content.get("Std").contains("-"))
        {
            doubleLesson = true;
            content.put("Std", content.get("Std").replaceAll(" ", ""));
            this.lesson = Integer.parseInt(content.get("Std").substring(0, content.get("Std").indexOf("-")));
        }
        else if(!content.get("Std").equals(""))
            this.lesson = Integer.parseInt(content.get("Std"));

        this.date = content.get("Datum");

        this.content = new HashMap<String, String>();

        for(String ic : importantContentOrder)
            this.content.put(ic, "");

        this.content.putAll(content);
    }

    /**
     * Konvertiert den Eintrag ein eine HTML-Tabellenzeile.
     *
     * @param cssClass css-Klasse, der dieser Eintrag angehört
     *
     * @return HTML-Tabellenzeile die die Werte des Eintrags besitzt
     *
     * 
     */
    public String toHtml(String cssClass)
    {
        String s = "";
        s += "'            <tr class=\"" + cssClass + "\">'+\n";
        if(doubleLesson)
            s += "'                <td>" + lesson + "-" + (lesson + 1) + "</td>'+\n";
        else
            s += "'                <td>" + lesson + "</td>'+\n";

        for(String c : importantContentOrder)
            s += "'                <td>" + content.get(c) + "</td>'+\n";

        s += "'            </tr>'+\n";
        return s;
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
     * Gibt relevanten Inhalt.
     *
     * @return Inhalt
     *
     * 
     */
    public String[] getImportantContent()
    {
        if(importantContentOrder.length < 0 || content == null || content.isEmpty())
            return new String[]
            {
            };
        String[] c = new String[importantContentOrder.length];
        for(int i = 0; i < c.length; i++)
            c[i] = content.get(importantContentOrder[i]);
        return c;
    }

    /**
     * Setzt relevanten Inhalt.
     *
     * @param c Neuer Inhalt
     *
     * 
     */
    public void setImportantContent(String[] c)
    {
        for(int i = 0; i < c.length; i++)
            content.put(importantContentOrder[i], c[i]);
    }

    public String[] getImportantContentOrder()
    {
        return importantContentOrder;
    }

    public void setImportantContentOrder(String[] importantContentOrder)
    {
        this.importantContentOrder = importantContentOrder;
    }
}
