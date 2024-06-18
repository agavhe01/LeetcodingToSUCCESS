/*

47. Permutations II
Solved
Medium
Topics
Companies
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

*/

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        helper(0, res, nums);
        return new ArrayList<>(res);
    }

    public void helper(
        int index,
        Set<List<Integer>> result,
        int[] nums
    )
    {
        if (index == nums.length){
            List<Integer> curr = new ArrayList<>();
            for(int n : nums) curr.add(n); 
            result.add(curr);
        }

        for(int i = index; i < nums.length; i++){
            swap(nums, i, index);
            helper(index + 1, result, nums);
            swap(nums, i, index);
        }

    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}


/*

ALTERNATIVE CODE

public List<List<Integer>> permuteUnique(int[] nums) {
		
        List<List<Integer>> ans = new ArrayList<>(); // ans list
        Arrays.sort(nums); // sort the array
		
		// create a boolean array which track the certain indexed integer is present in out temp list or not
        helper(ans, new ArrayList<>(), nums, new boolean[nums.length]); // helper method
		
        return ans; // return output
    }

    private void helper(List<List<Integer>> ans, List<Integer> temp, int[] nums, boolean[] vis) {
		
		
        if(nums.length == temp.size()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
		
        
        for(int i=0;i<nums.length; i++) {
		
            if(vis[i]) continue; // if current element is already present in the temp, skip the element
            if(i > 0 && ! vis[i-1] && nums[i] == nums[i-1]) continue; // if prev element and current element is equal, skip the element
            
            vis[i] = true;
            temp.add(nums[i]);
            
            helper(ans, temp, nums, vis); // recursive call
            
			// backtracking
            temp.remove(temp.size() - 1);
            vis[i] = false;
        }
    }






*/