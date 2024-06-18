/*

287. Find the Duplicate Number
Solved
Medium
Topics
Companies
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Example 1:

Input: nums = [1,3,4,2,2]
Output: 2
Example 2:

Input: nums = [3,1,3,4,2]
Output: 3
Example 3:

Input: nums = [3,3,3,3,3]
Output: 3
 

*/

class Solution {
    public int findDuplicate(int[] nums) {

        int slow = 0; int fast = 0;

        do 
        {
            slow = nums[slow];
            fast = nums[nums[fast]];

        }  while (slow != fast);

        int slow2 = 0;

        do
        {
            slow2 = nums[slow2];
            slow = nums[slow];

        } while (slow2 != slow);

        return slow;
        
    }
}

/*


class Solution {
    public int findDuplicate(int[] nums) {

        int slow = nums[0];
        int fast = nums[nums[0]];

        while (fast != slow){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        int slow2 = 0;

        while (slow2 != slow) {
            slow2 = nums[slow2];
            slow = nums[slow];
        }

        return slow2;
        
    }
}

*/