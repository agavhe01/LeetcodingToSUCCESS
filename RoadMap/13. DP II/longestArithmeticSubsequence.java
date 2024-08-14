/*

1027. Longest Arithmetic Subsequence
Medium
Topics
Companies

Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.

Note that:

    A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.
    A sequence seq is arithmetic if seq[i + 1] - seq[i] are all the same value (for 0 <= i < seq.length - 1).


Example 1:

Input: nums = [3,6,9,12]
Output: 4
Explanation:  The whole array is an arithmetic sequence with steps of length = 3.

Example 2:

Input: nums = [9,4,7,2,10]
Output: 3
Explanation:  The longest arithmetic subsequence is [4,7,10].

Example 3:

Input: nums = [20,1,15,3,10,5,8]
Output: 4
Explanation:  The longest arithmetic subsequence is [20,15,10,5].


*/

class Solution {
    public int longestArithSeqLength(int[] nums) {
        int count = 2;
        int len = nums.length;

        int[][] dp = new int[len][2000];
        for (int[] i : dp) {
            Arrays.fill(i, 0);
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                // Adding 1000 to make the number postive 
                // as the diff betn tow number ranges from -1000 to 1000
                int diff = nums[j] - nums[i] + 1000;
                dp[j][diff] = Math.max(2, dp[i][diff] + 1);
                count = Math.max(count, dp[j][diff]);
            }
        }
        return count;
    }
}