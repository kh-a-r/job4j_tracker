package ru.job4j.tracker;

public class FindById implements UserAction{

    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Input Item's id");
        Item rsl = tracker.findById(id);
        if (rsl == null) {
            System.out.println("Item with id " + id + " is not found");
        } else {
            System.out.println(rsl);
        }
        return true;
    }
}

