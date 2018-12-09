package com.oscarblancarteblog;

import java.sql.Connection;
import java.sql.DriverManager;

public class OracleDBAdapter implements IDBAdapter {
    
    static{
        try {
            //new oracle.jdbc.OracleDriver();
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error on load Oracle Driver");
        }
    }

    @Override
    public Connection getConnection() {
        try {
            String user = ConfigLoader.getPropery("Oracle.user");
            String password = ConfigLoader.getPropery("Oracle.password");
            String host = ConfigLoader.getPropery("Oracle.host");
            String port = ConfigLoader.getPropery("Oracle.port");
            String db = ConfigLoader.getPropery("Oracle.db");

            String url = "jdbc:oracle:thin:@${host}:${port}:${db}"
                    .replace("${host}", host).replace("${port}", port).replace("${db}", db);

            Connection connection = DriverManager.getConnection(url, user, password); //connection to MySQL
            return connection;
        } catch (Exception e) {
            throw new RuntimeException("Oracle connection error " + e.getMessage());
        }
    }
    
}
