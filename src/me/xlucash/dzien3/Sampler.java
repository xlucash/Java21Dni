package me.xlucash.dzien3;

public class Sampler {
    public static void main(String[] args) {
        Sample sample = new Sample();
        sample.weight=80;
        sample.depth=15;
        sample.height=180;
        System.out.println("Wysokość: " + sample.height);
        System.out.println("Szerokość: " + sample.weight);
        System.out.println("Głębokość: " + sample.depth);
    }
}
