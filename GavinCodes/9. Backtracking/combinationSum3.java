/*

216. Combination Sum III
Solved
Medium
Topics
Companies
Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
Example 3:

Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.

*/


class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {

        int[] candidates = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<>();
        helper(0, k, n, new ArrayList<Integer>(), result, candidates);
        return result; 
    }

    public void helper(
        int index,
        int k,
        int target, 
        List<Integer> current,
        List<List<Integer>> result,
        int[] candidates
    )
    {
        if (target == 0 && current.size() == k){ result.add(new ArrayList<>(current)); }
        else if (target < 0 || current.size() > k || index > candidates.length){ return; }
        else{
            for(int i = index; i < candidates.length; i++){
                if (i > index && candidates[i] == candidates[i - 1]) continue; // unneccessaryy becuase array does not contain duplicate items
                current.add(candidates[i]);
                helper(i + 1, k, target - candidates[i], current, result, candidates);
                current.remove(current.size() - 1);
            }
        }
    }
}


/*

ALTERNATIVE SOLUTION: WORKS BECAUSE ARRAY DOES NOT CONTAIN DUPLICATE ENTRIES

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] candidates = new int[]{1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<>();
        helper(0, k, n, new ArrayList<Integer>(), result, candidates);
        return result;
    }

    public void helper(
        int index,
        int k,
        int target, 
        List<Integer> current,
        List<List<Integer>> result,
        int[] candidates
    )
    {
        if (target == 0 && current.size() == k){ result.add(new ArrayList<>(current)); }
        else if (target < 0 || current.size() > k || index >= candidates.length){ return; }
        else{ 
            current.add(candidates[index]);
            helper(index + 1, k, target - candidates[index], current, result, candidates);
            current.remove(current.size() - 1);
            helper(index + 1, k, target , current, result, candidates);
        }
    }
}

*/