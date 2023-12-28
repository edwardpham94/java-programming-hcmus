package StudentManager;

import javax.swing.*;
import java.sql.*;

public class DataBase {
    public static String url = "jdbc:postgresql://localhost:5432/Student12";
    public static String user = "postgres";
    public static String password = "123456";
    public static Connection connection;


    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(url, user, password);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void allStudent(ListStudent list) {
        try {
            Class.forName("org.postgresql.Driver");
            // Establish a connection
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                if (conn != null) {
                    System.out.println("Connected to the database!");
                    System.out.println(conn);
                    // Do something with the connection here...
                    Statement stmt = conn.createStatement();
                    String sql = "SELECT id, first, last, dob, address FROM student";
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) { // Retrieve by column name
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        String dob = rs.getString("dob");
                        String address = rs.getString("address");
                        Student tmp = new Student(id, name, dob, address);
                        list.addStudent(tmp);
                    }
                    rs.close();
                } else {
                    System.out.println("Failed to make connection!");
                }
            } catch (SQLException e) {
                // Handle any SQL exceptions
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addNewStudent(Student tmp) {
        try {
            Class.forName("org.postgresql.Driver");
            // Establish a connection
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                if (conn != null) {
                    System.out.println("Connected to the database!");
                    System.out.println(conn);
                    Statement stmt = conn.createStatement();
                    String sql = "INSERT INTO STUDENT VALUES ('" + tmp.getId() + "','" + tmp.getName() +
                            "','" + tmp.getDOB() + "','" + tmp.getUrl() + "')";
                    System.out.println(sql);
                    stmt.executeUpdate(sql);
                } else {
                    System.out.println("Failed to make connection!");
                }
                conn.close();
            } catch (SQLException e) {
                // Handle any SQL exceptions
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Student searchStudent(int id, String name) {
        Connection connection = null;
        int idStudent = 0;
        String  nameStudent = "", dobStudent = "", urlStudent = "";
        try {
            Class.forName("org.postgresql.Driver");
            // Establish a connection
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                if (conn != null) {
                    System.out.println("Connected to the database!");
                    Statement stmt = conn.createStatement();
                    String sql = "SELECT id, name, dob, url FROM student" +
                            " where id='" + id + "' and name='" + name +  "'";
                    ResultSet rs = stmt.executeQuery(sql);
                    while (rs.next()) {
                        idStudent = rs.getInt("id");
                        nameStudent = rs.getString("name");
                        dobStudent = rs.getString("dob");
                        urlStudent = rs.getString("url");
                    }

                } else {
                    System.out.println("Failed to make connection!");
                }
            } catch (SQLException e) {
                // Handle any SQL exceptions
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Student tmp = new Student(idStudent, nameStudent, dobStudent, urlStudent);
        return tmp;
    }
}