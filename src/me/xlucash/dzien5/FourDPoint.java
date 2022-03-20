package me.xlucash.dzien5;

import java.awt.*;

public class FourDPoint extends Point {
    int c;
    int d;

    FourDPoint(int a, int b, int c, int d)
    {
        super(a,b);
        this.c=c;
        this.d=d;
    }

    public static void main(String[] args) {
        FourDPoint point = new FourDPoint(5,5,5,6);
        System.out.println("a wynosi " + point.x);
        System.out.println("b wynosi " + point.y);
        System.out.println("c wynosi " + point.c);
        System.out.println("d wynosi " + point.d);
    }
}
