package com.facharbeit.io;

import com.facharbeit.tools.*;
import java.sql.*;
import java.util.*;

/**
 * Schreibt in eine Datenbank.
 */
public class SqlWriter
{
    /**
     * Verbindung zur Datenbank.
     */
    protected Connection con = null;

    /**
     * Name der Datenbank.
     */
    protected String dbName;

    /**
     * Erstellt einen neuen Writer. Mit Verbindung zu einer Datenbank.
     *
     * @param dbHost     Host zur Datenbank
     * @param dbPort     Port der Datenbank
     * @param dbName     Name der Datenbank
     * @param dbUser     Nutername der Datenbank
     * @param dbPassword Passwort der Datenbank
     */
    public SqlWriter(String dbHost, int dbPort, String dbName, String dbUser, String dbPassword)
    {
        this.dbName = dbName;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?user=" + dbUser + "&password=" + dbPassword);
        } catch(ClassNotFoundException | SQLException ex)
        {
            Logger.log("Verbindung zur Datenbank konnte nicht hergestellt werden.", 2);
        }
    }

    /**
     * Fügt Zeilen zu einer Tabelle hinzu.
     *
     * @param tableName    Name der Tabelle
     * @param tableColumms Spalten, die es in den Zeilen geben soll
     * @param data         Inhalt, der geschrieben werden soll
     */
    public void addAll(String tableName, String[] tableColumms, ArrayList<String[]> data)
    {
        if(con != null)
            for(String[] lineData : data)
                try
                {
                    Statement query = con.createStatement();
                    String command = "INSERT INTO `" + dbName + "`.`" + tableName + "` (";

                    for(int i = 0; i < tableColumms.length; i++)
                    {
                        if(i > 0)
                            command += ", ";
                        command += "`" + tableColumms[i] + "`";
                    }

                    command += ") VALUES (";

                    for(int i = 0; i < lineData.length; i++)
                    {
                        if(i > 0)
                            command += ", ";
                        command += "`" + tableColumms[i] + "`";
                    }

                    command += ");";

                    query.executeQuery(command);
                } catch(SQLException ex)
                {
                    Logger.log("SQL-Befehl konnte nicht ausgeführt werden..", 1);
                }
    }

    /**
     * Fügt nur eine Zeile zur Tabelle hinzu.
     *
     * @param tableName    Name der Tabelle
     * @param tableColumms Spalten, die es in der Zeile geben soll
     * @param data         Inhalt, der geschrieben werden soll
     */
    public void addLine(String tableName, String[] tableColumms, String[] data)
    {
        ArrayList<String[]> dataList = new ArrayList<String[]>();
        dataList.set(0, data);
        addAll(tableName, tableColumms, dataList);
    }

    /**
     * Fügt nur eine Zeile mit einer Zelle hinzu.
     *
     * @param tableName   Name der Tabelle
     * @param tableColumm Spalte, die es in der Zeile geben soll
     * @param data        Inhalt, der geschrieben werden soll
     */
    public void addCell(String tableName, String tableColumm, String data)
    {
        String[] tableColumms =
        {
            tableColumm
        };
        String[] dataArray =
        {
            data
        };
        addLine(tableName, tableColumms, dataArray);
    }
}
