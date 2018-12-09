package com.oscarblancarteblog;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        try {
            IDBAdapter adapter = DBFactory.getDBAdapter();
            Connection connection = adapter.getConnection();
            System.out.println("Is Open => " + (!connection.isClosed()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
