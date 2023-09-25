/*

91. Decode Ways

Medium

A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, return the number of ways to decode it.

The test cases are generated so that the answer fits in a 32-bit integer.


Example 1:

Input: s = "12"
Output: 2
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: 3
Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:

Input: s = "06"
Output: 0
Explanation: "06" cannot be mapped to "F" because of 

*/



class Solution {
    public int numDecodings(String s) {
        int n = s.length();
       
        int[] f = new int[n + 1];
         /*
            This array is used to store the number of ways to decode substrings of the input string. Each element f[i] represents the number of ways to decode the substring of s from index 0 to i.
        */



        f[0] = 1;
        for (int i = 1; i <= n; ++i) {
            if (s.charAt(i - 1) != '0') {
                /*
If the current character at index i - 1 is not '0', it means it can be decoded as a single-digit number (1 to 9). In this case, add f[i - 1] to f[i]. This means that the number of ways to decode the current substring is at least as many ways as you could decode the substring without the current character.
                */
                f[i] += f[i - 1];
            }
            if (i > 1 && s.charAt(i - 2) != '0' && ((s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0') <= 26)) {
                /*
Check if you can decode the current character along with the previous character as a two-digit number. To do this, you check if the previous character at index i - 2 is not '0' and if the combination of the previous character and the current character forms a valid two-digit number (between 10 and 26). If these conditions are met, add f[i - 2] to f[i]. This accounts for the possibility of decoding the current and previous characters together as a two-digit number.
                */
                f[i] += f[i - 2];
            }
        }
        return f[n];
    }
}