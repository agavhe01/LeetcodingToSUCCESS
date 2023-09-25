/*

1143. Longest Common Subsequence

Medium

Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.

Example 1:

Input: text1 = "abcde", text2 = "ace" 
Output: 3  
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.

*/


class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        String [][] ap = new String[m+1][n+1];

        // System.out.println(ap[0][0]);

        // System.out.println(dp[0][1]);
        // System.out.println(dp[1][0]);
        // System.out.println(dp[0][0]);

        // System.out.println("start");


       // System.out.println(dp[0][1]);

        // for(var j: dp){
        //     Arrays.fill(j, 0);
        // }
        /*
This array will be used to store the lengths of common subsequences for various substrings of text1 and text2. dp[i][j] will represent the length of the longest common subsequence for the substrings text1[0:i] and text2[0:j].
        */
        for (int i = 1; i <= m; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = text2.charAt(j - 1);
                //System.out.println("j char: " + j );
                if (c1 == c2) {
                    /*
If c1 is equal to c2, it means you have found a character that is common in both strings. In this case, you increment dp[i][j] by 1, which means you add this character to the LCS found so far.
                    */
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    /*
If c1 is not equal to c2, it means the characters don't match. In this case, you take the maximum of two values:
dp[i-1][j], which represents the LCS length without the current character in text1.
dp[i][j-1], which represents the LCS length without the current character in text2.
                    */
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    if (i==1 && j==1){
                        //System.out.println("!!! " + dp[i-1][j] + " " + dp[i][j-1]);
                    }
                }
            }
        }

        // for (int i = 1; i <= m; i++) {
        //     for (int j = 1; j <= n; j++) {
        //         //System.out.println("i:" + i + " j:" + j + " dp[i][j]:" + dp[i][j]);
        //     }
        //     }
        return dp[m][n];
    }
}