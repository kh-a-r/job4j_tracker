package ru.job4j.search;

import org.junit.Test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import static org.hamcrest.core.Is.is;


public class PhoneDictionaryTest {

    @Test
           public void whenFindByName() {
            PhoneDictionary phones = new PhoneDictionary();
            phones.add(
                    new Person("Petr", "Arsentev", "534872", "Bryansk")
            );
            ArrayList<Person> persons = phones.find("Petr");
            assertThat(phones.persons.get(0).getSurname(), is("Arsentev"));
        }
    }
