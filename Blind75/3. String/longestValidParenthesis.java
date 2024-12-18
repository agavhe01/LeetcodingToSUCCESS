/*


2. Longest Valid Parentheses
Solved
Hard
Topics
Companies

Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
substring
.

 

Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".

Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".

Example 3:

Input: s = ""
Output: 0

 

Constraints:

    0 <= s.length <= 3 * 104
    s[i] is '(', or ')'.


*/

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();

        Stack<Integer> stk = new Stack<>();
        stk.push(-1);

        int maxLen = 0;

        for(int i = 0; i < n; i++){

            if (s.charAt(i) == '(') stk.push(i);
            
            else{
                stk.pop();
                if (stk.isEmpty()) stk.push(i);
                else maxLen = Math.max(maxLen, i - stk.peek());
            }

        }

        return maxLen;
        
    }
}