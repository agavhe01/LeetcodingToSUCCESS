/*

22. Generate Parentheses
Solved
Medium
Topics
Companies
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 

Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]
 

Constraints:

*/

class Solution {
    public List<String> generateParenthesis(int n) {

        List<String> result = new ArrayList<>();
        helper(result, 0, 0, new StringBuilder(), n);
        return result;
        
    }

    public void helper(
        List<String> result,
        int openN,
        int closedN,
        StringBuilder curr,
        int n
    ){
        double currSize = (openN + closedN) / 2;

        if (openN == closedN && currSize == n){
            result.add(curr.toString());
        }

        if (openN < n){
            curr.append('(');
            helper(result, openN + 1, closedN, curr, n);
            curr.deleteCharAt(curr.length() - 1);
        }

        if (closedN < openN){
            curr.append(')');
            helper(result, openN, closedN + 1, curr, n);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}


/*

stack soulution

package arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.generateParenthesis(3);
    }

    Stack<Character> stack = new Stack<>();
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(0, 0, n);
        return res;
    }

    private void backtrack(int openN, int closedN, int n) {
        if (openN == closedN && closedN == n) {
            Iterator vale = stack.iterator();
            String temp = "";
            while (vale.hasNext()) {
                temp = temp + vale.next();
            }
            res.add(temp);
        }
        if (openN < n) {
            stack.push('(');
            backtrack(openN + 1, closedN, n);
            stack.pop();
        }
        if (closedN < openN) {
            stack.push(')');
            backtrack(openN, closedN + 1, n);
            stack.pop();
        }
    }
}


*/

