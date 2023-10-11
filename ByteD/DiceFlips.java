import java.util.*;

public class DiceFlips {
    public static int minDiceFlips(int[] diceFaces) {
        if (diceFaces == null || diceFaces.length == 0) {
            return 0;
        }

        Map<Integer, Integer> countEachSingle = new HashMap<>();
        Map<HashSet<Integer>, Integer> countEachPair = new HashMap<>();

        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1, 6));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(2, 5));
        HashSet<Integer> set3 = new HashSet<>(Arrays.asList(3, 4));

        Integer old;

        for(int i = 0; i < diceFaces.length; i++){
            Integer val = diceFaces[i];
            old = countEachSingle.getOrDefault(val, 0);
            countEachSingle.put(val, old + 1);

            if (set1.contains(val)){ 
                old = countEachPair.getOrDefault(set1, 0);
                countEachPair.put(set1, old + 1);
            }
            else if (set2.contains(val)){
                old = countEachPair.getOrDefault(set2, 0);
                countEachPair.put(set2, old + 1);
            }
            else if(set3.contains(val)){
                old = countEachPair.getOrDefault(set3, 0);
                countEachPair.put(set3, old + 1);
            }
            else{ System.out.println("Should not be here. Value not in set!!!"); }
        }

        Integer singleMax = Integer.MIN_VALUE;
        Integer pairMax = Integer.MIN_VALUE;
        HashSet<Integer> maxPair = set1;

        for(HashSet<Integer> key: countEachPair.keySet()){
            old = countEachPair.getOrDefault(key, 0);
            if (pairMax <= old){ pairMax = old; maxPair = key; }
        }

        Integer target = 0;
        

        Iterator<Integer> it = maxPair.iterator();

        while (it.hasNext()){
            Integer element = it.next();
            old = countEachSingle.getOrDefault(element, 0);
            if (singleMax <= old){ singleMax = old; target = element; }

        }

        
System.out.println("Target:" + target);
        int result = 0;

        for(int i = 0; i < diceFaces.length; i++){
            Integer currDie = diceFaces[i];

            if (currDie == target){
                continue;
            }

            if (maxPair.contains(currDie)){
                result += 2;
            }
            else{
                result += 1;
            }

        }





        return result;
    }

    public static void main(String[] args) {
        // Test Case 1: [1, 6, 3, 4]
        int[] diceFaces1 = {1, 6, 3, 4};
        int minFlips1 = minDiceFlips(diceFaces1);
        System.out.println("Minimum number of flips for Test Case 1: " + minFlips1); // Expected Output: 4

        // Test Case 2: [1, 2, 3, 4]
        int[] diceFaces2 = {1, 2, 3, 4};
        int minFlips2 = minDiceFlips(diceFaces2);
        System.out.println("Minimum number of flips for Test Case 2: " + minFlips2); // Expected Output: 4

        // Test Case 3: [6, 2, 4, 6, 1, 3]
        int[] diceFaces3 = {6, 2, 4, 6, 1, 3};
        int minFlips3 = minDiceFlips(diceFaces3);
        System.out.println("Minimum number of flips for Test Case 3: " + minFlips3); // Expected Output: 6

        // Test Case 4: [1, 1, 1, 1, 1]
        int[] diceFaces4 = {1, 1, 1, 1, 1};
        int minFlips4 = minDiceFlips(diceFaces4);
        System.out.println("Minimum number of flips for Test Case 4: " + minFlips4); // Expected Output: 0
    }
}
