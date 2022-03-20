package me.xlucash.dzien1;

public class MarsRobot {
    String status;
    int speed;
    float temperature;

    void checkTemperature()
    {
        if(temperature< -80){
            status = "powrot do domu";
            speed = 5;
        }
    }
    void showAllAttributes()
    {
        System.out.println("Status: "+status);
        System.out.println("Predkosc: "+speed);
        System.out.println("Temperatura: "+temperature);
    }
}
