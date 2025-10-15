## Introduction to Strings  
A String in Java is a sequence of characters — for example, "Hello" or "Java123".  
Strings are non-primitive (reference) data types and belong to the java.lang package.  
They are widely used to represent text, messages, or any character data.

In Java, a String is an object of the String class.  
Each String object stores its sequence of characters internally using a char[] (character array).

### Key Points
* Strings are immutable — once created, they cannot be changed.
* They are objects, not primitive types.

* Java optimizes memory by maintaining a String pool, where identical string literals share a single instance.

#### Example:
```java
public class IntroToStrings {
    public static void main(String[] args) {
        String greeting = "Hello, Java!";
        System.out.println(greeting);
    }
}

// Expected Output: Hello, Java!
```
##  Declaring & Initializing Strings

There are two main ways to create a string in Java:

### (a) Using String Literals

When you create a string using double quotes ("..."), Java checks if the same literal already exists in the String pool.  
If it does, the existing object is reused — saving memory.
```java
String s1 = "Java";   // created in String pool
String s2 = "Java";   // refers to same object as s1
System.out.println(s1 == s2); // true (same reference)


// Expected Output: true
```
### (b) Using the new Keyword

When you use new String("text"), a new object is created in heap memory, even if the same string already exists in the pool.
```java
String s3 = new String("Java");  // new object created
String s4 = new String("Java");  // another new object
System.out.println(s3 == s4);    // false (different objects)
System.out.println(s3.equals(s4)); // true (same content)


// Expected Output:

// false
// true
```

### Key Differences: String Literal vs new String()

| **Aspect** | **String Literal** | **new String()** |
|-------------|--------------------|------------------|
| **Memory Location** | String Pool | Heap Memory |
| **Object Reuse** | ✅ Yes (if same literal) | ❌ No (always new object) |
| **Example** | `String s = "Java";` | `String s = new String("Java");` |

## String Immutability

A String is immutable, meaning that once created, its value cannot be changed.
When you modify a String, Java actually creates a new String object, and the old one remains unchanged.

#### Example:
```java
public class StringImmutability {
    public static void main(String[] args) {
        String text = "Hello";
        text.concat(" World");  // this does not change 'text'
        System.out.println(text);  // still prints "Hello"

        text = text.concat(" World");  // assigns new String
        System.out.println(text);  // now prints "Hello World"
    }
}

// Expected Output:

// Hello
// Hello World
```
### Why Immutability Matters

* Security: Prevents accidental or malicious changes (e.g., in network parameters, file paths).
* Performance: Enables String pooling — reuse of identical strings.
* Thread Safety: Immutable objects can be shared safely among multiple threads.

## String Operations 
The String class in Java provides a wide range of built-in methods to manipulate and inspect text data.
These methods allow you to measure length, extract parts, compare, or modify content.

Below are the most commonly used String methods, grouped by their purpose — each with a clear explanation, syntax, example, and expected output.


### Common String Operations
  * #### Measuring & Accessing
     * **length()** → returns the total number of characters in a string.
     * **charAt(index)** → returns the character at the given position (0-based index).

  * #### Extracting Substrings
     * **substring(beginIndex, endIndex)** → extracts part of a string from beginIndex (inclusive) to endIndex (exclusive).
     * **substring(beginIndex)** → extracts from the given index to the end.

  * #### Searching
     * **indexOf()** → finds the first position of a character or substring.
     * **lastIndexOf()** → finds the last occurrence.

  * #### Case Conversion
     * **toUpperCase()** → converts all characters to uppercase.
     * **toLowerCase()** → converts all characters to lowercase.

  * #### Cleaning & Replacing
     * **trim()** → removes leading and trailing spaces.
     * **replace()** → replaces all occurrences of one substring with another.
     * **contains()** → checks if a substring exists within the main string.

  * #### Comparison
     * **equals()** → checks if two strings have exactly the same characters (case-sensitive).
     * **equalsIgnoreCase()** → compares strings ignoring case differences.
     * **compareTo()** → compares lexicographically (dictionary order).
     * **startsWith()** → checks if a string begins with a specified prefix.
     * **endsWith()** → checks if a string ends with a specified suffix.



