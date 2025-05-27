package lethimcook.screens;

import lethimcook.models.*;
import lethimcook.models.enums.*;
import lethimcook.utils.ReceiptGenerator;

import java.util.Scanner;

public class OrderScreen {
    private Scanner scanner;
    private Order order;

    public OrderScreen(Scanner scanner) {
        this.scanner = scanner;
        this.order = new Order();
    }

    public void show() {
        boolean running = true;
        while (running) {
            System.out.println("\n=== ORDER MENU ===");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");

            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    Sandwich sandwich = Sandwich.createSandwich();
                    order.addSandwich(sandwich);
                    System.out.println("Sandwich added!");
                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addChips();
                    break;
                case "4":
                    checkout();
                    running = false;
                    break;
                case "0":
                    System.out.println("Order canceled.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    private void addDrink() {
        System.out.println("Select drink size:");
        for (Size s : Size.values()) {
            System.out.println((s.ordinal() + 1) + ") " + s);
        }
        Size size = Size.values()[Integer.parseInt(scanner.nextLine()) - 1];

        System.out.print("Enter flavor: ");
        String flavor = scanner.nextLine();

        order.addDrink(new Drink(size, flavor));
        System.out.println("Drink added!");
    }

    private void addChips() {
        System.out.print("Enter chip type: ");
        String chipType = scanner.nextLine();

        order.addChips(new Chips(chipType));
        System.out.println("Chips added!");
    }

    private void checkout() {
        System.out.println("\n--- Order Summary ---");
        System.out.println(order);

        System.out.print("Confirm order? (y/n): ");
        String confirm = scanner.nextLine().toLowerCase();

        if (confirm.equals("y")) {
            ReceiptGenerator.saveOrderToFile(order);
            System.out.println("Order confirmed.");
        } else {
            System.out.println("Order canceled.");
        }
    }
}
