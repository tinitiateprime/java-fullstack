# Introduction to Java Arrays

An array is a data structure that stores a fixed-size, ordered, index-based sequence of elements of the same type. In Java:

* Arrays are objects (they inherit from java.lang.Object).

* Every array has a public final field length (number of elements).

* Indexing starts at 0 (first element is index 0, last is length - 1).

* The array’s size can’t change after creation (but the values inside can).
```java
import java.util.Arrays;

public class Intro {
    public static void main(String[] args) {
        int[] a = {10, 20, 30};            // object on heap, length = 3
        System.out.println(a[0]);          // 10 (zero-based indexing)
        System.out.println(a.length);      // 3 (public final field)
        System.out.println(Arrays.toString(a)); // [10, 20, 30]
    }
}
// Output:
// 10
// 3
// [10, 20, 30]
```

## Why use arrays?

* Group related values under one name (e.g., 30 student scores).

* Fast random access by index (O(1) time to read/write arr[i]).

* Efficient, low-overhead representation for primitives (int, double, …).

 When you need dynamic size or rich methods (add, remove), prefer ArrayList (Collections). Arrays are great when the size is known and performance matters.

# Declaring & Initializing Arrays
 ##  Declaration

 Syntax
```java
<element-type>[] variableName;   // preferred, modern style
<element-type> variableName[];   // also valid (legacy style)
```
```java
Examples

int[] scores;        // preferred
int scoresAlt[];     // valid but less common
String[] names;      // array of references to String
double[] temps;      // array of double
```
## Initializing Arrays
### 1) Allocation (creates the backing storage)

#### Syntax
```java
variableName = new <element-type>[length];
<element-type>[] variableName = new <element-type>[length]; // declare + allocate
```
```java
Examples

int[] scores = new int[5];     // [0, 0, 0, 0, 0]
double[] temps = new double[3];// [0.0, 0.0, 0.0]
String[] names = new String[2];// [null, null]
```

#### Defaults after new:

* int, long, short, byte → 0

* double, float → 0.0

* boolean → false

* char → '\u0000' (NUL)

* Any object/reference (e.g., String) → null

> Note: Array length is fixed once created; to “resize,” create a new array and copy.

### 2) Literal (initializer list)

#### Syntax
```java
<element-type>[] variableName = { value1, value2, ... };  // declaration + init
variableName = new <element-type>[] { value1, value2, ... }; // later assignment
```
```java
Examples

int[] primes = {2, 3, 5, 7};            // declare + init
String[] colors;
colors = new String[] {"red", "green"}; // later assignment

// ❌ Not allowed:
// colors = {"red", "green"};  // Only valid at declaration time

3) Assigning values by index (after allocation)
int[] x = new int[4]; // [0,0,0,0]
x[0] = 42;
x[3] = 7;
// x now → [42, 0, 0, 7]
```

### 3) Assign by index (after allocation)
```java
int[] x = new int[4]; // [0,0,0,0]
x[0] = 42;
x[3] = 7;             // x → [42, 0, 0, 7]

```
## Multidimensional Arrays (2D, 3D)

Key idea: In Java, multi-dimensional arrays are arrays of arrays. They can be rectangular or jagged (rows of different lengths).

2D Arrays

### Declaration
```java
int[][] grid;          // declares a variable that will reference an int[][] 
```

### Allocation (rectangular)
```java
grid = new int[3][4];  // 3 rows, 4 cols; all elements 0
```

### Declaration + Allocation
```java
int[][] mat = new int[2][3];  // [ [0,0,0], [0,0,0] ]
```

### Literal (initializer list)
```java
int[][] board = {
    {1, 2, 3},
    {4, 5, 6}
}; // 2x3
```

### Jagged (rows can have different lengths)
```java
int[][] jag = new int[3][];
jag[0] = new int[1];       // row 0 length 1
jag[1] = new int[3];       // row 1 length 3
jag[2] = new int[2];       // row 2 length 2
```

# Array Operations

## Accessing Elements
* You can access an array element by referring to the index number.
* Read by index: arr[i] (valid indices: 0 .. arr.length - 1)

* Write/update by index: arr[i] = newValue;

* Length is a field: arr.length (not a method).
```java
int[] a = {10, 20, 30};
int first = a[0];          // 10
a[2] = 99;                 // a -> [10, 20, 99]
System.out.println(a.length); // 3
```
> Out-of-range access throws ArrayIndexOutOfBoundsException.

## Traversing Arrays


### 1) for loop (use when you need the index or to modify elements)
```java
int[] a = {3, 6, 9, 12};
for (int i = 0; i < a.length; i++) {
    System.out.println("a[" + i + "] = " + a[i]);
}
```
### 2) Enhanced for (for-each) loop (clean reading; does not let you reassign elements)
```java
for (int value : a) {
    System.out.println(value);
}
```
### 3) while loop (use when the stop condition isn’t a simple counter)
``` java
int i = 0;
while (i < a.length) {
    System.out.println(a[i]);
    i++;
}
```

## Updating Elements
Update with index (preferred for mutations)
```java
int[] a = {1, 2, 3, 4};

// add 10 to each element
for (int i = 0; i < a.length; i++) {
    a[i] += 10;          // a -> [11, 12, 13, 14]
}
```

## Why not for-each for mutations?
```java
int[] b = {1, 2, 3};
for (int x : b) {
    x += 100;            // changes only the local copy, NOT b
}
// b is still [1, 2, 3]
```
### Replacing elements in an object array
```java
String[] names = {"Ada", "Grace", "Linus"};
for (int i = 0; i < names.length; i++) {
    if (names[i].startsWith("G")) names[i] = names[i].toUpperCase();
}
// names -> ["Ada", "GRACE", "Linus"]
``