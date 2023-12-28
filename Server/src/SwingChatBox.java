import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingChatBox extends JFrame {
    private JTextArea chatArea;
    private JTextField messageField;

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
    }

    private void sendMessage(String userName) {
        String message = messageField.getText();
        if (!message.isEmpty()) {
            chatArea.append(userName + ": " + message + "\n");
            messageField.setText("");
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
