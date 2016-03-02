package eu.convertron.applib;

import eu.convertron.interlib.logging.Logger;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Mirko Ruether
 */
public class LogPanel extends JPanel
{
    private static final long serialVersionUID = 233225335911707914L;

    private JTable table;
    private LogTable tableModel;

    public LogPanel()
    {
        tableModel = new LogTable();
        Logger.addLogOutput(tableModel);

        table = new JTable();
        table.setShowVerticalLines(false);
        table.setTableHeader(null);
        table.setModel(tableModel);
        table.getColumnModel().getColumn(0).setMaxWidth(50);

        LogRenderer logRenderer = new LogRenderer();
        table.getColumnModel().getColumn(0).setCellRenderer(logRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer(logRenderer);

        setLayout(new GridLayout(0, 1));
        add(table);
    }

    public void setLogDevInfos(boolean logDevInfos)
    {
        tableModel.setLogDevInfos(logDevInfos);
    }

    public void setLogInfos(boolean logInfos)
    {
        tableModel.setLogInfos(logInfos);
    }
}
