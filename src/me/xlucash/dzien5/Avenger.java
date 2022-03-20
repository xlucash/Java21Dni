package me.xlucash.dzien5;

public class Avenger {
    public static void main(String[] args) {
        int sum = 0;


        if(args.length>0)
        {
            for (String arg : args) sum += Integer.parseInt(arg);
            System.out.println("Suma wynosi: "+sum);
            System.out.println("Srednia wynosi: "+(float)sum/args.length);

        }
    }
}
