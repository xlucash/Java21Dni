package me.xlucash.dzien3;

public class StringChecker {
    public static void main(String[] args) {
        String str = "Lannister zawsze spłaca swoje długi.";
        System.out.println("Tekst to: "+str);
        System.out.println("Długość tekstu: "+str.length());
        System.out.println("Znak na pozycji 6: "+str.charAt(6));
        System.out.println("Fragment od znaku 10 do 16: "+str.substring(10,16));
        System.out.println("Indeks pierwszej litery 't': "+str.indexOf('t'));
        System.out.println("Indeks początku podtekstu: "+"\"długi\": "+str.indexOf("długi"));
        System.out.println("Tekst napisany wielkimi literami: "+str.toUpperCase());

    }
}
