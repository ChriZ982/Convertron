package converter.io;

import converter.util.Settings;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class SqlIO
{
    /**
     * Die verschiedenen SQL-Modi.
     */
    public enum SqlMode
    {
        READ,
        ADD,
        OVERWRITE;

        /**
         * Prüft ob der Modus der aktuelle Modus ist.
         *
         * @return Ist dieser Modus gerade aktiv?
         *
         * @throws Exception
         */
        public boolean isActive() throws IOException
        {
            return Settings.load("sqlMode").equals(this.toString());
        }
    }

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
         * @throws java.lang.ClassNotFoundException
         * @throws java.sql.SQLException
         *
         *
         */
        public SqlWriter(String dbHost, int dbPort, String dbName, String dbUser, String dbPassword) throws ClassNotFoundException, SQLException
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
         * @throws java.sql.SQLException
         *
         *
         */
        public void addAll(String tableName, String[] tableColumms, ArrayList<String[]> data) throws SQLException
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

                   // Logger.log(command, 0);
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
         * @throws java.sql.SQLException
         *
         *
         */
        public void addLine(String tableName, String[] tableColumms, String[] data) throws SQLException
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
         * @throws java.sql.SQLException
         *
         *
         */
        public void addCell(String tableName, String tableColumm, String data) throws SQLException
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
         * @throws java.sql.SQLException
         *
         *
         */
        public void clear(String tableName) throws SQLException
        {
            Statement query = con.createStatement();
            query.execute("TRUNCATE TABLE `" + dbName + "`.`" + tableName + "`");
        }
    }

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
         * @throws java.lang.ClassNotFoundException
         * @throws java.sql.SQLException
         *
         *
         */
        public SqlTableWriter(String dbHost, int dbPort, String dbName, String dbUser, String dbPassword, String tableName, String[] tableColumms) throws ClassNotFoundException, SQLException
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
         * @throws java.sql.SQLException
         *
         *
         */
        public void addAll(ArrayList<String[]> data) throws SQLException
        {
            addAll(tableName, tableColumms, data);
        }

        /**
         * Fügt eine Zeile zu der Tabelle hinzu.
         *
         * @param data Inhalt der Zeile
         *
         * @throws java.sql.SQLException
         *
         *
         */
        public void add(String[] data) throws SQLException
        {
            addLine(tableName, tableColumms, data);
        }

        /**
         * Fügt eine Zeile mit einer Spalte zu der Tabelle hinzu.
         *
         * @param tableColumm Name der Zelle
         * @param data        Inhalt der Zelle
         *
         * @throws java.sql.SQLException
         *
         *
         */
        public void add(String tableColumm, String data) throws SQLException
        {
            addCell(tableName, tableColumm, data);
        }

        /**
         * Leert die Tabelle. (TRUNCATE)
         *
         *
         * @throws java.sql.SQLException
         */
        public void clear() throws SQLException
        {
            clear(tableName);
        }
    }

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
         * @throws java.lang.ClassNotFoundException
         * @throws java.sql.SQLException
         *
         *
         */
        public SqlTableReader(String dbHost, int dbPort, String dbName, String dbUser, String dbPassword, String tableName, String[] tableColumms) throws ClassNotFoundException, SQLException
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
         * @throws java.sql.SQLException
         *
         *
         */
        public ArrayList<String[]> readAll() throws SQLException
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
         * @throws java.sql.SQLException
         *
         *
         */
        public String[] read(int line) throws SQLException
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
         * @throws java.sql.SQLException
         *
         *
         */
        public String read(String tableColumm, int line) throws SQLException
        {
            String[] columm =
            {
                tableColumm
            };
            return readAll(this.tableName, columm).get(line)[0];
        }
    }

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
         * @param dbUser     Nutzername der Datenbank
         * @param dbPassword Passwort der Datenbank
         *
         * @throws java.lang.ClassNotFoundException
         * @throws java.sql.SQLException
         *
         *
         */
        public SqlReader(String dbHost, int dbPort, String dbName, String dbUser, String dbPassword) throws ClassNotFoundException, SQLException
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
         * @param tableColumms Spalten, die ausgelesen werden sollen
         *
         * @return Alle Zeilen der Tabelle
         *
         * @throws java.sql.SQLException
         *
         *
         */
        public ArrayList<String[]> readAll(String tableName, String... tableColumms) throws SQLException
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
         * @throws java.sql.SQLException
         *
         *
         */
        public String[] readLine(int line, String tableName, String... tableColumms) throws SQLException
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
         * @throws java.sql.SQLException
         *
         *
         */
        public String readCell(int line, String tableName, String tableColumm) throws SQLException
        {
            String[] columm =
            {
                tableColumm
            };
            return readAll(tableName, columm).get(line)[0];
        }
    }

}
