package Swing;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MenuDemo implements ActionListener {
    JLabel jlab;

    MenuDemo() {
// Create a new JFrame container.
        JFrame jfrm = new JFrame("Menu Demo");
// Specify FlowLayout for the layout manager.
        jfrm.setLayout(new FlowLayout());
// Give the frame an initial size.
        jfrm.setSize(300, 200);
//Terminate the program when the user closes  .
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// Create a label that will display the menu selection.
        jlab = new JLabel();
// Create the menu bar.
        JMenuBar jmb = new JMenuBar();
        JMenu jmFile = new JMenu("File");
        jmFile.setMnemonic(KeyEvent.VK_F);
        JMenuItem jmiOpen = new JMenuItem("Open", KeyEvent.VK_O);
        jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,
                InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiClose = new JMenuItem("Close", KeyEvent.VK_C);
        jmiClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,
                InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiSave = new JMenuItem("Save", KeyEvent.VK_S);
        jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,
                InputEvent.CTRL_DOWN_MASK));
        JMenuItem jmiExit = new JMenuItem("Exit", KeyEvent.VK_E);
        jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,
                InputEvent.CTRL_DOWN_MASK));

        JPopupMenu jpu = new JPopupMenu();
// Create the popup menu items
        JMenuItem jmiCut = new JMenuItem("Cut");
        JMenuItem jmiCopy = new JMenuItem("Copy");
        JMenuItem jmiPaste = new JMenuItem("Paste");
// Add the menu items to the popup menu.
        jpu.add(jmiCut);
        jpu.add(jmiCopy);
        jpu.add(jmiPaste);
// Add a listener for for the popup trigger.
        jfrm.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me) {
                if (me.isPopupTrigger()){
                    jpu.show(me.getComponent(), me.getX(), me.getY());
                }
                    //jpu.show(me.getComponent(), me.getX(), me.getY());
            }

            public void mouseReleased(MouseEvent me) {
                if (me.isPopupTrigger()){
                    jpu.show(me.getComponent(), me.getX(), me.getY());
                }

            }
        });

        jmFile.add(jmiOpen);
        jmFile.add(jmiClose);
        jmFile.add(jmiSave);
        jmFile.addSeparator();
        jmFile.add(jmiExit);
        jmb.add(jmFile);
        JMenu jmOptions = new JMenu("Options");
// Create the Colors submenu.
        JMenu jmColors = new JMenu("Colors");
        JMenuItem jmiRed = new JMenuItem("Red");
        JMenuItem jmiGreen = new JMenuItem("Green");
        JMenuItem jmiBlue = new JMenuItem("Blue");
        jmColors.add(jmiRed);
        jmColors.add(jmiGreen);
        jmColors.add(jmiBlue);
        jmOptions.add(jmColors);
// Create the Priority submenu.
        JMenu jmPriority = new JMenu("Priority");
        JMenuItem jmiHigh = new JMenuItem("High");
        JMenuItem jmiLow = new JMenuItem("Low");
        jmPriority.add(jmiHigh);
        jmPriority.add(jmiLow);
        jmOptions.add(jmPriority);

        JMenuItem jmiReset = new JMenuItem("Reset");
        jmOptions.addSeparator();
        jmOptions.add(jmiReset);
// Finally, add the entire options menu to the menu bar
        jmb.add(jmOptions);
// Create the Help menu.
        JMenu jmHelp = new JMenu("Help");
        JMenuItem jmiAbout = new JMenuItem("About");
        jmHelp.add(jmiAbout);
        jmb.add(jmHelp);


// Add action listeners for the menu items.
        jmiOpen.addActionListener(this);
        jmiClose.addActionListener(this);
        jmiSave.addActionListener(this);
        jmiExit.addActionListener(this);
        jmiRed.addActionListener(this);
        jmiGreen.addActionListener(this);
        jmiBlue.addActionListener(this);
        jmiHigh.addActionListener(this);
        jmiLow.addActionListener(this);
        jmiReset.addActionListener(this);
        jmiAbout.addActionListener(this);


        jfrm.add(jlab); // Add the label to the content pane.
// Add the menu bar to the frame.


        jfrm.setJMenuBar(jmb);
        jfrm.setVisible(true); // Display the frame.
    }

    //Handle menu item action events.
    public void actionPerformed(ActionEvent ae) {
// Get the action command from the menu selection.
        String comStr = ae.getActionCommand();
// If user chooses Exit, then exit the program.
        if (comStr.equals("Exit")) System.exit(0);
// Otherwise, display the selection.
        jlab.setText(comStr + " Selected");
    }

    public static void main(String args[]) {
// Create the frame on the event dispatching thread.
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MenuDemo();
            }
        });
    }
}