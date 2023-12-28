package ChatUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginForm() {
        // Set the title of the frame
        JFrame frame = new JFrame("Login Form");
        frame.setSize(900, 400);

        // Create left panel for welcome message
        JPanel welcomePanel = new JPanel();
        welcomePanel.setBackground(Color.lightGray);
        JLabel welcomeLabel = new JLabel("Welcome to ChatBox");
        welcomeLabel.setLocation(0, 0);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomePanel.add(welcomeLabel);
        welcomePanel.setSize(400, frame.getHeight()); // Set the size using x-axis and y-axis dimensions


        // Create the username label and field
        JLabel usernameLabel = new JLabel("Username");
        usernameField = new JTextField(20);

        // Create the password label and field
        JLabel passwordLabel = new JLabel("Password");
        passwordField = new JPasswordField(20);

        // Create the login button
        loginButton = new JButton("Login");
        loginButton.addActionListener(this);

        // Create a panel and set the layout to GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());

        // Create GridBagConstraints to control the layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add the welcome panel to the left side
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(welcomePanel, gbc);

        // Add the username label and field
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(usernameLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(usernameField, gbc);

        // Add the password label and field
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(passwordField, gbc);

        // Add the login button
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);
        panel.setSize(920, 400);
        // Add the panel to the frame
        add(panel);

        // Set the size of the frame
        setSize(920, 400);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the frame to be visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            // Perform login validation here
            if (username.equals("admin") && password.equals("password")) {
                JOptionPane.showMessageDialog(this, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm());
    }
}