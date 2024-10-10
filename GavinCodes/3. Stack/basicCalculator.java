/*

227. Basic Calculator II
Solved
Medium
Topics
Companies

Given a string s which represents an expression, evaluate this expression and return its value. 

The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-231, 231 - 1].

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

 

Example 1:

Input: s = "3+2*2"
Output: 7

Example 2:

Input: s = " 3/2 "
Output: 1

Example 3:

Input: s = " 3+5 / 2 "
Output: 5

 

Constraints:

    1 <= s.length <= 3 * 105
    s consists of integers and operators ('+', '-', '*', '/') separated by some number of spaces.
    s represents a valid expression.
    All the integers in the expression are non-negative integers in the range [0, 231 - 1].
    The answer is guaranteed to fit in a 32-bit integer.


*/

class Solution {
    public int calculate(String s) {

        char operator = '+';
        Stack<Integer> stk = new Stack<>();

        int currVal = 0;


        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);

            if (Character.isDigit(curr)) currVal = (currVal * 10) + (curr - '0');

            if (! Character.isDigit(curr) && Character.compare(curr, ' ') != 0 || i == s.length() - 1){
                if (operator == '-') stk.push(-currVal);
                else if (operator == '+') stk.push(currVal);
                else if (operator == '*') stk.push(stk.pop() * currVal);
                else if (operator == '/') stk.push(stk.pop() / currVal);

                currVal = 0;
                operator = curr;
            }

        }

        int res = 0;

        while ( ! stk.isEmpty() ) res += stk.pop();

        return res;
        
    }
}