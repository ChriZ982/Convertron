package com.facharbeit.io;

import java.util.*;

/**
 * Schreibt immer in die selbe Tabelle.
 */
public class SqlTableWriter extends SqlWriter
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
     * Erstellt einen neuen Table-Writer.
     *
     * @param dbHost       Host zur Datenbank
     * @param dbPort       Port der Datenbank
     * @param dbName       Name der Datenbank
     * @param dbUser       Nutername der Datenbank
     * @param dbPassword   Passwort der Datenbank
     * @param tableName    Name der Tabelle
     * @param tableColumms Spalten, die es geben soll
     */
    public SqlTableWriter(String dbHost, int dbPort, String dbName, String dbUser, String dbPassword, String tableName, String[] tableColumms)
    {
        super(dbHost, dbPort, dbName, dbUser, dbPassword);
        this.tableColumms = tableColumms;
        this.tableName = tableName;
    }

    /**
     * Fügt mehrere Zeilen zu der Tabelle hinzu.
     *
     * @param data Inhalt der Zeilen
     */
    public void addAll(ArrayList<String[]> data)
    {
        addAll(tableName, tableColumms, data);
    }

    /**
     * Fügt eine Zeile zu der Tabelle hinzu.
     *
     * @param data Inhalt der Zeile
     */
    public void add(String[] data)
    {
        addLine(tableName, tableColumms, data);
    }

    /**
     * Fügt eine Zeile mit einer Spalte zu der Tabelle hinzu.
     *
     * @param tableColumm Name der Zelle
     * @param data        Inhalt der Zelle
     */
    public void add(String tableColumm, String data)
    {
        addCell(tableName, tableColumm, data);
    }

    public void clear()
    {
        clear(tableName);
    }
}
