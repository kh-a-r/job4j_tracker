package ru.job4j.tracker;

public class FindByName implements UserAction{
    private final Output output;

    public FindByName(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Find item by name ===");
        String key = input.askStr("Input Item's name");
        Item[] rsl = tracker.findByName(key);
        if (rsl.length == 0) {
            output.println("Item with name " + key + " is not found");
        } else {
            for (int i = 0; i < rsl.length; i++) {
                output.println(rsl[i] + " ");
            }
        }
        return true;
    }
}
