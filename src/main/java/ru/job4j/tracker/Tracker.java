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
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null) {
                itemsWithoutNull[count] = items[i];
                count++;
            }
        }
        return Arrays.copyOf(itemsWithoutNull, count);
    }

    public Item[] findByName(String key) {
        Item[] eqName = new Item[items.length];
        int size = 0;
        for (int i = 0; i < items.length; i++) {
            if ( items[i].getName().equals(key)) {
                eqName[size] = items[i];
                size++;
            }
        }
        return eqName = Arrays.copyOf(eqName, size);
    }

    public static void main(String[] args) {
        Item item = new Item();
        item.setName("Item");
        Item item1 = new Item();
        // item1.setName("Item1");
        Item item2 = new Item();
        item2.setName("Item2");
        Tracker tracker = new Tracker();
       /* LocalDateTime date = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeForm = date.format(formatter);
        System.out.println(currentDateTimeForm); */

        Item rsl = tracker.add(item);
        Item rsl1 = tracker.add(item1);
        Item rsl2 = tracker.add(item2);

        Item[] noNullArray = tracker.findAll();
        for (int i = 0; i < noNullArray.length; i++) {
            System.out.print(noNullArray[i].getName() + " ");
        }
        System.out.println();
        Item[] addArray = tracker.items;
        for (int i = 0; i < addArray.length; i++) {
            System.out.print(addArray[i].getName() + " ");
        }

    }



    }

