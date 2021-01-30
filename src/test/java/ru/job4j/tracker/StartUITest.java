package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;


public class StartUITest {

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        Input input = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String exp = output.toString();
        String is = "Menu:" + System.lineSeparator() +
                "0. Exit" + System.lineSeparator() +
                "=== See you! ===" + System.lineSeparator();
        assertThat(exp, is(is));
    }


    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        String[] answers = {"0", "Item name", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Item name");
        assertThat(created.getName(), is(expected.getName()));
    }


    @Test
    public void whenReplaceItem() {
    Output output = new StubOutput();
        String[] answers = {"0", "Item name", "1", "1", "New Item", "2"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ReplaceItem(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        Item expected = new Item("New Item");
        assertThat(created.getName(), is(expected.getName()));
    }

   @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted Item"));
        String[] answers = {"0","1", "1"};
       Input input = new StubInput(answers);
       UserAction[] actions = {
               new DeleteItem(output),
               new Exit(output)
       };
       new StartUI(output).init(input, tracker, actions);
       assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenItemIsNotExistsThenFindById() {
        Output output = new StubOutput();
        String[] answers = new String[]{"0", "1", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindById(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().length, is(0));
    }

    @Test
    public void whenFindById() {
        Output output = new StubOutput();
        String[] answers = new String[]{"0", "Item", "1", "1", "2"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new FindById(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item"));
    }

    @Test
    public void whenItemIsNotExistsThenFindByName() {
        Output output = new StubOutput();
        String[] answers = new String[]{"0", "Item", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll().length, is(0));
    }

    @Test
    public void whenFindByName() {
        Output output = new StubOutput();
        String[] answers = new String[]{"0", "q1", "1", "q1", "2"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("q1"));
    }

    @Test
    public void whenNameNullThenFindByName() {
        Output output = new StubOutput();
        String[] answers = new String[]{"0", "", "1", "", "2"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is(""));
    }

    @Test
    public void whenFindAll() {
        Output output = new StubOutput();
        String[] answers = new String[]{"0", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        tracker.add(new Item("Item"));
        UserAction[] actions = {
                new ShowItems(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String is = "Menu:" +
                System.lineSeparator() +
                "0. Show all Items" +
                System.lineSeparator() +
                "1. Exit" + System.lineSeparator() +
                "=== Show all Items ===" + System.lineSeparator() +
                                 "Item{id=1, name='Item'} " +
                System.lineSeparator() +
        "Menu:" + System.lineSeparator() +
                "0. Show all Items" +  System.lineSeparator() +
                "1. Exit" +  System.lineSeparator() +
                "=== See you! ===" + System.lineSeparator();
        assertThat(output.toString(), is(is));
    }
}


