/*


Code
Testcase
Testcase
Test Result
153. Find Minimum in Rotated Sorted Array
Solved
Medium
Topics
Companies
Hint
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

*/


class Solution {
    public int findMin(int[] nums) {

        // 

        int n = nums.length;

        int start = 0;
        int end = n - 1;

        int minNum = Integer.MAX_VALUE;

        while(start <= end){

            if (nums[start] <= nums[end]){
                /*
                    means the subarray from start to end is already sorted
                    minimum element is nums[start]
                */
                return nums[start];
            }

            int mid = start + (end - start) / 2;
            int midval = nums[mid];

            if (midval >= nums[start]){
                start = mid + 1;
            }
            else{
                /*
                why not end = mid - 1 ???
                The element at mid could still be the minimum element, especially in the
                 second condition where nums[mid] < nums[start]. Therefore, you cannot
                exclude mid from the search space. Setting end = mid ensures that mid is
                considered in the next iteration.
                */
                 end = mid; 
            }

            
        }
        return 0;


        
    }
}