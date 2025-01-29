/*

784. Letter Case Permutation
Solved
Medium
Topics
Companies
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.

 

Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]
 

Constraints:

1 <= s.length <= 12
s consists of lowercase English letters, uppercase English letters, and digits.

*/

class Solution {

    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {

        helper(0, s, new StringBuilder());
        return res;
        
    }

    public void helper(int index, String s, StringBuilder sb){

        if (sb.length() == s.length()){
            res.add(new String(sb.toString()));
            return;
        }

        if (index > s.length()) return;

        Character curr = s.charAt(index);

        if (Character.isDigit(curr)){
            sb.append(curr);
            helper(index + 1, s, sb);
            sb.setLength(sb.length() - 1);
            return;
        }

        else {
            if (Character.isLowerCase(curr)) sb.append(Character.toUpperCase(curr));
            else sb.append(Character.toLowerCase(curr));
                
            helper(index + 1, s, sb);        
            sb.setLength(sb.length() - 1);

        }
        sb.append(curr);
        helper(index + 1, s, sb);
        sb.setLength(sb.length() - 1);
        return;

    }
}