/*
90. Subsets II

Medium

Given an integer array nums that may contain duplicates, return all possible 
subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

*/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), results);
        List<List<Integer>> noDups = removeDuplicates(results);
        return noDups;
    }

    public static List<List<Integer>> removeDuplicates(List<List<Integer>> list) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> uniqueList = new ArrayList<>();

        for (List<Integer> sublist : list) {
            if (set.add(sublist)) {
                // If the set returns true (i.e., it's a unique sublist), add it to the uniqueList.
                uniqueList.add(sublist);
            }
        }

        return uniqueList;
    }

        private void dfs(int[] nums,
                     int index,
                     List<Integer> subset,
                     List<List<Integer>> results) {
        // 3. 递归的出口
        if (index == nums.length) {
            results.add(new ArrayList<Integer>(subset));
            return;
        }
        
/*
Recursive steps:
The function proceeds with two recursive calls:
First, it adds the current element nums[index] to the subset and calls itself recursively with index incremented by 1. This represents the choice of including the current element in the subset.
Next, it removes the last element from the subset (backtracking) and calls itself recursively with index incremented by 1. This represents the choice of not including the current element in the subset.
These recursive calls explore all possible combinations of including or excluding each element in the nums array in the subset.

*/
        
        // 选了 nums[index]
        subset.add(nums[index]);
        dfs(nums, index + 1, subset, results);
        
        // 不选 nums[index]
        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, subset, results);
    }
}