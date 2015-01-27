package com.facharbeit.io;

import java.util.*;

/**
 * Klasse zum schreiben in eine bestimmte Tabelle in einer Datenabank.
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
     *
     * @throws java.lang.Exception Fehler
     */
    public SqlTableWriter(String dbHost, int dbPort, String dbName, String dbUser, String dbPassword, String tableName, String[] tableColumms) throws Exception
    {
        super(dbHost, dbPort, dbName, dbUser, dbPassword);
        this.tableColumms = tableColumms;
        this.tableName = tableName;
    }

    /**
     * Fügt mehrere Zeilen zu der Tabelle hinzu.
     *
     * @param data Inhalt der Zeilen
     *
     * @throws java.lang.Exception Fehler
     */
    public void addAll(ArrayList<String[]> data) throws Exception
    {
        addAll(tableName, tableColumms, data);
    }

    /**
     * Fügt eine Zeile zu der Tabelle hinzu.
     *
     * @param data Inhalt der Zeile
     *
     * @throws java.lang.Exception Fehler
     */
    public void add(String[] data) throws Exception
    {
        addLine(tableName, tableColumms, data);
    }

    /**
     * Fügt eine Zeile mit einer Spalte zu der Tabelle hinzu.
     *
     * @param tableColumm Name der Zelle
     * @param data        Inhalt der Zelle
     *
     * @throws java.lang.Exception Fehler
     */
    public void add(String tableColumm, String data) throws Exception
    {
        addCell(tableName, tableColumm, data);
    }

    /**
     * Leert die Tabelle. (TRUNCATE)
     *
     * @throws java.lang.Exception Fehler
     */
    public void clear() throws Exception
    {
        clear(tableName);
    }
}
