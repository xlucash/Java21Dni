package me.xlucash.dzien13;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Circle extends JFrame {
    public Circle(String radius, String x, String y, String color)
    {
        super("Circle");
        setSize(360,350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        CirclePane cp = new CirclePane(radius,x,y,color);
        add(cp);
        setVisible(true);
    }

    public static void main(String[] args) {
        if(args.length<1)
        {
            System.out.println("Użycie: Java Circle Promien, Polozenie X, Polozenie Y, Kolor");
            System.exit(0);
        }
        Circle circle = new Circle(args[0],args[1],args[2], args[3]);
    }
}

class CirclePane extends JPanel {
    int radius, x, y;
    Color color;
    public CirclePane(String inRadius, String inX, String inY, String inColor)
    {
        super();
        try {
            radius=Integer.parseInt(inRadius);
            x=Integer.parseInt(inX);
            y=Integer.parseInt(inY);
            color=Color.decode(inColor);
        } catch (NumberFormatException e)
        {
            System.out.println("Błąd " + e.getMessage());
        }
    }

    public void paintComponent(Graphics comp)
    {
        Graphics2D comp2D = (Graphics2D) comp;
        comp2D.setColor(Color.white);
        comp2D.fillRect(0, 0, getSize().width, getSize().height);
        comp2D.setColor(color);
        Ellipse2D.Float circle = new Ellipse2D.Float(x, y, radius, radius);
        comp2D.fill(circle);
    }
}
