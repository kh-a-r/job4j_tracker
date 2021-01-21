package ru.job4j.poly;

public class SpeedTrain implements Vehicle{

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " едет по монорельсу");
    }
}
