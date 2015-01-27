package com.facharbeit.io;

import java.sql.*;
import java.util.*;

/**
 * Klasse zum lesen aus einer Datenbank.
 */
public class SqlReader
{
    /**
     * Verbindung zur Datenbank.
     */
    protected Connection con = null;

    /**
     * Erstellt einen neuen Reader. Mit Verbindung zu einer Datenbank.
     *
     * @param dbHost     Host zur Datenbank
     * @param dbPort     Port der Datenbank
     * @param dbName     Name der Datenbank
     * @param dbUser     Nutername der Datenbank
     * @param dbPassword Passwort der Datenbank
     *
     * @throws java.lang.Exception Fehler
     */
    public SqlReader(String dbHost, int dbPort, String dbName, String dbUser, String dbPassword) throws Exception
    {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://" + dbHost;
        if(dbPort != -1)
            url += ":" + dbPort;
        url += "/" + dbName;
        con = DriverManager.getConnection(url, dbUser, dbPassword);
    }

    /**
     * Liest alle Zeilen aus einer Datenbank.
     *
     * @param tableName    Name der Tabelle, die ausgelesen werden soll
     * @param tableColumms Spalten, die ausgelesen werden solen
     *
     * @return Alle Zeilen der Tabelle
     *
     * @throws java.lang.Exception Fehler
     */
    public ArrayList<String[]> readAll(String tableName, String... tableColumms) throws Exception
    {
        ArrayList<String[]> data = null;
        if(con != null)
        {
            data = new ArrayList<String[]>();
            Statement query = con.createStatement();
            String command = "SELECT ";

            for(int i = 0; i < tableColumms.length; i++)
            {
                if(i > 0)
                    command += ", ";
                command += "`" + tableColumms[i] + "`";
            }

            command += "FROM `" + tableName + "`";

            ResultSet result = query.executeQuery(command);

            while(result.next())
            {
                String[] lineData = new String[tableColumms.length];
                for(int i = 0; i < tableColumms.length; i++)
                    lineData[i] = result.getString(tableColumms[i]);

                data.add(lineData);
            }
        }
        return data;
    }

    /**
     * Liest eine Zeile aus einer Datenbank.
     *
     * @param line         Nummer der Zeile, die gelesen werden soll
     * @param tableName    Name der Tabelle, die ausgelesen werden soll
     * @param tableColumms Spalten, die ausgelesen werden sollen
     *
     * @return Inhalt der Zeile
     *
     * @throws java.lang.Exception Fehler
     */
    public String[] readLine(int line, String tableName, String... tableColumms) throws Exception
    {
        return readAll(tableName, tableColumms).get(line);
    }

    /**
     * Liest eine Zelle aus einer Datenbank.
     *
     * @param tableName   Name der Tabelle, die gelesen werden soll
     * @param tableColumm Spalte, die gelesen werden soll
     * @param line        Zeile, aus der gelesen werden soll
     *
     * @return Inhalt der Zelle
     *
     * @throws java.lang.Exception Fehler
     */
    public String readCell(int line, String tableName, String tableColumm) throws Exception
    {
        String[] columm =
        {
            tableColumm
        };
        return readAll(tableName, columm).get(line)[0];
    }
}
