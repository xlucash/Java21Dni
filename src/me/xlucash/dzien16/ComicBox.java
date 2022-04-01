package me.xlucash.dzien16;

import java.util.HashMap;

public class ComicBox {
    class InnerComic {
        String title;
        String issueNumber;
        BookCondition condition;
        float basePrice;
        float price;

        InnerComic(String inTitle, String inIssueNumber, BookCondition inCondition, float inBasePrice){
            title = inTitle;
            issueNumber = inIssueNumber;
            condition = inCondition;
            basePrice = inBasePrice;
        }

        void setPrice(float factor){
            price = basePrice*factor;
        }
    }


    public ComicBox()
    {
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

        InnerComic[] comix = new InnerComic[3];
        comix[0] = new InnerComic("Wspanialy Spider-Man", "1A", BookCondition.BARDZO_DOBRY,12_000.00F);
        comix[0].setPrice((Float) quality.get(comix[0].condition));
        comix[1] = new InnerComic("Niesamowity Hulk", "181", BookCondition.PRAWIE_NOWY, 680.00F);
        comix[1].setPrice( (Float) quality.get(comix[1].condition) );
        comix[2] = new InnerComic("Cerebus", "1A", BookCondition.SREDNI, 190.00F);
        comix[2].setPrice( (Float) quality.get(comix[2].condition) );
        for (InnerComic innerComic : comix) {
            System.out.println("Tytul: " + innerComic.title);
            System.out.println("Numer: " + innerComic.issueNumber);
            System.out.println("Stan: " + innerComic.condition);
            System.out.println("Cena: " + innerComic.price + " zl\n");
        }
    }

    public static void main(String[] args) {
        new ComicBox();
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
