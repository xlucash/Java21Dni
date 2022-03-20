package me.xlucash.dzien6.ecommerce;

public class Item implements Comparable{
    private String id;
    private String name;
    private double retail;
    private int quantity;
    private double price;
    private boolean noDiscount;

    @Override
    public int compareTo(Object o) {
        Item temp = (Item) o;
        if(this.price<temp.price)
        {
            return 1;
        } else if (this.price>temp.price)
        {
            return -1;
        } else return 0;
    }

    Item(String idIn, String nameIn, String retailIn, String qIn, boolean discount)
    {
        id = idIn;
        name = nameIn;
        retail = Double.parseDouble(retailIn);
        quantity = Integer.parseInt(qIn);
        noDiscount = discount;

        if(quantity>400)
            price = retail*0.50;
        else if (quantity>200)
            price = retail*0.60;
        else
            price = retail*0.70;
        price = Math.floor(price*100+0.5)/100;
        if(noDiscount == true)
            price = retail;
    }
    public String getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public double getRetail()
    {
        return retail;
    }
    public int getQuantity()
    {
        return quantity;
    }
    public double getPrice()
    {
        return price;
    }
}
