package ru.job4j.tracker;

public class ReplaceItem implements UserAction {

    private final Output output;
    public ReplaceItem(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Update Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Update Item ===");
        int id = input.askInt("Enter id");
        String name = input.askStr("Enter a new name of Item: ");
        Item item = new Item(name);
        boolean rsl = tracker.replace(id, item);
        if (rsl) {
            output.println(("Item " + id + " is edited"));
            output.println(item);
        } else {
            output.println("Item " + id + " is not found");
        }
        return true;
    }
}
