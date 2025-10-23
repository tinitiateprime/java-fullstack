// Demonstrates using Deque as a Stack (LIFO behavior)

import java.util.*;

public class DequeExample {
    public static void main(String[] args) {
        Deque<String> dq = new ArrayDeque<>();

        // Push elements (adds to the front)
        dq.push("A");
        dq.push("B");
        dq.push("C"); // C is now on top

        System.out.println("Stack elements (top first): " + dq);

        // Peek top element
        System.out.println("Top element: " + dq.peek());

        // Pop removes from the top
        dq.pop();
        System.out.println("After pop: " + dq);
    }
}

/*
Expected Output:
Stack elements (top first): [C, B, A]
Top element: C
After pop: [B, A]
*/
