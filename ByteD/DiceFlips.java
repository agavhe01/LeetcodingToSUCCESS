import java.util.HashMap;
import java.util.Map;

public class DiceFlips {
    public static int minDiceFlips(int[] diceFaces) {
        if (diceFaces == null || diceFaces.length == 0) {
            return 0;
        }

        // Count the frequency of each number in the array
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int face : diceFaces) {
            frequencyMap.put(face, frequencyMap.getOrDefault(face, 0) + 1);
        }

        // Find the mode (most frequent number)
        int mode = -1;
        int maxFrequency = 0;
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxFrequency) {
                mode = entry.getKey();
                maxFrequency = entry.getValue();
            }
        }

        // Calculate the minimum flips needed to make all dice show the mode
        int totalFlips = 0;
        for (int face : diceFaces) {
            if (face != mode) {
                if (face + mode == 7) {
                    totalFlips += 2;
                } else {
                    totalFlips += 1;
                }
            }
        }

        return totalFlips;
    }

    public static void main(String[] args) {
        // Test Case 1: [1, 6, 3, 4]
        int[] diceFaces1 = {1, 6, 3, 4};
        int minFlips1 = minDiceFlips(diceFaces1);
        System.out.println("Minimum number of flips for Test Case 1: " + minFlips1); // Expected Output: 2

        // Test Case 2: [1, 2, 3, 4]
        int[] diceFaces2 = {1, 2, 3, 4};
        int minFlips2 = minDiceFlips(diceFaces2);
        System.out.println("Minimum number of flips for Test Case 2: " + minFlips2); // Expected Output: 1

        // Test Case 3: [6, 2, 4, 6, 1, 3]
        int[] diceFaces3 = {6, 2, 4, 6, 1, 3};
        int minFlips3 = minDiceFlips(diceFaces3);
        System.out.println("Minimum number of flips for Test Case 3: " + minFlips3); // Expected Output: 2

        // Test Case 4: [1, 1, 1, 1, 1]
        int[] diceFaces4 = {1, 1, 1, 1, 1};
        int minFlips4 = minDiceFlips(diceFaces4);
        System.out.println("Minimum number of flips for Test Case 4: " + minFlips4); // Expected Output: 0
    }
}
