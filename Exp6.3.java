import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

// Class to represent a Product
class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a large dataset of Product objects
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 1200.0));
        products.add(new Product("Smartphone", "Electronics", 1000.0));
        products.add(new Product("T-Shirt", "Clothing", 25.0));
        products.add(new Product("Jeans", "Clothing", 50.0));
        products.add(new Product("Book", "Books", 20.0));
        products.add(new Product("Laptop Charger", "Electronics", 50.0));
        products.add(new Product("Hoodie", "Clothing", 40.0));
        products.add(new Product("Java Book", "Books", 30.0));
        products.add(new Product("Gaming Laptop", "Electronics", 1500.0));
        products.add(new Product("Casual T-Shirt", "Clothing", 30.0));
        products.add(new Product("Data Structures Book", "Books", 40.0));
        products.add(new Product("UltraBook", "Electronics", 1300.0));
        products.add(new Product("Formal Shirt", "Clothing", 60.0));
        products.add(new Product("Programming Book", "Books", 35.0));
        products.add(new Product("Gaming Mouse", "Electronics", 75.0));


        // Group products by category
        Map<String, List<Product>> productsByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println("Products grouped by category:");
        productsByCategory.forEach((category, productList) -> {
            System.out.println(category + ":");
            productList.forEach(System.out::println);
        });

        // Find the most expensive product in each category
        Map<String, Optional<Product>> mostExpensiveByCategory = products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.maxBy(Comparator.comparing(Product::getPrice))));

        System.out.println("\nMost expensive product in each category:");
        mostExpensiveByCategory.forEach((category, optionalProduct) -> {
            if (optionalProduct.isPresent()) {
                System.out.println(category + ": " + optionalProduct.get());
            } else {
                System.out.println(category + ": No products found");
            }
        });

        // Calculate the average price of all products
        double averagePrice = products.stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0); // Handle the case where the list is empty

        System.out.println("\nAverage price of all products: " + averagePrice);
    }
}

