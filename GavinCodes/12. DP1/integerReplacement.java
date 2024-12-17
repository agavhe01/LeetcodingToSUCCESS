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

 

Constraints:

    1 <= n <= 231 - 1


*/


class Solution {

    Map<Long, Long> memo = new HashMap<>();

    public int integerReplacement(int n) {

        long num = n;
        Long result = helper(num);
        return result.intValue();
        
    }

    public long helper(long n){
        if (n == 1) return 0;

        if (memo.containsKey(n)) return memo.get(n);

        if (n % 2 == 0){
            long res = 1 + helper(n / 2);
            memo.put(n, res);
            return res;
        }
        else{
            long up = 1 + helper(n + 1);
            long down = 1 + helper(n - 1);
            long res = Math.min(up, down);
            memo.put(n, res);
            return res; 
        }

    }
}