/*

20. Valid Parentheses
Solved
Easy
Topics
Companies
Hint
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false

*/

class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stk = new Stack<Character>();

        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            //System.out.println("Char: " + c);

            if ( ((Character.compare(c, '}') == 0) ||
                 (Character.compare(c, ']') == 0) ||
                 (Character.compare(c, ')') == 0)) && 
                 stk.empty()
            ) { return false;}

            else {
                if (c == '}' && stk.peek() == '{') stk.pop();
                else if (Character.compare(c, ']') == 0 && stk.peek() == '[') stk.pop();
                else if (Character.compare(c, ')') == 0 && stk.peek() == '(') stk.pop();
                else stk.add(c);

            }

            
        }

        return stk.empty();
        
    }
}