package me.xlucash.dzien10;

import javax.swing.*;
import java.awt.*;

public class ProgressMonitor2 extends JFrame {

    JProgressBar current;
    JTextField numValue;
    int num = 0;

    public ProgressMonitor2() {
        super("Monitorowanie postępu");
        setLookAndFeel();
        setSize(220, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        numValue = new JTextField("" + num, 8);
        panel.add(numValue);
        current = new JProgressBar(0, 2000);
        current.setValue(0);
        current.setStringPainted(true);
        panel.add(current);
        setContentPane(panel);
        setVisible(true);
    }


    public void iterate() {
        while (num < 2000) {
            current.setValue(num);
            numValue.setText("" + num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
            num += 95;
        }
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.err.println("Nie potrafię wczytać "
                    + "systemowego wyglądu: " + e);
        }
    }

    public static void main(String[] arguments) {
        ProgressMonitor2 frame = new ProgressMonitor2();
        frame.iterate();
    }
}
