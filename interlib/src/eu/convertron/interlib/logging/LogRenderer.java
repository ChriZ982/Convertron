package eu.convertron.interlib.logging;

import eu.convertron.interlib.logging.messages.LogMessage;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/** Visualisiert die Nachrichten in der Tabelle in der Anwendung. */
@SuppressWarnings("serial")
public class LogRenderer extends JTextArea implements TableCellRenderer
{
    /** Enthält die Höhen der Zellen um Zeilenumbrüche anzuzeigen. */
    private final List<List<Integer>> rowColHeight;

    /** Konstruktor */
    public LogRenderer()
    {
        rowColHeight = new ArrayList<List<Integer>>();

        setFont(new Font("Tahoma", Font.PLAIN, 11));
        setWrapStyleWord(true);
        setLineWrap(true);
    }

    /**
     * Wird automatisch aufgerufen und Visualisiert die Nachrichten.
     * @param table      Tabelle, auf der die Operationen stattfinden
     * @param value      Wert der aktuellen Zelle
     * @param isSelected Ist die Zelle ausgewählt?
     * @param hasFocus   Ist die zelle fokussiert
     * @param row        Zeilennumer der Zelle
     * @param column     Spaltennummer der Zelle
     * @return Der Renderer selbst
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        LogMessage logMessage = (LogMessage)value;

        setForeground(logMessage.getPriority().getColor());

        if(column == 0)
            setText(logMessage.getTimeString());
        else
            setText(logMessage.getMessage());

        adjustRowHeight(table, row, column);

        return this;
    }

    /**
     * Führt Berechnungen durch um die Zeilenhöhe bei mehrzeiligen Texten zu bestimmen.
     * @param table  Tabelle, auf der die Operationen stattfinden
     * @param row    Zeilennumer der Zelle
     * @param column Spaltennummer der Zelle
     */
    private void adjustRowHeight(JTable table, int row, int column)
    {
        int colWidth = table.getColumnModel().getColumn(column).getWidth();
        setSize(new Dimension(colWidth, 1000));
        int prefH = getPreferredSize().height;

        while(rowColHeight.size() <= row)
            rowColHeight.add(new ArrayList<Integer>(column));
        List<Integer> colHeights = rowColHeight.get(row);

        while(colHeights.size() <= column)
            colHeights.add(0);
        colHeights.set(column, prefH);

        int maxH = prefH;
        for(Integer colHeight : colHeights)
        {
            if(colHeight > maxH)
                maxH = colHeight;
        }

        if(table.getRowHeight(row) != maxH)
            table.setRowHeight(row, maxH);
    }
}
