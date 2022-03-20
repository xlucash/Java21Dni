package me.xlucash.dzien10;

import javax.swing.*;
import java.awt.*;

public class ProgressMonitor extends JFrame {

    JProgressBar current;
    int num = 0;

    public ProgressMonitor()
    {
        super("Monitorowanie postępu");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLookAndFeel();
        setSize(205,68);
        setLayout(new FlowLayout());
        current = new JProgressBar(0,2000);
        current.setValue(0);
        current.setStringPainted(true);
        add(current);
    }

    public void iterate()
    {
        while (num<2000)
        {
            current.setValue(num);
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
            num+=95;
        }
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
        ProgressMonitor pm = new ProgressMonitor();
        pm.setVisible(true);
        pm.iterate();
    }
}
