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

    public Item[] findAllForDelete() {
        Item[] noNull = new Item[items.length];
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                noNull[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(noNull, count);
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

    //поиска индекс элемента массива по ид заявки
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
        int index = indexOf(id); // найдем индекс элемента массива по ид заявки
        item.setId(id); // присвоим номер заявке, номер добавляемой заявки == номеру прежней заявки
        items[index] = item; // запишем в ячейку с найденным индексом новую заявку item с прежним id
        return index != -1 ? true : false;
    }
}

