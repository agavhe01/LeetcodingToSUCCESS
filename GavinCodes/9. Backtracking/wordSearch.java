import java.util.*;

class Solution {

    List<String> result = new ArrayList<>();
    boolean[][] visited; // Array to track visited cells


    public List<String> findWords(char[][] board, String[] words) {

        Set<String> dict = new HashSet<>();

        for(String w: words){ dict.add(w); }

        visited = new boolean[board.length][board[0].length]; 

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                helper3(i, j, board, dict, new StringBuilder() );
            }
        }

        return result;
        
    }

    public void helper(int row, int col, char[][] board, Set<String> dict, StringBuilder curr){

        if (row >= board.length || col >= board[0].length || row < 0 || col < 0){
            if (curr.length() > 0){
                if (dict.contains(curr.toString())) { result.add(curr.toString()); }
            }
            return;
        }

        curr.append(board[row][col]);

        if (dict.contains(curr.toString())){
            result.add(curr.toString());
        }

        helper(row + 1, col, board, dict, new StringBuilder(curr));
        helper(row - 1, col, board, dict, new StringBuilder(curr));

        helper(row, col + 1, board, dict, new StringBuilder(curr));
        helper(row, col - 1, board, dict, new StringBuilder(curr));


    }

     public void helper2(int row, int col, char[][] board, Set<String> dict, StringBuilder curr) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]) {
            if (curr.length() > 0){
                if (dict.contains(curr.toString())) { result.add(curr.toString()); }
            }
            return;
        }

        curr.append(board[row][col]);
        String currentString = curr.toString();
        // System.out.println(currentString);

        if (dict.contains(currentString)) {
            result.add(currentString);
            dict.remove(currentString); // Ensuring uniqueness by removing the word from dictionary once found
        }

        char temp = board[row][col]; // Temporarily mark the current cell as visited
        board[row][col] = ' '; // Marking it as visited

        helper2(row + 1, col, board, dict, curr);
        helper2(row - 1, col, board, dict, curr);
        helper2(row, col + 1, board, dict, curr);
        helper2(row, col - 1, board, dict, curr);

        // Backtrack
        board[row][col] = temp;
        curr.setLength(curr.length() - 1);
    }

     public void helper3(int row, int col, char[][] board, Set<String> dict, StringBuilder curr) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]) {
            return;
        }

        curr.append(board[row][col]);
        String currentString = curr.toString();

        if (dict.contains(currentString)) {
            result.add(currentString);
            dict.remove(currentString); // Ensuring uniqueness by removing the word from dictionary once found
        }

        visited[row][col] = true; // Mark the cell as visited

        helper3(row + 1, col, board, dict, curr);
        helper3(row - 1, col, board, dict, curr);
        helper3(row, col + 1, board, dict, curr);
        helper3(row, col - 1, board, dict, curr);

        // Backtrack
        // visited[row][col] = false; // Mark the cell as not visited
        curr.setLength(curr.length() - 1);
    }

    public static void main(String[] args) {
        char[][] board = {
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'},
            {'a','a','a','a','a','a','a','a','a','a','a','a'}
        };

        String[] words = {
            "a", "aa", "aaa", "aaaa", "aaaaa", 
            "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"
        };

        Solution solution = new Solution();
        List<String> result = solution.findWords(board, words);

        System.out.println("Words found:");
        for (String word : result) {
            System.out.println(word);
        }
    }

}