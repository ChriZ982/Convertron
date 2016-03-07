package eu.convertron.applib.gui;

import eu.convertron.interlib.logging.LogMessage;
import eu.convertron.interlib.logging.LogOutput;
import eu.convertron.interlib.logging.LogPriority;
import java.awt.EventQueue;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/** Verwaltet die Tabelle mit der Fehler und Nachrichten in der Anwendung ausgegeben werden. */
public class LogTable extends DefaultTableModel implements LogOutput
{
    private static final long serialVersionUID = 135453575L;

    public LogTable()
    {
        super(0, 2);
    }

    /** Enthält temporär ausgeblendete unwichtige Nachrichten */
    private final ArrayList<LogMessage> hiddenLogMessages = new ArrayList<>();

    /** Sollen weniger wichtige Nachrichten und Fehler eingeblendet werden? */
    private boolean logInfos = false;
    /** Sollen weitere kurze Informationen zu Fehlern eingeblendet werden? */
    private boolean logDevInfos = false;

    /**
     * Fügt Nachrichten an die Tabelle oder versteckt sie direkt falls eigestellt.
     * @param logMessage Nachricht zum Anhängen
     */
    @Override
    public void addLogMessage(LogMessage logMessage)
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
    public void setLogInfos(boolean logInfos)
    {
        this.logInfos = logInfos;
        if(logInfos)
        {
            EventQueue.invokeLater(()
                    ->
                    {
                        showInformation();
            });
        }
        else
        {
            EventQueue.invokeLater(()
                    ->
                    {
                        hideInformation();
            });
        }
    }

    /** Zeigt weniger wichtige Nachrichten und Fehler. */
    private void showInformation()
    {
        for(LogMessage logMessage : hiddenLogMessages)
        {
            if(this.getRowCount() == 0)
            {
                addRow(logMessage);
                continue;
            }

            for(int i = 0; i < this.getRowCount(); i++)
            {
                LogMessage logMessage2 = (LogMessage)this.getValueAt(i, 0);
                if(logMessage2.getTime().after(logMessage.getTime()))
                {
                    insertRow(logMessage, i);
                    break;
                }
                else if(i + 1 == this.getRowCount())
                {
                    addRow(logMessage);
                    break;
                }
            }
        }
        hiddenLogMessages.clear();
    }

    /** Versteckt weniger wichtige Nachrichten und Fehler. */
    private void hideInformation()
    {
        for(int i = 0; i < this.getRowCount(); i++)
        {
            LogMessage logMessage = (LogMessage)this.getValueAt(i, 0);
            while(logMessage.getPriority() == LogPriority.INFO && !logInfos)
            {
                hiddenLogMessages.add(logMessage);
                this.removeRow(i);
                logMessage = (LogMessage)this.getValueAt(i, 0);
            }
        }
    }

    /**
     * Zeigt oder Versteckt weitere kurze Informationen zu Fehlern.
     * @param logDevInfos Anzeigen oder Verstecken?
     */
    public void setLogDevInfos(boolean logDevInfos)
    {
        this.logDevInfos = logDevInfos;
        EventQueue.invokeLater(()
                ->
                {
                    showOrHideDeveloperInformation();
        });
    }

    /** Zeigt oder Versteckt weitere kurze Informationen zu Fehlern. */
    private void showOrHideDeveloperInformation()
    {
        for(LogMessage logMessage : hiddenLogMessages)
            logMessage.setLogDevInfos(logDevInfos);
        for(int i = 0; i < this.getRowCount(); i++)
            ((LogMessage)this.getValueAt(i, 0)).setLogDevInfos(logDevInfos);
        this.fireTableDataChanged();
    }

    /**
     * Fügt eine Nachricht oder einen Fehler an die Tabelle an.
     * @param logMessage Nachricht oder Fehler
     */
    private void addRow(LogMessage logMessage)
    {
        this.addRow(
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
    private void insertRow(LogMessage logMessage, int i)
    {
        this.insertRow(i,
                       new Object[]
                       {
                           logMessage, logMessage
                       });
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
}
