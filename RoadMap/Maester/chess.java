import java.util.LinkedList;
import java.util.Queue;

public class chess {

    // Define the possible moves for the knight.
    private static final int[][] MOVES = {
            {-2, -1}, {-1, -2},
            {-2, 1}, {-1, 2},
            {1, -2}, {2, -1},
            {1, 2}, {2, 1}
    };

    public static int minMoves(int n, int startRow, int startCol, int endRow, int endCol) {
        // Create a chessboard of size n x n to keep track of visited positions.
        boolean[][] visited = new boolean[n][n];

        // Initialize the queue for BFS and enqueue the starting position.
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        int moves = 0;

        // Perform BFS to find the minimum number of moves.
        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all positions at the current level.
            for (int i = 0; i < size; i++) {
                int[] currentPosition = queue.poll();
                int row = currentPosition[0];
                int col = currentPosition[1];

                // Check if we have reached the target position.
                if (row == endRow && col == endCol) {
                    return moves;
                }

                // Explore all possible knight moves from the current position.
                for (int[] move : MOVES) {
                    int newRow = row + move[0];
                    int newCol = col + move[1];

                    // Check if the new position is within the chessboard and hasn't been visited.
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                        queue.offer(new int[]{newRow, newCol});
                        visited[newRow][newCol] = true;
                    }
                }
            }

            // Increment the number of moves.
            moves++;
        }

        // If we reach here, it means the knight cannot reach the target position.
        return -1;
    }

    public static void main(String[] args) {
        int n = 9;
        int startRow = 4;
        int startCol = 4;
        int endRow = 4;
        int endCol = 8;



        // yahh
        int minMoves1 = minMoves(n, startRow, startCol, endRow, endCol);
        assert(minMoves1 == 2): "Expected 2, actual: " + minMoves1;

        int minMoves2 = minMoves(10, 0, 0, 0, 2);
        assert(minMoves2 == 2): "Expected 2, actual: " + minMoves2;

        int minMoves3 = minMoves(7,6,6,0,1);
        assert(minMoves3 == 5): "Expected 5, actual: " + minMoves3;

        int minMoves4 = minMoves(6, 5, 1, 0, 5);
        assert(minMoves4 == 3): "Expected 3, actual: " + minMoves4;

        int minMoves5 = minMoves(8,0,0,1,1);
        assert(minMoves5 == 4): "Expected 4, actual: " + minMoves5;

        int minMoves6 = minMoves(10, 9,9,5,3);
        assert(minMoves6 == 4): "Expected 4, actual: " + minMoves6;

        int minMoves7= minMoves(30, 25, 2, 23, 29);
        assert(minMoves7 == 15): "Expected 15, actual: " + minMoves7;

        int minMoves8 = minMoves(10, 9, 9, 5, 3);
        assert(minMoves8 == 4): "Expected 4, actual: " + minMoves8;

        




    }
}
