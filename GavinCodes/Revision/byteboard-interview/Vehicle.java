import java.util.List;
import java.util.ArrayList;
import java.util.*;

/**
 * A named vehicle with a sequence of pings.
 */
final class Vehicle {
    private final String name;
    private final List<Ping> pings;


    Vehicle(String name) {
        this.name = name;
        this.pings = new ArrayList<Ping>();
    }

    /**
     * The name of the vehicle.
     */
    String getName() {
        return this.name;
    }

    /**
     * The pings for the vehicle, in chronological order (earliest first).
     */
    List<Ping> getPings() {
        return this.pings;
    }

    public String toString() {
        return this.name + ": " + this.pings;
    }

    /**
     * Determines the total distance covered by the pings.
     */
    static double getTotalDistance(List<Ping> pings) {
        /*
        double distance = 0;
        Ping start = pings.get(0);
        for(Ping p : pings){
            if (p.equals(temp)){ continue; }
            else{ 
                distance += Position.getDistance(temp.getPosition(), p.getPosition()); 
                temp = p;
            }
        }
        return distance;
        */

        double distance = 0.0;
        if (pings.size() <= 1) return distance; // cannot have a distance if only 1 or 0 pings
        
        int i = 0;
        for(int j = 1; j < pings.size(); j++){
            Ping start = pings.get(i);
            Ping end = pings.get(j);
            distance += Position.getDistance(start.getPosition(), end.getPosition());
            i = j;
        }
        return distance;
    }

    /**
     * Determines the total distance traveled by the vehicle.
     */
    double getTotalDistance() {
        return getTotalDistance(this.pings);
        
    }

    /**
     * Determines the average speed of the vehicle.
     */
    double getAverageSpeed() {
        
       double dist = getTotalDistance();
       if (dist == 0.0) return dist;

       // Since pings are sorted we only need first timestamp and last to determine time
       Ping first = this.pings.get(0);
       Ping last = this.pings.get(this.pings.size() - 1);
       long time = Ping.secondsBetween(first, last);
       double speed = dist / time;
       return speed;

    }

     double getAverageSpeed(List<Ping> pings) {
        
       if (pings.size() == 1) return 0.0;
       double dist = getTotalDistance(pings);
       if (dist == 0.0) return dist;


       // Since pings are sorted we only need first timestamp and last to determine time
       Ping first = pings.get(0);
       Ping last = pings.get(pings.size() - 1);
       long time = Ping.secondsBetween(first, last);
       double speed = dist / time;
       return speed;

    }

   List<Double> getAccelerations(List<Ping> pings) {
    List<Double> result = new ArrayList<>();
    int n = pings.size();

    // We need at least 3 pings to calculate acceleration (2 intervals)
    if (n <= 2) return result;

    for (int i = 1; i < n - 1; i++) {
        // Speed between pings[i-1] and pings[i]
        double u = getAverageSpeed(Arrays.asList(pings.get(i - 1), pings.get(i)));
        
        // Speed between pings[i] and pings[i+1]
        double v = getAverageSpeed(Arrays.asList(pings.get(i), pings.get(i + 1)));
        
        // Time difference between pings[i] and pings[i+1] (consecutive intervals)
        long deltaT = Ping.secondsBetween(pings.get(i), pings.get(i + 1));

        //System.out.println("u: " + u);
        //System.out.println("v: " + v);
        //System.out.println("deltaT: " + deltaT);

        // Ensure there's no division by zero
        double acc = (deltaT == 0) ? 0.0 : (v - u) / deltaT;

        result.add(acc);
    }

    return result;
}

}
