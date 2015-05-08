package com.facharbeit.sql;

import java.util.*;

/**
 * Klasse zum lesen aus einer bestimmten Tabelle in einer Datenabank.
 */
public class SqlTableReader extends SqlReader
{
    /**
     * Name der Tabelle.
     */
    protected String tableName;

    /**
     * Spalten, die ausgelesen werden.
     */
    protected String[] tableColumms;

    /**
     * Erstellt einen Table-Reader.
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
    public SqlTableReader(String dbHost, int dbPort, String dbName, String dbUser, String dbPassword, String tableName, String[] tableColumms) throws Exception
    {
        super(dbHost, dbPort, dbName, dbUser, dbPassword);
        this.tableColumms = tableColumms;
        this.tableName = tableName;
    }

    /**
     * Liest eine ganze Tabelle.
     *
     * @return Inhalt der Tabelle
     *
     * @throws java.lang.Exception Fehler
     */
    public ArrayList<String[]> readAll() throws Exception
    {
        return readAll(this.tableName, this.tableColumms);
    }

    /**
     * Liest eine Zeile einer Tabelle.
     *
     * @param line Zeile, die gelesen werden soll
     *
     * @return Inhalt der Zeile
     *
     * @throws java.lang.Exception Fehler
     */
    public String[] read(int line) throws Exception
    {
        return readAll().get(line);
    }

    /**
     * Liest eine Spalte aus einer Zeile einer Tabelle.
     *
     * @param tableColumm Spalte, die gelesen werden soll
     * @param line        Zeile, die gelesen werden soll
     *
     * @return Inhalt der Zelle
     *
     * @throws java.lang.Exception Fehler
     */
    public String read(String tableColumm, int line) throws Exception
    {
        String[] columm =
        {
            tableColumm
        };
        return readAll(this.tableName, columm).get(line)[0];
    }
}
