package ru.job4j.tracker;

public class ShowItems implements UserAction{
    private final Output output;

    public ShowItems(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Show all Items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Show all Items ===");
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            output.println(items[i] + " ");
        }
        return true;
    }
}
