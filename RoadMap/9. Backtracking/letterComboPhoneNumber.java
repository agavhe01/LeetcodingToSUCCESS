/*

17. Letter Combinations of a Phone Number

Medium

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

*/


class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer, List<Character>> DIGITS = new HashMap<>();

        List<List<Character>> arr = new ArrayList<>();

        DIGITS.put(2, List.of('a', 'b', 'c'));
        DIGITS.put(3, List.of('d', 'e', 'f'));
        DIGITS.put(4, List.of('g', 'h', 'i'));
        DIGITS.put(5, List.of('j', 'k', 'l'));
        DIGITS.put(6, List.of('m', 'n', 'o'));
        DIGITS.put(7, List.of('p', 'q', 'r', 's'));
        DIGITS.put(8, List.of('t', 'u', 'v'));
        DIGITS.put(9, List.of('w', 'x', 'y', 'z'));

        for(Character d: digits.toCharArray()){
            if (d == '1'){
                continue;
            }

            Integer intVal = Character.getNumericValue(d);
            arr.add(DIGITS.get(intVal));
        }

        if (arr.size() == 0){
            return new ArrayList<String>();
        }

        List<String> combinations = generateCombinations(arr);

        return combinations;        
    }

    public List<String> generateCombinations(List<List<Character>> array) {
        List<String> combinations = new ArrayList<>();
        generateCombinationsHelper(array, 0, new StringBuilder(), combinations);
        return combinations;
    }

    private void generateCombinationsHelper(List<List<Character>> array, int index, StringBuilder current, List<String> combinations) {
        if (index == array.size()) {
            combinations.add(current.toString());
            return;
        }

        /*
            It appends the character to the current StringBuilder, effectively adding it to the combination.
            It makes a recursive call to generateCombinationsHelper with an incremented index to consider the next sublist.
            After the recursive call, it removes the last character added (backtracks) from the current StringBuilder 
                using current.deleteCharAt(current.length() - 1) to explore other combinations.

        */

        List<Character> currentList = array.get(index);
        for (Character character : currentList) {
            current.append(character);
            generateCombinationsHelper(array, index + 1, current, combinations);
            current.deleteCharAt(current.length() - 1);
        }
    }
}