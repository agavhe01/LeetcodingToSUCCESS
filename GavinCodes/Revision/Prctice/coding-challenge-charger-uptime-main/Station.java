import java.util.Map;
import java.util.HashMap;

public class Station{

    // Station ID
    Integer stationId;

    // Keeps track of all the chargers mapped by Charger Id
    HashMap<Integer, Charger> allChargers;

    // Total time chargers are being used for
    Long totalUptime = 0L;

    // Total time chargers exist for
    Long totalTime = 0L;


    /*  
        constructor()   
            Arguments
                * Integer representing Station Id
            Purpose
                * Creates a Station Object and creates the HashMap to store Chargers, mapped by Charger Id
    */
    public Station(Integer id){
        stationId = id;
        allChargers = new HashMap<Integer, Charger>();
    }


    /*  
        addCharger()   
            Arguments
                * Charger object to be added to the relevant station
            Purpose
                * Adds Charger object to relevant Station object
    */
    public void addCharger(Charger c1){ allChargers.put(c1.chargerId, c1); }


    /*  
        getCharger()   
            Arguments
                * Charger Id 
            Return
                * Charger object of the given Charger Id
    */
    public Charger getCharger(int chargerId){ return allChargers.get(chargerId); }


    /*  
        calculateRuntime()   
            Purpose
                * Iterates through all chargers, noting the total on time and total existing time
            Return
                * Integer representing runtime percentage, rounded down to the nearest percent
    */
    public int calculateRuntime(){

        for (Map.Entry<Integer, Charger> entry : allChargers.entrySet()) {
            Charger charger = entry.getValue();
            totalUptime += charger.getRuntime(); 
            totalTime += charger.getTotalTime();
        }

        if (totalTime == 0) { return 0; } 
        return (int) ((totalUptime * 100) / totalTime); // Compute percentage, rounding down
        
    }

    /*  
        printStation()   
            Purpose
                * Prints the Station information to standard output seperated by 2 newlines
    */
    public void printStation(){
        System.out.println("Station Id: " + stationId);
        System.out.println();
        for (Map.Entry<Integer, Charger> entry : allChargers.entrySet()) {
            Charger charger = entry.getValue();
            charger.printCharger();
        }
        System.out.println();
        System.out.println();
    }


}