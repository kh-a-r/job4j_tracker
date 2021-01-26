package ru.job4j.tracker;


public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        Item rsl = tracker.add(item);
        System.out.println(rsl);
    }

    public static void showItems(Input input, Tracker tracker) {
        System.out.println("=== Show all Items ===");
        Item[] items = tracker.findAll();
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i] + " ");
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println("=== Update Item ===");
        int id = input.askInt("Enter id");
        String name = input.askStr("Enter a new name of Item: ");
        Item item = new Item(name);
        boolean rsl = tracker.replace(id, item);
        if (rsl) {
            System.out.println("Item " + id + " is edited");
        } else {
            System.out.println("Item " + id + " is not found");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete Item ===");
        int id = input.askInt("Input Item's id");
        boolean rsl = tracker.delete(id);
        if (rsl) {
            System.out.println("Item " + id + " is deleted");
        } else {
            System.out.println("Item " + id + " is not found");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        int id = input.askInt("Input Item's id");
        Item rsl = tracker.findById(id);
        if (rsl == null) {
            System.out.println("Item with id " + id + " is not found");
        } else {
            System.out.println(rsl);
        }
    }

    public static void findByName (Input input, Tracker tracker) {
        System.out.println("=== Find item by name ===");
        String key = input.askStr("Input Item's name");
        Item[] rsl = tracker.findByName(key);
        if (rsl.length == 0) {
            System.out.println("Item with name " + key + " is not found");
        } else {
            for (int i = 0; i < rsl.length; i++) {
                System.out.println(rsl[i] + " ");
            }
        }
    }

        public void init (Input input, Tracker tracker){
            boolean run = true;
            while (run) {
                this.showMenu();
                int select = input.askInt("Select: ");

                if (select == 0) {
                    StartUI.createItem(input, tracker);
                } else if (select == 1) {
                    StartUI.showItems(input, tracker);
                } else if (select == 2) {
                    StartUI.editItem(input, tracker);
                } else if (select == 3) {
                    StartUI.deleteItem(input, tracker);
                } else if (select == 4) {
                    StartUI.findById(input, tracker);
                } else if (select == 5) {
                    StartUI.findByName(input, tracker);
                } else if (select == 6) {
                    System.out.println("=== Exit.See you. ===");
                    run = false;
                }
            }
        }

        private void showMenu () {
            System.out.println("Menu:");
            System.out.println("0. Add new Item");
            System.out.println("1. Show all items");
            System.out.println("2. Edit item");
            System.out.println("3. Delete item");
            System.out.println("4. Find item by Id");
            System.out.println("5. Find items by name");
            System.out.println("6. Exit Program");
        }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
