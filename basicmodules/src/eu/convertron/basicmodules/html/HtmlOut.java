package eu.convertron.basicmodules.html;

import eu.convertron.basicmodules.LocalSettings;
import eu.convertron.basicmodules.Resources;
import eu.convertron.interlib.data.Configuration;
import eu.convertron.interlib.data.GeneralConfigFile;
import eu.convertron.interlib.data.IniConfigFile;
import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.filter.FilterOption;
import eu.convertron.interlib.filter.TableOptions;
import eu.convertron.interlib.interfaces.Configurable;
import eu.convertron.interlib.interfaces.Output;
import eu.convertron.interlib.interfaces.View;
import eu.convertron.interlib.io.TextFile;
import eu.convertron.interlib.logging.LogPriority;
import eu.convertron.interlib.logging.Logger;
import eu.convertron.interlib.util.SubTabView;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeSet;
import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * Generiert die HTML-Dateien.
 */
public class HtmlOut implements Output, Configurable
{
    private ColumnSelectPanel columnSelectPanel;
    private DesignPanel designPanel;
    private CustomDesignPanel customDesignPanel;

    private Configuration config;
    private IniConfigFile settings;
    private GeneralConfigFile designXml;

    public HtmlOut()
    {
    }

    @Override
    public void setConfiguration(Configuration config)
    {
        this.config = config;
        this.settings = new IniConfigFile(config, "htmlout.cfg", Resources.file("htmlout.cfg"));
        this.designXml = new GeneralConfigFile(config, "design.xml", Resources.file("design.xml"));

        this.columnSelectPanel = new ColumnSelectPanel(designXml);
        this.designPanel = new DesignPanel(designXml);
        this.customDesignPanel = new CustomDesignPanel(designXml);
    }

    //TEMP
    @Override
    public void out(Lesson[] lessons)
    {
        String[] targets = LocalSettings.targets.loadArray();
        TableOptions t = TableOptions.getInstance();

        //TODO remove date parameter in export method
        export(t.today(lessons), t.getToday(), appendToContent(targets, "/heute.html"));
        export(t.nextDayWithLessons(lessons), t.getNextDay(lessons), appendToContent(targets, "/morgen.html"));
        styleOut(appendToContent(targets, "/style.css"));
        resourcesOut(targets);
    }

    private String[] appendToContent(String[] source, String toAppend)
    {
        String[] result = Arrays.copyOf(source, source.length);
        for(int i = 0; i < result.length; i++)
        {
            result[i] += toAppend;
        }
        return result;
    }

    private void export(Lesson[] lessons, String date, String... files)
    {
        String templateLesson = new GeneralConfigFile(config, "template - lesson.txt", Resources.file("templates/lesson.txt")).loadString();
        String templateClass = new GeneralConfigFile(config, "template - class.txt", Resources.file("templates/class.txt")).loadString();
        String templateDay = new GeneralConfigFile(config, "template - day.txt", Resources.file("templates/day.txt")).loadString();

        String evenChar = TableOptions.getInstance().getEvenWeekChar();

        templateDay = templateDay.replace("DAY_SPEED", designPanel.getValue("DAY_SPEED"));

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

        for(String fileName : files)
        {
            TextFile file = new TextFile(fileName);
            file.writeLines(templateDay);
        }
    }

    private String getClassString(String templateClass, String className, String[] columnNames, String templateLesson, Lesson[] lessons, String date)
    {
        String customClass = templateClass.replace("CLASSNAME", className);
        Lesson[] classLessons = TableOptions.getInstance().filterRows(lessons,
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

        for(Lesson lesson : TableOptions.getInstance().filterRows(lessons, (Lesson lesson) -> lesson.get("Datum").equals(date)))
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
        String[] targets = LocalSettings.targets.loadArray();

        exportMotd(motd, appendToContent(targets, "/laufschrift.html"));
        styleOut(appendToContent(targets, "/style.css"));
        resourcesOut(targets);
    }

    private void exportMotd(String motd, String... files)
    {
        String templateMotd = new GeneralConfigFile(config, "template - motd.txt", Resources.file("templates/motd.txt")).loadString();
        templateMotd = templateMotd.replaceAll("MOTDTEXT", motd);
        templateMotd = templateMotd.replaceAll("MOTD_SPEED", designPanel.getValue("MOTD_SPEED"));

        for(String fileName : files)
        {
            //using Textfile makes crazy mistakes
            try
            {
                Files.write(new File(fileName).toPath(), templateMotd.getBytes(UTF_8));
            }
            catch(Exception ex)
            {
                Logger.logError(LogPriority.WARNING, "Konnte die Datei nicht schreiben", ex);
            }
        }
    }

    private void styleOut(String... files)
    {
        String templateStyle = new GeneralConfigFile(config, "template - style.txt", Resources.file("templates/style.txt")).loadString();
        String templateCustom = new GeneralConfigFile(config, "template - custom.txt", Resources.file("templates/custom.txt")).loadString();

        ArrayList<CustomDesignItem> customDesignItems = customDesignPanel.getAllCustomDesignItems();
        String extraFormats = "";
        for(CustomDesignItem item : customDesignItems)
        {
            extraFormats += templateCustom
                    .replaceAll("NAME", item.getId())
                    .replaceAll("CUSTOMFORMATCSS", item.getFormat().toCss());
        }
        templateStyle = templateStyle.replaceAll("DAY_EXTRA_FORMATS", extraFormats);

        for(DesignItem designItem : designPanel.getAllDesignItems())
        {
            templateStyle = templateStyle.replaceAll(designItem.getId(), designItem.getValue());
        }

        for(String fileName : files)
        {
            TextFile styleFile = new TextFile(fileName);
            styleFile.writeLines(templateStyle);
        }
    }

    private void resourcesOut(String... folders)
    {
        String[] resources = settings.loadArray("htmlResources");
        for(String res : resources)
        {
            GeneralConfigFile cfg = new GeneralConfigFile(config, res);
            if(Resources.get("htmlRes/" + res) != null)
                cfg.loadDefaultsFromResource(Resources.file("htmlRes/" + res));
            byte[] value = cfg.load();

            for(String f : folders)
            {
                writeFile(f, res, value);
            }
        }
    }

    private void writeFile(String folder, String name, byte[] value)
    {
        try
        {
            Path p = new File(folder, name).toPath();
            Files.deleteIfExists(p);
            Files.write(p, value, StandardOpenOption.CREATE_NEW);
        }
        catch(IOException ex)
        {
            Logger.logError(LogPriority.WARNING, "Konnte eine Html Resource nicht kopieren (" + name + " nach " + folder + ")", ex);
        }
    }

    @Override
    public View getView()
    {
        if(columnSelectPanel == null || designPanel == null || customDesignPanel == null)
        {
            Logger.logMessage(LogPriority.ERROR, "Das HtmlOut Modul wurde noch nicht richtig initialisiert");
            return null;
        }
        return new SubTabView("HTML Export", new HtmlOutSettingsView(), columnSelectPanel, designPanel, customDesignPanel);
    }

    @Override
    public String getName()
    {
        return "HTML Export V1.0";
    }
}
