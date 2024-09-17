import java.util.*;

public class SortMapEntry{

   
    public SortMapEntry(){}

    public static void main(String[] args){
        SortMapEntry sol = new SortMapEntry();

        TreeMap<Integer, Integer> tMap = new TreeMap<>();
        tMap.put(1, 5);
        tMap.put(2, 3);
        tMap.put(3, 8);
        tMap.put(4, 1);
        tMap.put(5, 3); // Another entry with the same value (3)

        Comparator<Map.Entry<String, Integer>> descInt = new Comparator<Map.Entry<String, Integer>>(){
            @Override
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
                int intComp = e1.getValue().compareTo(e2.getValue());
                if (intComp == 0){
                    return e1.getKey().compareTo(e2.getKey());
                }
                else return intComp; // e1.getValue().compareTo(e2.getValue());
            }
        };

        // Comparator<String, Integer> descIntComp = new Comparator<String, Integer>(){
        //     @Override
        //     public int compare(St)

        // };


        Map<String, Integer> cMap = new HashMap<String, Integer>();
        cMap.put("Anesu", 10);
        cMap.put("Zidane", 94);
        cMap.put("Ronaldinho", 94);
        cMap.put("Ronaldo", 92);
        cMap.put("Rooney", 90);
        cMap.put("Aguero", 90);

        cMap.put("Mainoo", 76);
        cMap.put("Quansah", 65);
        cMap.put("Musona", 57);

        for(Map.Entry<String, Integer> entry : cMap.entrySet()){
            System.out.println("Player: " + entry.getKey() + " and Rating: " + entry.getValue());
        }

        System.out.println();

        List<Map.Entry<String, Integer>> listPlayers = new ArrayList<>(cMap.entrySet());
        Collections.sort(listPlayers, descInt);

        for(Map.Entry<String, Integer> entry : listPlayers){
            System.out.println("Player: " + entry.getKey() + " Rating: " + entry.getValue());
        }



        System.out.println();
        System.out.println("Player Map Now");

        Comparator<Player> playerComp = new Comparator<Player>(){
            @Override
            public int compare(Player p1, Player p2){
                int ratingComp = Integer.compare(p1.rating, p2.rating);
                if (ratingComp == 0) return p2.name.compareTo(p2.name);
                else return ratingComp;
            }

        };

        Map<Player, String> playerMap = new TreeMap<Player, String>(playerComp);

        playerMap.put(new Player("Anesu", 10), "Anesu");
        playerMap.put(new Player("Zidane", 94), "Zidane");
        playerMap.put(new Player("Ronaldinho", 94), "Ronaldinho");
        playerMap.put(new Player("Ronaldo", 92), "Ronaldo");
        playerMap.put(new Player("Aguero", 90), "Aguero");
        playerMap.put(new Player("Rooney", 90), "Rooney");

        cMap.put("Zidane", 94);
        cMap.put("Ronaldinho", 94);
        cMap.put("Ronaldo", 92);
        cMap.put("Rooney", 90);
        cMap.put("Aguero", 90);

        for (Map.Entry<Player, String> entry : playerMap.keySet()){
            System.out.println("Player Name: " + entry.getValue() + " and Player Rating: " + entry.getKey().rating);
        }




    }
}

 class Player{
        String name;
        int rating;
        public Player(String name, int rating){
            this.name = name; this.rating = rating;
        }

    }