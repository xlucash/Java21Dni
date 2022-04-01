package me.xlucash.dzien15;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PrimeWriter {
    public static void main(String[] args) {
        int[] primes = new int[400];
        int numPrimes = 0;
        int candidate = 2;
        while (numPrimes<400)
        {
            if(isPrime(candidate))
            {
                primes[numPrimes] = candidate;
                numPrimes++;
            }
            candidate++;
        }
        try (FileOutputStream file = new FileOutputStream("400pierwszych.dat"); BufferedOutputStream buff = new BufferedOutputStream(file); DataOutputStream data = new DataOutputStream(buff))
        {
            for (int i = 0;i<400;i++)
                data.writeInt(primes[i]);
            data.close();
        } catch (IOException e)
        {
            System.out.println("Błąd -- "+e.toString());
        }
    }

    public static boolean isPrime(int checkNumber)
    {
        double root = Math.sqrt(checkNumber);
        for(int i = 2;i<=root;i++)
        {
            if(checkNumber%i==0)
                return false;
        }
        return true;
    }
}
