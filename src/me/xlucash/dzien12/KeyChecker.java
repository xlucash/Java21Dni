package me.xlucash.dzien12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyChecker extends JFrame {
    JLabel keyLabel = new JLabel("Naciśnij dowolny klawisz");

    public KeyChecker()
    {
        super("Naciśnij klawisz");
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        KeyMonitor monitor = new KeyMonitor(this);
        setFocusable(true);
        addKeyListener(monitor);
        add(keyLabel);
        setVisible(true);
    }

    private static void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel"
            );
        } catch (Exception e) {
            System.err.println("Nie potrafię wczytać "
                    + "systemowego wyglądu: " + e);
        }
    }

    public static void main(String[] args) {
        KeyChecker.setLookAndFeel();
        new KeyChecker();
    }
}

class KeyMonitor extends KeyAdapter
{
    KeyChecker display;
    KeyMonitor(KeyChecker display)
    {
        this.display = display;
    }

    public void keyTyped(KeyEvent event)
    {
        display.keyLabel.setText(""+event.getKeyChar());
        display.repaint();
    }
}
