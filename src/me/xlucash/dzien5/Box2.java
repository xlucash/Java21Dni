package me.xlucash.dzien5;

import java.awt.*;

public class Box2 {
    int x1=0;
    int y1=0;
    int x2=0;
    int y2=0;

    Box2(int x1,int y1, int x2, int y2)
    {
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
    }
    Box2(Point topLeft, Point bottomRight)
    {
        this(topLeft.x,topLeft.y,bottomRight.x,bottomRight.y);
    }
    Box2(Point topLeft, int w, int h)
    {
        this(topLeft.x,topLeft.y, topLeft.x+w, topLeft.y+h);
    }
    void printBox()
    {
        System.out.print("Box: <"+x1+", "+y1);
        System.out.println(", "+x2+", "+y2+">");
    }

    public static void main(String[] args) {
        Box2 rect;
        System.out.println("Wywolanie Box2 ze "+"Współrzędnymi (25,25) i (50,50)");
        rect=new Box2(25,25,50,50);
        rect.printBox();

        System.out.println("\nWywolanie Box2 z "+"Punktami (10,10) i (20,20)");
        rect=new Box2(new Point(10,10),new Point(20,20));
        rect.printBox();

        System.out.println("\nWywolanie Box2 z "+"Punktem (10,10), szerokością 50 i z wysokością 50");
        rect=new Box2(new Point(10,10),50,50);
        rect.printBox();
    }
}
