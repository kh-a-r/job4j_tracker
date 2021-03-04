package ru.job4j.search;

import java.util.ArrayList;

public class Search {

    public static void main(String[] args) {

        PhoneDictionary phones = new PhoneDictionary();
        phones.persons.add(
                new Person("Petr", "Arsentev", "534872", "Bryansk")
        );
        ArrayList<Person> persons = phones.find("Petr");
        System.out.println(phones.persons.size());
    }
}
