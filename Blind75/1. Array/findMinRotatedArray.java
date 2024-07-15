/*

Given the sorted rotated array nums of unique elements, return
the minimum element of this array.
You must write an algorithm that runs in O(log n) time.
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

*/

public class findMinRotatedArray{

    public findMinRotatedArray(){  }

     /*
        MY SOLUTION 
        TC : O(logn)
        SC : O(1)

    */
    public int findMin(int[] nums){
       int start = 0;
       int end = nums.length - 1;

      
       while (start <= end){
            if (nums[start] <= nums[end]) return nums[start];

            int mid = start + (end - start) / 2;
            int midVal = nums[mid];

            if (nums[start] <= midVal) start = mid + 1;
            else end = mid;
       }
       return 0;
    }
    

    public static void main(String[] args){
        findMinRotatedArray sol = new findMinRotatedArray();

        int[] test1 = new int[]{3,4,5,1,2};
        int[] test2 = new int[]{10, 11, 20, 25, 30};
        int[] test3 = new int[]{100, 20, 30, 40, 60, 80, 90};

        int res1 = sol.findMin(test1);
        int res2 = sol.findMin(test2);
        int res3 = sol.findMin(test3);

        System.out.println("Find Min  1 --> " + res1);
        System.out.println("Find Min 10 --> " + res2);
        System.out.println("Find Min 20 --> " + res3);

    }
}