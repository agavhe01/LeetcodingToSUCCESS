/*


16. 3Sum Closest
Solved
Medium
Topics
Companies

Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).

 

Constraints:

    3 <= nums.length <= 500
    -1000 <= nums[i] <= 1000
    -104 <= target <= 104



*/

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int closestSum = 0;
        int maxDiff = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length - 2; i++){

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right){
                int currSum = nums[i] + nums[left] + nums[right];

                if (Math.abs(currSum - target) < maxDiff){
                    closestSum = currSum;
                    maxDiff = Math.abs(currSum - target);
                }

                if (currSum < target) left++;
                else if (currSum > target) right--;
                else return currSum;
            }

        }

         return closestSum;
        
    }
}