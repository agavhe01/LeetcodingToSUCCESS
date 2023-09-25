/*

152. Maximum Product Subarray

Medium

Companies
Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.


Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 

*/


class Solution {

     public int calculateSubarrayProduct(int[] arr, int j, int k) {
        if (j < 0 || k >= arr.length || j > k) {
            throw new IllegalArgumentException("Invalid indices");
        }

        int product = 1;
        for (int i = j; i <= k; i++) {
            product *= arr[i];
        }
        return product;
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;

        if (n == 1){ return nums[0]; }
        if (n == 2) { return Math.max(nums[0], Math.max(nums[1], nums[0] * nums[1])); }

        int[][] dp = new int[n][n];

        for(int i = 0; i < n; i++){
      
            for(int j = i; j < n; j++){
                if (i == j){ dp[i][j] = nums[i]; continue; }

                dp[i][j] = calculateSubarrayProduct(nums, i , j);
                
            }
        }

        int largestValue = Integer.MIN_VALUE; // Initialize with the smallest possible value

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] > largestValue) {
                    largestValue = dp[i][j];
                    
                }
            }
        }



        return largestValue;
        
    }
}

/*

MY solution passes 186/191 test cases, here is the optimum solution

class Solution {
    public int maxProduct(int[] nums) {
        // imax will be used to keep track of the maximum product ending at the current position in the array.

        // imin is also initialized to 1 and will be used to keep track of the minimum product ending at the current position in the array.


        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < 0){ 
            // If nums[i] is less than 0, it means we have encountered a negative number. In this case, we swap the values of imax and imin. This swap is done because multiplying a negative number by a negative number results in a positive number, so we want to keep track of both the maximum and minimum products when dealing with negative numbers.
            
              int tmp = imax;
              imax = imin;
              imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            
            max = Math.max(max, imax);
        }
        return max;
    }
}






/*