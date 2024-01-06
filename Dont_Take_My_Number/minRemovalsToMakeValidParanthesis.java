/*


Leetcode: 1249. Minimum Remove to Make Valid Parentheses

Medium

Given a string s of '(' , ')' and lowercase English characters.

Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.

*/


class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        int open = 0;
        String ans = "";

        for (int i=0; i<n; i++) {
            if (s.charAt(i)=='(') {
                open++;
            }
            else if (s.charAt(i)==')') {
                if (open==0) {
                    continue;
                }
                open--;
            }
            ans = ans+s.charAt(i);
        }

        String result = "";
        for (int i=ans.length()-1; i>=0; i--) {
            if (ans.charAt(i)=='(' && open>0) {
                /*
                If an opening parenthesis ( is found and open is greater than 0,
                it means this opening parenthesis is unmatched and should 
                be skipped. open is then decremented.
                */

                open--;
                continue;
            }
            result = ans.charAt(i) + result;
        }
        return result;
    }
}