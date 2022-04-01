package me.xlucash.dzien8;

import java.util.HashMap;

public class ComicBooks {
    public ComicBooks()
    {

    }

    public static void main(String[] args) {
        HashMap quality = new HashMap();
        float price1 = 3.00F;
        quality.put(BookCondition.NOWY, price1);
        float price2 = 2.00F;
        quality.put(BookCondition.PRAWIE_NOWY,price2);
        float price3 = 1.50F;
        quality.put(BookCondition.BARDZO_DOBRY,price3);
        float price4 = 1.00F;
        quality.put(BookCondition.DOBRY,price4);
        float price5 = 0.50F;
        quality.put(BookCondition.SREDNI,price5);
        float price6 = 0.25F;
        quality.put(BookCondition.SLABY,price6);
        float price7 = 5.00F;
        quality.put(BookCondition.CALKOWICIE_NOWY,price7);
        float price8 = 0.10F;
        quality.put(BookCondition.BEZ_OKLADKI,price8);

        Comic[] comix = new Comic[3];
        comix[0] = new Comic("Wspanialy Spider-Man", "1A", BookCondition.BARDZO_DOBRY,12_000.00F);
        comix[0].setPrice((Float) quality.get(comix[0].condition));
        comix[1] = new Comic("Niesamowity Hulk", "181", BookCondition.PRAWIE_NOWY, 680.00F);
        comix[1].setPrice( (Float) quality.get(comix[1].condition) );
        comix[2] = new Comic("Cerebus", "1A", BookCondition.SREDNI, 190.00F);
        comix[2].setPrice( (Float) quality.get(comix[2].condition) );
        for(int i = 0;i<comix.length;i++)
        {
            System.out.println("Tytul: " + comix[i].title);
            System.out.println("Numer: " + comix[i].issueNumber);
            System.out.println("Stan: " + comix[i].condition);
            System.out.println("Cena: " + comix[i].price + " zl\n");
        }

    }
}

class Comic{
    String title;
    String issueNumber;
    BookCondition condition;
    float basePrice;
    float price;

    Comic(String inTitle, String inIssueNumber, BookCondition inCondition, float inBasePrice){
        title = inTitle;
        issueNumber = inIssueNumber;
        condition = inCondition;
        basePrice = inBasePrice;
    }

    void setPrice(float factor){
        price = basePrice*factor;
    }
}

enum BookCondition {
    NOWY,
    PRAWIE_NOWY,
    BARDZO_DOBRY,
    DOBRY,
    SREDNI,
    SLABY,
    CALKOWICIE_NOWY,
    BEZ_OKLADKI,
}
