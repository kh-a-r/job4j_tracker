package ru.job4j.tracker;

public class DeleteItem implements UserAction {

    private final Output output;

    public DeleteItem(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Delete Item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Delete Item ===");
        int id = input.askInt("Enter id: ");
        boolean rsl = tracker.delete(id);
        if (rsl) {
            output.println("Item " + id + " is deleted");
        } else {
            output.println("Item " + id + " is not found");
        }
        return true;
    }
}
