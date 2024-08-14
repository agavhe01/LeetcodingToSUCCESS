import java.util.*;

 class Lion {
        String name;
        int height;

        public Lion(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }

 class LionCompetition {

    
    private Map<String, Lion> myLions;
    private Map<String, int[]> schedule; // To store enter and exit times
    private TreeMap<Integer, Integer> heightsCount; // Count heights for efficient max height calculation
    private Set<String> myLionsInRoom; // Track your lions currently in the room

    public LionCompetition(List<Lion> lions, Map<String, int[]> schedule) {
        this.myLions = new HashMap<>();
        this.schedule = schedule;
        this.heightsCount = new TreeMap<>(Collections.reverseOrder());
        this.myLionsInRoom = new HashSet<>();

        for (Lion lion : lions) {
            myLions.put(lion.name, lion);
        }
    }

    public void lionEntered(int currentTime, int height) {
        // Check if it's one of our lions
        for (Map.Entry<String, Lion> entry : myLions.entrySet()) {
            String lionName = entry.getKey();
            Lion lion = entry.getValue();
            int[] times = schedule.get(lionName);

            if (times[0] == currentTime && lion.height == height) {
                // It's our lion entering
                // System.out.println("My lion: " + lionName + " entered the room");
                myLionsInRoom.add(lionName);
                return;
            }
        }

        // Otherwise, it's a competitor lion
        heightsCount.put(height, heightsCount.getOrDefault(height, 0) + 1);
    }

    public void lionLeft(int currentTime, int height) {
        // Check if it's one of our lions
        for (Map.Entry<String, Lion> entry : myLions.entrySet()) {
            String lionName = entry.getKey();
            Lion lion = entry.getValue();
            int[] times = schedule.get(lionName);

            if (times[1] == currentTime && lion.height == height) {
                // It's our lion leaving
                myLionsInRoom.remove(lionName);
                return;
            }
        }

        // Otherwise, it's a competitor lion
        if (heightsCount.containsKey(height)) {
            heightsCount.put(height, heightsCount.get(height) - 1);
            if (heightsCount.get(height) == 0) {
                heightsCount.remove(height);
            }
        }
    }

    public List<String> getBiggestLions(int currentTime) {
        List<String> result = new ArrayList<>();

        // Determine the max competitor lion height
        int maxCompetitorHeight = heightsCount.isEmpty() ? 0 : heightsCount.firstKey();

        for (String lionName : myLionsInRoom) {
            Lion lion = myLions.get(lionName);
            // System.out.println("Comparing " + lionName + " of height " + lion.height + " with " + maxCompetitorHeight);
            if (lion.height >= maxCompetitorHeight) {
                result.add(lionName);
            }
        }

        Collections.sort(result);
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Lion> lions = new ArrayList<>();
        lions.add(new Lion("marry", 300));
        lions.add(new Lion("rob", 250));

        Map<String, int[]> schedule = new HashMap<>();
        schedule.put("marry", new int[]{10, 15});
        schedule.put("rob", new int[]{13, 20});

        LionCompetition competition = new LionCompetition(lions, schedule);

        competition.lionEntered(8, 200);  // Competitor enters
        competition.lionEntered(10, 310); // Competitor enters
        competition.lionEntered(10, 300); // Marry enters

        System.out.println(competition.getBiggestLions(11)); // Should return []

        competition.lionEntered(13, 250); // Rob enters
        competition.lionLeft(13, 310); 

        System.out.println(competition.getBiggestLions(13)); // Should return [marry, rob]

        competition.lionLeft(15, 300); // Marry leaves

        System.out.println(competition.getBiggestLions(16)); // Should return [rob]
    }
}