#### Example
```java
public class StringOperationsExample {
    public static void main(String[] args) {
        String text = "   Java Programming   ";

        // Measuring & Accessing
        System.out.println("Length: " + text.length());                // Output: 22
        System.out.println("Char at index 5: " + text.charAt(5));      // Output: P

        // Extracting
        System.out.println("Substring(3, 7): " + text.substring(3, 7)); // Output: a Pr

        // Searching
        System.out.println("Index of 'a': " + text.indexOf('a'));       // Output: 1
        System.out.println("Last index of 'a': " + text.lastIndexOf('a')); // Output: 19

        // Case Conversion
        System.out.println("Uppercase: " + text.toUpperCase());         // Output:    JAVA PROGRAMMING   
        System.out.println("Lowercase: " + text.toLowerCase());         // Output:    java programming   

        // Cleaning & Replacing
        System.out.println("Trimmed: '" + text.trim() + "'");           // Output: 'Java Programming'
        System.out.println("Replaced 'Java' → 'Python': " 
                            + text.replace("Java", "Python"));          // Output:    Python Programming   
        System.out.println("Contains 'Program': " + text.contains("Program")); // Output: true

        // Comparison
        String s1 = "Java";
        String s2 = "java";
        System.out.println("equals(): " + s1.equals(s2));                      // Output: false
        System.out.println("equalsIgnoreCase(): " + s1.equalsIgnoreCase(s2));  // Output: true
        System.out.println("compareTo(): " + s1.compareTo(s2));                // Output: -32
        System.out.println("startsWith(\"Ja\"): " + s1.startsWith("Ja"));      // Output: true
        System.out.println("endsWith(\"va\"): " + s1.endsWith("va"));          // Output: true
    }
}
```

## String Concatenation

String concatenation means joining two or more strings together to form a single combined string.
It’s one of the most common operations when displaying messages, constructing sentences, or combining data in Java.

Java provides multiple ways to concatenate strings — each with different use cases and performance implications.

### Concatenation Methods

 *  **Using + Operator**  
    * Easiest and most readable way to join strings.  
    * Internally uses **StringBuilder** during compilation.  
    * Suitable for small, simple concatenations.

 * **Using concat() Method**  
    * Built-in **String** method that joins one string to another.  
    * **Syntax:** `str1.concat(str2)`  
    * Can only join string values, not primitives directly.

 * **Using String.join() (Java 8+)**  
    * Joins multiple strings with a delimiter (like space, comma, etc.).  
    * **Syntax:** `String.join(" ", str1, str2, str3)`  
    * Very handy for joining lists or multiple words.

 * **Using String.format()**  
    * Provides advanced formatting using placeholders (like `%s`, `%d`, etc.).  
    * Useful when combining different data types or creating structured messages.  
    * **Syntax:** `String.format("Name: %s, Age: %d", name, age)`

#### Example
```java
public class StringConcatenationExample {
    public static void main(String[] args) {
        String first = "Java";
        String second = "Programming";
        int version = 17;

        // Using + operator
        String result1 = first + " " + second;
        System.out.println(result1);                     // Output: Java Programming

        // Using concat() method
        String result2 = first.concat(" ").concat(second);
        System.out.println(result2);                     // Output: Java Programming

        // Using String.join()
        String result3 = String.join(" ", "Learn", "Java", "Easily");
        System.out.println(result3);                     // Output: Learn Java Easily

        // Using String.format()
        String result4 = String.format("%s %s %d", first, second, version);
        System.out.println(result4);                     // Output: Java Programming 17

        // Mixing text and variables
        String message = "Welcome to " + first + " " + second + " " + version;
        System.out.println(message);                     // Output: Welcome to Java Programming 17
    }
}
```

## String Compariso
String comparison in Java is used to check whether two strings are the same or to determine their order alphabetically (lexicographically).  
Since String is an object, comparisons can be done in two main ways:  

 * By reference (==)
 * By content (equals() / compareTo())

 ### Comparison Methods

  *  **Using == Operator**
     * Compares object references, not actual string content.
     * Returns true only if both variables point to the same memory location.
     * Not reliable for checking text equality unless you are sure they refer to the same literal in the String pool.

     Syntax:
     ```
      string1 == string2
      ```

  * **Using equals() Method**  
    * Compares the contents (characters) of two strings.
    * Returns true if both strings have identical sequences of characters.
    * Case-sensitive comparison.

    Syntax:
      ```
      string1.equals(string2)
      ```
  * **Using compareTo() Method**
    * Compares two strings lexicographically (dictionary order).
    * **Returns:**

      * 0 → if both strings are equal
      * < 0 → if string1 comes before string2
      * > 0 → if string1 comes after string2

    * Comparison is case-sensitive (use compareToIgnoreCase() to ignore case).

    Syntax:
    ```
    string1.compareTo(string2)
    ```
