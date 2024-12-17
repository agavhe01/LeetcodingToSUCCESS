
/*

200. Number of Islands
Solved
Medium
Topics
Companies

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 a

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

 

Constraints:

    m == grid.length
    n == grid[i].length
    1 <= m, n <= 300
    grid[i][j] is '0' or '1'.


*/

class Solution {

    int result = 0;

    // left, right, up, down
    int[][] dirs = { {0, -1} , {0, 1} , {-1, 0} , {1 , 0} };

    public int numIslands(char[][] grid) {

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if (grid[row][col] == '1'){
                    result++;
                    dfsHelper(grid, row, col);
                }
            }
        }

        return result;
        
    }

    public void dfsHelper(char[][] grid, int r, int c){

        int n = grid.length;
        int m = grid[0].length;

        if (r < 0 || c < 0 || r >= n || c >= m || grid[r][c] != '1') return;
        
        grid[r][c] = '0';

        for(int[] dir : dirs){
            int newR = r + dir[0];
            int newC = c + dir[1];
            dfsHelper(grid, newR, newC);
        }



    }
}