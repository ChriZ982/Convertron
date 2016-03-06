package eu.convertron.server.faults;

public class NoSuchModule extends Exception
{
    private static final long serialVersionUID = 4301043560489104273L;

    public NoSuchModule(String name)
    {
        super("No such module: " + name);
    }
}
