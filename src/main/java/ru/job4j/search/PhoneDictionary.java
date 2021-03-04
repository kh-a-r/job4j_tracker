package ru.job4j.search;

import java.util.ArrayList;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<Person>();
        for (int i = 0; i < persons.size(); i++) {
            if (persons.get(i).getName().contains(key) ||
                    persons.get(i).getSurname().contains(key) ||
                    persons.get(i).getPhone().contains(key) ||
                    persons.get(i).getAddress().contains(key)) {
                result.add(persons.get(i));
            }
        }
        return result;
    }
}

 //   там нужен цикл,
 //   в котором мы будем проверять список пользователей и проверять у него каждое
 //   поле на наличие в нем передаваемого
  //      key и только в этом случае добавлять в результирующий список найденного пользователя и поле