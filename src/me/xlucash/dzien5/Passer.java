package me.xlucash.dzien5;

public class Passer {
    void toUpperCase(String[] text)
    {
        for(int i=0; i<text.length;i++)
            text[i] = text[i].toUpperCase();
    }

    public static void main(String[] args) {
        Passer passer = new Passer();
        passer.toUpperCase(args);
        for (String arg : args) {
            System.out.print(arg + " ");
        }
        System.out.println();
    }
}
