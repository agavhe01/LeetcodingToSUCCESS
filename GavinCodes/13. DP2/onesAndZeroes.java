/*

474. Ones and Zeroes
Solved
Medium
Topics
Companies
You are given an array of binary strings strs and two integers m and n.

Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.

A set x is a subset of a set y if all elements of x are also elements of y.


Example 1:

Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3
Output: 4
Explanation: The largest subset with at most 5 0's and 3 1's is {"10", "0001", "1", "0"}, so the answer is 4.
Other valid but smaller subsets include {"0001", "1"} and {"10", "1", "0"}.
{"111001"} is an invalid subset because it contains 4 1's, greater than the maximum of 3.
Example 2:

Input: strs = ["10","0","1"], m = 1, n = 1
Output: 2
Explanation: The largest subset is {"0", "1"}, so the answer is 2.

*/

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {

        int[][] dp = new int[m + 1][n + 1];

       for(String str: strs){
            int zeroCount = decodeZeroes(str);
            int oneCount = decodeOnes(str);

            for(int i = m; i >= zeroCount; i--){
                for(int j = n; j >= oneCount; j--){
                    int first = dp[i][j];
                    int second = dp[i - zeroCount][j - oneCount] + 1;
                    dp[i][j] = Math.max(first, second);
                }
            }
       }

        return dp[m][n];    
    }

    public int decodeOnes(String str){
        int count = 0;
        for(char c: str.toCharArray()){
            if (Character.compare(c, '1') == 0) count++;
        }
        return count;
    }

    public int decodeZeroes(String str){
        int count = 0;
        for(char c: str.toCharArray()){
            if (Character.compare(c, '0') == 0) count++;
        }
        return count;
    }
}