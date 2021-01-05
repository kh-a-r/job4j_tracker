package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartIU {

    public static void main(String[] args) {
        Item item = new Item(2);
        LocalDateTime date = item.getCreated();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String currentDateTimeForm = date.format(formatter);
        System.out.println(currentDateTimeForm);
    }
}
