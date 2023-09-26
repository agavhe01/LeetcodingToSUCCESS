import java.util.*;

public class teamSolution {
    public static int maxNonDecreasingLength(List<Integer> nums1, List<Integer> nums2) {
        int n = nums1.size();
        
        int result = 1;
        
        // dp[current][index]
        int[][] dp = new int[2][n];

        // base state
        dp[0][0] = 1;
        dp[1][0] = 1;

        for (int i = 1; i < n; ++i) {
            // transition if we select nums1[i]
            dp[0][i] = Math.max(
                nums1.get(i) >= nums1.get(i - 1) ? dp[0][i - 1] + 1 : 1,
                nums1.get(i) >= nums2.get(i - 1) ? dp[1][i - 1] + 1 : 1
            ); 

            // transition if we select nums2[i]
            dp[1][i] = Math.max(
                nums2.get(i) >= nums1.get(i - 1) ? dp[0][i - 1] + 1 : 1,
                nums2.get(i) >= nums2.get(i - 1) ? dp[1][i - 1] + 1 : 1
            );

            // keep updating the result on the go
            // or iterate over DP in the end to find MAX
            result = Math.max(result, Math.max(dp[0][i], dp[1][i]));
        }        
        
        return result;
    }

     public static void main(String[] args) {
        
        // int[] a1 = {5,2,4,1};
        // int[] b1 = {3,6,2,2};
        // int res1 = getMaxSubarrayLen(a1, b1);
        // assert (res1 == ): "Expected 2, actual: " + res1;



        // int[] a2 = {45,81,29,2,25,84,32,28,37,39};
        // int[] b2 = {72,47,97,75,82,17,2,56,57,18};
        // int res2 = getMaxSubarrayLen(Arrays.asList(45,81,29,2,25,84,32,28,37,39), Arrays.asList(72,47,97,75,82,17,2,56,57,18));
        // assert (res2 == 10): "Expected 10, actual: " + res2;

        // int[] a3 = {4,3,2,5,3};
        // int[] b3 = {4,10,2,8,4};
        // int res3 = getMaxSubarrayLen(a3, b3);
        // assert (res3 == 3): "Expected 2, actual: " + res3; // not 3

        int[] a4 = {2,9,7};
        int[] b4 = {2,10,8};
        int res4 = maxNonDecreasingLength(Arrays.asList(2,9,7), Arrays.asList(2,10,8));
        assert (res4 == 2): "Expected 2, actual: " + res4; 

        // int[] a5 = {2,7,3};
        // int[] b5 = {4,2,6};
        int res5 = maxNonDecreasingLength(Arrays.asList(2,7,3), Arrays.asList(4,2,6));
        assert (res5 == 2): "Expected 2, actual: " + res5; 

        // int[] a6 = {9,7};
        // int[] b6 = {10,8};
        // int res6 = getMaxSubarrayLen(Arrays.asList(9, 7), Arrays.asList(10, 8));
        // assert (res6 == 1): "Expected 1, actual: " + res6; 



        

        // int minMoves1 = minMoves(n, startRow, startCol, endRow, endCol);
        // assert(minMoves1 == 2): "Expected 2, actual: " + minMoves1;

        // int minMoves2 = minMoves(10, 0, 0, 0, 2);
        // assert(minMoves2 == 2): "Expected 2, actual: " + minMoves2;

        // int minMoves3 = minMoves(7,6,6,0,1);
        // assert(minMoves3 == 5): "Expected 5, actual: " + minMoves3;

        // int minMoves4 = minMoves(6, 5, 1, 0, 5);
        // assert(minMoves4 == 3): "Expected 3, actual: " + minMoves4;

        // int minMoves5 = minMoves(8,0,0,1,1);
        // assert(minMoves5 == 4): "Expected 4, actual: " + minMoves5;

        // int minMoves6 = minMoves(10, 9,9,5,3);
        // assert(minMoves6 == 4): "Expected 4, actual: " + minMoves6;

        // int minMoves7= minMoves(30, 25, 2, 23, 29);
        // assert(minMoves7 == 15): "Expected 15, actual: " + minMoves7;

        // int minMoves8 = minMoves(10, 9, 9, 5, 3);
        // assert(minMoves8 == 4): "Expected 4, actual: " + minMoves8;

        




    }
}
