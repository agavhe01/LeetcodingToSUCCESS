/*

238. Product of Array Except Self
Medium

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
*/


class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

/*

The first loop iterates through the array, calculating the product of all elements to the left of each element and stores the result in the "answer" array. The loop starts from index 1 because there are no elements to the left of index 0, so "answer[0]" is initialized to 1.  

*/
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

/*

The second loop starts from the last element of the array and goes backward. In this loop, first, it multiplies "answer[i]" by "R," which represents the product of elements to the left and right of the current index "i." Then, it updates the value of "R" by multiplying it by "nums[i]" to include the current element in the right-hand product calculation.

*/
        
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
           
            answer[i] = answer[i] * R;
           
            R *= nums[i];
        }
        return answer;
    }
}
