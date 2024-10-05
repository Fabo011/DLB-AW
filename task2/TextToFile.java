package task2;

import java.io.FileWriter;
import java.io.IOException;

public class TextToFile {

    /**
     * Writes the specified text to a file, overwriting it if it already exists.
     *
     * @param text the text to write to the file
     * @param fileName the name of the file to write to
     */
    public static void writeToFile(String text, String fileName) {
        // with false it`s possible to overwrite the file:)
        try (FileWriter writer = new FileWriter(fileName, false)) {
            writer.write(text);
            System.out.println("Successfully wrote to the file: " + fileName);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}

