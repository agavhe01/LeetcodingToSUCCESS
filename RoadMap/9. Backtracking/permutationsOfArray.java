/*

46. Permutations

Medium

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


public class Solution {
    /*
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        
        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), results);
        
        return results;
    }
    
    private void dfs(int[] nums,
                     boolean[] visited,
                     List<Integer> permutation,
                     List<List<Integer>> results) {
        if (nums.length == permutation.size()) {
            results.add(new ArrayList<Integer>(permutation));
            return;
        }

        /*

Recursive steps:
The function proceeds with a loop that iterates through the elements in the nums array.
For each element nums[i] at index i, it checks whether it has been visited before (visited[i] is true). If it has been visited, it continues to the next element (backtracking).
If nums[i] has not been visited, it adds nums[i] to the permutation, marks visited[i] as true to indicate that nums[i] has been used, and then makes a recursive call to itself.
After the recursive call, it marks visited[i] as false (backtracking) to allow the element to be considered for future permutations, and removes the last added element (nums[i]) from the permutation.

        */
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            
            permutation.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited, permutation, results);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }
}