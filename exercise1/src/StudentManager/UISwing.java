package StudentManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class UISwing extends JFrame {
    private static void addStudent() {
        //Declare frame object
        JFrame win = new JFrame();
        //Set the title
        win.setTitle("Add a new Student");
        //Set the window size
        win.setSize(500, 320);

        // ID LABEL
        JLabel lbl1 = new JLabel("Student ID", JLabel.LEFT);
        lbl1.setBounds(80, 20, 100, 20);
        win.add(lbl1);

        // ID INPUT
        JTextField id = new JTextField();
        id.setBounds(200, 20, 200, 20);
        win.add(id);

        // FIRST LABEL
        JLabel firstName = new JLabel("Full Name", JLabel.LEFT);
        firstName.setBounds(80, 60, 100, 20);
        win.add(firstName);

        JTextField name = new JTextField();
        name.setBounds(200, 60, 200, 20);
        win.add(name);
        
        // DOB LABEL
        JLabel dobName = new JLabel("DOB", JLabel.LEFT);
        dobName.setBounds(80, 140, 100, 20);
        win.add(dobName);

        JTextField dob = new JTextField();
        dob.setBounds(200, 140, 200, 20);
        win.add(dob);

        // LAST LABEL
        JLabel url = new JLabel("URL", JLabel.LEFT);
        url.setBounds(80, 180, 100, 20);
        win.add(url);

        JTextField address = new JTextField();
        address.setBounds(200, 180, 200, 20);
        win.add(address);


        //Create a button, set the position, and add to the frame
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(200, 220, 100, 30);
        win.add(submitButton);

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Color buttonColor = new Color(50, 150, 200);
        Color textColor = new Color(255, 255, 255);

        submitButton.setFont(buttonFont);
        submitButton.setBackground(buttonColor);
        submitButton.setForeground(textColor);
        submitButton.setFocusPainted(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the input values
                String idStudent = id.getText();
                String nameStudent = name.getText();
                String dobStudent = dob.getText();
                String urlStudent = url.getText();

                Student tmp = new Student(Integer.parseInt(idStudent), nameStudent, dobStudent, urlStudent);
                DataBase db = new DataBase();
                db.addNewStudent(tmp);
                // Display a message dialog with the input values
                JOptionPane.showMessageDialog(win,
                        "Add New Student Successfully",
                        "Input Values",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //Set window position
        win.setLocationRelativeTo(null);
        //Disable the default layout of the frame
        win.setLayout(null);
        //Make the window visible
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private static void searchStudent() {
        //Declare frame object
        JFrame win = new JFrame();
        //Set the title
        win.setTitle("Search Student");
        //Set the window size
        win.setSize(500, 250);

        // ID LABEL
        JLabel lbl1 = new JLabel("Student ID", JLabel.LEFT);
        lbl1.setBounds(80, 20, 100, 20);
        win.add(lbl1);

        // ID INPUT
        JTextField id = new JTextField();
        id.setBounds(200, 20, 200, 20);
        win.add(id);

        // FIRST LABEL
        JLabel firstName = new JLabel("Name", JLabel.LEFT);
        firstName.setBounds(80, 60, 100, 20);
        win.add(firstName);

        JTextField name = new JTextField();
        name.setBounds(200, 60, 200, 20);
        win.add(name);

        //Create a button, set the position, and add to the frame
        JButton submitButton = new JButton("Search");
        submitButton.setBounds(200, 140, 100, 30);
        win.add(submitButton);

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Color buttonColor = new Color(50, 150, 200);
        Color textColor = new Color(255, 255, 255);

        submitButton.setFont(buttonFont);
        submitButton.setBackground(buttonColor);
        submitButton.setForeground(textColor);
        submitButton.setFocusPainted(false);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Retrieve the input values
                String idStudent = id.getText();
                String firstName = name.getText();

                DataBase db = new DataBase();
                Student tmp = db.searchStudent(Integer.parseInt(idStudent), firstName);

                // Display a message dialog with the input values
                JOptionPane.showMessageDialog(win,
                        "ID : " + tmp.getId() +
                                "\nName : " + tmp.getName() +
                                "\nDOB : " + tmp.getDOB() +
                                "\nURL : " + tmp.getUrl(),
                        "Search Output Values",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        //Set window position
        win.setLocationRelativeTo(null);
        //Disable the default layout of the frame
        win.setLayout(null);
        //Make the window visible
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void showAllStudent(ListStudent list) {
        JFrame frame = new JFrame("List of Students");
        // Sample data for the table
        Object[][] data = new Object[list.getSize()][5];

        for (int i = 0; i < list.getSize(); i++) {
            Student student = list.getStudent(i);
            data[i][0] = student.getId();
            data[i][1] = student.getName();
            data[i][2] = student.getDOB();
            data[i][3] = student.getUrl();
        }

        // Column names
        String[] columnNames = {"ID", "Name", "DOB", "URL"};

        // Create a DefaultTableModel
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(model);

        // Create a JScrollPane to hold the table (for scrolling, if needed)
        JScrollPane scrollPane = new JScrollPane(table);

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        table.setDefaultRenderer(Object.class, centerRenderer);

        frame.add(scrollPane);

        // Set frame properties
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static void initialize(ListStudent list) {
        JFrame frame = new JFrame("Student Management");

        // Create a JPanel
        JPanel panel = new JPanel();

        // Create a JButton
        JButton showStudent = new JButton("Show All Students");
        JButton addStudent = new JButton("Add new Student");
        JButton searchStudent = new JButton("Search Student");

        Font buttonFont = new Font("Arial", Font.BOLD, 16);
        Color buttonColor = new Color(50, 150, 200);
        Color textColor = new Color(255, 255, 255);

        showStudent.setFont(buttonFont);
        showStudent.setBackground(buttonColor);
        showStudent.setForeground(textColor);
        showStudent.setFocusPainted(false);

        addStudent.setFont(buttonFont);
        addStudent.setBackground(buttonColor);
        addStudent.setForeground(textColor);
        addStudent.setFocusPainted(false);

        searchStudent.setFont(buttonFont);
        searchStudent.setBackground(buttonColor);
        searchStudent.setForeground(textColor);
        searchStudent.setFocusPainted(false);


        // Set button text color
        // Add an ActionListener to handle button clicks
        showStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Show Student");
                SwingUtilities.invokeLater(() -> showAllStudent(list));
            }


        });

        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Add Student");
                SwingUtilities.invokeLater(() -> addStudent());

            }
        });

        searchStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Search Student");
                SwingUtilities.invokeLater(() -> searchStudent());
            }
        });

        // Add the button to the panel
        panel.add(showStudent);
        panel.add(addStudent);
        panel.add(searchStudent);

        // Add the panel to the frame
        frame.add(panel, BorderLayout.CENTER);

        // Set the frame visibility
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        // Make the JFrame visible
        frame.setSize(500, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}