package task6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadAndAnalyzeCsv {
    // Class to hold flight information
    static class Flight {
        String flightNumber;
        String departureCity;
        String arrivalCity;
        String date;

        Flight(String flightNumber, String departureCity, String arrivalCity, String date) {
            this.flightNumber = flightNumber;
            this.departureCity = departureCity;
            this.arrivalCity = arrivalCity;
            this.date = date;
        }

        @Override
        public String toString() {
            return "Flight " + flightNumber + " from " + departureCity + " to " + arrivalCity + " on " + date;
        }
    }

    // Method to read and process CSV file
    public static void processCSV(String csvFilePath) {
        ArrayList<Flight> flights = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {
            while ((line = reader.readLine()) != null) {
                // Process each line (CSV row)
                Flight flight = parseFlightData(line);
                flights.add(flight);
            }

            // Example of building a report using StringBuffer
            StringBuffer report = new StringBuffer();
            for (Flight flight : flights) {
                report.append(flight.toString()).append("\n");
            }

            // Output the report
            System.out.println("Flight Report:\n" + report.toString());

        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
        }
    }

    // Helper method to parse CSV row into Flight object
    public static Flight parseFlightData(String csvLine) {
        // Split the CSV line into its fields
        String[] fields = csvLine.split(",");

        // Use trim() to clean up any extra spaces
        String flightNumber = fields[0].trim();
        String departureCity = fields[1].trim();
        String arrivalCity = fields[2].trim();
        String date = fields[3].trim();

        // Return the Flight object
        return new Flight(flightNumber, departureCity, arrivalCity, date);
    }

}
