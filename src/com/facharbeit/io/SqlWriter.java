package com.facharbeit.io;

import com.facharbeit.tools.*;
import java.sql.*;
import java.util.*;

/**
 * Klasse zum schreiben in eine Datenbank.
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
     *
     * @throws java.lang.Exception Fehler
     */
    public SqlWriter(String dbHost, int dbPort, String dbName, String dbUser, String dbPassword) throws Exception
    {
        this.dbName = dbName;
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + dbHost;
        if(dbPort != -1)
            url += ":" + dbPort;
        url += "/" + dbName;
        con = DriverManager.getConnection(url, dbUser, dbPassword);
    }

    /**
     * Fügt Zeilen zu einer Tabelle hinzu.
     *
     * @param tableName    Name der Tabelle
     * @param tableColumms Spalten, die es in den Zeilen geben soll
     * @param data         Inhalt, der geschrieben werden soll
     *
     * @throws java.lang.Exception Fehler
     */
    public void addAll(String tableName, String[] tableColumms, ArrayList<String[]> data) throws Exception
    {
        if(con != null)
            for(String[] lineData : data)
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
                    command += "'" + lineData[i] + "'";
                }

                command += ");";

                Logger.log(command, 0);

                query.execute(command);
            }
    }

    /**
     * Fügt nur eine Zeile zur Tabelle hinzu.
     *
     * @param tableName    Name der Tabelle
     * @param tableColumms Spalten, die es in der Zeile geben soll
     * @param data         Inhalt, der geschrieben werden soll
     *
     * @throws java.lang.Exception Fehler
     */
    public void addLine(String tableName, String[] tableColumms, String[] data) throws Exception
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
     *
     * @throws java.lang.Exception Fehler
     */
    public void addCell(String tableName, String tableColumm, String data) throws Exception
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

    /**
     * Leert eine komplette Tabelle.
     *
     * @param tableName Name der zu leerende Tabelle
     *
     * @throws java.lang.Exception Fehler
     */
    public void clear(String tableName) throws Exception
    {
        Statement query = con.createStatement();
        query.execute("TRUNCATE TABLE `" + dbName + "`.`" + tableName + "`");
    }
}
