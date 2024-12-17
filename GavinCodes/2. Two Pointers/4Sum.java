/*

18. 4Sum
Solved
Medium
Topics
Companies

Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.

 

Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]

 

Constraints:

    1 <= nums.length <= 200
    -109 <= nums[i] <= 109
    -109 <= target <= 109


*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        for(int i = 0; i < n - 3; i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < n - 2; j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int k = j + 1;
                int l = n - 1;

                while (k < l){
                    long currSum = nums[i] + nums[j];
                    currSum += nums[k] + nums[l];

                    if (currSum == target){
                        List<Integer> curr = new ArrayList<>();
                        curr.add(nums[i]);
                        curr.add(nums[j]);
                        curr.add(nums[k]);
                        curr.add(nums[l]);
                        result.add(curr);
                        k++;
                        l--;

                        while(k < l && nums[k] == nums[k - 1]) k++;
                        while(k < l && nums[l] == nums[l + 1]) l--;

                    }
                    else if (currSum < target) k++;
                    else l--;
                }
            }
        }        
        return result;
    }
}