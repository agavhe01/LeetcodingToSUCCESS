public class maxSumArray{

    public maxSumArray(){}
    
     /*
        PREFERRED SOLUTION
        TC : O(n)
        SC : O(1)

    */

      public int maxSubArray(int[] nums) {
        int curr = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], nums[i] + curr);
            max = Math.max(max, curr);
        }
        return max;
    }


    public static void main(String[] args){
        maxSumArray sol = new maxSumArray();

        int[] test1 = new int[]{2,1,-3,4,-1,2,1,-5,4};
        int[] test2 = new int[]{2};
        int[] test3 = new int[]{5,4,-1,7,8};

        int sol1 = sol.maximumSumArray(test1);
        int sol2 = sol.maximumSumArray(test2);
        int sol3 = sol.maximumSumArray(test3);

        // int sol1 = sol.maxSubArray(test1);
        // int sol2 = sol.maxSubArray(test2);

        System.out.println("Max Sum  6 -->  " + sol1);
        System.out.println("Max Sum  2 -->  " + sol2);
        System.out.println("Max Sum 23 --> "  + sol3);
    }
}