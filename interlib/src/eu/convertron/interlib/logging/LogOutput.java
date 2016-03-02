package eu.convertron.interlib.logging;

import eu.convertron.interlib.logging.messages.LogMessage;

/**
 * The interface to define LogOutputs.
 */
public interface LogOutput
{
    public void addLogMessage(LogMessage message);
}
