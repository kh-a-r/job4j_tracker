package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;


public class StartIUTest {

        @Test
    public void whenAddItem() {
            String[] answers = {"Fix PC"};
            Input input = new StubInput(answers);
            Tracker tracker = new Tracker();
            StartIU.createItem(input, tracker);
            Item created = tracker.findAll()[0];
            Item expected = new Item("Fix PC");
            assertThat(created.getName(), is(expected.getName()));
        }

    @Test
    public void whenEditItem() {
            Tracker tracker = new Tracker();
            Item item = new Item("new Item");
            tracker.add(item);
            String[] answers = {String.valueOf(item.getId()), "replace Item"}; //тут массив содержит строки, поэтму число удобно представлено чеерз строку, чтобы все данные по одному объекту хранить в одном массив
            StartIU.editItem(new StubInput(answers), tracker);
            Item replaced = tracker.findById(item.getId());
            assertThat(replaced.getName(), is("replace Item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("new Item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId()), "replace Item"}; //тут массив содержит строки, поэтму число удобно представлено чеерз строку, чтобы все данные по одному объекту хранить в одном массив
        StartIU.deleteItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced, is(nullValue()));

    }
}


