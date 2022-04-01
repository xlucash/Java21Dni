package me.xlucash.dzien16;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ProgressMonitor2 extends JFrame {
    JProgressBar current;
    int num = 0;
    boolean done = false;

    public ProgressMonitor2()
    {
        super("Monitorowanie postępu 2");
        setLookAndFeel();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(done)
                {
                    dispose();
                    System.exit(0);
                }
            }
        });
        setSize(400,100);
        setLayout(new FlowLayout());
        current = new JProgressBar(0,2000);
        current.setValue(0);
        current.setStringPainted(true);
        current.setPreferredSize(new Dimension(360,50));
        add(current);
        setVisible(true);
        iterate();
    }

    public final void iterate()
    {
        while(num<2000)
        {
            current.setValue(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {}
            num+=95;
        }
        done = true;
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
        new ProgressMonitor2();
    }
}
