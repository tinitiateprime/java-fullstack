// File: Stream_CreateFromArray.java
// Demonstrates creating a stream from an array

import java.util.stream.*;

public class Stream_CreateFromArray {
    public static void main(String[] args) {
        String[] languages = {"HTML", "CSS", "JavaScript"};

        Stream.of(languages).forEach(lang -> System.out.println("Learning: " + lang));
    }
}

/*
Expected Output:
Learning: HTML
Learning: CSS
Learning: JavaScript
*/
