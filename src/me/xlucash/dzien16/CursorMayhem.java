package me.xlucash.dzien16;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CursorMayhem extends JFrame {
    JButton harry, wade, hansel;
    public CursorMayhem()
    {
        super("Wybierz kursor");
        setLookAndFeel();
        setSize(400,80);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        harry = new JButton("Celownik");
        add(harry);
        wade = new JButton("Oczekiwanie");
        add(wade);
        hansel = new JButton("Rączka");
        add(hansel);

        ActionListener act = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==harry)
                    setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                if(e.getSource()==wade)
                    setCursor(new Cursor(Cursor.WAIT_CURSOR));
                if(e.getSource()==hansel)
                    setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        };

        harry.addActionListener(act);
        wade.addActionListener(act);
        hansel.addActionListener(act);

        setVisible(true);
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

    public static void main(String[] args) {
        new CursorMayhem();
    }
}
