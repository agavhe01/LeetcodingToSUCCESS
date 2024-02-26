/*

3. Longest Substring Without Repeating Characters
Solved
Medium
Topics
Companies
Given a string s, find the length of the longest 
substring
 without repeating characters.

 

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



*/


class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int left = 0;
        int result = 0;

        Set<Character> map = new HashSet<>();

        for(int right = 0; right < n; right++){
            if (!(map.contains(s.charAt(right)))){
                map.add(s.charAt(right));
                result = Math.max(result, right - left + 1);
            }
            else{
                while(s.charAt(left) != s.charAt(right)){
                    map.remove(s.charAt(left));
                    left++;
                }
                map.remove(s.charAt(left));
                left++;
                map.add(s.charAt(right));
            }
        }

        return result;

        
    }
}


/*

SLIDING WINDOW APPROACH

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


*/