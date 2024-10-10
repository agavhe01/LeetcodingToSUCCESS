
import com.google.gson.*;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;

import java.io.FileReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Ride> ridesList = new ArrayList<>();
        ArrayList<Rating> ratingsList = new ArrayList<>();

        try {
            // Parse the JSON file
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = (JsonObject) parser.parse(new FileReader("input001.json"));

            // Parse rides array
            JsonArray ridesArray = jsonObject.getAsJsonArray("rides");
            for (JsonElement rideElement : ridesArray) {
                JsonObject rideObject = rideElement.getAsJsonObject();
                Long rideId = rideObject.get("rideId").getAsLong();
                Long riderId = rideObject.get("riderId").getAsLong();
                Long driverId = rideObject.get("driverId").getAsLong();
                Long timestamp = rideObject.get("timestamp").getAsLong();

                // Add to Ride list
                Ride ride = new Ride(rideId, riderId, driverId, timestamp);
                ridesList.add(ride);
            }

            // Parse ratings array
            JsonArray ratingsArray = jsonObject.getAsJsonArray("ratings");
            for (JsonElement ratingElement : ratingsArray) {
                JsonObject ratingObject = ratingElement.getAsJsonObject();
                Long rideId = ratingObject.get("rideId").getAsLong();
                Long ratingFromUserId = ratingObject.get("ratingFromUserId").getAsLong();
                Long rating = ratingObject.get("rating").getAsLong();

                // Add to Rating list
                Rating ratingItem = new Rating(rideId, ratingFromUserId, rating);
                ratingsList.add(ratingItem);
            }

            // Print the results
            System.out.println("Rides:");
            for (Ride ride : ridesList) {
                System.out.println(ride);
            }

            System.out.println("\nRatings:");
            for (Rating rating : ratingsList) {
                System.out.println(rating);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
