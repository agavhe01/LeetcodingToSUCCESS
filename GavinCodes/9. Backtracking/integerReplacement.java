/*

397. Integer Replacement
Solved
Medium
Topics
Companies
Given a positive integer n, you can apply one of the following operations:

If n is even, replace n with n / 2.
If n is odd, replace n with either n + 1 or n - 1.
Return the minimum number of operations needed for n to become 1.

Example 1:

Input: n = 8
Output: 3
Explanation: 8 -> 4 -> 2 -> 1
Example 2:

Input: n = 7
Output: 4
Explanation: 7 -> 8 -> 4 -> 2 -> 1
or 7 -> 6 -> 3 -> 2 -> 1
Example 3:

Input: n = 4
Output: 2

*/

class Solution {

    int currMin = Integer.MAX_VALUE;
    
    public int integerReplacement(int n) {    
        long newN = n;
        helper(0, newN);
        return currMin;
    }

    public void helper(
        int count,
        long n
    ){
        if ( (n == 1) ){
            if (count <= currMin) currMin = count;
            return;
        }
       
        else{
            if (isOdd(n)){
                helper(count + 1, n + 1);
                helper(count + 1, n - 1);
            }
            else{
                helper(count + 1, n / 2);
            }
        }

    }

    public boolean isOdd(long n){
        long res = n % 2;
        return res == 1;
    }
}