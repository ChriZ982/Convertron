package converter.data;

import converter.util.Settings;
import converter.util.Time;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasse, die alle Vertretungen (Entrys) einer Schulklasse beinhaltet.
 */
public class Class
{
    /**
     * Name der Schulklasse.
     */
    private String name;

    /**
     * Datum auf das die Einträge begrenzt wurden (durch onlyDate(String)).
     */
    private String curDate;

    /**
     * Einträge der Klasse.
     */
    private List<Lesson> entries;

    /**
     * Spalten, die es gibt.
     */
    private String[] contentColumms =
    {
        "Vertreter", "Raum", "Art", "Fach", "Lehrer", "Verl. von", "Hinweise"
    };

    /**
     * Initialisiert eine Schulklasse.
     *
     * @param name Name der Klasse
     */
    public Class(String name)
    {
        this.entries = new ArrayList<Lesson>();
        this.name = name;
    }

    /**
     * Gibt Name.
     *
     * @return Name der Schulklasse.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Prüft ob Einträge vorhanden sind.
     *
     * @return Sind keine Einträge vorhanden?
     *
     *
     */
    public boolean isEmpty()
    {
        if(entries == null)
            return true;
        return entries.isEmpty();
    }

    /**
     * Sortiert die Einträge.
     *
     * @param newOrder Neue Reihenfolge
     *
     *
     */
    public void sort(int... newOrder)
    {
        contentColumms = sort(contentColumms, newOrder);
        for(Lesson e : entries)
            e.setImportantContentOrder(sort(e.getImportantContentOrder(), newOrder));
    }

    /**
     * Sortiert die Einträge.
     *
     * @param old      Alter Inhalt
     * @param newOrder Neue Reihenfolge
     *
     * @return Alter Inhalt neu sortiert
     */
    private String[] sort(String[] old, int[] newOrder)
    {
        String[] newContent = new String[newOrder.length];

        int i = 0;
        for(int j : newOrder)
            if(j < old.length)
            {
                newContent[i] = old[j];
                i++;
            }

        return newContent;
    }

    /**
     * Löscht vergangene Stunden.
     *
     *
     * @throws java.io.IOException
     */
    public void cut() throws IOException
    {
        ArrayList<Lesson> newEntries = new ArrayList<Lesson>();
        for(Lesson e : entries)
        {
            int lesson = e.getLesson() - 1;
            if(e.isDoubleLesson())
                lesson++;
            if(Time.isAfter(Integer.valueOf(Settings.loadArray("lessons")[lesson].split(":")[0]),
                            Integer.valueOf(Settings.loadArray("lessons")[lesson].split(":")[1]),
                            Time.hour(),
                            Time.minute()))
                newEntries.add(e);
        }
        entries = newEntries;
    }

    /**
     * Konvertiert diese Schulklasse inkl ihrer Vertretungen (Entrys) in eine HTML-Tabelle.
     *
     * @return Konvertierte Klasse
     *
     * @throws java.io.IOException
     *
     *
     */
    public String toHtml() throws IOException
    {
        String s = "";
        String[] sizes = Settings.loadArray("lessonSizes");
        if(entries.size() > 0)
        {
            s += "'        <br/>'+\n"
                 + "''+\n"
                 + "'        <table class=\"stufeTab\" rules=\"all\">'+\n"
                 + "'            <colgroup>'+\n"
                 + "'                <col width=\"" + 7 + "%\">'+\n"
                 + "'                <col width=\"" + 6 + "%\">'+\n";

            for(String cc : contentColumms)
            {
                int colWidth = 10;
                switch(cc)
                {
                    case "Vertreter":
                        if(!sizes[0].isEmpty())
                            colWidth = Integer.parseInt(sizes[0]);
                        break;
                    case "Raum":
                        if(!sizes[1].isEmpty())
                            colWidth = Integer.parseInt(sizes[1]);
                        break;
                    case "Art":
                        if(!sizes[2].isEmpty())
                            colWidth = Integer.parseInt(sizes[2]);
                        break;
                    case "Fach":
                        if(!sizes[3].isEmpty())
                            colWidth = Integer.parseInt(sizes[3]);
                        break;
                    case "Lehrer":
                        if(!sizes[4].isEmpty())
                            colWidth = Integer.parseInt(sizes[4]);
                        break;
                    case "Verl. von":
                        if(!sizes[5].isEmpty())
                            colWidth = Integer.parseInt(sizes[5]);
                        break;
                    case "Hinweise":
                        if(!sizes[6].isEmpty())
                            colWidth = Integer.parseInt(sizes[6]);
                        break;
                    default:
                        break;
                }
                s += "'                <col width=\"" + colWidth + "%\">'+\n";
            }
            s += "'            </colgroup>'+\n"
                 + "'            <tr >'+\n"
                 + "'                <td rowspan=\"" + (entries.size() + 1) + "\" valign=\"top\"><div class=\"stufe\">" + name + "</div></td>'+\n";

            s += "'                <td>Std</td>'+\n";
            for(String cc : contentColumms)
                s += "'                <td>" + cc + "</td>'+\n";

            s += "'            </tr>'+\n";

            for(Lesson e : entries)
                s += e.toHtml(e.getContent().get("Vertretungsart").replaceAll("\\.", ""));

            s += "'        </table>'+";
        }
        return s;
    }

    /**
     * Prüft ob Einträge eines Datums enthalten sind.
     *
     * @param date Datum, das geprüft wird (dd.mm.)
     *
     * @return Einträge des Datums vorhanden?
     *
     *
     */
    public boolean containsEntrysOfDate(String date)
    {
        for(Lesson e : entries)
            if(e.getDate().equals(date))
                return true;
        return false;
    }

    /**
     * Löscht alle Einträge, die nicht dem Datum entsprechen.
     *
     * @param date Datum (dd.mm.)
     *
     *
     */
    public void onlyDate(String date)
    {
        curDate = date;
        ArrayList<Lesson> newEntrys = new ArrayList<Lesson>();
        for(Lesson e : entries)
            if(e.getDate().equals(date))
                newEntrys.add(e);
        entries = newEntrys;
    }

    /**
     * Gibt Datum.
     *
     * @return Datum
     */
    public String getCurDate()
    {
        return curDate;
    }

    public void addLesson(Lesson l)
    {
        entries.add(l);
    }

    public Lesson getLesson(int index)
    {
        return entries.get(index);
    }

    public int size()
    {
        return entries.size();
    }

    public void appendLesson(Lesson l)
    {
        Lesson last = entries.get(size() - 1);
        for(String key : l.getContent().keySet())
            l.append(key, l.getContent().get(key));
    }

    /**
     * @deprecated
     * Gibt Einträge.
     *
     * @return Einträge
     */
    public List<Lesson> getEntries()
    {
        return entries;
    }

    /**
     * @deprecated
     * Setzt Einträge.
     *
     * @param entrys Neue Einträge
     */
    public void setEntries(List<Lesson> entrys)
    {
        this.entries = entrys;
    }
}
