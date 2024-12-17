/*

416. Partition Equal Subset Sum
Solved
Medium
Topics
Companies

Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

 
Constraints:

    1 <= nums.length <= 200
    1 <= nums[i] <= 100


*/


class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum = 0;
        for(int n : nums) sum += n;
        if (sum % 2 != 0) return false;

        sum = sum / 2;
        Boolean[][] memo = new Boolean[nums.length][sum + 1];
        return helper(0, sum, nums, memo);

    }

    public boolean helper(int index, int sum, int[] nums, Boolean[][] memo ){

        if (sum == 0) return true;

        if (sum < 0 || index >= nums.length) return false;

        if (memo[index][sum] != null) return memo[index][sum];

        Boolean include = helper(index + 1, sum - nums[index], nums, memo);
        Boolean exclude = helper(index + 1, sum              , nums, memo);

        memo[index][sum] = include || exclude;
        return memo[index][sum];
    }
}