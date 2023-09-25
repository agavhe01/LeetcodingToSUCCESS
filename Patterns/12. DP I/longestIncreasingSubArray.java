/*

300. Longest Increasing Subsequence

Medium

Given an integer array nums, return the length of the longest strictly increasing 
subsequence
.
Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1


*/

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // This array is used to keep track of the length of the longest increasing subsequence ending at each position in the nums array.
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {

                    /*
 If nums[j] is less than nums[i], it means that nums[i] can be added to the increasing subsequence ending at position j, potentially increasing its length. In this case, update dp[i] to be the maximum of its current value dp[i] and dp[j] + 1. This step ensures that we consider all possible subsequences ending at position i.

                    */
                     //System.out.println(i +" " +j + " dp[i]:" + dp[i] + " dp[j]:" + dp[j]);
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            res = Math.max(res, dp[i]);
        }

        // for (int k = 0; k < dp.length; k++){
        //     System.out.println(k + " " + dp[k]);
        // }
        return res;
    }
}