package ru.job4j.tracker;

public class Item {
    private int id;
    private String name;

    public Item(){

    }

    public Item(int n){
        
    }
    
    public Item(int n, String text){
        
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
    }
}