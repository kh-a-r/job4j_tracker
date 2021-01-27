package ru.job4j.tracker;

public class FindByName implements UserAction{
    @Override
    public String name() {
        return "=== Find item by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String key = input.askStr("Input Item's name");
        Item[] rsl = tracker.findByName(key);
        if (rsl.length == 0) {
            System.out.println("Item with name " + key + " is not found");
        } else {
            for (int i = 0; i < rsl.length; i++) {
                System.out.println(rsl[i] + " ");
            }
        }
        return true;
    }
}
