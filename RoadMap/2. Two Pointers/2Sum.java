/*

LEETCODE: 1 Two SUm

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compliment = target - nums[i];
            if (map.containsKey(compliment)) {
                return new int[] { map.get(compliment), i };
            }
            map.put(nums[i], i);

        }
        return new int[] {};
    }
}

/*

if the nums[] is sorted, this works
doesnt work in this case because they want the indice positions in the original array, not sorted array

 public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);


        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) return new int[]{ i, j};
            else if (sum < target) i++;
            else j--;
        }
    return new int[] {};

*/