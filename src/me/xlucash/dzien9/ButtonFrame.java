package me.xlucash.dzien9;

import javax.swing.*;

public class ButtonFrame extends JFrame {

    JButton load = new JButton("Wczytaj");
    JButton save = new JButton("Zapisz");
    JButton unsubscribe = new JButton("Wyrejestruj");

    public ButtonFrame()
    {
        super("Ramka z przyciskami");
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.add(load);
        panel.add(save);
        panel.add(unsubscribe);
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
        setLookAndFeel();
        ButtonFrame buttonFrame = new ButtonFrame();
    }
}
