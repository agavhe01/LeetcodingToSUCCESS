/*

159. Longest Substring with At Most Two Distinct Characters
Solved
Medium
Topics
Companies

Given a string s, return the length of the longest
substring
that contains at most two distinct characters.

 

Example 1:

Input: s = "eceba"
Output: 3
Explanation: The substring is "ece" which its length is 3.

Example 2:

Input: s = "ccaabbb"
Output: 5
Explanation: The substring is "aabbb" which its length is 5.

 

Constraints:

    1 <= s.length <= 105
    s consists of English letters.


*/


class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {

        Map<Character, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        int maxLen = 0;
        int counter = 0;

        while (end < s.length() ){

            char endChar = s.charAt(end);
            map.put(endChar, map.getOrDefault(endChar, 0) + 1);

            if (map.get(endChar) == 1) counter++;
            end++;

            while (counter > 2){
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar) - 1);

                if (map.get(startChar) == 0){
                    counter --;
                }

                start++;

            }

            maxLen = Math.max(maxLen, end - start);
        }
        
        return maxLen;
    }
}
