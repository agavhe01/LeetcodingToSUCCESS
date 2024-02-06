/*

Leetcode: 163. Missing Ranges
Easy

You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are within the inclusive range.

A number x is considered missing if x is in the range [lower, upper] and x is not in nums.

Return the shortest sorted list of ranges that exactly covers all the missing numbers. That is, no element of nums is included in any of the ranges, and each missing number is covered by one of the ranges.

*/

class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> res = new ArrayList<>();
        int left = lower;
        for(int i = 0; i < nums.length; i++){
            if (left < nums[i]){
                res.add(Arrays.asList(left, nums[i] - 1));
            }
            left = nums[i] + 1;
        }
        if (left <= upper) res.add(Arrays.asList(left, upper));      
        return res;
    }
}