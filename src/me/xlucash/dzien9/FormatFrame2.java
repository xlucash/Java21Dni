package me.xlucash.dzien9;

import javax.swing.*;

public class FormatFrame2 extends JFrame {

    String[] formats = { "Atom", "RSS 0.92", "RSS 1.0", "RSS 2.0" };
    JComboBox formatBox = new JComboBox(formats);

    public FormatFrame2()
    {
        super("Wybierz format");
        setSize(320,110);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        JLabel formatLabel = new JLabel("Formaty wyjściowe: ");
        panel.add(formatLabel);
        panel.add(formatBox);

        add(panel);
        setVisible(true);

    }

    private static void setLookAndFeel()
    {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch(Exception ex){
        }
    }

    public static void main(String[] args) {
        FormatFrame2.setLookAndFeel();
        FormatFrame2 ff2 = new FormatFrame2();

    }
}
