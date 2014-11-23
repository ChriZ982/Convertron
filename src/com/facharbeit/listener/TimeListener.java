/*package com.facharbeit.listener;

import com.facharbeit.main.Application;
import java.util.Calendar;

public class TimeListener extends Thread
{
    private Application app;

    private final int ONE = 520;
    private final int TWO = 565;
    private final int THREE = 630;
    private final int FOUR = 675;
    private final int FIVE = 735;
    private final int SIX = 785;
    private final int SEVEN = 885;
    private final int EIGHT = 930;
    private final int NINE = 980;
    private final int TEN = 1025;

    public TimeListener(Application pApp)
    {
        app = pApp;
        this.start();
    }

    @Override
    public void run()
    {
        while(true)
        {
            checkTime();

            try
            {
                Thread.sleep(60000);
            } catch(InterruptedException ex)
            {
                System.out.println(ex);
            }
        }
    }

    private void checkTime()
    {
        Calendar calendar = Calendar.getInstance();
        long time = calendar.get(Calendar.HOUR_OF_DAY) * 60 + calendar.get(Calendar.MINUTE);

        if(time > TEN)
            app.lessonTen(time);
        else if(time > NINE)
            app.lessonNine(time);
        else if(time > EIGHT)
            app.lessonEight(time);
        else if(time > SEVEN)
            app.lessonSeven(time);
        else if(time > SIX)
            app.lessonSix(time);
        else if(time > FIVE)
            app.lessonFive(time);
        else if(time > FOUR)
            app.lessonFour(time);
        else if(time > THREE)
            app.lessonThree(time);
        else if(time > TWO)
            app.lessonTwo(time);
        else if(time > ONE)
            app.lessonOne(time);
    }
}
*/