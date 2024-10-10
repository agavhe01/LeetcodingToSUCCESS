/*

680. Valid Palindrome II
Solved
Easy
Topics
Companies

Given a string s, return true if the s can be palindrome after deleting at most one character from it.

 

Example 1:

Input: s = "aba"
Output: true

Example 2:

Input: s = "abca"
Output: true
Explanation: You could delete the character 'c'.

Example 3:

Input: s = "abc"
Output: false

 

Constraints:

    1 <= s.length <= 105
    s consists of lowercase English letters.


*/

class Solution {
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) {
                return (checkPalindrome(s, left, right - 1) || checkPalindrome(s, left + 1, right));
            }
             left++;
            right--;
        }
        
        return true;
    }
    private boolean checkPalindrome(String s, int l, int r) {
        
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            
            l++;
            r--;
            
        }
        
        return true;
    }
}