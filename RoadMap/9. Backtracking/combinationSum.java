/*
39. Combination Sum

Medium

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

*/

class Solution {
   public List<List<Integer>> combinationSum(int[] nums, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(list, new ArrayList<>(), nums, target, 0);
    return list;
}

private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
    if(remain < 0) return;
    else if(remain == 0) list.add(new ArrayList<>(tempList));

    /*
Recursive steps:
The function proceeds with a loop that starts from the start index and iterates through the elements in the nums array.
For each element nums[i] at index i, it adds nums[i] to the tempList and recursively calls itself with the updated parameters:
remain - nums[i]: This reduces the remaining target value by the value of the added element, effectively considering the element in the current combination.
i: The same index i is passed to the recursive call to allow reusing the same element in the combination if needed.
After the recursive call, the last added element (nums[i]) is removed from tempList (backtracking) to explore other combinations.
The recursion continues, exploring different combinations and backtracking as necessary.

    */
    else{ 
        for(int i = start; i < nums.length; i++){
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
            tempList.remove(tempList.size() - 1);
        }
    }
}
}

