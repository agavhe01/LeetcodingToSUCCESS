/*

17. Letter Combinations of a Phone Number
Solved
Medium
Topics
Companies

Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:

Input: digits = ""
Output: []

Example 3:

Input: digits = "2"
Output: ["a","b","c"]

 

Constraints:

    0 <= digits.length <= 4
    digits[i] is a digit in the range ['2', '9'].


*/

class Solution {

    Map<Character, List<Character>> map = new HashMap<>();
    List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {

        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        if (digits == null || digits.length() == 0) return result;

        helper("", digits, 0);
        return result;
    }

    public void helper(String curr, String digits, int index){
        if (index == digits.length()){
            result.add(curr);
            return;
        }

        // if (index > digits.length()) return;

        Character idx = digits.charAt(index);
        List<Character> arr = map.get(idx);

        for(int i = 0; i < arr.size(); i++){
            helper(curr + arr.get(i), digits, index + 1);
        }
    }
}