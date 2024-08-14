import java.util.*;
import java.util.HashMap;


public class matrixGraph{

    public int[][] grid;
    public int gridLength;

    public matrixGraph(int n) {
        grid = new int[n][n];
        gridLength = n;
    }

    public matrixGraph(int[][] g){
        grid = g;
        gridLength = grid[0].length;
    }

 /*

        Return the length of the shortest path from top left to bottom right along the 0's

        T(C): O ( ROWS * COLS )   
        S(C): O ( ROWS * COLS )
                              

*/
    public int bfsShortestPath() {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int[][] visit = new int[ROWS][COLS];
        Deque<int[]> queue = new ArrayDeque<>();

        queue.add(new int[2]); // Add {0, 0}
        visit[0][0] = 1;

        int length = 0;
        while (!queue.isEmpty()) {
            int queueLength = queue.size();
            for (int i = 0; i < queueLength; i++) {
                int pair[] = queue.poll();
                int r = pair[0], c = pair[1];
                if (r == ROWS - 1 && c == COLS - 1) {
                    return length;
                }    
                // We can directly build the four neighbors
                int[][] neighbors = {{r, c + 1}, {r, c - 1}, {r + 1, c}, {r - 1, c}};
                for (int j = 0; j < 4; j++) {
                    int newR = neighbors[j][0], newC = neighbors[j][1];
                    if (Math.min(newR, newC) < 0 || newR == ROWS || newC == COLS
                    || visit[newR][newC] == 1 || grid[newR][newC] == 1) {
                        continue;
                    }
                    queue.add(neighbors[j]);
                    visit[newR][newC] = 1;
                }
            }
            length++;
        }
        return length; // This should never be called
    }


    /*
        Count unique paths from top left to bottom right along the Os
        Can only visit a cell once 

        T(C) : O (4 ^ nm)   WHERE N = ROWS
                                  M = COLS

        S(C) : O (  nm )   --> size of visit and size of recursive call stack = nm

    */
    public int dfsCountPaths(int r, int c, int[][] visit) {
        int ROWS = grid.length, COLS = grid[0].length;

        if (Math.min(r, c) < 0 || r == ROWS || c == COLS ||
            visit[r][c] == 1 || grid[r][c] == 1 ) {
            return 0;
        }
        if (r == ROWS - 1 && c == COLS - 1) {
            return 1;
        }
        visit[r][c] = 1;

        int count = 0;
        count += dfsCountPaths(r + 1, c, visit);
        count += dfsCountPaths(r - 1, c, visit);
        count += dfsCountPaths(r, c + 1, visit);
        count += dfsCountPaths(r, c - 1, visit);

        visit[r][c] = 0;
        return count;
    }

    public static void main(String[] args){
                          // col
        int[][] grid = {{0, 0, 0, 0},
                        {1, 1, 0, 0},
                        {0, 0, 0, 1},   // row
                        {0, 1, 0, 0}};

        matrixGraph g1 = new matrixGraph(grid);
        int r1 = g1.bfsShortestPath();
        System.out.println("  Shortest Path g1: 6 --> " + r1);

        int r2 = g1.dfsCountPaths(0, 0, new int[grid.length][grid[0].length]);
        System.out.println("Number of Paths g1: 2 --> " + r2);


    }
}