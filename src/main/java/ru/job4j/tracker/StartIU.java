package ru.job4j.tracker;


import java.util.Scanner;

public class StartIU {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.valueOf(scanner.nextLine());

            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                Item rsl = tracker.add(item);
                System.out.println(rsl);

            } else if (select == 1) {
                System.out.println("=== Show all Items ===");
                Item[] items = tracker.findAll();
                for (int i = 0; i < items.length; i++) {
                    System.out.println(items[i] + " ");
                }
            } else if (select == 2) {
                    System.out.println("=== Edit Item ===");
                    System.out.println("Enter Item's id");
                    int id = Integer.valueOf(scanner.nextLine());
                    System.out.println("Enter new Item's name");
                    String name = scanner.nextLine();
                    Item item = new Item(name);
                    boolean rsl = tracker.replace(id, item);
                    if (rsl) {
                        System.out.println("Item " + id + " is edited");
                    } else {
                        System.out.println("Item " + id + " is not find");
                    }

                } else if (select == 3) {
                    System.out.println("=== Delete Item ===");
                    System.out.println("Input Item's id");
                    int id = Integer.valueOf(scanner.nextLine());
                     boolean rsl = tracker.delete(id);
                     if (rsl) {
                         System.out.println("Item " + id + " is deleted");
                     } else {
                         System.out.println("Item " + id + " is not find");
                     }

                } else if (select == 4) {
                    System.out.println("=== Find item by Id ===");
                    System.out.println("Input Item's id");
                    int id = Integer.valueOf(scanner.nextLine());
                    Item rsl = tracker.findById(id);
                    if (rsl == null) {
                        System.out.println("Item with id " + id +" is not find");
                    } else {
                        System.out.println(rsl);
                    }

                } else if (select == 5) {
                    System.out.println("=== Find item by name ===");
                    System.out.println("Input Item's name");
                    String key = scanner.nextLine();
                    Item[] rsl = tracker.findByName(key);
                    if (rsl.length == 0) {
                        System.out.println("Item with name " +key + " is not find");
                    } else {
                        for (int i = 0; i < rsl.length; i++) {
                            System.out.println(rsl[i] + " ");
                        }
                    }

                } else if (select == 6) {
                    System.out.println("=== Exit.See you. ===");
                    run = false;
                }
            }
        }


    private void showMenu() {
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartIU().init(scanner, tracker);
    }
}
