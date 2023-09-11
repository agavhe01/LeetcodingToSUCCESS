import java.util.LinkedList;
import java.util.Queue;

public class BestPath {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static int findBestPath(int n, int m, int startRow, int startColumn, int endRow, int endColumn,
                                   int[] monsterRow, int[] monsterColumn) {
        int[][] grid = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startColumn});
        visited[startRow][startColumn] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == endRow && y == endColumn) {
                return grid[x][y];
            }

            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && !visited[newX][newY]) {
                    int minDist = Math.min(grid[x][y], calcDist(x, y, monsterRow, monsterColumn));
                    grid[newX][newY] = minDist;
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        return 0; // No valid path to reach the endpoint without visiting a cell with monsters
    }

    private static int calcDist(int x, int y, int[] monsterRow, int[] monsterColumn) {
        int minDist = Integer.MAX_VALUE;
        for (int i = 0; i < monsterRow.length; i++) {
            int dist = Math.abs(x - monsterRow[i]) + Math.abs(y - monsterColumn[i]);
            minDist = Math.min(minDist, dist);
        }
        return minDist;
    }

    public static void main(String[] args) {
        int n1 = 5, m1 = 3, startRow1 = 1, startColumn1 = 1, endRow1 = 4, endColumn1 = 2;
        int[] monsterRow1 = {0, 2};
        int[] monsterColumn1 = {2, 2};
        int result1 = findBestPath(n1, m1, startRow1, startColumn1, endRow1, endColumn1, monsterRow1, monsterColumn1);
        System.out.println(result1);

        int n2 = 3, m2 = 3, startRow2 = 0, startColumn2 = 1, endRow2 = 2, endColumn2 = 2;
        int[] monsterRow2 = {1, 1, 1};
        int[] monsterColumn2 = {0, 1, 2};
        int result2 = findBestPath(n2, m2, startRow2, startColumn2, endRow2, endColumn2, monsterRow2, monsterColumn2);
        System.out.println(result2);
    }
}
