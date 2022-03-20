package me.xlucash.dzien6.ecommerce;

public class GiftShop {
    public static void main(String[] args) {
        Storefront store = new Storefront();
        store.addItem("CO1","KUBEK","9.99","150", false);
        store.addItem("CO2","DUŻY KUBEK","12.99","82", true);
        store.addItem("CO3","PODKLADKA","10.49","800", false);
        store.addItem("DO1","KOSZULKA","16.99","90", true);
        store.sort();

        for (int i = 0;i<store.getSize();i++){
            Item show = store.getItem(i);
            System.out.println("\nIdentyfikator elementu: " + show.getId() +
                    "\nNazwa: " + show.getName() +
                    "\nCena detaliczna: " + show.getRetail() + " zl" +
                    "\nCena: " + show.getPrice() + " zl" +
                    "\nSztuk: " + show.getQuantity());
        }
    }
}
