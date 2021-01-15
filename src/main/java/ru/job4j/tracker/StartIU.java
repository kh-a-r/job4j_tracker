package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartIU {

    public static void main(String[] args) {

        Item item = new Item();
        item.setName("Item");
        Item item1 = new Item();
        item1.setName("Item1");
        Item item2 = new Item();

        Tracker tracker = new Tracker();
       /* LocalDateTime date = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeForm = date.format(formatter);
        System.out.println(currentDateTimeForm); */

        Item rsl = tracker.add(item); // добавление заявки
        Item rsl1 = tracker.add(item1);
        Item rsl2 = tracker.add(item2);
        System.out.println("Название и номер заявки " + rsl.getName() + " #" + rsl.getId());
        System.out.println(("Название и номер заявки " + rsl1.getName() + " #" + rsl1.getId()));
        System.out.println(("Название и номер заявки " + rsl2.getName() + " #" + rsl2.getId()));
        Item findItem = tracker.findById(2); // поиск по номеру заявки
        System.out.println("Найдена заявка " + findItem.getName() + "," +  " #" + findItem.getId());
        Item itemForReplace = new Item();
        itemForReplace.setName("Change");
        System.out.println(tracker.replace(2,itemForReplace));

        //System.out.println(item);

        Item[] noNullarr = tracker.findAllForDelete();
        for (int i = 0; i < noNullarr.length; i++) {
            System.out.println(noNullarr[i] + " ");
        }

        Item[] findAllEl = tracker.findAll();
        for (int i = 0; i < findAllEl.length; i++) {
            System.out.println(findAllEl[i] +" ");
        }
    }
}
