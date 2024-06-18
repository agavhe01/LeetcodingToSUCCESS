/*

491. Non-decreasing Subsequences
Solved
Medium
Topics
Companies
Given an integer array nums, return all the different possible non-decreasing subsequences of the given array with at least two elements. You may return the answer in any order.

 

Example 1:

Input: nums = [4,6,7,7]
Output: [[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
Example 2:

Input: nums = [4,4,3,2,1]
Output: [[4,4]]
 

Constraints:

1 <= nums.length <= 15
-100 <= nums[i] <= 100

*/

class Solution {


    public List<List<Integer>> findSubsequences(int[] nums) {

        Set<List<Integer>> result = new HashSet<>();
        List<Integer> current = new ArrayList<>();
        helper(0, nums, result, current);
        return new ArrayList(result);
        
    }

    public void helper(
        int index, 
        int[] nums, 
        Set<List<Integer>> result, 
        List<Integer> current 
        )
    {

            if (index == nums.length){
                if(current.size() > 1) result.add(new ArrayList(current));
                return;
            }

            if (current.size() == 0 || current.get(current.size() - 1) <= nums[index]){
                current.add(nums[index]);
                helper(index + 1, nums, result, current);
                current.remove(current.size() - 1);
            }
            helper(index + 1, nums, result, current);

            /*
                The last call to the helper method 
                (after possibly adding the current element and backtracking) 
                is crucial for exploring all subsequences that exclude the current element 
                at nums[index]. This ensures that the algorithm does not miss any subsequences 
                by only considering those that include the current element. 
                By making this call, the algorithm effectively explores all branches of the 
                decision tree: one where the current element is included and one where it's not, 
                at every step of the recursion. This exhaustive search is necessary to find all 
                valid subsequences as per the problem's requirements.
            */
    }
}
