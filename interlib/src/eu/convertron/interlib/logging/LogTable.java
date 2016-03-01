package eu.convertron.interlib.logging;

import eu.convertron.interlib.logging.messages.LogMessage;
import eu.convertron.interlib.logging.messages.LogPriority;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/** Verwaltet die Tabelle mit der Fehler und Nachrichten in der Anwendung ausgegeben werden. */
public class LogTable
{
    /** Das Datenmodell, mit dem die Tabelle gefüllt wird. */
    private static final DefaultTableModel logModel = new DefaultTableModel(0, 2)
    {
        private static final long serialVersionUID = 1L;

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex)
        {
            return false;
        }
    };

    /** Enthält temporär ausgeblendete unwichtige Nachrichten */
    private static final ArrayList<LogMessage> hiddenLogMessages = new ArrayList<LogMessage>();

    /** Sollen weniger wichtige Nachrichten und Fehler eingeblendet werden? */
    private static boolean logInfos = false;
    /** Sollen weitere kurze Informationen zu Fehlern eingeblendet werden? */
    private static boolean logDevInfos = false;

    /**
     * Fügt Nachrichten an die Tabelle oder versteckt sie direkt falls eigestellt.
     * @param logMessage Nachricht zum Anhängen
     */
    public static void addLogMessage(LogMessage logMessage)
    {
        logMessage.setLogDevInfos(logDevInfos);
        if(logMessage.getPriority() == LogPriority.INFO && !logInfos)
            hiddenLogMessages.add(logMessage);
        else
            addRow(logMessage);
    }

    /**
     * Zeigt oder Versteckt weniger wichtige Nachrichten und Fehler.
     * @param logInfos Anzeigen oder Verstecken?
     */
    public static void setLogInfos(boolean logInfos)
    {
        LogTable.logInfos = logInfos;
        if(logInfos)
        {
            EventQueue.invokeLater(() ->
            {
                showInformation();
            });
        }
        else
        {
            EventQueue.invokeLater(() ->
            {
                hideInformation();
            });
        }
    }

    /** Zeigt weniger wichtige Nachrichten und Fehler. */
    private static void showInformation()
    {
        for(LogMessage logMessage : hiddenLogMessages)
        {
            if(logModel.getRowCount() == 0)
            {
                addRow(logMessage);
                continue;
            }

            for(int i = 0; i < logModel.getRowCount(); i++)
            {
                LogMessage logMessage2 = (LogMessage)logModel.getValueAt(i, 0);
                if(logMessage2.getTime().after(logMessage.getTime()))
                {
                    insertRow(logMessage, i);
                    break;
                }
                else if(i + 1 == logModel.getRowCount())
                {
                    addRow(logMessage);
                    break;
                }
            }
        }
        hiddenLogMessages.clear();
    }

    /** Versteckt weniger wichtige Nachrichten und Fehler. */
    private static void hideInformation()
    {
        for(int i = 0; i < logModel.getRowCount(); i++)
        {
            LogMessage logMessage = (LogMessage)logModel.getValueAt(i, 0);
            while(logMessage.getPriority() == LogPriority.INFO && !logInfos)
            {
                hiddenLogMessages.add(logMessage);
                logModel.removeRow(i);
                logMessage = (LogMessage)logModel.getValueAt(i, 0);
            }
        }
    }

    /**
     * Zeigt oder Versteckt weitere kurze Informationen zu Fehlern.
     * @param logDevInfos Anzeigen oder Verstecken?
     */
    public static void setLogDevInfos(boolean logDevInfos)
    {
        LogTable.logDevInfos = logDevInfos;
        EventQueue.invokeLater(() ->
        {
            showOrHideDeveloperInformation();
        });
    }

    /** Zeigt oder Versteckt weitere kurze Informationen zu Fehlern. */
    private static void showOrHideDeveloperInformation()
    {
        for(LogMessage logMessage : hiddenLogMessages)
            logMessage.setLogDevInfos(logDevInfos);
        for(int i = 0; i < logModel.getRowCount(); i++)
            ((LogMessage)logModel.getValueAt(i, 0)).setLogDevInfos(logDevInfos);
        logModel.fireTableDataChanged();
    }

    /**
     * Fügt eine Nachricht oder einen Fehler an die Tabelle an.
     * @param logMessage Nachricht oder Fehler
     */
    private static void addRow(LogMessage logMessage)
    {
        logModel.addRow(
                new Object[]
                {
                    logMessage, logMessage
                });
    }

    /**
     * Fügt eine Nachricht oder einen Fehler in die Tabelle ein.
     * @param logMessage Nachricht oder Fehler
     * @param i          Stelle zum Einfügen
     */
    private static void insertRow(LogMessage logMessage, int i)
    {
        logModel.insertRow(i,
                           new Object[]
                           {
                               logMessage, logMessage
                           });
    }

    /**
     * Gets the model.
     * @return TableModel
     */
    public static DefaultTableModel getLogModel()
    {
        return logModel;
    }
}
