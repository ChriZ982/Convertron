package eu.convertron.server;

import eu.convertron.applib.etc.CsvLessonSerializer;
import eu.convertron.interlib.data.Lesson;
import eu.convertron.interlib.data.LessonValidator;
import eu.convertron.interlib.filter.TableOptions;
import javax.jws.WebMethod;
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
}
