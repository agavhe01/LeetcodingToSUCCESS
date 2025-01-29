/*

451. Sort Characters By Frequency
Solved
Medium
Topics
Companies
Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

Return the sorted string. If there are multiple answers, return any of them.

 

Example 1:

Input: s = "tree"
Output: "eert"
Explanation: 'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input: s = "cccaaa"
Output: "aaaccc"
Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input: s = "Aabb"
Output: "bbAa"
Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

*/


class Solution {

    Comparator<Map.Entry<Character, Integer>> custComp = new Comparator<>(){
        @Override
        public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2){
            int valueComp = Integer.compare(e2.getValue(), e1.getValue());

            if (valueComp == 0) return Character.compare(e1.getKey(), e2.getKey());
            else return valueComp;
        }
    };


    public String frequencySort(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for(Character c : s.toCharArray()){
           map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedList = new ArrayList<>(map.entrySet());
        Collections.sort(sortedList, custComp);

        StringBuilder result = new StringBuilder();

        for(Map.Entry<Character, Integer> entry : sortedList){
            // System.out.println("Key:" + entry.getKey() + " Value:" + entry.getValue());
            // for(int i = 0; i < entry.getValue(); i++) result.append(entry.getKey());
            result.append(String.valueOf(entry.getKey()).repeat(entry.getValue()));
        }

        return result.toString();
    }
}