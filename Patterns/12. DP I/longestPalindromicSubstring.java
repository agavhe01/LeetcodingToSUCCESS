/*

5. Longest Palindromic Substring

Medium

Companies
Given a string s, return the longest palindromic substring in s.

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"

*/

class Solution {
    public String longestPalindrome(String s) {
        int n = s.length(); // Get the length of the input string.

        // Create a 2D boolean array `dp` to store information about whether substrings are palindromes.
        boolean[][] dp = new boolean[n][n];

        // Initialize the `dp` array by assuming all substrings of length 1 are palindromes.
        for (boolean[] j : dp) {
            Arrays.fill(j, true);
        }

        int mx = 1; 
        int k = 0; 
       
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = false; // Initialize as false by default.

                // If the characters at positions `i` and `j` are the same, and the substring between them is a palindrome,
                // then mark the current substring as a palindrome.
                //System.out.println(i +" "+ s.charAt(i) + "  " + j + " " + s.charAt(j));
                if (s.charAt(i) == s.charAt(j)) {
                    //System.out.println("doing");
                    dp[i][j] = dp[i + 1][j - 1];

                    // If the current substring is a palindrome and its length is greater than the current maximum,
                    // update the maximum and the starting index of the longest palindrome substring.
                    if (dp[i][j] && mx < j - i + 1) {
                        mx = j - i + 1;
                        k = i;
                    }
                }
            }
        }

        // The result is the substring from index `k` to `k + mx`, which represents the longest palindromic substring.
        return s.substring(k, k + mx);
    }
}
