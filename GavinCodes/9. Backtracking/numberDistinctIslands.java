/*

694. Number of Distinct Islands
Solved
Medium
Topics
Companies

You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Return the number of distinct islands.

 

Example 1:

Input: grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
Output: 1

Example 2:

Input: grid = [[1,1,0,1,1],[1,0,0,0,0],[0,0,0,0,1],[1,1,0,1,1]]
Output: 3

 

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 50
    grid[i][j] is either 0 or 1.



*/

class Solution {
    public int numDistinctIslands(int[][] grid) {

        Set<String> results = new HashSet<>();

        int m = grid.length;
        int n = grid[0].length;

        for(int row = 0; row < m; row++){
            for(int col = 0; col < n; col++){
                
                if (grid[row][col] != 0){
                    StringBuilder sb = new StringBuilder();
                    helper(grid, row, col, m, n, sb, "o");
                    results.add(sb.toString());
                }
            }

        }

        return results.size();
        
    }

    public void helper(
        int[][] grid,
        int row, int col, int m, int n,
        StringBuilder sb,
        String dir
    ){
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0) return;

        grid[row][col] = 0;
        sb.append(dir);

        helper(grid, row - 1, col, m, n, sb, "u");
        helper(grid, row + 1, col, m, n, sb, "d");
        helper(grid, row, col - 1, m, n, sb, "l");
        helper(grid, row, col + 1, m, n, sb, "r");

        sb.append("b");


    }
}