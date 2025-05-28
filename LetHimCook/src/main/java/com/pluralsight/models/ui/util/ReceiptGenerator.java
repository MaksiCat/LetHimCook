package lethimcook.utils;

import lethimcook.models.Order;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptGenerator {
    public static void saveOrderToFile(Order order) {
        try {
            Path dirPath = Paths.get("receipts");
            if (!Files.exists(dirPath)) {
                Files.createDirectories(dirPath); // <-- now supports nested dirs
            }

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String fileName = "receipts/" + timestamp + ".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(order.toString());
            }

            System.out.println("Receipt saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Failed to save receipt: " + e.getMessage());
        }
    }
}

