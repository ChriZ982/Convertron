package eu.convertron.basicmodules.html.serialization;

public class IllegalMarkupException extends RuntimeException
{
    private static final long serialVersionUID = 1684135168L;

    public IllegalMarkupException()
    {
    }

    public IllegalMarkupException(String message)
    {
        super(message);
    }

    public IllegalMarkupException(Throwable cause)
    {
        super(cause);
    }

    public IllegalMarkupException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
