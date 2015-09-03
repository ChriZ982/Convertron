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

    public static final Runnable IMPORTLESSONS = new Runnable()
    {
        @Override
        public void run()
        {
            Control.importLessons();
        }
    };

    public static final Runnable EXPORTLESSONSANDMOTD = new Runnable()
    {
        @Override
        public void run()
        {
            Control.exportLessons();
            Control.exportMotd();
        }
    };

    public static final Runnable IMPORTMOTD = new Runnable()
    {
        @Override
        public void run()
        {
            Control.importMotd();
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
