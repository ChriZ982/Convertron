package eu.convertron.interlib.data;

public class InvalidConfigurationException extends Exception
{
    public InvalidConfigurationException()
    {
        super("Invalid Configuration");
    }

    public InvalidConfigurationException(String message)
    {
        super(message);
    }

    public InvalidConfigurationException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public InvalidConfigurationException(Throwable cause)
    {
        super(cause);
    }
}
