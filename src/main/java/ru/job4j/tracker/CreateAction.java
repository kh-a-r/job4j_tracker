package ru.job4j.tracker;

public class CreateAction implements UserAction {

    private final Output output;

    public CreateAction(Output out) {
        output = out;
    }

    @Override
    public String name() {
        return "Create";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        System.out.println(tracker.add(item));
        return true;
    }
}
