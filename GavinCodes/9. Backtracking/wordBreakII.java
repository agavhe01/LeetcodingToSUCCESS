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

 

Constraints:

    1 <= s.length <= 20
    1 <= wordDict.length <= 1000
    1 <= wordDict[i].length <= 10
    s and wordDict[i] consist of only lowercase English letters.
    All the strings of wordDict are unique.
    Input is generated in a way that the length of the answer doesn't exceed 105.


*/

class Solution {

    List<String> result = new ArrayList<>();

    public List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> dict = new HashSet<>(wordDict);
        helper(0, dict, new StringBuilder(), s);
        return result;
        
    }

    public void helper(int index, HashSet<String> dict, StringBuilder sb, String str ){

        if (index == str.length() ){
            result.add(sb.substring(0, sb.length() - 1));
            return;
        }

        for(int i = index; i < str.length(); i++){
            String curr = str.substring(index, i + 1);
            if (dict.contains(curr)){
                StringBuilder newSb = new StringBuilder(sb.toString());
                newSb.append(curr);
                newSb.append(" ");
                helper(i + 1, dict, newSb, str);
            }
        }

    }
}