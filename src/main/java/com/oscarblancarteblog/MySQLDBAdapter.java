package com.oscarblancarteblog;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDBAdapter implements IDBAdapter {

    static {
        try {
            new com.mysql.jdbc.Driver();
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error on load MySQL Driver");
        }
    }

    @Override
    public Connection getConnection() {
        try {
            String user = ConfigLoader.getPropery("MySQL.user");
            String password = ConfigLoader.getPropery("MySQL.password");
            String host = ConfigLoader.getPropery("MySQL.host");
            String port = ConfigLoader.getPropery("MySQL.port");
            String db = ConfigLoader.getPropery("MySQL.db");

            String url = "jdbc:mysql://${host}:${port}/${db}?zeroDateTimeBehavior=convertToNull&amp;serverTimezone=UTC&amp;useSSL=false;"
                    .replace("${host}", host).replace("${port}", port).replace("${db}", db);

            Connection connection = DriverManager.getConnection(url, user, password); //connection to MySQL
            return connection;
        } catch (Exception e) {
            throw new RuntimeException("MySQL connection error " + e.getMessage());
        }
    }

}
