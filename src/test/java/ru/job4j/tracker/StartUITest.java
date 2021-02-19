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
        Tracker tracker = Tracker.getInstance();
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
        String[] answers = {"0", "q1", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = Tracker.getInstance();
        UserAction[] actions = {
                new CreateAction(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String is = "Menu:" + System.lineSeparator() +
                "0. Create" + System.lineSeparator() +
                "1. Exit" +   System.lineSeparator() +
                "=== Create a new Item ==="  + System.lineSeparator() + "Item{id=1, name='q1'}"
                + System.lineSeparator() +
                "Menu:"  + System.lineSeparator() +
                "0. Create"  + System.lineSeparator() +
                "1. Exit"  + System.lineSeparator() +
                "=== See you! ==="  + System.lineSeparator();
        assertThat(output.toString(), is(is));
    }


    @Test
    public void whenReplaceItem() {
    Output output = new StubOutput();
        String[] answers = {"0", "q1", "1", "1", "New Item", "2"};
        Input input = new StubInput(answers);
        Tracker tracker = Tracker.getInstance();
        UserAction[] actions = {
                new CreateAction(output),
                new ReplaceItem(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String is = "Menu:" + System.lineSeparator() +
                "0. Create" + System.lineSeparator() +
                "1. Update Item" + System.lineSeparator() +
                "2. Exit" +   System.lineSeparator() +
                "=== Create a new Item ==="  + System.lineSeparator() + "Item{id=1, name='q1'}"
                + System.lineSeparator() +
                "Menu:"  + System.lineSeparator() +
                "0. Create"  + System.lineSeparator() +
                "1. Update Item"  + System.lineSeparator() +
                "2. Exit"  + System.lineSeparator() +
                "=== Update Item ==="  + System.lineSeparator() +
                "Item 1 is edited" + System.lineSeparator() +
                "Item{id=1, name='New Item'}"  + System.lineSeparator() +
                "Menu:"  + System.lineSeparator() +
                "0. Create" + System.lineSeparator() +
                "1. Update Item"  + System.lineSeparator() +
                "2. Exit"
                + System.lineSeparator() + "=== See you! ==="  + System.lineSeparator();
        assertThat(output.toString(), is(is));
    }

   @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = Tracker.getInstance();
        String[] answers = {"0","1", "1"};
       Input input = new StubInput(answers);
       UserAction[] actions = {
               new DeleteItem(output),
               new Exit(output)
       };
       new StartUI(output).init(input, tracker, actions);
       String is = "Menu:" + System.lineSeparator() +
               "0. Delete Item" + System.lineSeparator() +
               "1. Exit" +   System.lineSeparator() +
               "=== Delete Item ==="  + System.lineSeparator() +
               "Item 1 is not found"  + System.lineSeparator() +
               "Menu:"  + System.lineSeparator() +
               "0. Delete Item"  + System.lineSeparator() +
               "1. Exit"
               + System.lineSeparator() + "=== See you! ==="  + System.lineSeparator();
       assertThat(output.toString(), is(is));
    }

    @Test
    public void whenItemIsNotExistsThenFindById() {
        Output output = new StubOutput();
        String[] answers = new String[]{"0", "1", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = Tracker.getInstance();
        UserAction[] actions = {
                new FindById(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String is = "Menu:" + System.lineSeparator() +
                "0. Find item by Id" + System.lineSeparator() +
                "1. Exit" +   System.lineSeparator() +
                    "=== Find item by Id ==="  + System.lineSeparator() +
                "Item with id 1 is not found"  + System.lineSeparator() +
                "Menu:"  + System.lineSeparator() +
                "0. Find item by Id"  + System.lineSeparator() +
                "1. Exit"
                + System.lineSeparator() + "=== See you! ==="  + System.lineSeparator();
        assertThat(output.toString(), is(is));
    }

    @Test
    public void whenFindById() {
        Output output = new StubOutput();
        String[] answers = new String[]{"0", "q1", "1", "1", "2"};
        Input input = new StubInput(answers);
        Tracker tracker = Tracker.getInstance();
        UserAction[] actions = {
                new CreateAction(output),
                new FindById(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String is = "Menu:" + System.lineSeparator() +
                "0. Create" + System.lineSeparator() +
                "1. Find item by Id" + System.lineSeparator() +
                "2. Exit" +   System.lineSeparator() +
                "=== Create a new Item ==="  + System.lineSeparator() + "Item{id=1, name='q1'}"
                + System.lineSeparator() +
                "Menu:"  + System.lineSeparator() +
                "0. Create"  + System.lineSeparator() +
                "1. Find item by Id"  + System.lineSeparator() +
                "2. Exit"  + System.lineSeparator() +
                "=== Find item by Id ==="  + System.lineSeparator() +
                "Item{id=1, name='q1'}"  + System.lineSeparator() +
                "Menu:"  + System.lineSeparator() +
                "0. Create" + System.lineSeparator() +
                "1. Find item by Id"  + System.lineSeparator() +
                "2. Exit"
                + System.lineSeparator() + "=== See you! ==="  + System.lineSeparator();
        assertThat(output.toString(), is(is));
    }

    @Test
    public void whenItemIsNotExistsThenFindByName() {
        Output output = new StubOutput();
        String[] answers = new String[]{"0", "Item", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = Tracker.getInstance();
        UserAction[] actions = {
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String is = "Menu:" + System.lineSeparator() +
                "0. Find item by name" + System.lineSeparator() +
                "1. Exit" +   System.lineSeparator() +
                "=== Find item by name ==="  + System.lineSeparator() +
                "Item with name Item is not found"  + System.lineSeparator() +
                "Menu:"  + System.lineSeparator() +
                "0. Find item by name"  + System.lineSeparator() +
                "1. Exit"
                + System.lineSeparator() + "=== See you! ==="  + System.lineSeparator();
        assertThat(output.toString(), is(is));
    }

    @Test
    public void whenFindByName() {
        Output output = new StubOutput();
        String[] answers = new String[]{"0", "q1", "1", "q1", "2"};
        Input input = new StubInput(answers);
        Tracker tracker = Tracker.getInstance();
        UserAction[] actions = {
                new CreateAction(output),
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String is = "Menu:" + System.lineSeparator() +
                "0. Create" + System.lineSeparator() +
                "1. Find item by name" + System.lineSeparator() +
                "2. Exit" +   System.lineSeparator() +
                "=== Create a new Item ==="  + System.lineSeparator() + "Item{id=1, name='q1'}"
                + System.lineSeparator() +
                "Menu:"  + System.lineSeparator() +
                "0. Create"  + System.lineSeparator() +
                "1. Find item by name"  + System.lineSeparator() +
                "2. Exit"  + System.lineSeparator() +
                "=== Find item by name ==="  + System.lineSeparator() +
                "Item{id=1, name='q1'} "  + System.lineSeparator() +
                "Menu:"  + System.lineSeparator() +
                "0. Create" + System.lineSeparator() +
                "1. Find item by name"  + System.lineSeparator() +
                "2. Exit"
                + System.lineSeparator() + "=== See you! ==="  + System.lineSeparator();
        assertThat(output.toString(), is(is));
    }

    @Test
    public void whenNameNullThenFindByName() {
        Output output = new StubOutput();
        String[] answers = new String[]{"0", "", "1", "", "2"};
        Input input = new StubInput(answers);
        Tracker tracker = Tracker.getInstance();
        UserAction[] actions = {
                new CreateAction(output),
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String is = "Menu:" + System.lineSeparator() +
                "0. Create" + System.lineSeparator() +
                "1. Find item by name" + System.lineSeparator() +
                "2. Exit" +   System.lineSeparator() +
        "=== Create a new Item ==="  + System.lineSeparator() + "Item{id=1, name=''}"
                + System.lineSeparator() +
                "Menu:"  + System.lineSeparator() +
                "0. Create"  + System.lineSeparator() +
                "1. Find item by name"  + System.lineSeparator() +
                "2. Exit"  + System.lineSeparator() +
        "=== Find item by name ==="  + System.lineSeparator() +
                "Item{id=1, name=''} "  + System.lineSeparator() +
                "Menu:"  + System.lineSeparator() +
        "0. Create" + System.lineSeparator() +
        "1. Find item by name"  + System.lineSeparator() +
                "2. Exit"
                + System.lineSeparator() + "=== See you! ==="  + System.lineSeparator();
        assertThat(output.toString(), is(is));
    }

    @Test
    public void whenFindAll() {
        Output output = new StubOutput();
        String[] answers = new String[]{"0", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = Tracker.getInstance();
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

    @Test
    public void whenInvalidExit() {
    Output output = new StubOutput();
    Input in = new StubInput(
            new String[] {"1", "0"}
    );
    Tracker tracker = Tracker.getInstance();
    UserAction[] actions = {
            new Exit(output)
    };
    new StartUI(output).init(in, tracker, actions);
    assertThat(output.toString(), is(
            String.format(
            "Menu:%n"
            + "0. Exit%n"
            + "Wrong input, you can select: 0 .. 0%n"
            + "Menu:%n"
            + "0. Exit%n"
            + "=== See you! ===%n"
            )));
}
}


