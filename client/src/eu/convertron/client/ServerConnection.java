package eu.convertron.client;

import eu.convertron.applib.etc.CsvLessonSerializer;
import eu.convertron.applib.storage.Storage;
import eu.convertron.interlib.data.Lesson;
import java.net.MalformedURLException;
import java.net.URL;

public class ServerConnection implements Storage
{
    private ConvertronWS service;

    public ServerConnection(String ip, int port) throws MalformedURLException
    {
        this(new URL("http://" + ip + ":" + port + "/_convertron?WSDL"));
    }

    public ServerConnection(URL wsdl)
    {
        ConvertronWSService s = new ConvertronWSService(wsdl);
        service = s.getConvertronWSPort();
    }

    @Override
    public Lesson[] load()
    {
        String serialization = service.getData();
        return new CsvLessonSerializer().deserializeMultiple(serialization);
    }

    @Override
    public void save(Lesson[] lessons)
    {
        String serialization = new CsvLessonSerializer().serializeMultiple(lessons);
        service.setData(serialization);
    }
}
