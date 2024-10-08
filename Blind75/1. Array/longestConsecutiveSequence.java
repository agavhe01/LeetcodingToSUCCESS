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

import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class longestConsecutiveSequence{

    public longestConsecutiveSequence(){}
    /*
        TC: O(n)
        SC: O(n)
    */

    public int findLongestConsecutiveSequence(int[] nums){
       if (nums.length == 0) return 0;

        Set<Integer> st = new HashSet<Integer>();
        for(int num : nums) st.add(num);

        int result = 0;

        for(int num : nums){

            if ( !st.contains(num - 1)){
                
                int count = 1;
                int i = 1;

                while (st.contains(num + i)){
                    i++;
                    count++;
                }

                result = Math.max(result, count);
            }

        }
        
        return result;
    }

    public static void main(String[] args){
        longestConsecutiveSequence sol = new longestConsecutiveSequence();

        int[] t1 = {100, 4, 200, 1, 3, 2};
        int r1 = sol.findLongestConsecutiveSequence(t1);

        System.out.println("Result 1: 4 --> " + r1);


        int[] t2 = {202, 203, 100, 4, 200, 1, 206, 3, 2, 201, 204, 205, };
        int r2 = sol.findLongestConsecutiveSequence(t2);

        System.out.println("Result 2: 7 --> " + r2);


        /*

= [100,4,200,1,3,2]
Output: 4
        */
    }
}