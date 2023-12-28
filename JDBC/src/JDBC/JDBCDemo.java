package JDBC;

import java.sql.*;


public class JDBCDemo {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static final String DB_URL = "jdbc:sqlserver://localhost:1433;databaseName=JDBCDemo";
    // Database credentials
    static final String USER = "EDWARD\\HP-PC";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch ( ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        System.out.println(conn);
    }
}