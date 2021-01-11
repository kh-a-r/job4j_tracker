package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartIU {

    public static void main(String[] args) {
        Item item = new Item("Item3");
        Item item1 = new Item("Item1");
        Item item2 = new Item("Item2");
        Tracker tracker = new Tracker();
       // LocalDateTime date = item.getCreated();
       // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
       // String currentDateTimeForm = date.format(formatter);
       // System.out.println(currentDateTimeForm);
        Item[] names = new Item[]{item, null, item1, item2, null};
       // Item[] names = new Item[4];
        Item rsl = tracker.add(item);
        Item rsl1 = tracker.add(item1);
        Item[] arrNoNull = tracker.findAll();
      //  Item[] eqName = tracker.findByName( "Item3");
        Item findItem = tracker.findById(1);

        System.out.println(rsl.getName() + " #" + rsl.getId());
        for (int i = 0; i < arrNoNull.length; i++) {
            System.out.print(arrNoNull[i].getName() + " ");
          //  System.out.println(eqName[i].getName());
        }
        System.out.println();
        System.out.print(arrNoNull.length);
        System.out.println();
        System.out.println(names.length);
        System.out.println();
        System.out.println("Найдена заявка " + findItem.getName());
    }
}
