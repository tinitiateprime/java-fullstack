// Demonstrates simple try-catch block
public class TryCatchExample {
    public static void main(String[] args) {
        System.out.println("Starting calculation...");

        try {
            int x = 10 / 0; // risky operation
        } catch (ArithmeticException e) {
            System.out.println("Caught: Cannot divide by zero.");
        }

        System.out.println("Continuing after handling...");
    }
}

/*
Expected Output:
Starting calculation...
Caught: Cannot divide by zero.
Continuing after handling...
*/
