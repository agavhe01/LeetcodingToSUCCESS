import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.*;

final class WarehouseServer {

    // vehicles is a list of vehicle instances
    private List<Vehicle> vehicles;

    WarehouseServer() {
        vehicles = new ArrayList<Vehicle>();
    }


    /**
     * Returns a Map from vehicle name to that vehicle's average speed for all
     * vehicles.
     */
    Map<String, Double> getAverageSpeeds() {
        Map<String, Double> avgSpeeds = new HashMap<>();
        for (Vehicle vehicle : this.vehicles) {
            avgSpeeds.put(vehicle.getName(), vehicle.getAverageSpeed());
        }
        return avgSpeeds;
    }

    /**
     * Returns a sorted array of size max_results of vehicle names corresponding
     * to the vehicles that have traveled the most distance since the given
     * timestamp.
     */
    // String[] getMostTraveledSince(int maxResult, long timestamp) {
    //     String[] res = new String[maxResult];

    //     // TreeMap to store distances as keys and lists of vehicle names as values
    //     Map<Double, List<String>> distNameMap = new HashMap<>();

    //     for (Vehicle v : this.vehicles) {
    //         List<Ping> pings = v.getPings();
    //         int index = 0;

    //         // Find the first ping after the timestamp
    //         for (int i = 0; i < pings.size(); i++) {
    //             if (pings.get(i).getTimestamp() >= timestamp) {
    //                 index = i;
    //                 break;
    //             }
    //         }

    //         // Get all pings after the timestamp
    //         List<Ping> finalPings = pings.subList(index, pings.size());
    //         double distance = v.getTotalDistance(finalPings);

    //         // Add the vehicle's name to the list for this distance
    //         // distNameMap.computeIfAbsent(distance, k -> new ArrayList<>()).add(v.getName());

    //         if (distNameMap.containsKey(distance)) {
    //             distNameMap.get(distance).add(v.getName());
    //         } else {
    //             List<String> curr = new ArrayList<>();
    //             curr.add(v.getName());
    //             distNameMap.put(distance, curr);
    //         }
    //     }

    //     // Collect the results, keeping track of how many vehicles we've added
    //     List<String> result = new ArrayList<>();
    //     for (Map.Entry<Double, List<String>> entry : distNameMap.entrySet()) {
    //         if (result.size() >= maxResult) break;
    //         result.addAll(entry.getValue());
    //     }

    //     // Fill the result array, ensuring we don't exceed maxResult
    //     for (int j = 0; j < Math.min(result.size(), maxResult); j++) {
    //         res[j] = result.get(j);
    //     }

    //     return res;
    // }// end fun

     String[] getMostTraveledSince(int maxResult, long timestamp) {
        // Create a HashMap to store vehicle names and their distances
        Map<String, Double> vehicleDistances = new HashMap<>();

        // Calculate distances for each vehicle since the given timestamp
        for (Vehicle v : this.vehicles) {
            List<Ping> pings = v.getPings();
            int index = 0;

            // Find the index where pings have timestamps >= the given timestamp
            for (int i = 0; i < pings.size(); i++) {
                if (pings.get(i).getTimestamp() >= timestamp) {
                    index = i;
                    break;
                }
            }

            // Sublist of pings after the timestamp
            List<Ping> finalPings = pings.subList(index, pings.size());
            double distance = v.getTotalDistance(finalPings);

            // Store the distance in the HashMap
            vehicleDistances.put(v.getName(), distance);
        }

        // Use a PriorityQueue to sort the entries by distance in descending order
       // PriorityQueue<Map.Entry<String, Double>> maxHeap = new PriorityQueue<>(
         //   (a, b) -> Double.compare(b.getValue(), a.getValue()) // Max-heap by distance
        //);

        Comparator<Map.Entry<String, Double>> compPQ = new Comparator<Map.Entry<String, Double>>(){
            @Override
            public int compare(Map.Entry<String, Double> e1, Map.Entry<String, Double> e2){
                int valueComp = Double.compare(e2.getValue(), e1.getValue());
                if (valueComp == 0) return e1.getKey().compareTo(e2.getKey());
                return valueComp;
            }
        };

       PriorityQueue <Map.Entry<String, Double>> maxHeap = new PriorityQueue <Map.Entry<String, Double>>(compPQ);
            
        // Add all entries from the HashMap to the PriorityQueue
        maxHeap.addAll(vehicleDistances.entrySet());

        // Extract the top maxResult vehicles from the PriorityQueue
        String[] result = new String[maxResult];
        int count = 0;

        while (count < maxResult && !maxHeap.isEmpty()) {
            Map.Entry<String, Double> entry = maxHeap.poll();
            result[count++] = entry.getKey();
        }

        return result;
    }

    


    /**
     * Returns an array of names identifying vehicles that might have been
     * damaged through any number of risky behaviors, including collision with
     * another vehicle and excessive acceleration.
     */
    String[] checkForDamage() {
        //TODO: Implement

        for(Vehicle v : this.vehicles){
            List<Double> acc = v.getAccelerations(v.getPings());

            System.out.println("Vehicle: " + v.getName());


            for(Double a : acc) System.out.println(a);

        }

        return new String[0];
    }

    void initializeServer(String fileName) {
        String line = null;
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                String[] parsedLine = line.split(",");
                processPing(
                    parsedLine[0],
                    Double.parseDouble(parsedLine[1]),
                    Double.parseDouble(parsedLine[2]),
                    Integer.parseInt(parsedLine[3]));
            }

            bufferedReader.close();
        } catch (IOException ioException) {
            System.out.println("Exception thrown populating data: " + ioException);
        }
    }

    private void processPing(String vehicleName, double x, double y, long timestamp) {
        Ping ping = new Ping(x, y, timestamp);
        if (vehicles.isEmpty() || !vehicles.get(vehicles.size() - 1).getName().equals(vehicleName)) {
            vehicles.add(new Vehicle(vehicleName));
        }
        vehicles.get(vehicles.size() - 1).getPings().add(ping);
    }
}
