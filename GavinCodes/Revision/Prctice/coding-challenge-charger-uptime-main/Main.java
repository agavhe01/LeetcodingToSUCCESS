import java.io.*;
import java.util.*;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.nio.file.*;


class Main {

    // Keeps track of all the Stations mapped according to their stationIds
    static TreeMap<Integer, Station> allStations = new TreeMap<>(); 

    // Keeps track of chargerId to stationId, ensuring all chargerIds are unique
    static Map<Integer, Integer> chargerIdTOstationId = new HashMap<>();

    // File Path
    static String relativeFilePath;

    /*  
        main()   
            Arguments
                * Path of the input file and filename
            Purpose
                * Checks valid command line argument
                * Calls functions to process file, calculate runtimes and write output content
                * Throws IOException and FileNotFoundException
    */
    public static void main(String[] args) throws IOException, FileNotFoundException {

         // Check if a file path is provided as a command-line argument
        if (args.length != 1) {
            System.out.println("Usage: ./your_submission <relative/path/to/input/file>");
            return;
        }

        // Get the relative file path from the command-line arguments
        relativeFilePath = args[0];

        try
        {

            processFile(relativeFilePath);
            // printDataStructures();
            String content = generateContent();
            processOutputFile(relativeFilePath, content);

        }
        catch(IOException e){ processOutputFile(relativeFilePath, "ERROR"); System.exit(0); }
       

    }


    /*  
        processFile()   
            Arguments
                * String representing the pathfile from the command line argument
            Purpose
                * Ensures filepath is valid and that input file exists
                * Reads the file and creates the relevand Charger, Station and Interval objects
                * Throws IOException and FileNotFoundException
    */
    public static void processFile(String argument)  throws IOException, FileNotFoundException{

        Path inputPath = Paths.get(argument);
        if (!Files.exists(inputPath) || !Files.isRegularFile(inputPath)) {
            processOutputFile(relativeFilePath, "ERROR"); 
            System.exit(0);
        }

        File file = new File(argument);

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;
            boolean readingStations = false;
            boolean readingReports = false;

            while ((line = br.readLine()) != null) {
                line = line.trim(); // Remove leading/trailing spaces

                if (line.isEmpty()) continue; // Skip empty lines

                if (line.equals("[Stations]")) {
                    readingStations = true;
                    readingReports = false;
                } else if (line.equals("[Charger Availability Reports]")) {
                    readingStations = false;
                    readingReports = true;
                } else if (readingStations) {
                    parseStationLine(line);
                } else if (readingReports) {
                    parseChargerReportLine(line);
                }
                else { processOutputFile(relativeFilePath, "ERROR"); System.exit(0); }
            }
        }

