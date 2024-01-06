
/*

53. Maximum Subarray

Medium

Given an integer array nums, find the 
subarray
 with the largest sum, and return its sum.

 

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

*/

// KADANE
class Solution {
   public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE, sum = 0;
        
        for(int i=0;i<n;i++){
            sum += nums[i];
            max = Math.max(sum,max);
            
            if(sum<0) sum = 0;
        }
        
        return max;
    }
}


/*

DP APPROACH

public class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum = nums[0];      
        int max_ending_here = nums[0]; 

        for (int i = 1; i < nums.length; i++) {
            max_ending_here = Math.max(max_ending_here + nums[i], nums[i]);
            max_sum = Math.max(max_sum, max_ending_here);
        }

        return max_sum;
    }
}

*/