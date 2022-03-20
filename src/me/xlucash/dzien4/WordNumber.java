package me.xlucash.dzien4;

public class WordNumber {
    public static void main(String[] args) {
        if (args.length>0)
        {
            long num = 0;
            char firstChar = args[0].charAt(0);
            char secondChar = args[0].charAt(1);
            switch (firstChar) {
                case 'o' -> num = 8L;
                case 't' -> num = 3L;
                case 'j' -> num = 1L;
                case 'p' -> num = 5L;
                case 'c' -> num = 4L;
                case 's' -> {
                    if (secondChar == 'z') num = 6L;
                    if (secondChar == 'i') num = 7L;
                }
                case 'd' -> {
                    if (secondChar == 'w') num = 2L;
                    if (secondChar == 'z')
                        if (args[0].charAt(4) == 'w') num = 9L;
                        if (args[0].charAt(4) == 's') num = 10L;
                }
            }
            System.out.println("The number is " + num);
        }
    }
}
