/*

46. Permutations
Solved
Medium
Topics
Companies
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]

*/

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(0, nums, result);
        return result;
   
    }

    public void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void helper(
        int index, 
        int[] nums,
        List<List<Integer>> result
    ){
        int n = nums.length;
        if (index == n){
            List<Integer> perm = new ArrayList<>();
            for(int num : nums){ perm.add(num); }
            result.add(perm);
        }

        for(int i = index; i < n; i++){
            swap(nums, i, index);
            helper(index + 1, nums, result);
            swap(nums, i, index);
        }
    }
}