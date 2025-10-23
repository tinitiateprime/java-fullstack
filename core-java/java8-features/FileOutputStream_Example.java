// File: FileOutputStream_Example.java
// Topic: Write raw bytes to a file with FileOutputStream

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStream_Example {
    public static void main(String[] args) {
        byte[] data = {72, 101, 108, 108, 111, 10}; // "Hello\n" as bytes

        try (FileOutputStream out = new FileOutputStream("sample.bin")) {
            out.write(data);
            System.out.println("Wrote " + data.length + " bytes to sample.bin");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

/*
Expected Output:
Wrote 6 bytes to sample.bin
*/
