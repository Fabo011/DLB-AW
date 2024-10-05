import java.util.Scanner;
import task1.DirectoryAnalyzer;
import task2.TextToFile;
import task3.CodeConventions;
import task4.StringComparison;
import task5.JavaClassLibraryShowcase;
import task6.ReadAndAnalyzeCsv;
import java.io.IOException;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main menu for task selection
        while (true) {
            System.out.println("Please select a task to run:");
            System.out.println("1. Task 1 - Directory Analyzer");
            System.out.println("2. Task 2 - Write text to a file");
            System.out.println("3. Task 3 - Code Conventions");
            System.out.println("4. Task 4 - String Comparison");
            System.out.println("5. Task 5 - Three examples of Java Class Library");
            System.out.println("6. Task 6 - Read and Analyze CSV");
            System.out.println("7. Generate JavaDoc documentation");
            System.out.println("0. Exit");

            System.out.print("Enter the number of the task you want to run: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    runTask1(); // Run Directory Analyzer
                    break;
                case 2:
                    runTask2(); // Run Text to File
                    break;
                case 3:
                    runTask3(); // Run Code Conventions
                    break;
                case 4:
                    runTask4(); // Run String Comparison
                    break;
                case 5:
                    runTask5(); // Run Java Class Library
                    break;
                case 6:
                    runTask6(); // Run Read and Analyze CSV
                    break;
                case 7:
                    generateJavaDoc(); // Generate JavaDoc
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();
        }
    }

    // Method to run Task 1 (Directory Analyzer)
    private static void runTask1() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Running Task 1: Directory Analyzer");
        System.out.print("Please provide a directory path (or press Enter for default './files'): ");
        String input = scanner.nextLine();

        String directoryPath = input.isEmpty() ? "./task1/files" : input;
        DirectoryAnalyzer.analyzeDirectory(directoryPath);
    }

    private static void runTask2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Running Task 2: Write to File");
        System.out.print("Please enter the text you want to write to the file: ");
        String text = scanner.nextLine();

        System.out.print("Please enter the file name (including path if necessary): ");
        String fileName = scanner.nextLine();

        TextToFile.writeToFile(text, fileName);
    }

    private static void runTask3() {
        System.out.println("Running Task 3: Code Conventions");
        CodeConventions.demonstrateCodeConventions();
    }

    private static void runTask4() {
        System.out.println("Running Task 4: Substring Search & Comparison");
        StringComparison.textEditorSearch();
    }

    public static void runTask5() {
        System.out.println("Running Task 5: Java Class Library Examples");
        JavaClassLibraryShowcase.utilExample();
    }

    public static void runTask6() {
        System.out.println("Running Task 6: Read and Analyze CSV with flight data");
        String csvFilePath = "./task6/flights.csv";
        ReadAndAnalyzeCsv.processCSV(csvFilePath);
    }

    public static void generateJavaDoc() {
        String[] command = {
                "javadoc",
                "-d", "docs",
                "-sourcepath", ".",
                "-subpackages", "task1:task2:task3:task4:task5:task6"
        };

        try {
            ProcessBuilder pb = new ProcessBuilder(command);
            Process process = pb.inheritIO().start();
            process.waitFor();
            System.out.println("JavaDoc has been generated in the 'doc' folder.");
        } catch (IOException e) {
            System.out.println("Error generating JavaDoc: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("JavaDoc generation interrupted: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}

