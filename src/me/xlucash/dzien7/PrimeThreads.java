package me.xlucash.dzien7;

public class PrimeThreads {
    public static void main(String[] arguments) {
        try {
            PrimeFinder[] finder = new PrimeFinder[arguments.length];
            for (int i = 0; i < arguments.length; i++) {
                long count = Long.parseLong(arguments[i]);
                finder[i] = new PrimeFinder(count);
                System.out.println("Szukam liczby pierwszej " + count);
            }
            boolean complete = false;
            while (!complete) {
                complete = true;
                for (PrimeFinder primeFinder : finder) {
                    if (!primeFinder.finished)
                        complete = false;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ie) {

                }
            }
            for (int j = 0; j < finder.length; j++) {
                System.out.println("Liczba pierwsza " + finder[j].target
                        + " to " + finder[j].prime);
            }
        } catch (NumberFormatException | NegativeNumberException nfe) {
            System.out.println("Błąd: " + nfe.getMessage());
        }
    }
}