package ChatUI;
import javax.swing.*;
import java.awt.*;

public class SizeTableExample extends JFrame {
    public SizeTableExample() {
        setTitle("Size Table Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the data for the table
        String[][] data = {
                {"John", "Doe", "25"},
                {"Jane", "Smith", "30"},
                {"Bob", "Johnson", "45"}
        };

        // Create the column names
        String[] columnNames = {"First Name", "Last Name", "Age"};

        // Create the table
        JTable table = new JTable(data, columnNames);

        // Set the preferred size of the table
        table.setPreferredScrollableViewportSize(new Dimension(900, 200));

        // Create a scroll pane and add the table to it
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame
        add(scrollPane);

        pack();
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SizeTableExample example = new SizeTableExample();
            example.setVisible(true);
        });
    }
}