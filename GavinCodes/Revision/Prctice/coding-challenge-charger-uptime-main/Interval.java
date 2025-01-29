public class Interval{

    // Charger Id
    Integer chargerId;

    // Interval start time
    Long start;

    // Inteval end time
    Long end;

    // Was charger being used?
    boolean running;


    /*  
        constructor()   
            Arguments
                * Charger Id, start time, end time, running ?
            Return
                * Interval object
    */
    public Interval(Integer id, Long begin, Long stop, boolean state){
        chargerId = id;
        start = begin;
        end = stop;
        running = state;
    }


}