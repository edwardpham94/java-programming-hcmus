import java.sql.*;

import StudentManager.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase();

        ListStudent list = new ListStudent();

        db.allStudent(list);
        UISwing ui = new UISwing();

        SwingUtilities.invokeLater(() -> ui.initialize(list));
    }
}