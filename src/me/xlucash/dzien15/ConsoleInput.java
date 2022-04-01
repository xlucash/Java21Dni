package me.xlucash.dzien15;

import java.io.BufferedInputStream;
import java.io.IOException;

public class ConsoleInput {
    public static String readLine() {
        StringBuilder response = new StringBuilder();
        try (BufferedInputStream buff = new BufferedInputStream(System.in))
        {
            int in;
            char inChar;
            do {
                in = buff.read();
                inChar = (char) in;
                if ((in!=-1)&(in!='\n')&(in!='\r'))
                {
                    response.append(inChar);
                }
            } while ((in!=-1)&(in!='\n')&(in!='\r'));
            buff.close();
            return response.toString();
        } catch (IOException e)
        {
            System.out.println("Wyjątek: "+e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.print("\nJak się nazywasz? ");
        String input = ConsoleInput.readLine();
        System.out.println("\nWitaj, "+input);
    }
}
