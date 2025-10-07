public class ReturnExample {
    public static int add(int a, int b) {
        return a + b; // exit method and return value
    }

    public static void main(String[] args) {
        int result = add(5, 10);
        System.out.println("Sum: " + result);
    }
}
// Output:
// Sum: 15
