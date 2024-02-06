/*

1. Two Sum
Solved
Easy
Topics
Companies
Hint
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

*/

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int n = nums.length;

        for(int i = 0; i < n; i++){
            Integer num = nums[i];
            Integer diff = target - num;

            if(map.containsKey(diff)){
                 return new int[] {map.get(diff), i};
            }
            map.put(num, i);
        }

        
        return new int[] {0, 0};
        
    }
}