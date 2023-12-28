import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class StudentManagementAppSwingPostgres {
    private JTextField studentIdField = new JTextField(10);
    private JTextField fullNameField = new JTextField(10);
    private JTextField dobField = new JTextField(10);
    private JTextField imagePathField = new JTextField(10);

    private JTextArea resultArea = new JTextArea(10, 30);

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StudentManagementAppSwingPostgres().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Student Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(5, 5, 5, 5);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(new JLabel("Student ID:"), constraints);

        constraints.gridx = 1;
        panel.add(studentIdField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(new JLabel("Full Name:"), constraints);

        constraints.gridx = 1;
        panel.add(fullNameField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(new JLabel("Date of Birth:"), constraints);

        constraints.gridx = 1;
        panel.add(dobField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(new JLabel("Image Path:"), constraints);

        constraints.gridx = 1;
        panel.add(imagePathField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(e -> addStudent());
        panel.add(addButton, constraints);

        constraints.gridx = 1;
        JButton displayButton = new JButton("Display Students");
        displayButton.addActionListener(e -> displayStudents());
        panel.add(displayButton, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(new JLabel("Result:"), constraints);

        constraints.gridx = 1;
        panel.add(new JScrollPane(resultArea), constraints);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void addStudent() {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentmanager", "postgres", "123456")) {
            String sql = "INSERT INTO student (id, name, dob, url) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, Integer.parseInt(studentIdField.getText()));
                statement.setString(2, fullNameField.getText());
                statement.setString(3, dobField.getText());
                statement.setString(4, imagePathField.getText());

                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    resultArea.setText("Student added successfully!");
                } else {
                    resultArea.setText("Failed to add student.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error: " + e.getMessage());
        }
    }

    private void displayStudents() {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/studentmanager", "postgres", "123456")) {
            String sql = "SELECT * FROM student";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                resultArea.setText("");
                while (resultSet.next()) {
                    int studentId = resultSet.getInt("id");
                    String fullName = resultSet.getString("name");
                    String dob = resultSet.getString("dob");
                    String imagePath = resultSet.getString("url");

                    resultArea.append("Student ID: " + studentId + "\n");
                    resultArea.append("Full Name: " + fullName + "\n");
                    resultArea.append("Date of Birth: " + dob + "\n");
                    resultArea.append("Image Path: " + imagePath + "\n\n") ;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            resultArea.setText("Error: " + e.getMessage());
        }
    }
}
