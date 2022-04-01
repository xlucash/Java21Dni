package me.xlucash.dzien11;

import javax.swing.*;
import java.awt.*;

public class Stacker extends JFrame {
    public Stacker()
    {
        super("Stacker");
        setSize(450,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLookAndFeel();

        JPanel commandPane = new JPanel();
        BoxLayout horizontal = new BoxLayout(commandPane, BoxLayout.X_AXIS); //poziomy układ przycisków
        // BoxLayout horizontal = new BoxLayout(commandPane, BoxLayout.Y_AXIS); - pionowy układ przycisków
        commandPane.setLayout(horizontal);

        JButton subscribe = new JButton("Subskrybuj");
        JButton unsubscribe = new JButton("Anuluj subskrypcję");
        JButton refresh = new JButton("Odśwież");
        JButton save = new JButton("Zapisz");
        commandPane.add(subscribe);
        commandPane.add(unsubscribe);
        commandPane.add(refresh);
        commandPane.add(save);


        JPanel textPane = new JPanel();
        JTextArea text = new JTextArea(4,70);
        JScrollPane scrollPane = new JScrollPane(text);

        FlowLayout flow = new FlowLayout();
        setLayout(flow);
        add(commandPane);
        add(scrollPane);
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
        Stacker stacker = new Stacker();

    }
}
