/*

186. Reverse Words in a String II
Solved
Medium
Topics
Companies

Given a character array s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by a single space.

Your code must solve the problem in-place, i.e. without allocating extra space.

 

Example 1:

Input: s = ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]

Example 2:

Input: s = ["a"]
Output: ["a"]

 

Constraints:

    1 <= s.length <= 105
    s[i] is an English letter (uppercase or lowercase), digit, or space ' '.
    There is at least one word in s.
    s does not contain leading or trailing spaces.
    All the words in s are guaranteed to be separated by a single space.


*/

class Solution {
    public void reverseWords(char[] s) {

        // Reverse the whole word
        reverse(s, 0, s.length - 1);
        // printSeq(s, 0, s.length - 1);

        // Reverse each word

        int start = 0;
        for(int i = 0; i < s.length; i++){
            if (s[i] == ' '){
                reverse(s, start, i - 1);
                start = i + 1;
            }
        }

        // printSeq(s, 0, s.length - 1);

        // reverse the last word
        reverse(s, start, s.length - 1);
        
    }

    public void reverse(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }

    public void printSeq(char[] s, int st, int e){
        for(int i = st; i <= e; i++){
            System.out.print(s[i] + " ");
        }
        System.out.println();
    }
}