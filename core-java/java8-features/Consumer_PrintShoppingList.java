// File: Consumer_PrintShoppingList.java
// Demonstrates Consumer<T> that prints each item from a list

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumer_PrintShoppingList {
    public static void main(String[] args) {
        Consumer<String> printItem = item -> System.out.println("Buying: " + item);

        List<String> items = Arrays.asList("Milk", "Bread", "Eggs");
        items.forEach(printItem);
    }
}

/*
Expected Output:
Buying: Milk
Buying: Bread
Buying: Eggs
*/