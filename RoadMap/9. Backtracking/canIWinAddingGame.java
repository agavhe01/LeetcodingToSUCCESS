/*

464. Can I Win
Solved
Medium
Topics
Companies

In the "100 game" two players take turns adding, to a running total, any integer from 1 to 10. The player who first causes the running total to reach or exceed 100 wins.

What if we change the game so that players cannot re-use integers?

For example, two players might take turns drawing from a common pool of numbers from 1 to 15 without replacement until they reach a total >= 100.

Given two integers maxChoosableInteger and desiredTotal, return true if the first player to move can force a win, otherwise, return false. Assume both players play optimally.


Example 1:

Input: maxChoosableInteger = 10, desiredTotal = 11
Output: false
Explanation:
No matter which integer the first player choose, the first player will lose.
The first player can choose an integer from 1 up to 10.
If the first player choose 1, the second player can only choose integers from 2 up to 10.
The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
Same with other integers chosen by the first player, the second player will always win.

Example 2:

Input: maxChoosableInteger = 10, desiredTotal = 0
Output: true

Example 3:

Input: maxChoosableInteger = 10, desiredTotal = 1
Output: true

 
Constraints:

    1 <= maxChoosableInteger <= 20
    0 <= desiredTotal <= 300

*/

class Solution {

    Map<List<Boolean>, Boolean> memo = new HashMap<List<Boolean>, Boolean>();

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        if (desiredTotal <= maxChoosableInteger) return true;

        int maxSum = 0;
        for(int i = 1; i <= maxChoosableInteger; i++) maxSum += i;
        if (maxSum < desiredTotal) return false;

        List<Boolean> initState = new ArrayList<Boolean>();
        for(int i = 0; i <= maxChoosableInteger; i++)initState.add(false);

        return backTrackSolver(maxChoosableInteger, desiredTotal, initState);  
    }

    public boolean backTrackSolver(
        int maxChoosableInteger,
        int desiredTotal,
        List<Boolean> state
    ){
        // If desiredTotal is less than or equal to zero, 
        // the current player loses, so the method returns false.
        if (desiredTotal <= 0) return false;

        if (memo.containsKey(state)) return memo.get(state);

        for(int i = 1; i <= maxChoosableInteger; i++){
            if (state.get(i)) continue;

            state.set(i, true);

            boolean canOpponentWin = backTrackSolver(   maxChoosableInteger, 
                                                        desiredTotal - i,
                                                        state
                                                    );

            state.set(i, false);
            
            if (! canOpponentWin ){
                memo.put(state, true);
                return true;
                
            }
                
        }// end for

        memo.put(state, false);
        return false;

    }

}