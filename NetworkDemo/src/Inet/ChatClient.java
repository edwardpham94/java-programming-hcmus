package Inet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.Socket;

public class ChatClient extends JFrame {
    private final JTextField messageField;
    private final JTextArea chatArea;
    private final PrintWriter writer;

    public ChatClient(String name, Socket socket) throws IOException {
        super("Chat Client - " + name);

        // Set up GUI components
        messageField = new JTextField();
        chatArea = new JTextArea();
        chatArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        // Set up layout
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);

        JPanel inputPanel = new JPanel(new BorderLayout());
        inputPanel.add(messageField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);

        // Set up networking
        writer = new PrintWriter(socket.getOutputStream(), true);

        // Start a separate thread to listen for incoming messages
        new Thread(() -> {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true) {
                    String message = reader.readLine();
                    if (message == null) {
                        break;
                    }
                    chatArea.append(message + "\n");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }).start();

        // Set up frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setVisible(true);

        // Focus on the message field
        messageField.requestFocus();
    }

    private void sendMessage() {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            writer.println(message);
            messageField.setText("");
        }
        messageField.requestFocus();
    }

    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Enter your name:");
        if (name != null && !name.isEmpty()) {
            try {
                Socket socket = new Socket("localhost", 5555);
                new ChatClient(name, socket);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error connecting to the server.");
            }
        } else {
            System.out.println("Invalid name. Exiting.");
        }
    }
}
