/*

567. Permutation in String
Solved
Medium
Topics
Companies
Hint
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.


Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.

*/

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for(int i = 0; i < n1; i++){
            map1[s1.charAt(i) - 'a']++;
        }

        for(int i = 0; i < n1 - 1; i++){
            map2[s2.charAt(i) - 'a']++;
        }

        for(int left = 0, right = n1 - 1; right < n2; left++, right++){
            map2[s2.charAt(right) - 'a']++;
            if (check(map1, map2)) return true;
            map2[s2.charAt(left) - 'a']--;
        }

        return false;   
    }

    public boolean check(int[] m1, int[] m2){
        for(int i = 0; i < 26; i++){
            if (!(m1[i] == m2[i])) return false;
        }
        return true;
    }
}

/*

SOLUTION TO INCORPORATE BOTH CAPITAL AND SMALL LETTERS: 

    README:
        This considers ab and AB as different permutations
        To consider them as the same, remove every occurrence of    "+ 26" from the string s


public class Solution {
    
    public static void main(String args[]) {
      Solution s = new Solution();
      String s1 = "ab";
      String s2 = "eiBAcooo";
      Boolean result = s.checkInclusion(s1, s2); 

      System.out.println("Result: " + result);
    }
    
    
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;
        
        int[] map1 = new int[52]; // Frequency array for lowercase and uppercase letters
        int[] map2 = new int[52]; // Frequency array for lowercase and uppercase letters

        // Populate map1 with frequencies of characters in s1
        for (int i = 0; i < n1; i++) {
            char c = s1.charAt(i);
            if (Character.isLowerCase(c)) {
                map1[c - 'a']++;
            } else {
                map1[c - 'A' + 26]++; // Adjusting index for uppercase letters
            }
        }

        // Populate map2 with frequencies of characters in the first n1 - 1 characters of s2
        for (int i = 0; i < n1 - 1; i++) {
            char c = s2.charAt(i);
            if (Character.isLowerCase(c)) {
                map2[c - 'a']++;
            } else {
                map2[c - 'A' + 26]++; // Adjusting index for uppercase letters
            }
        }

        // Sliding window approach
        for (int left = 0, right = n1 - 1; right < n2; left++, right++) {
            // Update map2 with the frequency of the character at the right end of the window
            char rightChar = s2.charAt(right);
            if (Character.isLowerCase(rightChar)) {
                map2[rightChar - 'a']++;
            } else {
                map2[rightChar - 'A' + 26]++; // Adjusting index for uppercase letters
            }
            
            // Check if the current window of s2 is a permutation of s1
            if (check(map1, map2)) return true;
            
            // Update map2 by decrementing the frequency of the character at the left end of the window
            char leftChar = s2.charAt(left);
            if (Character.isLowerCase(leftChar)) {
                map2[leftChar - 'a']--;
            } else {
                map2[leftChar - 'A' + 26]--; // Adjusting index for uppercase letters
            }
        }

        return false;
    }

    // Method to check if two frequency arrays are equal
    public boolean check(int[] m1, int[] m2) {
        for (int i = 0; i < 52; i++) {
            if (m1[i] != m2[i]) return false;
        }
        return true;
    }
}



*/