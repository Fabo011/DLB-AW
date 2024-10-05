package task1;

import java.io.File;

public class DirectoryAnalyzer {

    /**
     * Lists all files in the specified directory and prints their sizes.
     *
     * @param directoryPath the path of the directory to analyze
     */
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

    /**
     * Recursively calculates the total size of the specified directory,
     * including the sizes of files in all its subdirectories.
     *
     * @param directory the directory for which to calculate the total size
     * @return the total size of the directory in bytes
     */
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

    /**
     * Analyzes the specified directory by listing files and calculating
     * the total size of the directory including all subdirectories.
     *
     * @param directoryPath the path of the directory to analyze
     */
    public static void analyzeDirectory(String directoryPath) {
        // Step 1: List files and their sizes
        listFilesInDirectory(directoryPath);

        // Step 2: Calculate and print total size of the directory including subdirectories
        File directory = new File(directoryPath);
        long totalSize = calculateTotalDirectorySize(directory);
        System.out.println("Total size of the directory (including subdirectories): " + totalSize + " bytes");
    }
}
