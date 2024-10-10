/*

529. Minesweeper
Solved
Medium
Topics
Companies

Let's play the minesweeper game (Wikipedia, online game)!

You are given an m x n char matrix board representing the game board where:

    'M' represents an unrevealed mine,
    'E' represents an unrevealed empty square,
    'B' represents a revealed blank square that has no adjacent mines (i.e., above, below, left, right, and all 4 diagonals),
    digit ('1' to '8') represents how many mines are adjacent to this revealed square, and
    'X' represents a revealed mine.

You are also given an integer array click where click = [clickr, clickc] represents the next click position among all the unrevealed squares ('M' or 'E').

Return the board after revealing this position according to the following rules:

    If a mine 'M' is revealed, then the game is over. You should change it to 'X'.
    If an empty square 'E' with no adjacent mines is revealed, then change it to a revealed blank 'B' and all of its adjacent unrevealed squares should be revealed recursively.
    If an empty square 'E' with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
    Return the board when no more squares will be revealed.


*/

class Solution {

    int[][] dirs = { {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1} };

    public char[][] updateBoard(char[][] board, int[] click) {

        int m = board.length;
        int n = board[0].length;

        int i = click[0];
        int j = click[1];

        if (board[i][j] == 'M'){
            board[i][j] = 'X';
            return board;
        }

        dfsHelper(i, j, board, m, n);

        return board;
        
    }

    public void dfsHelper(int i, int j, char[][] board, int m, int n){
        int mineCount = 0;

        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];

            if (x < 0 || y < 0 || x >= m || y >= n ) continue;
            if (board[x][y] == 'M') mineCount++;
        }


        board[i][j] = (mineCount > 0) ? (char) (mineCount + '0') : 'B';

        if (board[i][j] == 'B'){
            for(int[] dir : dirs){
                int x = i + dir[0];
                int y = j + dir[1];

                if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != 'E') continue;

                dfsHelper(x, y, board, m, n);
            }
        }


    }
}