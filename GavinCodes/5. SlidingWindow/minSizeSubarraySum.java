/*

209. Minimum Size Subarray Sum
Medium
Topics
Companies
Given an array of positive integers nums and a positive integer target, return the minimal length of a 
subarray
 whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

*/


class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        int minLength = Integer.MAX_VALUE;
        int currSum = 0;
        int left = 0;

        for(int right = 0; right < n; right++){
            currSum += nums[right];

            while(currSum >= target){
                minLength = Math.min(minLength, right - left + 1);
                currSum -= nums[left];
                left++;
                
            }

        }

        if (minLength == Integer.MAX_VALUE) return 0;
        return minLength;
        
    }
}

/*
public static int shortestSubarray(int[] nums, int target) {
        int L = 0, total = 0;
        int length = Integer.MAX_VALUE;

        for (int R = 0; R < nums.length; R++) {
            total += nums[R];
            while (total >= target) {
                length = Math.min(R - L + 1, length);
                total -= nums[L];
                L++;
            }
        }

        if (length ==  Integer.MAX_VALUE) {
            return 0;
        } 
        return length;
    }
}

*/