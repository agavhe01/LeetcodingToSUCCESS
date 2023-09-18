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
}sol