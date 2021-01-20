package ru.job4j.poly;

import java.util.Scanner;

public class Bus implements Transport{


    @Override
    public void run() {
       this.passenger(13);
    }

    @Override
    public void passenger(int countOfPassenger) {
        if (countOfPassenger == 20) {
            System.out.println("Автобус полный, можно ехать");
        } else if (countOfPassenger < 20) {
            System.out.println("Ждем еще");
        }
    }

    @Override
    public double fuel(int liter) {
        Scanner scanner = new Scanner(System.in);
        double price = scanner.nextDouble();
        return liter * price;
    }
}
