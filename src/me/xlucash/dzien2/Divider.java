package me.xlucash.dzien2;

public class Divider {
    public static void main(String[] args) {
        double numberOne = 20;
        double numberTwo = 3;
        double result = numberOne/numberTwo;
        double remainder = numberOne%numberTwo;
        System.out.println("Dzielenie 2 liczb: " + numberOne + " "+ numberTwo);
        System.out.println("Wynik\tReszta");
        System.out.println(result+"\t"+remainder);

    }
}
