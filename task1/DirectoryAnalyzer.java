package task1;

import java.io.File;

public class DirectoryAnalyzer {

    // Method to list all files in the directory and print their sizes
    public static void listFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        // Check if the provided path is a valid directory
        if (!directory.isDirectory()) {
            System.out.println(directoryPath + " is not a valid directory.");
            return;
        }

        File[] files = directory.listFiles();

        // Check if directory can be accessed or is not empty
        if (files == null || files.length == 0) {
            System.out.println("The directory is empty or cannot be accessed.");
            return;
        }

        System.out.println("Listing files in directory: " + directoryPath);

        long totalSize = 0;  // total size of all files

        for (File file : files) {
            if (file.isFile()) {
                long fileSize = file.length();
                System.out.println("File: " + file.getName() + " | Size: " + fileSize + " bytes");
                totalSize += fileSize;
            }
        }

        System.out.println("Total size of files in directory: " + totalSize + " bytes\n");
    }

    // Method to recursively calculate the total size of the directory (including subdirectories)
    // Method to solve description 1.2 and 1.3 of the task1
    public static long calculateTotalDirectorySize(File directory) {
        if (!directory.isDirectory()) {
            return 0;  // If it's not a directory, return 0
        }

        File[] files = directory.listFiles();
        if (files == null) {
            return 0;  // Inaccessible directory or empty
        }

        long totalSize = 0;

        // Loop through files AND subdirectories
        for (File file : files) {
            if (file.isFile()) {
                totalSize += file.length();  // Add the file size
            } else if (file.isDirectory()) {
                totalSize += calculateTotalDirectorySize(file);  // Recursively add subdirectory sizes
            }
        }

        return totalSize;
    }

    public static void analyzeDirectory(String directoryPath) {
        // Step 1: List files and their sizes
        listFilesInDirectory(directoryPath);

        // Step 2: Calculate and print total size of the directory including subdirectories
        File directory = new File(directoryPath);
        long totalSize = calculateTotalDirectorySize(directory);
        System.out.println("Total size of the directory (including subdirectories): " + totalSize + " bytes");
    }
}
