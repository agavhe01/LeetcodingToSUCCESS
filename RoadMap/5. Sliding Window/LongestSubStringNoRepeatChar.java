/*

3. Longest Substring Without Repeating Characters
Medium


Given a string s, find the length of the longest substring without repeating characters.


Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.



The provided code is an implementation of an algorithm to find the length of the longest substring without repeating characters in a given string s. It uses a sliding window approach with two pointers (i and j) and an integer array map to efficiently solve this problem. Let's break down how it works:

Initialization: The algorithm initializes an integer array map of size 256, which represents all possible ASCII characters (since there are 256 possible ASCII characters). Each element of map is used to store the last occurred index of a character in the input string s.

Pointers and Variables: It also initializes three integer variables: j, i, and ans.

j is used as the right pointer to expand the window.
i is used as the left pointer to move the window.
ans is used to store the length of the longest substring without repeating characters found so far.
Main Loop: The main loop iterates through the characters of the input string s using the i pointer.

Expanding the Window (Right Pointer):

Inside the loop, there is an inner while loop that moves the j pointer to the right as long as the character at position j has not been encountered before in the current substring (determined by map[s.charAt(j)] == 0).
For each character encountered, it updates map to store its index (i.e., map[s.charAt(j)] = 1).
It also updates ans by taking the maximum of its current value and the length of the current substring (j - i + 1). This step ensures that ans always holds the length of the longest substring without repeating characters.
Moving the Window (Left Pointer):

Once a repeating character is encountered (the character at j has been seen before), the i pointer is moved to the right. At the same time, the map entry for the character at i is set back to 0 (i.e., map[s.charAt(i)] = 0). This effectively removes the character at i from consideration, allowing the window to slide forward.
Loop Continues: The loop continues this process as the i pointer moves through the string. The j pointer is adjusted whenever a repeating character is encountered.

Return Result: Once the loop finishes, the function returns the ans, which contains the length of the longest substring without repeating characters found in the input string s.


*/

public class Solution {
    
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256]; // map from character's ASCII to its last occured index
        
        int j = 0;
        int i = 0;
        int ans = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)]==0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j-i + 1);
                j ++;
            }
            map[s.charAt(i)] = 0;
        }
        
        return ans;
    }
}


