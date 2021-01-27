package ru.job4j.tracker;

public class DeleteItem implements UserAction {

    @Override
    public String name() {
        return "=== Delete Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        boolean rsl = tracker.delete(id);
        if (rsl) {
            System.out.println("Item " + id + " is deleted");
        } else {
            System.out.println("Item " + id + " is not found");
        }
        return true;
    }
}
