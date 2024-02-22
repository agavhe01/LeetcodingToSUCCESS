/*

40. Combination Sum II
Solved
Medium
Topics
Companies
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]

*/

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, target, new ArrayList<Integer>(), result);
        return result;
        
    }

    public void helper(
        int index,
        int[] candidates,
        int target,
        List<Integer> current,
        List<List<Integer>> result
    ){

        if (target == 0) result.add(new ArrayList<>(current));
        else if (target < 0) return;
        else{
            for(int j = index; j < candidates.length; j++){
                if (j > index && candidates[j] == candidates[j - 1]) continue;
                current.add(candidates[j]);
                helper(j + 1, candidates, target - candidates[j], current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}