package me.xlucash.dzien10;

import javax.swing.*;
import java.awt.*;

public class FeedInfo extends JFrame {

    private JLabel nameLabel = new JLabel("Nazwa: ",SwingConstants.RIGHT);
    private JTextField name;
    private JLabel urlLabel = new JLabel("URL: ", SwingConstants.RIGHT);
    private JTextField url;
    private JLabel typeLabel = new JLabel("Typ: ", SwingConstants.RIGHT);
    private JTextField type;

    public FeedInfo()
    {
        super("Informacje o źródle");
        setSize(400,150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLookAndFeel();
        String response1 = JOptionPane.showInputDialog(null, "Wpisz nazwę witryny:");
        name = new JTextField(response1, 20);

        String response2 = JOptionPane.showInputDialog(null, "Wpisz adres witryny");
        url = new JTextField(response2, 20);

        String[] choices = { "Osobista", "Komercyjna", "Inna" };
        int response3 = JOptionPane.showOptionDialog(null, "Jaki to typ witryny?",
                "Typ witryny", 0, JOptionPane.QUESTION_MESSAGE, null,
                choices, choices[0]);
        type = new JTextField(choices[response3],20);

        setLayout(new GridLayout(3,2));
        add(nameLabel);
        add(name);
        add(urlLabel);
        add(url);
        add(typeLabel);
        add(type);
        setLookAndFeel();
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
        FeedInfo frame = new FeedInfo();
    }


}
