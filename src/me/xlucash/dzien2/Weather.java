package me.xlucash.dzien2;

public class Weather {
    public static void main(String[] args) {
        float fah = 86;
        System.out.println(fah + " stopni Fahrenheita to ...");
        // Aby skonwertować temperaturę ze stopni Fahrenheita
        // na stopnie Celsjusza, rozpocznij od odjęcia 32.
        fah-=32;
        //Podziel wynik przez 9
        fah/=9;
        //Pomnóz wynik przez 5;
        fah*=5;
        System.out.println(fah + " stopni Celsjusza\n");

        float cel = 33;
        System.out.println(cel + " stopnie Celsjusza to ...");
        // Aby skonwertować temperaturę ze stopni Celsjusza
        // na stopnie Fahrenheita, rozpocznij od pomnożenia przez 9.
        cel*=9;
        //Podziel przez 5.
        cel/=5;
        //Dodaj 32.
        cel+=32;
        System.out.println(cel + " stopni Fahrenheita");
    }
}
