/*

139. Word Break
Solved
Medium
Topics
Companies

Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

 

Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".

Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.

Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false

 

Constraints:

    1 <= s.length <= 300
    1 <= wordDict.length <= 1000
    1 <= wordDict[i].length <= 20
    s and wordDict[i] consist of only lowercase English letters.
    All the strings of wordDict are unique.



*/

class Solution {

    Map<String, Boolean> memo = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> dict = new HashSet<>(wordDict);
        return helper(s, dict);
        
    }

    public boolean helper(String s, Set<String> dict ){

        if (memo.containsKey(s)) return memo.get(s);
        if (s.length() == 0) return true;

        for(int i = 1; i <= s.length(); i++){

            String currWord = s.substring(0, i);
            if (dict.contains(currWord)){
                memo.put(currWord, true);
                String restWord = s.substring(i);

                if (helper(restWord, dict)) return true;
            }
        }

        memo.put(s, false);
        return false;
    }
}

/* DYNAMIC PROGRAMMING

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(String word : wordDict){
                int start = i - word.length();

                if( start >= 0 && dp[start] && s.substring(start, i).equals(word)){
                    dp[i] = true; 
                    break;
                }
            }

        }

        return dp[s.length()];
        
    }
}

*/