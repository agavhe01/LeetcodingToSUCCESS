/*

931. Minimum Falling Path Sum
Solved
Medium
Topics
Companies
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

Example 1:

Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100

*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        // that will store the minimum path sums up to each element.
        int[][] dp = new int[rows][cols];

        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                if (i == 0){
                    dp[i][j] = matrix[i][j];
                }
                else{
                    int sAbove = dp[i - 1][j];
                    int rAbove = (j - 1 > -1)   ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                    int lAbove = (j + 1 < cols) ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                    int minAbove = Math.min(sAbove, Math.min(rAbove, lAbove));
                    dp[i][j] = matrix[i][j] + minAbove;

                }
            }
        }

        int result = Integer.MAX_VALUE;
        for(int num : dp[rows - 1]) result = Math.min(num, result);
        return result;
        
    }
}
