public class wordSearch{

    public wordSearch(){ };

    /*
       
        TC : O(nm * 4 ^ nm) ??
        SC : O(1)

        // wont detect word that covers all letters

    */

    public boolean searchWord(char[][] board, String word){
        int n = board.length;
        int m = board[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (dfsChecker(board, word, i, j, n, m)) return true;
            }
        }
        return false;
    }

    public boolean dfsChecker(
        char[][] board,
        String word,
        int i,
        int j,
        int n,
        int m
    ){

        if (word.length() == 0) return true;
        if (i >= n || j >= m || i < 0 || j < 0 || board[i][j] == '#') return false;

        char c = board[i][j];
        char firstC = word.charAt(0);

        if (c != firstC) return false;
        else{
            board[i][j] = '#';
            boolean top = dfsChecker(board, word.substring(1), i - 1, j, n, m);
            boolean bottom = dfsChecker(board, word.substring(1), i + 1, j, n, m);
            boolean right = dfsChecker(board, word.substring(1), i , j - 1, n, m);
            boolean left = dfsChecker(board, word.substring(1), i, j + 1, n, m);
            board[i][j] = c;
            return top || bottom || right || left;
        }
    }

    public static void main(String[] args){

        wordSearch sol = new wordSearch();
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        
        boolean res1 = sol.searchWord(board , "ABCCED");
        boolean res2 = sol.searchWord(board , "ABCCEE");
        boolean res3 = sol.searchWord(board , "ABCCEEF");
        boolean res4 = sol.searchWord(board , "ESE");
        boolean res5 = sol.searchWord(board , "ESEECC");
        boolean res6 = sol.searchWord(board , "EEDA");
        boolean res7 = sol.searchWord(board , "ABCESEEDASFC");
        boolean res8 = sol.searchWord(board , "ABCESEEDASFCS");
        
        System.out.println("Result 1: true --> " + res1);
        System.out.println("Result 2: true --> " + res2);
        System.out.println("Result 3: false --> " + res3);
        System.out.println("Result 4: true --> " + res4);
        System.out.println("Result 5: true --> " + res5);
        System.out.println("Result 6: true --> " + res6);
        System.out.println("Result 7: true --> " + res7);
        System.out.println("Result 8: false --> " + res8); 
    }
}