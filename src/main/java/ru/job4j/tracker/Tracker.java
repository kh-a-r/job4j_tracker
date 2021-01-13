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
                return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] eqName = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if ( items[i].getName().equals(key)) {
                eqName[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(eqName, count);
    }

    public static void main(String[] args) {
        Item item = new Item();
        item.setName("Item");
        Item item1 = new Item();
         item1.setName("Item1");
       // Item item2 = new Item();

        Tracker tracker = new Tracker();
       /* LocalDateTime date = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeForm = date.format(formatter);
        System.out.println(currentDateTimeForm); */

        Item rsl = tracker.add(item);
        Item rsl1 = tracker.add(item1);
       // Item rsl2 = tracker.add(item2);



        Item[] findString = tracker.findByName("Item");
        for (int i = 0; i < findString.length; i++) {
            System.out.println(findString[i].getName());
        }



    }



    }

