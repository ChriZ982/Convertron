package com.facharbeit.io;

import com.facharbeit.tools.*;
import java.sql.*;
import java.util.*;

/**
 * Liest Daten aus einer SQL-Datenbank.
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
     */
    public SqlReader(String dbHost, int dbPort, String dbName, String dbUser, String dbPassword)
    {
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
     * Liest alle Zeilen aus einer Datenbank.
     *
     * @param tableName    Name der Tabelle, die gelesen werden soll
     * @param tableColumms Array der Spalten, die gelesen werden solen
     *
     * @return Alle Zeilen der Tabelle
     */
    public ArrayList<String[]> readAll(String tableName, String[] tableColumms)
    {
        ArrayList<String[]> data = null;
        if(con != null)
        {
            data = new ArrayList<String[]>();

            try
            {
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

            } catch(SQLException ex)
            {
                Logger.log("SQL-Befehl konnte nicht ausgeführt werden..", 1);
            }
        }
        return data;
    }

    /**
     * Liest eine Zeile aus einer Datenbank.
     *
     * @param tableName    Name der Tabelle, die gelesen werden soll
     * @param tableColumms Spalten, die gelesen werden sollen
     * @param line         Nummer der Zeile, die gelesen werden soll
     *
     * @return Inhalt der Zeile
     */
    public String[] readLine(String tableName, String[] tableColumms, int line)
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
     */
    public String readCell(String tableName, String tableColumm, int line)
    {
        String[] columm =
        {
            tableColumm
        };
        return readAll(tableName, columm).get(line)[0];
    }
}
