/*

128. Longest Consecutive Sequence
Solved
Medium
Topics
Companies
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9


*/

class Solution {
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) return 0;

        HashSet<Integer> mp = new HashSet<>();

        for(int num : nums) mp.add(num);

        int longest = 1;


        for(int num : nums){
            if (!mp.contains(num - 1)){
                int count = 1;

                while (mp.contains(num + 1)){
                    num++;
                    count++;
                }
                longest = Math.max(longest, count);
            }

            /*
            if the sequence found is already longer than half the array's length 
            since you can't find a longer sequence in the remaining part of the array.
            */
            if(longest > nums.length/2) break;

            

        }
        


        return longest;
        
    }
}