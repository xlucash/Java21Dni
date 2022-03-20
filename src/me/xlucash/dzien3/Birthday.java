package me.xlucash.dzien3;

import java.util.StringTokenizer;

public class Birthday {
    public static void main(String[] args) {
        StringTokenizer str1;
        String dateBirth = "29/04/2016";

        //pierwszy sposob
        str1 = new StringTokenizer(dateBirth,"/");
        System.out.println("Dzień: "+str1.nextToken());
        System.out.println("Miesiąc: "+str1.nextToken());
        System.out.println("Rok: "+str1.nextToken());

        //drugi sposob
        String day = dateBirth.substring(0,2);
        String month = dateBirth.substring(3,5);
        String year = dateBirth.substring(6,10);
        System.out.println("Dzień: "+day);
        System.out.println("Miesiąc: "+month);
        System.out.println("Rok: "+year);
    }
}
