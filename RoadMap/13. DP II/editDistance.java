//Refer to neetcode's video

/*
72. Edit Distance
Medium
14K
184
Companies
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 

Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 

*/

class Solution {

    public int minDistance(String word1, String word2) {
        int m = word1.length() - 1;
        int n = word2.length() - 1;

        /*
dp[][] represents the minimum edit distance between the substrings word1[0...m] and word2[0...n].

        */
        int[][] dp = new int[m + 2][n + 2];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int result =  helper(word1, word2, m, n, dp);

        for(int i = 0; i < m+1; i++){
            for(int j = 0; j < n+1;j++){
                System.out.println("I:" + i + " and j:" + j + " value:" + dp[i][j]);
            }
        }



        return result - 1;
    }

    public int helper(String word1, String word2, int m, int n, int[][] dp) {
        //the strings are null
        if (m + 1 == 0 && n + 1 == 0) {
            return 0;
        }
        //one of the strings are null
        if (m + 1 == 0 || n + 1 == 0) {
            return Math.max(m + 1, n + 1);
        }
        //both values at the index are equal
        if (dp[m][n] != -1) return dp[m][n];
        if (word1.charAt(m) == word2.charAt(n)) {
            dp[m][n] = helper(word1, word2, m - 1, n - 1, dp);
            return dp[m][n];
        } else {
            //try deletion
            int delete = 1 + helper(word1, word2, m - 1, n, dp);
            //try insertion
            int insert = 1 + helper(word1, word2, m, n - 1, dp);
            //try replacing
            int replace = 1 + helper(word1, word2, m - 1, n - 1, dp);
            //now we'll choose the minimum out of these 3 and add 1 for the operation cost
            dp[m][n] = Math.min(Math.min(delete, insert), replace);
            return dp[m][n];
        }
    }
}
