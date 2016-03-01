package eu.convertron.interlib.io;

import eu.convertron.interlib.logging.Logger;
import eu.convertron.interlib.logging.messages.LogPriority;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SqlTable
{
    private String tableName;

    private Statement statement;
    private Connection connection;

    public SqlTable(String addressWithPort, String databaseName, String tableName, String userName, String password)
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");

            this.connection = DriverManager.getConnection("jdbc:mysql://" + addressWithPort
                                                          + "/" + databaseName
                                                          + "?user=" + userName
                                                          + "&password=" + password);
            this.statement = this.connection.createStatement();
            this.tableName = tableName;
        }
        catch(ClassNotFoundException | SQLException ex)
        {
            throw new RuntimeException("Die Datenbank konnte nicht verbunden werden", ex);
        }
    }

    private void execute(String stmt)
    {
        try
        {
            statement.execute(stmt);
            Logger.logError(LogPriority.INFO, "Der Sql Befehl '" + stmt + "'konnte nicht ausgeführt werden", null);
        }
        catch(SQLException ex)
        {
            throw new RuntimeException("Das SQL Statement " + stmt + " konnte nicht ausgeführt werden", ex);
        }
    }

    public void createTableIfNotExists()
    {
        execute("CREATE TABLE IF NOT EXISTS " + tableName + " (`Index` INT NOT NULL AUTO_INCREMENT PRIMARY KEY)");
    }

    private void configureDefaultPrimaryKey()
    {
        execute("ALTER TABLE  " + tableName + " MODIFY `Index` INT NOT NULL AUTO_INCREMENT PRIMARY KEY");
    }

    public void dropTableIfExists()
    {
        execute("DROP TABLE IF EXISTS " + tableName);
    }

    public void addDefaultTextColumns(String... columnNames)
    {
        String stmtPart = " ADD `"
                          + String.join("` TEXT CHARACTER SET latin1 COLLATE latin1_german1_ci, ADD `", columnNames)
                          + "` TEXT CHARACTER SET latin1 COLLATE latin1_german1_ci";
        execute("ALTER TABLE " + tableName + stmtPart);
    }

    public void addTextRows(String[][] keysAndValues)
    {
        String[] keys = keysAndValues[0];
        for(int i = 1; i < keysAndValues.length; i++)
        {
            execute("INSERT INTO " + tableName
                    + " (`" + String.join("`, `", keys) + "`) "
                    + "VALUES ('" + String.join("', '", keysAndValues[i]) + "')");
        }
    }

    public String[][] getAllTextRows()
    {
        try
        {
            ArrayList<String[]> keysAndValues = new ArrayList<String[]>();
            ResultSet result = statement.executeQuery("SELECT * FROM " + tableName);

            String[] keys = getAllColumns(result.getMetaData());
            keysAndValues.add(keys);

            result.first();
            do
            {
                keysAndValues.add(getAllValues(keys, result));
            }
            while(result.next());

            return keysAndValues.toArray(new String[keysAndValues.size()][]);
        }
        catch(SQLException ex)
        {
            throw new RuntimeException("Das SQL Statement konnte nicht ausgeführt werden", ex);
        }
    }

    private String[] getAllColumns(ResultSetMetaData metaData) throws SQLException
    {
        ArrayList<String> keys = new ArrayList<String>();
        int columnCount = metaData.getColumnCount();
        for(int i = 1; i < columnCount + 1; i++)
        {
            String key = metaData.getColumnName(i);
            if(!key.equals("Index"))
                keys.add(key);
        }
        return keys.toArray(new String[keys.size()]);
    }

    private String[] getAllValues(String[] keys, ResultSet row) throws SQLException
    {
        ArrayList<String> values = new ArrayList<String>();
        for(String key : keys)
        {
            String value = row.getString(key);
            if(value.equals("null"))
                values.add(null);
            else
                values.add(value);
        }
        return values.toArray(new String[values.size()]);
    }

    public void copyToOtherTableAndRecreate(SqlTable otherTable)
    {
        otherTable.dropTableIfExists();
        createTableIfNotExists();

        execute("CREATE TABLE IF NOT EXISTS " + otherTable.getTableName() + " AS SELECT * FROM " + tableName);
        otherTable.configureDefaultPrimaryKey();

        dropTableIfExists();
        createTableIfNotExists();
    }

    @Override
    protected void finalize() throws Throwable
    {
        statement.close();
        connection.close();

        super.finalize();
    }

    public String getTableName()
    {
        return tableName;
    }
}
