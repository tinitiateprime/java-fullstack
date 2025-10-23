// File: GenericMethod_DisplayPairExample.java
// 🧠 Topic: Generic Methods with Multiple Type Parameters
// Demonstrates a generic method that prints a pair of values of any types.

public class GenericMethod_DisplayPairExample {

    // Generic method with two type parameters <K, V>
    public static <K, V> void displayPair(K key, V value) {
        System.out.println("Key: " + key + " | Value: " + value);
    }

    public static void main(String[] args) {
        displayPair("Course", "Java Full Stack");
        displayPair("Duration (months)", 6);
        displayPair(101, "Student ID");
    }
}

/*
Expected Output:
Key: Course | Value: Java Full Stack
Key: Duration (months) | Value: 6
Key: 101 | Value: Student ID
*/
