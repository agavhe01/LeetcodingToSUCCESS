/*

64. Minimum Path Sum
Solved
Medium
Topics
Companies
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.


Example 1:


Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

*/

class Solution {
    public int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){

                int num = grid[row][col];

                if ( (row == 0) && (col == 0) ){
                    dp[row][col] = num;
                }
                else if ( (row == 0) ){
                    dp[row][col] = dp[row][col - 1] + num;
                }
                else if ( (col == 0) ){
                    dp[row][col] = dp[row - 1][col] + num;
                }
                else {
                    dp[row][col] = Math.min( dp[row - 1][col], dp[row][col - 1] ) + num;
                }
            }
        }

        
        return dp[m - 1][n - 1];
    }
}