/*

994. Rotting Oranges
Solved
Medium
Topics
Companies

You are given an m x n grid where each cell can have one of three values:

    0 representing an empty cell,
    1 representing a fresh orange, or
    2 representing a rotten orange.

Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

 

Example 1:

*/


class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int countFresh = 0;
        int countRotten = 0;

        Queue<int[]> q = new ArrayDeque<int[]>();

        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                    countRotten++;
                }
                if (grid[i][j] == 1) countFresh++;
            }
        }

        if (countFresh == 0) return 0;
        if (countRotten == 0) return -1;

        int minutes = -1;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (! q.isEmpty()){
            int currSize = q.size();

            while (currSize -- > 0){
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];

                for(int[] dir : dirs){
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && grid[newX][newY] == 1){
                        grid[newX][newY] = 2;
                        countRotten++;
                        countFresh--;
                        q.offer(new int[]{newX, newY});
                    }
                }


            }
            
            minutes++;
            System.out.println("Number fresh: " + countFresh + " and Rotten: " + countRotten + " and Time: " + minutes);
        }

        if (countFresh == 0) return minutes;
        return -1;
        
    }
}