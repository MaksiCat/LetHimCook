package lethimcook.ui;

import lethimcook.models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static Scanner scanner = new Scanner(System.in);
    private static Order currentOrder;

    public static void showHomeScreen() {
        while (true) {
            System.out.println("\nWelcome to LetHimCook!");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            String choice = scanner.nextLine();

            if (choice.equals("1")) {
                currentOrder = new Order();
                showOrderScreen();
            } else if (choice.equals("0")) {
                System.out.println("Thank you for visiting!");
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    private static void showOrderScreen() {
        while (true) {
            System.out.println("\nORDER MENU");
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    currentOrder.addSandwich(Sandwich.createSandwich());
                    break;
                case "2":
                    currentOrder.addDrink(Drink.createDrink());
                    break;
                case "3":
                    currentOrder.addChips(Chips.createChips());
                    break;
                case "4":
                    currentOrder.checkout();
                    return;
                case "0":
                    System.out.println("Order canceled.");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
