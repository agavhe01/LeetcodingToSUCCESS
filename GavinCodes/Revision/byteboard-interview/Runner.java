import java.util.*;

class Runner {

    public static void main(String[] args) throws Exception {
        // Initialize WarehouseServer instance.
        WarehouseServer warehouseServer = new WarehouseServer();
        warehouseServer.initializeServer("warehouse_pings.csv");
        System.out.println("~~~WarehouseServer is initialized.");
        System.out.println();

        System.out.println("Average Speeds: " + warehouseServer.getAverageSpeeds());
        System.out.println();

        printArrayContents(
            "The 3 most traveled vehicles since 1553273158 are: ",
            warehouseServer.getMostTraveledSince(3, 1553273158));

        printArrayContents(
            "The 3 most traveled vehicles since 1553273160 are: ",
            warehouseServer.getMostTraveledSince(4, 1553273160));

        printArrayContents(
            "Vehicles possibly damaged: ",
            warehouseServer.checkForDamage());

        // Feel free to put any println statements below for testing and debugging

        // Test case for getAverageSpeeds
        System.out.println("~~~ My Test Case 1: getAverageSpeeds() ~~~");
        System.out.println("Speeds of all vehicles: " + warehouseServer.getAverageSpeeds());
        System.out.println();

        // Test case for getMostTraveledSince
        System.out.println("~~~ My Test Case 2: getMostTraveledSince(2, 1553273155) ~~~");
        System.out.println("Expected: The top 2 most traveled vehicles since timestamp 1553273155");
        printArrayContents("Most Traveled: ", warehouseServer.getMostTraveledSince(2, 1553273155));
        System.out.println();


        // Test case for accelerations in Vehicle1
        System.out.println("~~~ My Test Case 3: getAccelerations() and distances() for vehicles ~~~");
        List<Vehicle> vehicles = warehouseServer.getVehicles();
        for(Vehicle v : vehicles){
            System.out.println("Vehicle: " + v.getName());
            System.out.println("List of acceleration values " + v.getAccelerations(v.getPings()));
            System.out.println("Total distance for Vehicle: " + v.getName() + " " + v.getTotalDistance());
            System.out.println();
        }
        
    }

    private static void printArrayContents(String description, String[] array) {
        System.out.println(description);
        for(String element : array) {
            System.out.println("\t" + element);
        }
        System.out.println();
    }
}
