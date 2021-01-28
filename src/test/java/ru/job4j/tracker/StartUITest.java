package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.nullValue;


public class StartUITest {

    @Test
    public void whenExit() {
        Output output = new StubOutput();
        String[] answers = {"0"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Exit()
        };
        new StartUI(output).init(input, tracker, actions);
        String exp = output.toString();
        String is = "Menu:" + System.lineSeparator() +
                "0. Exit";
        assertThat(exp, is(is));
      }
    }


   /* @Test
    public void whenCreateItem() {
        String[] answers = {"0", "Item name", "1"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new Exit()
        };
        new StartUI().init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Item name");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {
        String[] answers = {"0", "Item name", "1", "1", "New Item", "2"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ReplaceItem(),
                new Exit()
        };
        new StartUI().init(input, tracker, actions);
        Item created = tracker.findAll()[0];
        Item expected = new Item("New Item");
        assertThat(created.getName(), is(expected.getName()));
    }

   @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted Item"));
        String[] answers = {"0","1", "1"};
       Input input = new StubInput(answers);
       UserAction[] actions = {
               new DeleteItem(),
               new Exit()
       };
       new StartUI().init(input, tracker, actions);
       assertThat(tracker.findById(item.getId()), is(nullValue()));

    }
}
*/

