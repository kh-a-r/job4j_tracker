package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item {
    private int id;
    private String name;
    LocalDateTime created = LocalDateTime.now();

    public Item(){

    }

    public Item(int n){
        this.id = n;
    }
    
    public Item(int n, String text){
        this.id = n;
        this.name = text;
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
        Item item1 = new Item(2);
        Item item2 = new Item(5, "Cat");
        System.out.println(item2.getCreated());
    }

       public LocalDateTime getCreated() {
        return created;
    }
}
