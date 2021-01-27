package ru.job4j.tracker;

public class ReplaceItem implements UserAction {
    @Override
    public String name() {
        return "=== Update Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id");
        String name = input.askStr("Enter a new name of Item: ");
        Item item = new Item(name);
        boolean rsl = tracker.replace(id, item);
        if (rsl) {
            System.out.println("Item " + id + " is edited");
        } else {
            System.out.println("Item " + id + " is not found");
        }
        return true;
    }
}
