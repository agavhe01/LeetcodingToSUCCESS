/*

Leetcode: 82. Expression Add Operators
Hard

Given a string num that contains only digits and an integer target, return all possibilities to insert the binary operators '+', '-', and/or '*' between the digits of num so that the resultant expression evaluates to the target value.

Note that operands in the returned expressions should not contain leading zeros.
*/

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }

    /*
    with initial parameters: the result list, an empty path (string for accumulating the expression), the string num, the target value, and initial values for pos (position in the string), eval (current evaluation of the expression), and multed (the last multiplied value, for handling precedence in multiplication).

Method helper:

    */
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
        if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        for(int i = pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0') break;
            /* this avoids numbers with leading zeros 
                by breaking the loop if a number starts with 0 and it's not a 
                single digit. 
            */

            long cur = Long.parseLong(num.substring(pos, i + 1));

            /*
            If pos is 0 (the start of the string), the helper method 
            is called recursively without an operator, just adding the current
            number.

            */
            if(pos == 0){
                helper(rst, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                /*

If pos is not 0, the method is recursively called for each of the three operators (+, -, *), adjusting the eval and multed parameters accordingly.

    For + and -, eval is updated by adding or subtracting cur, respectively.
    For *, the expression is evaluated as (eval - multed) + multed * cur. This is because the last operation might be a multiplication, and we need to respect the precedence of operations. multed keeps track of the last operand in a multiplication chain to correctly adjust the current evaluation.


                */
                helper(rst, path + "+" + cur, num, target, i + 1, eval + cur , cur);
                
                helper(rst, path + "-" + cur, num, target, i + 1, eval -cur, -cur);
                
                helper(rst, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur );
            }
        }
    }
}