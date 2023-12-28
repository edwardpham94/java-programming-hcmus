import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SwingChatBox extends JFrame {
    private JTextArea chatArea;
    private JTextField messageField;
    private PrintWriter out;

    public SwingChatBox(String userName) {
        setTitle("Chatter - " + userName);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);

        chatArea = new JTextArea();
        chatArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(userName);
            }
        });

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(userName);
            }
        });

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(inputPanel, BorderLayout.SOUTH);

        setVisible(true);

        // Connect to the server when the SwingChatBox is created
        connectToServer(userName);
    }

    private void connectToServer(String userName) {
        try {
            Socket clientSocket = new Socket("localhost", 1234);
            out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Send the client's name to the server
            out.println(userName);

            // Create a separate thread to read messages from the server
            new Thread(new ClientReader(clientSocket)).start();
        } catch (IOException e) {
            System.out.println("Error connecting to the server: " + e.getMessage());
        }
    }

    private void sendMessage(String userName) {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            out.println(userName + ": " + message);
            messageField.setText("");
        }
    }

    private class ClientReader implements Runnable {
        private Socket clientSocket;

        public ClientReader(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    // Read messages from the server and display them in the UI
                    String message = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())).readLine();
                    if (message != null) {
                        chatArea.append(message + "\n");
                    }
                }
            } catch (IOException e) {
                System.out.println("Error reading from server: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        String userName = JOptionPane.showInputDialog("Enter your name:");
        if (userName != null && !userName.isEmpty()) {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new SwingChatBox(userName);
                }
            });
        } else {
            System.out.println("Invalid name. Exiting.");
        }
    }
}
