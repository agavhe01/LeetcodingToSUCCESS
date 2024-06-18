/*

140. Word Break II
Solved
Hard
Topics
Companies
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.


Example 1:

Input: s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
Output: ["cats and dog","cat sand dog"]
Example 2:

Input: s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine","pineapple"]
Output: ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: []

*/

class Solution {

    List<String> result = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        helperFind(s, wordDict, new ArrayList());
        return result;
        
    }

    public void helperFind(String s, List<String> words, List<String> curr) {
        if (s.isEmpty()) {
            result.add(String.join(" ", curr));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String window = s.substring(0, i);
            if (words.contains(window)) {
                curr.add(window); // Add the found word to the current path
                helperFind(s.substring(i), words, curr); // Recurse with the remainder of the string
                curr.remove(curr.size() - 1); // Backtrack
            }
        }
    }

}