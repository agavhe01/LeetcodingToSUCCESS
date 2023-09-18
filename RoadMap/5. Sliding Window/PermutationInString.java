/*

LEETCODE: 567. Permutation in String
Medium

Companies
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false

*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();
        char[] c1 = s1.toCharArray();

        Arrays.sort(c1);

        for (int i = 0; i < n2 - n1 + 1; i++){
            String subS = s2.substring(i, i + n1);
            //System.out.println(subS);
        
            char[] c2 = subS.toCharArray();
            Arrays.sort(c2);
            boolean areEqual = Arrays.equals(c1, c2);
            if (areEqual){ return true; }
        }
        return false;
        
    }
}