package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;

public final class Tracker {
    private static Tracker instance = null;

    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    private Tracker(){

    }

public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
}
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
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] eqName = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (items[i].getName().equals(key)) {
                eqName[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(eqName, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int i = 0; i < size; i++) {
            if (items[i].getId() == id) {
                rsl = i;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        boolean isReplace = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            isReplace = true;
        }
        return isReplace;
    }

    public boolean delete(int id) {
        boolean rsl = false;
        int  index = indexOf(id);
        if (index != -1) {
            int start = index + 1;
            int lenght = size - index;
            System.arraycopy(items, start, items, index, lenght);
            items[size - 1] = null;
            size--;
            rsl = true;
        }
        return rsl;
    }

}

