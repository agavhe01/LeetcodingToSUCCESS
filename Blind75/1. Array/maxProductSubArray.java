public class maxProductSubArray{

    public maxProductSubArray(){}

    /*
        MY SOLUTION --> TEST ON LEETCODE
        TC : O(n)
        SC : O(1)

    */

    public static int maxProduct(int[] arr){
        int n = arr.length;
        if (n == 0) return 0;

        int left = 0;
        int sum = arr[left];
        int result = sum;

        for(int right = 1; right < n; right++){
                int prevSum = sum;
                sum *= arr[right];
                result = Math.max(result, sum);
                if (sum < prevSum) left++;
        }
        return result;
    }

    public static int maxProduct2(int[] nums) {
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
    



    public static void main(String[] args){
        maxProductSubArray sol = new maxProductSubArray();

        int[] test1 = new int[]{2,3,-2,4};
        int[] test2 = new int[]{-2,0,-1};
        int[] test3 = new int[]{5,4,-1,7,8};

        int sol1 = sol.maxProduct(test1);
        int sol2 = sol.maxProduct(test2);
        int sol3 = sol.maxProduct(test3);

        // int sol1 = sol.maxSubArray(test1);
        // int sol2 = sol.maxSubArray(test2);

        System.out.println("Max Sum  6 -->  " + sol1);
        System.out.println("Max Sum  0 -->  " + sol2);
        // System.out.println("Max Sum 23 --> "  + sol3);
    }
}