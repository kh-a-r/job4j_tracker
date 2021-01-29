package ru.job4j.tracker;

public class FindById implements UserAction{
    private final Output output;

    public FindById(Output output) {
        this.output = output;
    }


    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Find item by Id ===");
        int id = input.askInt("Input Item's id");
        Item rsl = tracker.findById(id);
        if (rsl == null) {
         output.println("Item with id " + id + " is not found");
        } else {
           output.println(rsl);
        }
        return true;
    }
}

