/*
125. Valid Palindrome
Solved
Easy
Topics
Companies
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

*/

class Solution {
    public boolean isPalindrome(String s) {

        if (s.length() == 0) return true;

        int start = 0;
        int end = s.length() - 1;

        while (start < end){
            Character sChar = s.charAt(start);
            Character eChar = s.charAt(end);

            if (!Character.isLetterOrDigit(sChar)) start++;
            else if (!Character.isLetterOrDigit(eChar)) end--;
            else{
                
                Character normStart = Character.toLowerCase(sChar);
                Character normEnd = Character.toLowerCase(eChar);
                if (normStart.equals(normEnd) == false){
                    return false;
                }
                start++;
                end--;

            }
        }



        return true;


        
    }
}