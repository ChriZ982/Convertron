
import com.facharbeit.tools.PathConverter;
import java.util.Calendar;

public class Test
{
    public static void main(String[] args)
    {
        System.out.println(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
        System.out.println(Calendar.getInstance().get(Calendar.MONTH));
        System.out.println(Calendar.getInstance().get(Calendar.YEAR));
        System.out.println(PathConverter.convert("<dd>.<mm>.<yy>", "30.8"));
    }
}
