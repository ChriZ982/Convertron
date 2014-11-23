package com.facharbeit.sql;

import java.util.ArrayList;

/**
 * Liest immer aus der selben SQL-Tabelle.
 */
public class sqlTableReader extends sqlReader
{
    /**
     * Name der Tabelle.
     */
    protected String tableName;

    /**
     * Spalten, die es geben soll.
     */
    protected String[] tableColumms;

    /**
     * Erstellt einen Table-Reader.
     * @param dbHost       Host zur Datenbank
     * @param dbPort       Port der Datenbank
     * @param dbName       Name der Datenbank
     * @param dbUser       Nutername der Datenbank
     * @param dbPassword   Passwort der Datenbank
     * @param tableName    Name der Tabelle
     * @param tableColumms Spalten, die es geben soll
     */
    public sqlTableReader(String dbHost, int dbPort, String dbName, String dbUser, String dbPassword, String tableName, String[] tableColumms)
    {
        super(dbHost, dbPort, dbName, dbUser, dbPassword);
        this.tableColumms = tableColumms;
        this.tableName = tableName;
    }

    /**
     * Liest eine ganze Tabelle.
     * @return Inhalt der Tabelle
     */
    public ArrayList<String[]> readAll()
    {
        try
        {
            return readAll(this.tableName, this.tableColumms);
        } catch(NullPointerException ex)
        {
            System.out.println("SQL-Datenbank konnte nicht ausgelesen werden");
            return null;
        }
    }

    /**
     * Liest eine Zeile einer Tabelle.
     * @param line Zeile, die gelesen werden soll
     * @return Inhalt der Zeile
     */
    public String[] read(int line)
    {
        return readAll().get(line);
    }

    /**
     * Liest eine Spalte aus einer Zeile einer Tabelle.
     * @param tableColumm Spalte, die gelesen werden soll
     * @param line        Zeile, die gelesen werden soll
     * @return Inhalt der Zelle
     */
    public String read(String tableColumm, int line)
    {
        String[] columm =
        {
            tableColumm
        };
        return readAll(this.tableName, columm).get(line)[0];
    }
}
