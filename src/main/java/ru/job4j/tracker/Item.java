package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.util.StringJoiner;

public class Item {
    private int id;
    private String name;

    Item() {
    };

    public Item(int number) {
        id = number;
    }

    public Item(int number, String name) {
        id = number;
        this.name = name;
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

   /* @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }*/

    @Override
    public String toString() {
        return new StringJoiner(", ")
                .add("id=" + id)
                .add("name='" + name + "'")
                .toString();
    }
}
