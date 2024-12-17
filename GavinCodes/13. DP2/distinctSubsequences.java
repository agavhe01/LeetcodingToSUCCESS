/*

115. Distinct Subsequences
Solved
Hard
Topics
Companies

Given two strings s and t, return the number of distinct subsequences of s which equals t.

The test cases are generated so that the answer fits on a 32-bit signed integer.

 

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from s.
rabbbit
rabbbit
rabbbit

Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from s.
babgbag
babgbag
babgbag
babgbag
babgbag

*/

class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        /*

            dp[i][j]:  This stores the number of distinct subsequences of the first j characters of string S that
                    form the first i characters of string T.

        */
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i < n; i++){
            dp[0][i] = 1;
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0 ; j < n; j++){
                if (s.charAt(j) == t.charAt(i)){
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                }
                else dp[i + 1][j + 1] = dp[i + 1][j];
            }
        }
        return dp[m][n];
    }
}