package me.xlucash.dzien12.mouseprank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PrankPanel extends JPanel implements MouseMotionListener {
    JButton ok = new JButton("OK");
    int buttonX, buttonY, mouseX, mouseY;
    int width, height;

    PrankPanel()
    {
        super();
        setLayout(null);
        addMouseMotionListener(this);
        buttonX=110;
        buttonY=110;
        ok.setBounds(new Rectangle(buttonX,buttonY,70,20));
        add(ok);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX=e.getX();
        mouseY=e.getY();
        width = (int) getSize().getWidth();
        height = (int) getSize().getHeight();
        if(Math.abs((mouseX+35)-buttonX)<50)
        {
            buttonX = moveButton(mouseX,buttonX,width);
            repaint();
        }
        if(Math.abs((mouseY+10)-buttonY)<50)
        {
            buttonY = moveButton(mouseY,buttonY,width);
            repaint();
        }
    }

    private int moveButton(int mouseAt, int buttonAt, int bord)
    {
        if(buttonAt<mouseAt)
        {
            buttonAt--;
        } else
        {
            buttonAt++;
        }
        if(buttonAt>(bord-20))
        {
            buttonAt=10;
        }
        if(buttonAt<0)
        {
            buttonAt=bord-80;
        }
        return buttonAt;
    }

    public void paintComponent(Graphics comp)
    {
        super.paintComponent(comp);
        ok.setBounds(buttonX,buttonY,70,20);
    }
}
