/*

Leetcode: 844. Backspace String Compare

Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

*/

class Solution {
    public boolean backspaceCompare(String s, String t) {
        return processBackspace(s).equals(processBackspace(t));
    }

    private String processBackspace(String s){
        StringBuilder sb = new StringBuilder(s);
        while(sb.indexOf("#") >= 0 ){
            if(sb.indexOf("#") == 0)
                sb.deleteCharAt(0);
            else
                sb.delete(sb.indexOf("#") - 1, sb.indexOf("#") + 1);
        }
        return sb.toString();
    }
}