        catch(FileNotFoundException e){ processOutputFile(relativeFilePath, "ERROR"); System.exit(0); }
        catch(IOException e){ processOutputFile(relativeFilePath, "ERROR"); System.exit(0); }
    }


    /*  
        parseStationLine()                 
            Arguments
                * String representing the a line from the input file from which Station Data should be parsed

            Purpose
                * Ensures the line is valid and contains enough data (Station ID and at least one charger)
                * Creates the Station and Charger objects and adds to relevant data structures
                * Throws NumberFormatException and IOException
    */
    public static void parseStationLine(String line)  throws NumberFormatException, IOException{
        // Checking for empty or null line
        if (line == null || line.trim().isEmpty()) {
            processOutputFile(relativeFilePath, "ERROR"); System.exit(0);
        }

        // Split the line by the space character and check for at least one Station Id and one Charger Id
        String[] parts = line.split("\\s+");
        if (parts.length < 2) {
            processOutputFile(relativeFilePath, "ERROR"); System.exit(0);
        }

        // Ensure that Station Id is a number and validate
        Integer stationId = Integer.MAX_VALUE;
        try 
        {
            stationId = Integer.parseInt(parts[0]);
        } 
        catch (NumberFormatException e) { processOutputFile(relativeFilePath, "ERROR"); System.exit(0); }

        // Retrieve or create the station then create the relevant charger objects
        if (stationId == Integer.MAX_VALUE || allStations.containsKey(stationId)) {
            processOutputFile(relativeFilePath, "ERROR"); 
            System.exit(0);
        }

        Station station = allStations.computeIfAbsent(stationId, Station::new);
        for (int i = 1; i < parts.length; i++) {

             // Ensure that Charger Id is a number and validate
            Integer chargerId = Integer.MAX_VALUE;
            try
            {
                chargerId = Integer.parseInt(parts[i]);
            } 
            catch (NumberFormatException e) { processOutputFile(relativeFilePath, "ERROR"); System.exit(0); }

            // Check for duplicate Charger Ids
            if (chargerId == Integer.MAX_VALUE || chargerIdTOstationId.containsKey(chargerId)) {
                processOutputFile(relativeFilePath, "ERROR");
                System.exit(0);
            }
            
            // Add the Charger Id to the charger id - station id mapping
            chargerIdTOstationId.put(chargerId, stationId);
           
            // Add charger to station
            Charger charger = new Charger(chargerId);
            station.addCharger(charger);

        }
    }


    /*  
        parseChargerReportLine()   
            Arguments
                * String representing the a line from the input file from which Charger Interval Data should be parsed
            Purpose
                * Ensures the line is valid and contains enough data (Charger ID, Start Time, End Time and Boolean)
                * Creates the Interval object and updates the relevant Charger object with the relevant information
                * Throws 
    
    public static void parseChargerReportLine(String line){
        
        // Split the line by the space and parse the relevant fields of the Interval object
        String[] parts = line.split("\\s+");
        Integer chargerId = Integer.parseInt(parts[0]);
        Long start = Long.parseLong(parts[1]);
        Long end = Long.parseLong(parts[2]);
        boolean available = Boolean.parseBoolean(parts[3]);

        // Retrieve the charger
        Integer stationId = chargerIdTOstationId.get(chargerId);
        Station station = allStations.get(stationId);
        Charger charger = station.getCharger(chargerId);

        // Add interval to the charger
        charger.processInterval(new Interval(chargerId, start, end, available));
    }

    */

    public static void parseChargerReportLine(String line) {
    // Trim whitespace and check for empty or null line
    if (line == null || line.trim().isEmpty()) {
        processOutputFile(relativeFilePath, "ERROR: Empty or null line in Charger Availability Reports");
        System.exit(0);
    }

    // Split the line into parts and validate the number of fields
    String[] parts = line.split("\\s+");
    if (parts.length != 4) {
        processOutputFile(relativeFilePath, "ERROR: Invalid Charger Availability Report format");
        System.exit(0);
    }

    // Validate Charger ID
    int chargerId;
    try {
        chargerId = Integer.parseInt(parts[0]);
    } catch (NumberFormatException e) {
        processOutputFile(relativeFilePath, "ERROR: Invalid Charger ID in Charger Availability Report");
        System.exit(0);
        return; // For compiler's benefit; won't be reached
    }

    // Validate start time
    long startTime;
    try {
        startTime = Long.parseLong(parts[1]);
        if (startTime < 0) { // Ensure start time is non-negative
            throw new IllegalArgumentException();
        }
    } catch (NumberFormatException | IllegalArgumentException e) {
        processOutputFile(relativeFilePath, "ERROR: Invalid start time in Charger Availability Report");
        System.exit(0);
        return;
    }

    // Validate end time
    long endTime;
    try {
        endTime = Long.parseLong(parts[2]);
        if (endTime <= startTime) { // Ensure end time is after start time
            throw new IllegalArgumentException();
        }
    } catch (NumberFormatException | IllegalArgumentException e) {
        processOutputFile(relativeFilePath, "ERROR: Invalid end time in Charger Availability Report");
        System.exit(0);
        return;
    }

    // Validate availability (true/false)
    boolean available;
    try {
        available = Boolean.parseBoolean(parts[3]);
    } catch (Exception e) {
        processOutputFile(relativeFilePath, "ERROR: Invalid availability value in Charger Availability Report");
        System.exit(0);
        return;
    }

    // Ensure the charger ID exists in the data structures
    Integer stationId = chargerIdTOstationId.get(chargerId);
    if (stationId == null) {
        processOutputFile(relativeFilePath, "ERROR: Charger ID not associated with any station in Charger Availability Report");
        System.exit(0);
    }

    // Retrieve station and charger objects
    Station station = allStations.get(stationId);
    if (station == null) {
        processOutputFile(relativeFilePath, "ERROR: Station not found for Charger ID in Charger Availability Report");
        System.exit(0);
    }
    Charger charger = station.getCharger(chargerId);
    if (charger == null) {
        processOutputFile(relativeFilePath, "ERROR: Charger not found in Station for Charger Availability Report");
        System.exit(0);
    }

    // Add the validated interval to the charger
    charger.processInterval(new Interval(chargerId, startTime, endTime, available));
}



    /*  
        printDataStructures()                    
            Purpose
                * Debugging helper to print all the Data post-interval processing (Stations and Chargers)
    */
    public static void printDataStructures(){
         for (Map.Entry<Integer, Station> entry : allStations.entrySet()) {
            Station station = entry.getValue();
            station.printStation();
        }
    }


    /*  
        generateContent()   
            Purpose
                * Iterates through all stations and calculates the overall runtime
                * Uses a stringbuilder to format the output content
            Returns
                * String representing the content to be printed to the output file
    */
    public static String generateContent(){
        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Integer, Station> entry : allStations.entrySet()) {
            Station station = entry.getValue();
            sb.append(station.stationId);
            sb.append(" ");
            sb.append(station.calculateRuntime());
            sb.append("\n");
        }

        // Remove the last newline character if present
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '\n') {
            sb.deleteCharAt(sb.length() - 1); 
        }

        return sb.toString();
    }


    /*  
        processOutputFile()                  
            Arguments
                * String representing the pathFile and name of the output file (inputFilename + output)
                * String representing the content to be written to the file 
            Purpose
                * Creates the output file and writes the content to it
    */
    public static void processOutputFile(String arg, String content) throws IOException {
        
        // Resolve the input file path and get the parent directory (or current dir if null)
        Path inputPath = Paths.get(arg);
        Path parentDir = inputPath.getParent();
        if (parentDir == null) { parentDir = Paths.get(""); }

        // Extract the file name and create the output file name
        String inputFileName = inputPath.getFileName().toString();
        String outputFileName = inputFileName.substring(0, inputFileName.length() - 4) + "_output.txt";

        // Construct the full output file path if it doesn't exist
        Path outputPath = parentDir.resolve(outputFileName);

        // Ensure parent directories exists and write content to file 
        Files.createDirectories(parentDir);
        Files.write(outputPath, content.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
    }


}