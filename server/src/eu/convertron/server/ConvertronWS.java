package eu.convertron.server;

import eu.convertron.interlib.data.Lesson;
import java.util.Date;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Mirko Ruether
 */
@WebService
public class ConvertronWS
{
    @WebMethod
    public Lesson[] getAllLessonsForDate(@WebParam Date date)
    {
        throw new UnsupportedOperationException();
    }
}
