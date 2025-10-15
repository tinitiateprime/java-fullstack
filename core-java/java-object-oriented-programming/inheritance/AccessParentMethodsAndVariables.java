// Use super to call parent method; access parent's protected variable.
public class AccessParentMethodsAndVariables {
    public static void main(String[] args) {
        new Child().demo();
    }
}

class Parent {
    protected int value = 10;           // child can see this
    void printValue() {
        System.out.println("Parent value: " + value);
    }
}

class Child extends Parent {
    void demo() {
        super.printValue();             // call parent's method
        value = value + 5;              // use parent's protected field
        System.out.println("Child value: " + value);
    }
}

/*
Expected output:
Parent value: 10
Child value: 15
*/
