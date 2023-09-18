/*

128. Longest Consecutive Sequence
Medium

Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

*/

class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0){
            return 0;
        }

        if (nums.length == 1){
            return 1;
        }

        Arrays.sort(nums);
        Integer longSeq = Integer.MIN_VALUE;
        Integer current = 1;
        Integer prev = nums[0];


        for(int i = 1; i < nums.length; i++){
            if( nums[i] == prev + 1 ){
                current++;
            }
            else if (nums[i] != prev){
                current = 1;
            }

            prev = nums[i];
            longSeq = Math.max(longSeq, current);
        }

        return longSeq;
        
    }
}