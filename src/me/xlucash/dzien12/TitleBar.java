package me.xlucash.dzien12;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleBar extends JFrame implements ActionListener {
    JButton b1;
    JButton b2;

    public TitleBar()
    {
        super("Pasek tytułu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLookAndFeel();

        b1 = new JButton("Rosenkrantz");
        b2 = new JButton("Guildenstern");

        b1.addActionListener(this);
        b2.addActionListener(this);

        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        add(b1);
        add(b2);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source==b1)
        {
            setTitle("Rosenkrantz");
        } else if(source==b2)
        {
            setTitle("Guildenstern");
        }
        repaint();
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
        TitleBar tb = new TitleBar();

    }
}
