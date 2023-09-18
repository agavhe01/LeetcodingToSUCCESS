/*

198. House Robber

Medium

Companies
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.


Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.


*/


public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        int n = A.length;
        if (n == 0)
            return 0;


        /*
An array res is created to store the maximum amount of money that can be robbed up to the i-th house. It is of length n+1 to accommodate for the base cases.
        */
        long []res = new long[n+1];
        
        res[0] = 0;
        res[1] = A[0]; // For the first house, res[1] is set to the value of the first house in the input array.

        /*
For each house i, the code calculates the maximum amount of money that can be robbed up to that house. It does this by considering two options:

Option 1: Not robbing the current house, which means the maximum amount of money is the same as the maximum amount obtained up to the previous house (res[i-1]).
Option 2: Robbing the current house, which means adding the current house's value (A[i-1]) to the maximum amount obtained up to the house two steps back (res[i-2]).

        */
        for (int i = 2; i <= n; i++) {
            res[i] = Math.max(res[i-1], res[i-2] + A[i-1]);
        }
        return res[n];
    }
}