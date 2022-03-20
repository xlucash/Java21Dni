package me.xlucash.dzien1;

public class MarsApplication {
    public static void main(String[] args) {
        MarsRobot spirit = new MarsRobot();
        spirit.status= "eksploracja";
        spirit.speed = 2;
        spirit.temperature = -60;

        spirit.showAllAttributes();
        System.out.println("Zwiekszenie predkosci do 3");
        spirit.speed=3;
        spirit.showAllAttributes();
        System.out.println("Zmiana temperatury na -90");
        spirit.temperature = -90;
        spirit.showAllAttributes();
        System.out.println("Sprawdzenie temperatury");
        spirit.checkTemperature();
        spirit.showAllAttributes();

        MarsRobot opportunity = new MarsRobot();
        opportunity.status= "poruszanie sie";
        opportunity.speed = 3;
        opportunity.temperature = -50;
        opportunity.showAllAttributes();
    }
}
