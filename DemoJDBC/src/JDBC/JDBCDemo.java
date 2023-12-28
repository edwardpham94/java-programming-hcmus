package JDBC;

import java.sql.*;

public class JDBCDemo {
    // JDBC driver name and database URL


    public static void main(String[] args) {
        Connection conn = null;
        String url = "jdbc:postgresql://your_host:1433/your_database";
        String user = "your_username";
        String password = "your_password";
        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.postgresql.Driver");
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(url, user, password);
        } catch ( ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        System.out.println(conn);
    }
}