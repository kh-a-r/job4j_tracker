package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item {
    private int id;
    private String name;

    Item() {
    //info();
    };

    public Item(int number) {
        id = number;
       // info();
    }

    public Item(int number, String name) {
        id = number;
        this.name = name;
       // info();
    }

    public void info() {
        System.out.println(getId() + ", " + getName());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        Item item = new Item();
        item.name = "Заявка";
        item.id = 1;
        item.info();
    }

}
