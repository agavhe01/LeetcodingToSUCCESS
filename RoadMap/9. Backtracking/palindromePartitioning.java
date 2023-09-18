/*

131. Palindrome Partitioning

Medium


Given a string s, partition s such that every substring of the partition is a palindrome 
Return all possible palindrome partitioning of s.

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]




*/

public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        // Check for base cases: empty input string
        if (s == null || s.length() == 0) {
            return results;
        }
        
        List<String> partition = new ArrayList<String>();
        // Start the partitioning process with the helper function
        helper(s, 0, partition, results);
        
        return results; // Return the list of all valid partitions
    }
    
    // Helper function for recursive partitioning
    private void helper(String s,
                        int startIndex,
                        List<String> partition,
                        List<List<String>> results) {
        // If we have reached the end of the input string, add the current
        // partition to the results and return
        if (startIndex == s.length()) {
            results.add(new ArrayList<String>(partition));
            return;
        }
        
        // Iterate through the string from the current startIndex
        for (int i = startIndex; i < s.length(); i++) {
            // Extract a substring from startIndex to i
            String subString = s.substring(startIndex, i + 1);
            
            // Check if the extracted substring is a palindrome
            if (!isPalindrome(subString)) {
                continue; // If not a palindrome, skip to the next substring
            }
            
            // Add the palindrome substring to the current partition
            partition.add(subString);
            
            // Recursively explore further partitions starting from i + 1
            helper(s, i + 1, partition, results);
            
            // Backtrack by removing the last added substring
            partition.remove(partition.size() - 1);
        }
    }
    
    // Function to check if a string is a palindrome
    private boolean isPalindrome(String s) {
        // Compare characters from the start and end of the string
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false; // If a mismatch is found, it's not a palindrome
            }
        }
        return true; // If no mismatches are found, it's a palindrome
    }
}
