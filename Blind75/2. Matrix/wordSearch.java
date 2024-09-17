public class wordSearch{

    public wordSearch(){ };

    /*
       
        TC : O(nm * 4 ^ nm) ??
        SC : O(1)

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
            boolean top    = dfsChecker(board, word.substring(1), i - 1, j, n, m);
            boolean bottom = dfsChecker(board, word.substring(1), i + 1, j, n, m);
            boolean right  = dfsChecker(board, word.substring(1), i, j - 1, n, m);
            boolean left   = dfsChecker(board, word.substring(1), i, j + 1, n, m);
            board[i][j] = c;
            return top || bottom || right || left;
        }
    }

    public static void main(String[] args){

        wordSearch sol = new wordSearch();
        System.out.println("Board 1 Results");
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

        System.out.println("_______________________________________________");

        char[][] board2 = {{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};

        boolean res11 = sol.searchWord(board2 , "oath");
        boolean res12 = sol.searchWord(board2 , "pea");
        boolean res13 = sol.searchWord(board2 , "eat");
        boolean res14 = sol.searchWord(board2 , "rain");

        System.out.println("Board 2 Results");
        System.out.println("Result 11:  true --> " + res11);
        System.out.println("Result 12: false --> " + res12);
        System.out.println("Result 13:  true --> " + res13);
        System.out.println("Result 14: false --> " + res14);
    }
}

/*

class Solution {

    class Node {
        HashMap<Character, Node> child;
        String word;
        public Node() {
            child = new HashMap<>();
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        Node root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0;  j < board[0].length; j++) {
                dfs(board, list, root, i, j);
            }
        }
        return list;
    }

    public void dfs(char[][] board, List<String> list, Node curr, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;

        char ch = board[i][j];

        if (ch == '#' || curr.child.get(ch) == null) return;
        curr = curr.child.get(ch);
        if (curr.word != null) {
            list.add(curr.word);
            curr.word = null;
        }

        board[F][j] = '#';
        // top, left, down, right
        dfs(board, list, curr, i - 1, j);
        dfs(board, list, curr, i, j - 1);
        dfs(board, list, curr, i + 1, j);
        dfs(board, list, curr, i, j + 1);
        board[i][j] = ch;
    }

    public Node buildTrie(String[] words) {
        Node root = new Node();
        for (String word : words) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (!curr.child.containsKey(ch)) {
                    curr.child.put(ch, new Node());
                }
                curr = curr.child.get(ch);
            }
            curr.word = word;
        }
        return root;
    }
}



*/