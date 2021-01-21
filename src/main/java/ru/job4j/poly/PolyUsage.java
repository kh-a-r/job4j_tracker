package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle train = new Train();
        Vehicle aircraft = new Airplane();
        Vehicle truck = new Truck();
        Vehicle speedTrain = new SpeedTrain();

        Vehicle[] vehicles = new Vehicle[] {train, aircraft, truck, speedTrain};
        for (Vehicle v : vehicles) {
            v.move();
        }
    }
}
