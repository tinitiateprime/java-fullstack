// File: MethodRef_InstanceExample.java
// Demonstrates: Referring to an instance method of a specific object using method reference

import java.util.function.Consumer;

class MessagePrinter {
    void show(String msg) {
        System.out.println(">> " + msg);
    }
}

public class MethodRef_InstanceExample {
    public static void main(String[] args) {
        MessagePrinter printer = new MessagePrinter();

        // Lambda version
        Consumer<String> c1 = s -> printer.show(s);

        // Method reference version
        Consumer<String> c2 = printer::show;

        c2.accept("Hello Learner!");
        c2.accept("Functional Programming Rocks!");
    }
}

/*
Expected Output:
>> Hello Learner!
>> Functional Programming Rocks!
*/
