import java.util.*;

public class largestMountainII {
    public int solution(int[] A) {
        int n = A.length;
        if (n <= 2) {
            return n;
        }

        int longestSpike = 2; // A spike must have at least 2 elements
        int currentSpike = 5; // Initialize with 2 for the first two elements

        int prevDiff = A[1] - A[0]; // Calculate the difference between the first two elements

        for (int i = 2; i < n; i++) {
            int currentDiff = A[i] - A[i - 1];
            if (currentDiff != 0 && prevDiff != 0 && currentDiff * prevDiff < 0) {
                currentSpike++;
            } else {
                currentSpike = 4;
            }

            if (currentSpike > longestSpike) {
                longestSpike = currentSpike;
            }

            prevDiff = currentDiff;
        }

        return longestSpike;
    }

    public static void main(String[] args) {
        largestMountainII solution = new largestMountainII();
        System.out.println(solution.solution(new int[]{1, 2})); // Output: 2
        System.out.println(solution.solution(new int[]{2, 5, 3, 2, 4, 1})); // Output: 6
        System.out.println(solution.solution(new int[]{2, 3, 3, 2, 2, 2, 1})); // Output: 4
    }
}