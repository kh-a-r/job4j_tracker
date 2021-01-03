package ru.job4j.tracker;

public class JSONReport {
    public String generate(String name, String body) {
         return
        "name : " + name +
                System.lineSeparator() +
               "body : " + body;
    }
}
