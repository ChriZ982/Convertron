package com.facharbeit.tools;

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
     * Wochentag des Eintrags
     */
    private String dayOfWeek = null;

    /**
     * Ist der Eintrag doppelstündig?.
     */
    private boolean doubleLesson;

    /**
     * Daten des Eintrags.
     */
    private String[] content;

    /**
     * Initialisiert einen neuen Eintrag.
     *
     * @param content Inhalt des Eintrags
     */
    public Entry(String... content)
    {
        try
        {
            boolean isDoubleLesson = false;

            if(content[0].contains("-"))
                this.lesson = Integer.parseInt(content[0].substring(0, content[0].indexOf("-") - 1));
            else if(!content[0].equals(""))
                this.lesson = Integer.parseInt(content[0]);

            if(content[0].indexOf("-") > 0)
            {
                isDoubleLesson = true;
                this.lesson = Integer.parseInt(content[0].substring(0, content[0].indexOf("-") - 1));

            }

            this.doubleLesson = isDoubleLesson;
            this.date = content[1];
            this.dayOfWeek = content[2];
            this.content = new String[content.length - 3];

            for(int i = 3; i < content.length; i++)
                this.content[i - 3] = content[i];
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
            for(String c : content)
                s += "'                <td>" + c + "</td>'+\n";
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
     * Gibt Wochentag.
     *
     * @return Wochentag
     */
    public String getDayOfWeek()
    {
        return dayOfWeek;
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
    public String[] getContent()
    {
        return content;
    }

    /**
     * Setzt Inhalt.
     *
     * @param content Neuer Inhalt
     */
    public void setContent(String[] content)
    {
        this.content = content;
    }
}
