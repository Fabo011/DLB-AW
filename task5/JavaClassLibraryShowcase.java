package task5;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class JavaClassLibraryShowcase {

    /**
     * Demonstrates examples of various Java classes from the standard library.
     * Includes ArrayList, HashMap, BufferedReader, and date/time classes.
     */
    public static void utilExample() {
        // Example 1: java.util.ArrayList and java.util.HashMap
        // ArrayList example
        ArrayList<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        System.out.println("ArrayList Example:");
        for (String name : names) {
            System.out.println("Name: " + name);
        }

        // HashMap example
        HashMap<String, Integer> ages = new HashMap<>();
        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Charlie", 35);

        System.out.println("\nHashMap Example:");
        for (String name : ages.keySet()) {
            System.out.println(name + " is " + ages.get(name) + " years old.");
        }

        // Example 2: java.io - Reading input from the console
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\njava.io Example: Please enter something:");

        try {
            String input = reader.readLine();
            System.out.println("You entered: " + input);
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }

        // Example 3: java.time - Getting current date and time
        LocalDate today = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        System.out.println("\njava.time Example:");
        System.out.println("Today's date: " + today);
        System.out.println("Current time: " + currentTime);
    }
}
