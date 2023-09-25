/*

213. House Robber II

Medium

Companies
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
Example 2:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 3:

Input: nums = [1,2,3]
Output: 3

*/

class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return nums[0];
        } else if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        /*

If there are more than two houses, the code proceeds to solve the problem by considering two scenarios:

Rob houses from the first house to the second-to-last house (0 to length - 2) using the robRange function.
Rob houses from the second house to the last house (1 to length - 1) using the robRange function.
Take the maximum of the two scenarios, as you can't rob both the first and last houses at the same time.

        */
        return Math.max(robRange(nums, 0, length - 2), robRange(nums, 1, length - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start + 1]);

        /*
For each house, it calculates the maximum amount of money that can be robbed considering two options:

Option 1: Not robbing the current house, which means the maximum amount of money is the same as the maximum amount obtained up to the previous house (second).
Option 2: Robbing the current house, which means adding the current house's value (nums[i]) to the maximum amount obtained up to the house two steps back (first).

        */
        for (int i = start + 2; i <= end; i++) {
            int temp = second;

            //The second variable is updated with the maximum amount between the two options, and the first variable is updated to store the previous value of second.
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}