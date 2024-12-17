/*

205. Isomorphic Strings
Solved
Easy
Topics
Companies

Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"

Output: true

Explanation:

The strings s and t can be made identical by:

    Mapping 'e' to 'a'.
    Mapping 'g' to 'd'.

Example 2:

Input: s = "foo", t = "bar"

Output: false

Explanation:

The strings s and t can not be made identical as 'o' needs to be mapped to both 'a' and 'r'.

Example 3:

Input: s = "paper", t = "title"

Output: true

 

Constraints:

    1 <= s.length <= 5 * 104
    t.length == s.length
    s and t consist of any valid ascii character.


*/

class Solution {
    public boolean isIsomorphic(String s, String t) {

        int nS = s.length();
        int nT = t.length();

        Map<Character, Integer> mS = new HashMap<>();
        Map<Character, Integer> mT = new HashMap<>();

        Map<Character, Character> definitions = new HashMap<>();

        if (nS != nT) return false;

        for(int i = 0; i < nS; i++){
            Character cS = s.charAt(i);
            Character cT = t.charAt(i);

            mS.put(cS, mS.getOrDefault(cS, 0) + 1);
            mT.put(cT, mT.getOrDefault(cT, 0) + 1);

            int newS = mS.get(cS);
            int newT = mT.get(cT);

            if (newS != newT) return false;

            if (newS == 1){
                definitions.put(cS, cT);
            }
            else {
                Character assertCT = definitions.get(cS);
                if (Character.compare(cT, assertCT) != 0) return false;
            }


        }

        return true;
        
    }
}

/*

BETTER BY CHECKING LAST SEEN INDEX POSITIONS INSTEAD OF CHARACTER COUNTS;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Create arrays to store the index of characters in both strings
        int[] indexS = new int[200]; // Stores index of characters in string s
        int[] indexT = new int[200]; // Stores index of characters in string t
        
        // Get the length of both strings
        int len = s.length();
        
        // If the lengths of the two strings are different, they can't be isomorphic
        if(len != t.length()) {
            return false;
        }
        
        // Iterate through each character of the strings
        for(int i = 0; i < len; i++) {
            // Check if the index of the current character in string s
            // is different from the index of the corresponding character in string t
            if(indexS[s.charAt(i)] != indexT[t.charAt(i)]) {
                return false; // If different, strings are not isomorphic
            }
            
            // Update the indices of characters in both strings
            indexS[s.charAt(i)] = i + 1; // updating index of current character
            indexT[t.charAt(i)] = i + 1; // updating index of current character
        }
        
        // If the loop completes without returning false, strings are isomorphic
        return true;
    }
}


*/