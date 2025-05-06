package SixthLesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Map<String, Integer>> buyers = new TreeMap<>();

        String line;
        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            String[] parts = line.split(" ");
            if (parts.length < 3) {
                continue; // Пропускаем некорректные строки
            }
            String buyer = parts[0];
            String product = parts[1];
            int quantity;

            try {
                quantity = Integer.parseInt(parts[2]);
            } catch (NumberFormatException e) {
                continue; // Пропускаем строки с некорректным количеством
            }

            buyers.putIfAbsent(buyer, new HashMap<>());
            buyers.get(buyer).put(product, buyers.get(buyer).getOrDefault(product, 0) + quantity);
        }

        for (String buyer : buyers.keySet()) {
            System.out.println(buyer + ":");
            Map<String, Integer> products = buyers.get(buyer);
            List<String> productList = new ArrayList<>(products.keySet());
            Collections.sort(productList);

            for (String product : productList) {
                System.out.println(product + " " + products.get(product));
            }
        }

        reader.close();
    }
}