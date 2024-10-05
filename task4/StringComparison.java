package task4;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringComparison {
    public static void findSubstring(String text, String substring) {
        System.out.println("Using String Methods:");

        // Using contains()
        if (text.contains(substring)) {
            System.out.println("The text contains the substring \"" + substring + "\".");
        } else {
            System.out.println("The text does not contain the substring \"" + substring + "\".");
        }

        // Using indexOf()
        int index = text.indexOf(substring);
        if (index != -1) {
            System.out.println("The substring \"" + substring + "\" is found at index " + index + ".");
        } else {
            System.out.println("The substring \"" + substring + "\" is not found in the text.");
        }

        // Using startsWith() and endsWith()
        if (text.startsWith(substring)) {
            System.out.println("The text starts with \"" + substring + "\".");
        }
        if (text.endsWith(substring)) {
            System.out.println("The text ends with \"" + substring + "\".");
        }
        System.out.println();
    }

    // Method to demonstrate substring search using regular expressions
    public static void findUsingRegex(String text, String patternString) {
        System.out.println("Using Regular Expressions:");
        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(text);

        // Check if pattern exists in text
        if (matcher.find()) {
            System.out.println("Pattern \"" + patternString + "\" found at index " + matcher.start() + ".");
        } else {
            System.out.println("Pattern \"" + patternString + "\" not found.");
        }
        System.out.println();
    }

    // Method to compare substrings
    public static void compareSubstrings(String text, String substring) {
        System.out.println("Substring Comparison:");

        // Using equals()
        if (text.equals(substring)) {
            System.out.println("The text is exactly equal to the substring.");
        } else {
            System.out.println("The text is not exactly equal to the substring.");
        }

        // Using equalsIgnoreCase()
        if (text.equalsIgnoreCase(substring)) {
            System.out.println("The text equals the substring, ignoring case.");
        }

        // Using startsWith() and endsWith()
        if (text.startsWith(substring)) {
            System.out.println("The text starts with the substring.");
        }
        if (text.endsWith(substring)) {
            System.out.println("The text ends with the substring.");
        }

        System.out.println();
    }

    // Search function in a simple text editor
    public static void textEditorSearch() {
        Scanner scanner = new Scanner(System.in);

        // Input the text
        System.out.println("Enter the text: ");
        String text = scanner.nextLine();

        // Input the substring to search
        System.out.println("Enter the substring/pattern to search: ");
        String substring = scanner.nextLine();

        // Find substring using String methods
        findSubstring(text, substring);

        // Find using regex
        findUsingRegex(text, substring);

        // Compare substrings
        compareSubstrings(text, substring);
    }
}
