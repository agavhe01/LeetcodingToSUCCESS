/*

221. Maximal Square
Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

Example 1:

Input: matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
Output: 4
Example 2:


Input: matrix = [["0","1"],["1","0"]]
Output: 1
Example 3:

Input: matrix = [["0"]]
Output: 0
 

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 300
matrix[i][j] is '0' or '1'.


*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int result = Integer.MIN_VALUE;

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){

                if ( (row == 0) || (col == 0) ){
                    if (matrix[row][col] == '1'){
                        dp[row][col] = 1;
                        result = Math.max(result, dp[row][col]);
                    }
                }
                else{
                    if (matrix[row][col] == '1'){
                        dp[row][col] = 1 + Math.min(dp[row - 1][col], Math.min(dp[row][col - 1], dp[row - 1][col - 1]));
                        result = Math.max(result, dp[row][col]);
                    }
                }

            }
        }

        return result * result;
    }
}