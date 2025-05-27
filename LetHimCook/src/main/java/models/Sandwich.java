package lethimcook.models;

import lethimcook.models.enums.BreadType;
import lethimcook.models.enums.Size;
import lethimcook.models.enums.ToppingType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sandwich {
    private BreadType bread;
    private Size size;
    private List<ToppingType> toppings;
    private String mainFilling;
    private boolean toasted;

    public Sandwich(BreadType bread, Size size, List<ToppingType> toppings, String mainFilling, boolean toasted) {
        this.bread = bread;
        this.size = size;
        this.toppings = toppings;
        this.mainFilling = mainFilling;
        this.toasted = toasted;
    }

    public static Sandwich createSandwich() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose bread type:");
        for (BreadType b : BreadType.values()) {
            System.out.println("- " + b);
        }
        System.out.print("Enter bread type: ");
        String breadInput = scanner.nextLine().trim().toUpperCase();
        BreadType bread;
        try {
            bread = BreadType.valueOf(breadInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Defaulting to WHITE.");
            bread = BreadType.WHITE;
        }

        System.out.println("Choose size:");
        for (Size s : Size.values()) {
            System.out.println("- " + s);
        }
        System.out.print("Enter size: ");
        String sizeInput = scanner.nextLine().trim().toUpperCase();
        Size size;
        try {
            size = Size.valueOf(sizeInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input. Defaulting to SMALL.");
            size = Size.SMALL;
        }

        System.out.print("Enter main filling (e.g., Turkey, Ham): ");
        String filling = scanner.nextLine();

        System.out.print("Do you want it toasted? (yes/no): ");
        boolean toasted = scanner.nextLine().trim().equalsIgnoreCase("yes");

        List<ToppingType> toppings = new ArrayList<>();
        System.out.println("Add toppings (type 'done' to finish):");
        for (ToppingType topping : ToppingType.values()) {
            System.out.println("- " + topping);
        }

        while (true) {
            System.out.print("Topping: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                ToppingType topping = ToppingType.valueOf(input.toUpperCase());
                toppings.add(topping);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid topping: " + input + ". Please try again.");
            }
        }

        return new Sandwich(bread, size, toppings, filling, toasted);
    }

    public double getPrice() {
        double price = 5.00;
        switch (size) {
            case MEDIUM: price += 1.00; break;
            case LARGE: price += 2.00; break;
        }
        price += toppings.size() * 0.50;
        return price;
    }

    @Override
    public String toString() {
        return size + " " + bread + " sandwich with " + mainFilling +
                (toasted ? " (toasted)" : "") +
                "\nToppings: " + toppings +
                "\nPrice: $" + String.format("%.2f", getPrice());
    }
}

