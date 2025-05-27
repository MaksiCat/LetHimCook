package lethimcook.models;

import java.util.*;
import java.nio.file.*;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(0, sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(0, drink);
    }

    public void addChips(Chips chip) {
        chips.add(0, chip);
    }

    public double getTotal() {
        double total = 0;
        for (Sandwich s : sandwiches) total += s.getPrice();
        for (Drink d : drinks) total += d.getPrice();
        for (Chips c : chips) total += c.getPrice();
        return total;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (Sandwich s : sandwiches) {
            sb.append("Sandwich ").append(count++).append(":\n").append(s).append("\n\n");
        }

        count = 1;
        for (Drink d : drinks) {
            sb.append("Drink ").append(count++).append(": ").append(d).append("\n");
        }

        count = 1;
        for (Chips c : chips) {
            sb.append("Chips ").append(count++).append(": ").append(c).append("\n");
        }

        sb.append("\nTotal: $").append(String.format("%.2f", getTotal()));
        return sb.toString();
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public void checkout() {
        System.out.println("\n=== Order Summary ===");
        System.out.println(this);

        String filename = "receipts/receipt_" + System.currentTimeMillis() + ".txt";
        try {
            Files.createDirectories(Paths.get("receipts"));
            Files.write(Paths.get(filename), this.toString().getBytes());
            System.out.println("Receipt saved to " + filename);
        } catch (Exception e) {
            System.out.println("Failed to save receipt: " + e.getMessage());
        }
    }
}
