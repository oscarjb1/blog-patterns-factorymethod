package com.oscarblancarteblog;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLServerAdapter implements IDBAdapter {
    
    static{
        try {
            //new com.microsoft.jdbc.sqlserver.SQLServerDriver();
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error on load SQLServer Driver");
        }
    }

    @Override
    public Connection getConnection() {
        try {
            String user = ConfigLoader.getPropery("SQLServer.user");
            String password = ConfigLoader.getPropery("SQLServer.password");
            String host = ConfigLoader.getPropery("SQLServer.host");
            String port = ConfigLoader.getPropery("SQLServer.port");
            String db = ConfigLoader.getPropery("SQLServer.db");

            String url = "jdbc:sqlserver://${host}:${port};databaseName=${db};"
                    .replace("${host}", host).replace("${port}", port).replace("${db}", db);

            Connection connection = DriverManager.getConnection(url, user, password); //connection to MySQL
            return connection;
        } catch (Exception e) {
            throw new RuntimeException("SQLServer connection error " + e.getMessage());
        }
    }
    
}