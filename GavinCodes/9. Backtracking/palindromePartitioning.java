/*

131. Palindrome Partitioning
Solved
Medium
Topics
Companies

Given a string s, partition s such that every
substring
of the partition is a
palindrome
. Return all possible palindrome partitioning of s.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]

Example 2:

Input: s = "a"
Output: [["a"]]

 
Constraints:

    1 <= s.length <= 16
    s contains only lowercase English letters.



*/

class Solution {
    public List<List<String>> partition(String s) {

        List<List<String>> results = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        backtrack(s, 0, results, curr);

        return results;
        
    }

    public void backtrack(
        String str,
        int start,
        List<List<String>> results,
        List<String> curr
    ){
        if (start == str.length()){
            results.add(new ArrayList<String>(curr));
            return;
        }

        for(int end = start + 1; end <= str.length(); end++){
            if (isPalindrome(str, start, end - 1)){
                curr.add(str.substring(start, end));

                backtrack(str, end, results, curr);

                curr.remove(curr.size() - 1);
            }
        }
    }

    // Check if the substring s[left : right + 1] is a palindrome
    public boolean isPalindrome(String str, int left, int right){
        while (left < right){
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}