/*

2653. Sliding Subarray Beauty
Solved
Medium
Topics
Companies
Hint
Given an integer array nums containing n integers, find the beauty of each subarray of size k.

The beauty of a subarray is the xth smallest integer in the subarray if it is negative, or 0 if there are fewer than x negative integers.

Return an integer array containing n - k + 1 integers, which denote the beauty of the subarrays in order from the first index in the array.

A subarray is a contiguous non-empty sequence of elements within an array.

 

Example 1:

Input: nums = [1,-1,-3,-2,3], k = 3, x = 2
Output: [-1,-2,-2]
Explanation: There are 3 subarrays with size k = 3. 
The first subarray is [1, -1, -3] and the 2nd smallest negative integer is -1. 
The second subarray is [-1, -3, -2] and the 2nd smallest negative integer is -2. 
The third subarray is [-3, -2, 3] and the 2nd smallest negative integer is -2.
Example 2:

Input: nums = [-1,-2,-3,-4,-5], k = 2, x = 2
Output: [-1,-2,-3,-4]
Explanation: There are 4 subarrays with size k = 2.
For [-1, -2], the 2nd smallest negative integer is -1.
For [-2, -3], the 2nd smallest negative integer is -2.
For [-3, -4], the 2nd smallest negative integer is -3.
For [-4, -5], the 2nd smallest negative integer is -4. 

*/

class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;

        // int[] result =  new int [n - k + 1];

        List<Integer> result = new ArrayList<>();

        int[] map = new int[101];

        int start = 0;

        for(int i = 0; i < k - 1; i++){
            int index = nums[i] + 50;
            map[index]++;
        } 

        for (int end = k - 1; end < n; end++ ){

            int endIndex = nums[end] + 50;
            map[endIndex]++;
            
            result.add(findXthSmallestNegative(map, x));

            int startIndex = nums[start] + 50;
            map[startIndex]--;
            start++;
        }

        // return result.stream().mapToInt(Integer::intValue).toArray();

        return result.stream().mapToInt(i->i).toArray();
    }

    public int findXthSmallestNegative(int[] map, int x) {
        int count = 0;
        for (int i = 0; i < 50; i++) {
            if (map[i] > 0) {
                count += map[i];
                if (count >= x) {
                    return i - 50; // Adjust the index to get the actual negative integer
                }
            }
        }
        return 0; // Return 0 if there are fewer than x negative integers
    }
}