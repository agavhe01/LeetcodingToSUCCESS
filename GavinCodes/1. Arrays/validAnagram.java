/*

242. Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
*/


class Solution {
    public boolean isAnagram(String s, String t) {

/*

We create two integer arrays, s1 and t1, each of size 26 (assuming lowercase English letters only) to represent the frequency of characters in s and t. We initialize them with all zeros.

We iterate through each character in s and t and increment the corresponding index in s1 and t1 based on the character's position in the alphabet (e.g., 'a' maps to index 0, 'b' maps to index 1, and so on).

After counting the frequencies for both strings, we use Arrays.equals(s1, t1) to check if the frequency arrays are equal. If they are equal, the strings are anagrams, so we return true. Otherwise, we return false.

*/
        if(s.length()!=t.length()) return false;
        int[] s1 = new int[32];
        int[] t1 = new int[32];
        for(int i=0;i<s.length();i++){
            s1[s.charAt(i) - 'a']++;
            t1[t.charAt(i) - 'a']++;
        }
        return Arrays.equals(s1, t1);
    }
}




/*

ALTERNATE SOLUTION THAT SORTS THE STRINGS  

RUNTIME: O(n log n)

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) return false;

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        String s1 = new String(arr1);
        String s2 = new String(arr2);

        if (!s1.equals(s2)) return false; 
        return true; 

        
    }
}


*/