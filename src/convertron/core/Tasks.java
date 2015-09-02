package convertron.core;

public final class Tasks
{
    public static final Runnable GENALL = new Runnable()
    {
        @Override
        public void run()
        {
            Control.genAll();
        }
    };

    public static final Runnable GENLESSONS = new Runnable()
    {
        @Override
        public void run()
        {
            Control.genLessons();
        }
    };

    public static final Runnable BACKUP = new Runnable()
    {

        @Override
        public void run()
        {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    };
}
