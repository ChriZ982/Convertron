package eu.convertron.server;

import eu.convertron.applib.etc.ChangeSet;
import eu.convertron.applib.etc.CsvLessonSerializer;
import eu.convertron.interlib.data.Configuration;
import eu.convertron.interlib.data.ConfigurationListener;
import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.data.LessonValidator;
import eu.convertron.interlib.filter.TableOptions;
import java.util.HashMap;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ConvertronWS
{
    private Control control;
    private HashMap<byte[], ChangeSet> changes;

    public ConvertronWS(Control control)
    {
        this.control = control;
        this.changes = new HashMap<>();
    }

    @WebMethod
    public String getAllLessonsForDate(String date)
    {
        LessonValidator.validateDateString(date);
        Lesson[] lessons = TableOptions.getInstance().onlyDate(control.getData(), date);
        return new CsvLessonSerializer().serializeMultiple(lessons);
    }

    @WebMethod
    public String getData()
    {
        Lesson[] lessons = control.getData();
        return new CsvLessonSerializer().serializeMultiple(lessons);
    }

    @WebMethod
    public void setData(String lessonSerialization)
    {
        Lesson[] lessons = new CsvLessonSerializer().deserializeMultiple(lessonSerialization);
        control.setData(lessons);
    }

    @WebMethod
    public void subscribeToConfigChanges(String moduleName, byte[] clientId)
    {
        Configuration config = control.getOrCreateConfiguration(moduleName);
        ChangeSet c = new ChangeSet();
        config.addConfigListener(new ConfigurationListener()
        {
            @Override
            public void configurationChanged(HashMap<String, byte[]> changed, boolean complete)
            {
                for(String configPart : changed.keySet())
                    c.configChanged(moduleName, configPart);
            }

            @Override
            public void newConfigurationAdded(String name)
            {
                c.configAdded(moduleName, name);
            }
        });
        changes.put(clientId, c);
    }

    @WebMethod
    public byte[] getChanges(byte[] clientId)
    {
        if(!changes.containsKey(clientId))
            return null;

        ChangeSet c = changes.get(clientId);

        if(c == null || c.isEmpty())
            return null;

        byte[] result = c.serialize();
        c.clear();
        return result;
    }

    @WebMethod
    public void setConfigFile(String moduleName, String configName, byte[] value)
    {
        Configuration config = control.getOrCreateConfiguration(moduleName);
        config.setConfig(configName, value);
    }

    @WebMethod
    public byte[] getConfigFile(String moduleName, String configName)
    {
        Configuration config = control.getOrCreateConfiguration(moduleName);
        return config.getConfig(configName);
    }

    @WebMethod
    public boolean removeConfigFile(String moduleName, String configName)
    {
        Configuration config = control.getOrCreateConfiguration(moduleName);
        return config.removeConfig(configName);
    }

    @WebMethod
    public String[] getAvailableConfigs(String moduleName)
    {
        Configuration config = control.getOrCreateConfiguration(moduleName);
        return config.getConfigFiles();
    }
}
