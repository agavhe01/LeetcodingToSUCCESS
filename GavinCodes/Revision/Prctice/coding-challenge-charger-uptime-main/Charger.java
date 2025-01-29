import java.util.Comparator;

public class Charger{

    // Charger id
    public Integer chargerId;

    // When was Charger initially ready
    public Long lowerBoundTime;

    // When was Charger last available
    public Long upperBoundTime;

    // Total time Charger was used for 
    public Long runtime;


    /*  
        constructor()   
            Arguments
                * Integer representing Charger Id
            Purpose
                * Creates a Charger Object and initializes fields
    */
    public Charger(Integer id){
        chargerId = id;
        runtime = 0L;
        lowerBoundTime = Long.MAX_VALUE;
        upperBoundTime = Long.MIN_VALUE;
    }


    /*  
        processInterval()   
            Arguments
                * Interval relevant to the charger
            Purpose
                * Updates the start and end times of the charger availability
                * Adds the usage runtime of the charger 
    */
    public void processInterval(Interval interval){
        if (Integer.compare(interval.chargerId, chargerId) != 0) { System.out.println("Wrong interval chargerId"); return; }

        lowerBoundTime = Math.min(lowerBoundTime, interval.start);
        upperBoundTime = Math.max(upperBoundTime, interval.end);

        if (interval.running){
            Long cumulative = interval.end - interval.start;
            runtime += cumulative;
        }
    }


     /*  
        getRuntime()   
            Return
                * Integer representing the total time the charger was being used for
    */
    public Long getRuntime(){ return this.runtime; }


    /*  
        getTotalTime()   
            Purpose
                * If lower and upper are unchanged since initialization, return 0 else calulate totaltime and return
            Return
                * Long representing the total time the charger existed for        
    */
    public Long getTotalTime(){ 
        //
        if ( Long.compare(lowerBoundTime, Long.MAX_VALUE ) == 0 || Long.compare(upperBoundTime, Long.MIN_VALUE ) == 0 ) return 0L;
        return Math.abs(upperBoundTime - lowerBoundTime); 
    }


    /*  
        printCharger()   
            Purpose
                * Prints the Charger information to standard output seperated by 1 newline
    */
    public void printCharger(){
        System.out.println("  Charger Id: " + chargerId);
        System.out.println(" Lower Bound: " + lowerBoundTime);
        System.out.println(" Upper Bound: " + upperBoundTime);
        System.out.println("     Runtime: " + runtime);
        System.out.println();
    }

    
}