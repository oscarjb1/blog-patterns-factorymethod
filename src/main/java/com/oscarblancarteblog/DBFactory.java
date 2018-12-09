package com.oscarblancarteblog;

public class DBFactory {
    public static IDBAdapter getDBAdapter(){
        String dbType = ConfigLoader.getDBType();
        System.out.println("DBType => " + dbType);
        switch(dbType){
            case "MySQL":
                return new MySQLDBAdapter();
            case "Oracle":
                return new OracleDBAdapter();
            case "SQLServer":
                return new SQLServerAdapter();
            default:
                throw new RuntimeException("Unsupported db type");
        }
    }
    
    
    
}
