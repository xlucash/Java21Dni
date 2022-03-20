package me.xlucash.dzien9;

import javax.swing.*;

public class FormatFrame extends JFrame {

    JRadioButton[] teams = new JRadioButton[4];

    public FormatFrame()
    {
        super("Wybierz format wyjściowy");
        setSize(320,110);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        teams[0] = new JRadioButton("Atom");
        teams[1] = new JRadioButton("RSS 0.92");
        teams[2] = new JRadioButton("RSS 1.0");
        teams[3] = new JRadioButton("RSS 2.0",true);

        JPanel panel = new JPanel();
        JLabel chooseLabel = new JLabel("Wybierz format wyjściowy dla wiadomości RSS.");
        panel.add(chooseLabel);
        ButtonGroup group = new ButtonGroup();
        for(JRadioButton team: teams)
        {
            group.add(team);
            panel.add(team);
        }

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
        FormatFrame.setLookAndFeel();
        FormatFrame ff = new FormatFrame();

    }
}
