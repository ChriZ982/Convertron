package eu.convertron.server;

import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.filter.TableOptions;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class ConvertronWS
{
    private Control control;

    public ConvertronWS(Control control)
    {
        this.control = control;
    }

    @WebMethod
    public Lesson[] getAllLessonsForDate(@WebParam Date date)
    {
        Lesson[] lessons = control.getData();
        return TableOptions.onlyDate(lessons, new SimpleDateFormat("dd.mm.").format(date));
    }

    @WebMethod
    public void setConfiguration(String moduleName, String configurationName, byte[] value)
    {

    }
}
