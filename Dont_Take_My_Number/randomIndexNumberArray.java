/*

Leetcode: 398

Given an integer array nums with possible duplicates, randomly output the index of a given target number. You can assume that the given target number must exist in the array.

Implement the Solution class:

Solution(int[] nums) Initializes the object with the array nums.
int pick(int target) Picks a random index i from nums where nums[i] == target. If there are multiple valid i's, then each index should have an equal probability of returning.

*/

class Solution {
    Map<Integer, List<Integer>> map;

    public Solution(int[] nums) {

       map = new HashMap();

        for(int i = 0; i < nums.length; i++){
            int key = nums[i];
            
            if (map.get(key) == null){
                List<Integer> arr = new ArrayList<>();
                arr.add(i);
                map.put(key, arr);
            }
            else{
                List<Integer> arr = map.get(key);
                arr.add(i);
                map.put(key, arr);
            }
        }
        
    }
    
    public int pick(int target) {
        List<Integer> arr = map.get(target);
        Random rd = new Random();
        return arr.get(rd.nextInt(arr.size()));
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */