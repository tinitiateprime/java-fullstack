/**
 * instanceof Operator
 * -------------------
 * Checks whether an object is an instance of a given class.
 */
public class InstanceofOperator {
    public static void main(String[] args) {
        Animal a = new Dog();

        System.out.println(a instanceof Animal); // true
        System.out.println(a instanceof Dog);    // true
        System.out.println(a instanceof Cat);    // false
    }
}

class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

/*
Expected output:
true
true
false
*/
