package com.oscarblancarteblog;

import java.sql.Connection;

public interface IDBAdapter {
    public Connection getConnection();
}