#### Example
 ```java
 public class StringComparisonExample {
    public static void main(String[] args) {
        String s1 = "Java";
        String s2 = "Java";
        String s3 = new String("Java");
        String s4 = "Python";

        // == operator (checks reference)
        System.out.println(s1 == s2);       // true  → both refer to same literal in String pool
        System.out.println(s1 == s3);       // false → different memory locations

        // equals() (checks content)
        System.out.println(s1.equals(s2));  // true  → same content
        System.out.println(s1.equals(s4));  // false → different content

        // compareTo() (lexicographical comparison)
        System.out.println(s1.compareTo(s2)); // 0  → equal
        System.out.println(s1.compareTo(s4)); // -6 → "J" comes before "P"
        System.out.println(s4.compareTo(s1)); // 6  → "P" comes after "J"
    }
}
```

## StringBuilder and StringBuffer
Unlike the String class (which is immutable),  
StringBuilder and StringBuffer are mutable classes — meaning their contents can be changed after creation.  
They are ideal for situations where you need to modify, append, or manipulate strings frequently (e.g., loops, dynamic content).

### Mutable Alternatives to String

| **Feature** | **String** | **StringBuilder** | **StringBuffer** |
|--------------|-------------|-------------------|------------------|
| **Mutability** | Immutable | Mutable | Mutable |
| **Thread Safety** | Safe (immutable) | Not Thread-Safe | Thread-Safe |
| **Speed** | Slower for modifications | Faster (no synchronization) | Slower (uses synchronization) |
| **Use Case** | Fixed text | Single-threaded performance | Multi-threaded programs |

### Key Methods

| **Method** | **Description** |
|-------------|-----------------|
| **append(String s)** | Adds text to the end |
| **insert(int index, String s)** | Inserts text at the given position |
| **delete(int start, int end)** | Removes characters from the specified range |
| **reverse()** | Reverses the character sequence |
| **toString()** | Converts the builder back to a regular String |

#### Syntax
```java
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
sb.insert(5, ",");
sb.delete(0, 1);
sb.reverse();
String result = sb.toString();
```
#### Example
```java
public class StringBuilderBufferExample {
    public static void main(String[] args) {
        // Using StringBuilder (faster, not synchronized)
        StringBuilder sb = new StringBuilder("Java");
        sb.append(" Programming");                  // add text → "Java Programming"
        sb.insert(4, " Language");                  // insert text → "Java Language Programming"
        sb.delete(4, 13);                           // delete " Language" → "Java Programming"
        sb.reverse();                               // reverse string → "gnimmargorP avaJ"
        System.out.println(sb.toString());          // Output: gnimmargorP avaJ

        // Convert back to normal String
        String normal = sb.toString();
        System.out.println("As String: " + normal); // Output: As String: gnimmargorP avaJ

        // Using StringBuffer (thread-safe)
        StringBuffer sbf = new StringBuffer("Fast");
        sbf.append(" and Safe");                    // add text → "Fast and Safe"
        System.out.println(sbf.toString());         // Output: Fast and Safe
    }
}
```

### Performance and Thread-Safety Differences
* #### StringBuilder
  * Faster because it’s not synchronized.
  * Best choice for single-threaded applications.
* #### StringBuffer
  * Thread-safe because all methods are synchronized.
  * Slightly slower, used in multi-threaded or concurrent environments.

## String Conversion
String conversion in Java means converting Strings to other data types or other data types back to Strings.
This is extremely common when handling user input, performing calculations, or displaying results.

### Java provides simple built-in methods for:
 * Converting between Strings and primitives (like int, double, etc.)
 * Converting between Strings and character arrays (char[])

 ### String ↔ Primitive Conversion
   * #### Converting String → Primitive
     Use wrapper class methods like Integer.parseInt(), Double.parseDouble(), etc.  
     These convert numeric strings into their respective primitive values.

     Syntax:
     ```java
      int num = Integer.parseInt("100");
      double price = Double.parseDouble("99.5");
      boolean flag = Boolean.parseBoolean("true");
      ```
   * #### Converting Primitive → String
     Use String.valueOf() or concatenation (+ "") to convert primitives into Strings.

     Syntax:
     ```java
      String str1 = String.valueOf(123);
      String str2 = String.valueOf(45.6);
      String str3 = 99 + "";   // implicit conversion using +
      ```
