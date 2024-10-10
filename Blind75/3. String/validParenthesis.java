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

import java.util.Stack;

public class validParenthesis{

    public static Stack<Character> stk;

    public validParenthesis(){}

    static { stk = new Stack<Character>(); }

    /*
       
        TC : O(n) 
        SC : O(n)

    */

    public static boolean isValidParanthesis(String str){
        int n = str.length();

        for(int i = 0; i < n; i++){
            Character c = str.charAt(i);

            if ( 
                    ( c == '}' || c == ']' || c == ')' ) 
                        &&
                    ( stk.isEmpty() ) 

                ) return false;
            
            else{
                if      ( ( c == '}' ) && ( stk.peek() == '{' ) ) stk.pop();
                else if ( ( c == ']' ) && ( stk.peek() == '[' ) ) stk.pop();
                else if ( ( c == ')' ) && ( stk.peek() == '(' ) ) stk.pop();
                else stk.add(c);
            }
        }
        return stk.empty();
    }

    public static void main(String[] args){
        validParenthesis sol = new validParenthesis();

        boolean res1 = sol.isValidParanthesis("()");
        boolean res2 = sol.isValidParanthesis("()[]{}");
        boolean res3 = sol.isValidParanthesis("(]");

        System.out.println("Res 1 : true  --> " + res1);
        System.out.println("Res 2 : true  --> " + res2);
        System.out.println("Res 3 : false --> " + res3);
        

    }
}


/*

BETTER SOLUTION

THE ONE ABOVE DOES NOT WORK WITH STRINGS LIKE "{[()]}"
public boolean isValid(String s) {

        Stack<Character> stk = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);

            if      (c == '{') stk.push('}');
            else if (c == '[') stk.push(']');
            else if (c == '(') stk.push(')');

            // if the character is a closing bracket
            // if the stack is empty (i.e., there is no matching opening bracket) or the top of the stack
            // does not match the closing bracket, the string is not valid, so return false

            else if ( stk.isEmpty() || stk.pop() != c) return false;

            
        }

        // if the stack is empty, all opening brackets have been matched with their corresponding closing brackets,
        // so the string is valid, otherwise, there are unmatched opening brackets, so return false
        return stk.isEmpty();
        
    }


*/