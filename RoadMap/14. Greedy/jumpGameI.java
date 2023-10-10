/*

55. Jump Game

Medium

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.

*/

class Solution {
    public boolean canJump(int[] nums) {
        
       int reachable = 0;
       for(int i = 0; i < nums.length; i ++) {
           if(i > reachable) return false;
           reachable = Math.max(reachable, i + nums[i]);
       } 
       return true;
    }
}


/*

ANOTHER SOLUTION IN O(N) STARTING FROM NUMS[I]

public boolean canJump(int[] a) {
        int goal = a.length - 1;

        for(int i = a.length - 1; i >= 0; i--){
            if (i + a[i] >= goal){
                goal = i;
            }
        }
        if (goal == 0){return true; }
        else{ return false; }
    }



*/