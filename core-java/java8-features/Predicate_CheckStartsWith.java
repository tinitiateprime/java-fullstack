// File: Predicate_CheckStartsWith.java
// Demonstrates Predicate<T> to check if a string starts with 'J'

import java.util.function.Predicate;

public class Predicate_CheckStartsWith {
    public static void main(String[] args) {
        Predicate<String> startsWithJ = word -> word.startsWith("J");

        System.out.println("Java starts with J? " + startsWithJ.test("Java"));
        System.out.println("Python starts with J? " + startsWithJ.test("Python"));
    }
}

/*
Expected Output:
Java starts with J? true
Python starts with J? false
*/
