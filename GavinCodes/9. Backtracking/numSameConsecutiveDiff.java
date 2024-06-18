/*

967. Numbers With Same Consecutive Differences
Solved
Medium
Topics
Companies
Given two integers n and k, return an array of all the integers of length n where the difference between every two consecutive digits is k. You may return the answer in any order.

Note that the integers should not have leading zeros. Integers as 02 and 043 are not allowed.


Example 1:

Input: n = 3, k = 7
Output: [181,292,707,818,929]
Explanation: Note that 070 is not a valid number, because it has leading zeroes.
Example 2:

Input: n = 2, k = 1
Output: [10,12,21,23,32,34,43,45,54,56,65,67,76,78,87,89,98]
 

*/

class Solution {

    List<Integer> result = new ArrayList<>();

    public int[] numsSameConsecDiff(int n, int k) {

        for(int i = 1; i < 10; i++){
            helperFind(i, n - 1, k);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public void helperFind(
        int ans,
        int n,
        int k
    ){
        if (n == 0){ result.add(ans); return; }

        for(int i = 0; i < 10; i++){
            int currDiff = (ans % 10) - i;
            if(Math.abs(currDiff) == k){
                helperFind(ans * 10 + i, n - 1, k);
            }
        }
    }
}