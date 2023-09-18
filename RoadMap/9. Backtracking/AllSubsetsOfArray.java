/*

78. Subsets
Medium

Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.


Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]




*/

public class AllSubsetsOfArray {
    /**
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), results);
        return results;
    }
    
    // 1. 递归的定义
    // 以 subset 开头的，配上 nums 以 index 开始的数所有组合放到 results 里
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