/*

424. Longest Repeating Character Replacement
Medium


You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

*/
public class Solution {

    public int characterReplacement(String s, int k) {
        // write your code here
        int[] num = new int[26];
        int n = s.length();
        int maxn = 0;
        int left = 0, right = 0;
        while (right < n) {
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right) - 'A']);

/*
Checking for Valid Window Size:

It checks whether the difference between the length of the current window (right - left + 1) and the maxn value (maximum character frequency) is greater than k. This condition checks whether it's possible to replace at most k characters to make all characters in the window the same. If the condition is met, it means the window size is not valid, so characters need to be removed from the left side of the window.
*/

            if (right - left + 1 - maxn > k) {
//If the condition is met, it decrements the count of the character at the left pointer in the num array (representing removing that character from the window) and moves the left pointer one step to the right.

                num[s.charAt(left) - 'A']--;
                left++;
            }
            right++;
        }
        return right - left;
    }
}