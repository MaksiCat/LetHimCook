package lethimcook.models;

import lethimcook.models.enums.Size;

import java.util.Scanner;

public class Drink {
    private Size size;
    private String flavor;

    public Drink(Size size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public static Drink createDrink() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select drink size:");
        for (Size s : Size.values()) {
            System.out.println("- " + s);
        }
        System.out.print("Enter size: ");
        String sizeInput = scanner.nextLine().toUpperCase();
        Size size;
        try {
            size = Size.valueOf(sizeInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid size. Defaulting to SMALL.");
            size = Size.SMALL;
        }

        System.out.print("Enter drink flavor (e.g., Cola, Lemonade, Orange): ");
        String flavor = scanner.nextLine();

        return new Drink(size, flavor);
    }

    public double getPrice() {
        switch (size) {
            case SMALL: return 2.00;
            case MEDIUM: return 2.50;
            case LARGE: return 3.00;
            default: return 0;
        }
    }

    public String toString() {
        return size + " " + flavor + " drink - $" + String.format("%.2f", getPrice());
    }
}
