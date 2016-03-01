package eu.convertron.basicmodules.html;

import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.filter.FilterOption;
import eu.convertron.interlib.filter.TableOptions;
import eu.convertron.interlib.interfaces.Output;
import eu.convertron.interlib.interfaces.View;
import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.util.SubTabView;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;

/**
 * Generiert die HTML-Dateien.
 */
public class HtmlOut implements Output
{
    private static String dataPath = "./debug/Data/";
    private static String evenChar = "B";

    private ColumnSelectPanel columnSelectPanel;
    private DesignPanel designPanel;
    private CustomDesignPanel customDesignPanel;

    public HtmlOut()
    {
        columnSelectPanel = new ColumnSelectPanel();
        designPanel = new DesignPanel();
        customDesignPanel = new CustomDesignPanel();
    }

    //TEMP
    @Override
    public void out(Lesson[] lessons)
    {
        export(lessons, "20.1.", "heute.html");
        export(lessons, "21.1.", "morgen.html");
    }

    private void export(Lesson[] lessons, String date, String fileName)
    {
        String templateLesson = new TextFile(dataPath, "template - lesson.txt").readAllToString();
        String templateClass = new TextFile(dataPath, "template - class.txt").readAllToString();
        String templateDay = new TextFile(dataPath, "template - day.txt").readAllToString();

        templateClass = addColumnsToClassTemplate(templateClass);
        String[] columnNames = getColumnNames();

        String[] classes = getClasses(lessons, date);
        String classesString = "";
        for(String className : classes)
        {
            classesString += getClassString(templateClass, className, columnNames, templateLesson, lessons, date) + "\n\n";
        }
        templateDay = templateDay.replace("CLASSES", classesString);

        String[] dates = date.substring(0, date.length() - 1).split("\\.");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, Integer.valueOf(dates[0]));
        cal.set(Calendar.MONTH, Integer.valueOf(dates[1]) - 1);
        templateDay = templateDay.replace("DAY", cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.GERMAN) + " " + date);

        String unevenChar = evenChar.equals("B") ? "A" : "B";
        String weekChar = cal.get(Calendar.WEEK_OF_YEAR) % 2 == 0 ? evenChar : unevenChar;

        templateDay = templateDay.replace("WEEK", weekChar + "-Woche (" + cal.get(Calendar.WEEK_OF_YEAR) + ". KW)");

        TextFile file = new TextFile(dataPath, fileName);
        file.writeLines(templateDay);

        styleOut(templateDay.split("\n").length);
    }

    private String getClassString(String templateClass, String className, String[] columnNames, String templateLesson, Lesson[] lessons, String date)
    {
        String customClass = templateClass.replace("CLASSNAME", className);
        Lesson[] classLessons = TableOptions.filterRows(lessons,
                                                        (FilterOption)(Lesson lesson) -> lesson.get("Klasse").trim().equals(className) && lesson.get("Datum").equals(date));
        customClass = customClass.replace("NUMLESSONS", String.valueOf(classLessons.length + 1));

        return customClass.replace("LESSONS", getLessonsString(classLessons, columnNames, templateLesson));
    }

    private String getLessonsString(Lesson[] classLessons, String[] columnNames, String templateLesson)
    {
        String classLessonsString = "";
        for(Lesson lesson : classLessons)
        {
            classLessonsString += templateLesson.replace("COLUMNS", getLessonColumns(columnNames, lesson)) + "\n";
        }
        return classLessonsString;
    }

    private String getLessonColumns(String[] columnNames, Lesson lesson)
    {
        String columns = "";
        for(String columnName : columnNames)
        {
            columns += "                <td>" + lesson.get(columnName) + "</td>\n";
        }
        return columns;
    }

    private String[] getClasses(Lesson[] lessons, String date)
    {
        TreeSet<String> classes = new TreeSet<String>();

        for(Lesson lesson : TableOptions.filterRows(lessons, (Lesson lesson) -> lesson.get("Datum").equals(date)))
        {
            classes.add(lesson.get("Klasse").trim());
        }
        return classes.toArray(new String[classes.size()]);
    }

    private String[] getColumnNames()
    {
        HashMap<String, Column> columns = columnSelectPanel.getColumns();

        String[] columnNames = new String[columns.values().size()];
        for(Map.Entry<String, Column> column : columns.entrySet())
        {
            columnNames[column.getValue().getPosition() - 1] = column.getKey();
        }
        return columnNames;
    }

    private String addColumnsToClassTemplate(String template)
    {
        HashMap<String, Column> columns = columnSelectPanel.getColumns();

        String[] columnTags = new String[columns.values().size()];
        for(Column column : columns.values())
        {
            columnTags[column.getPosition() - 1] = "                <th width=\""
                                                   + String.format(Locale.ENGLISH, "%.2f", column.getWidth() * 0.93)
                                                   + "%\">" + column.getName() + "</th>\n";
        }

        String allColumnTags = "";
        for(String columnTag : columnTags)
            allColumnTags += columnTag;

        return template.replace("COLUMNS", allColumnTags);
    }

    @Override
    public void motdOut(String motd)
    {
        String templateMotd = new TextFile(dataPath, "template - motd.txt").readAllToString();

        TextFile motdFile = new TextFile(dataPath, "laufschrift.html");
        motdFile.writeLines(templateMotd);

        styleOut(templateMotd.split("\n").length);
    }

    private String getValue(String name)
    {
        return null;
//        return designer.getDesign().getDesignItems().get(designer.getDesign().getDesignItems().indexOf(new DesignItem(name))).getValue();
    }

    private void styleOut(double lineCount)
    {
        String templateStyle = new TextFile(dataPath, "template - style.txt").readAllToString();
        String templateCustom = new TextFile(dataPath, "template - custom.txt").readAllToString();
//        SerializableDesign design = designer.getDesign();
//
//        int style = getValue("MOTD_FONT_STYLE").equals("bold") ? 1 : getValue("MOTD_FONT_STYLE").equals("italic") ? 2 : 0;
//        FontMetrics fontMetrics = new JFrame().getFontMetrics(new Font(getValue("MOTD_FONT_FAMILY"), style, Integer.parseInt(getValue("MOTD_FONT_SIZE"))));
//
//        templateStyle = templateStyle.replaceAll("MOTD_HEIGHT", String.valueOf(fontMetrics.getHeight()));
//
//        templateStyle = templateStyle.replaceAll("MOTD_SPEED", String.valueOf(lineCount / Double.parseDouble(getValue("MOTD_SPEED"))));
//        templateStyle = templateStyle.replaceAll("DAY_SPPED", String.valueOf(lineCount / Double.parseDouble(getValue("DAY_SPPED"))));

        String extraFormats = "";
        for(String name : customDesignPanel.getDesignItems().keySet())
        {
            extraFormats += templateCustom.replaceAll("NAME", name);
        }
        templateStyle = templateStyle.replaceAll("DAY_EXTRA_FORMATS", extraFormats);

        for(HashMap<String, CustomDesignItem> head : customDesignPanel.getDesignItems().values())
        {
            for(Map.Entry<String, CustomDesignItem> designItem : head.entrySet())
            {
                templateStyle = templateStyle.replaceAll(designItem.getKey(), designItem.getValue().getValue());
            }
        }

        for(Map.Entry<String, DesignItem> designItem : designPanel.getDesignItems().entrySet())
        {
            templateStyle = templateStyle.replaceAll(designItem.getKey(), designItem.getValue().getValue());
        }

        TextFile styleFile = new TextFile(dataPath, "style.css");
        styleFile.writeLines(templateStyle);
    }

    @Override
    public View getView()
    {
        return new SubTabView("HTML Export", columnSelectPanel, designPanel, customDesignPanel);
    }

    @Override
    public String getName()
    {
        return "HTML Export V1.0";
    }
}
