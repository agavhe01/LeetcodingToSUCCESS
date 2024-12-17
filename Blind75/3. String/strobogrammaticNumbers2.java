/*

247. Strobogrammatic Number II
Solved
Medium
Topics
Companies
Hint

Given an integer n, return all the strobogrammatic numbers that are of length n. You may return the answer in any order.

A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 

Example 1:

Input: n = 2
Output: ["11","69","88","96"]

Example 2:

Input: n = 1
Output: ["0","1","8"]

 

Constraints:

    1 <= n <= 14


*/

class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }

    public List<String> helper(int n, int m){
        if (n == 0) return new ArrayList<String>(Arrays.asList(""));
        if (n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));

        List<String> list = helper(n - 2, m);
        List<String> result =  new ArrayList<String>();

        for(String str : list){
            if (n != m) result.add("0" + str + "0");

            result.add("1" + str + "1");
            result.add("8" + str + "8");
            result.add("9" + str + "6");
            result.add("6" + str + "9");
        }
        return result;
    }
}