import java.util.*;

public class Solution {

    public long getMedianSubarrays(int[] efficiency, int k) {
        int n = efficiency.length;
        int target = efficiency[k - 1];
        long result = 0;

        for (int start = 0; start < n; start++) {
            int count = 0; // Count elements less than target
            int greater = 0; // Count elements greater than target

            for (int length = 1; start + length <= n; length++) {
                int num = efficiency[start + length - 1];

                if (num < target) count++;
                else if (num > target) greater++;

                if (length % 2 == 1) { // Check only odd-length subarrays
                    int medianIndex = length / 2;
                    if (greater <= medianIndex && count <= medianIndex) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] efficiency = {5, 3, 1, 4, 7, 7};
        int k = 4;
        System.out.println(solution.getMedianSubarrays(efficiency, k)); // Output: 4

        int[] efficiency1 = {1, 2, 3};
        System.out.println(solution.getMedianSubarrays(efficiency1, 1)); // Output: 1
    }
}
