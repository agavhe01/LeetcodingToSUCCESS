public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */



/*
board: The 2D character array representing the board.
word: The target word to find.
now: The current index in the word that is being matched.
x and y: The current position on the board (x, y).
n and m: The dimensions of the board (number of rows and columns).
visited: A map to keep track of visited cells on the board.
*/
    boolean dfs(char[][] board, String word, int now, int x, int y, int n, int m, Map<Integer, Boolean>visited) {

        // two integer arrays used to represent pairs of movements in the horizontal (x) and vertical (y) directions. 
        int []zx = {0, 0, 1, -1};
        int []zy = {1, -1, 0, 0};

       
        if(now == word.length() - 1) {
            return true;
        }


        /*
The function first checks if the current cell (x, y) matches the character at the now index of the word. If not, it returns false.
It then explores four possible directions (up, down, left, and right) from the current cell.
If a valid neighboring cell is found that matches the next character in the word and has not been visited before, the function recursively calls itself with the updated position and index and marks the neighboring cell as visited.
After the recursive call, it backtracks by marking the cell as unvisited (to allow other paths to explore) and checks if the recursive call returns true. If it does, it means a valid path has been found, and the function returns true. Otherwise, it continues to explore other directions.
If no valid path is found from the current cell, the function returns false.
        */
        
        for(int k = 0; k < 4; k++) {
            int nx = x + zx[k];
            int ny = y + zy[k];
          
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] != word.charAt(now + 1) || visited.get(nx * m + ny) == true) {
                continue;
            }
            
            visited.put(nx * m + ny, true);
            boolean tmp = dfs(board, word, now + 1, nx, ny, n, m, visited);
           
            visited.put(nx * m + ny, false);
            if(tmp) {
                return true;
            }
        }
        return false;
    }
    public boolean exist(char[][] board, String word) {

        // initializes the dimensions of the board (n and m) and a map visited to track visited cells.
        int n;
        int m;
        n = board.length;
        m = board[0].length;
        
        Map<Integer, Boolean>visited = new HashMap<Integer, Boolean>();
       
      

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                visited.put(i * m + j, false);
            }
        }


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(word.charAt(0) == board[i][j]) {
                    visited.put(i * m + j, true);
                    boolean tmp = dfs(board, word, 0, i, j, n, m, visited);
                    visited.put(i * m + j, false);
                    if(tmp) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}