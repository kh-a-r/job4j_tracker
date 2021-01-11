package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findAll() {
        Item[] itemsWithoutNull = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                itemsWithoutNull[size] = items[i];
                size++;
            }
        }
        return itemsWithoutNull = Arrays.copyOf(itemsWithoutNull, size);
    }

    public Item[] findByName(String key) {
        Item[] eqName = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i].getName().equals(key)) {
                eqName[size] = items[i];
                size++;
            }
        }
        return eqName = Arrays.copyOf(items, size);
    }


    public static void main(String[] args) {
    Item[] items = new Item[5];
    Item item2 = new Item("Item2");
    Tracker tracker = new Tracker();
    System.out.println(tracker.add(item2).getId() + " " + tracker.add(item2).getName());
        }
    }

