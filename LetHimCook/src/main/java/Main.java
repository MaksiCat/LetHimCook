package lethimcook;

import lethimcook.screens.OrderScreen;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== WELCOME TO LetHimCook ===");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    OrderScreen orderScreen = new OrderScreen(scanner);
                    orderScreen.show();
                    break;
                case "0":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        }

        scanner.close();
    }
}
