package me.xlucash.dzien10;

import javax.swing.*;

public class Slider extends JFrame {

    public Slider()
    {
        super("Suwak");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLookAndFeel();
        JSlider pick = new JSlider(JSlider.HORIZONTAL,0,30,5);
        pick.setMajorTickSpacing(10);
        pick.setMinorTickSpacing(1);
        pick.setPaintTicks(true);
        pick.setPaintLabels(true);
        add(pick);
        pack();
        setVisible(true);
    }

    private void setLookAndFeel()
    {
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch(Exception ex){
            System.err.println("Nie potrafie wczytac "+ "systemowego wygladu: " + ex);
        }
    }

    public static void main(String[] args) {
        Slider slider = new Slider();
    }
}
