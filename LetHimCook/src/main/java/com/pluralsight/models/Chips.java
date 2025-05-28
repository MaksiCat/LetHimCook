package lethimcook.models;

import java.util.Scanner;

public class Chips {
    private String chipType;

    public Chips(String chipType) {
        this.chipType = chipType;
    }

    public static Chips createChips() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select chip type:");
        System.out.println("1) Classic");
        System.out.println("2) BBQ");
        System.out.println("3) Sour Cream & Onion");
        System.out.print("Enter choice: ");
        String choice = scanner.nextLine();

        String chipType;
        switch (choice) {
            case "1":
                chipType = "Classic";
                break;
            case "2":
                chipType = "BBQ";
                break;
            case "3":
                chipType = "Sour Cream & Onion";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Classic.");
                chipType = "Classic";
                break;
        }

        return new Chips(chipType);
    }

    public double getPrice() {
        return 1.50;
    }

    @Override
    public String toString() {
        return chipType + " chips - $" + String.format("%.2f", getPrice());
    }
}

