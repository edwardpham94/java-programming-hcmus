package Swing;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

class ListDemo implements ListSelectionListener {
    JList<String> jlst;
    JLabel jlab;
    JScrollPane jscrlp;
    String names[] = {"Sherry", "Jon", "Rachel", "Sasha",
            "Josselyn", "Randy", "Tom", "Mary", "Ken", "Andrew",
            "Matt", "Todd"};

    ListDemo() {
        JFrame jfrm = new JFrame("JList Demo");
        jfrm.setLayout(new FlowLayout());
        jfrm.setSize(400, 400);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jlst = new JList<String>(names);
        jlst.setSelectionMode(
                ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        jscrlp = new JScrollPane(jlst);
        jscrlp.setPreferredSize(new Dimension(300, 200));
        jlab = new JLabel("Please choose a name");
        jlst.addListSelectionListener(this);
        jfrm.add(jscrlp);
        jfrm.add(jlab);
        jfrm.setVisible(true);
    }

    public void valueChanged(ListSelectionEvent le) {
        int[] idx = jlst.getSelectedIndices();
        for (int a : idx){
            System.out.println(a);
        }
    }

    public static void main(String args[]) {
// Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ListDemo();
            }
        });
    }
}