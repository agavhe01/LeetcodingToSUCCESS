

class LongestIncreasingPathMatrix {
    public int n;
    public int m;
    public int[][] theMatrix;

    public LongestIncreasingPathMatrix(int[][] mat){
        theMatrix = mat;
        n = mat.length;
        m = mat[0].length;


    }

    public int longestIncreasingPath(int[][] matrix) {

       
        theMatrix = matrix;

        //System.out.println(n);
        //System.out.println(m);

        int maxPath = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                int path = DFS(i, j, -1);
                maxPath = Integer.max(path, maxPath);
            }
        }

        maxPath = DFS(0, 0, -1);

        return maxPath;
        
    }

    public int DFS(int i, int j, int prev){
       

        if( i < 0 || j < 0 || i >= n || j >= m ){
            return 0;
        }

        int left = DFS(i - 1, j, theMatrix[i][j]);
        int right = DFS(i + 1, j, theMatrix[i][j]);
        int up = DFS(i, j + 1, theMatrix[i][j]);
        int down = DFS(i, j - 1, theMatrix[i][j]);
        int maxIncreasing = Math.max(left, (Math.max(right, Math.max(up, down))));

        return maxIncreasing + 1;
    
    }

   public static void main(String[] args) {

        int[][] matrix1 = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        //[9,9,4],[6,6,8],[2,1,1]

        LongestIncreasingPathMatrix instance = new LongestIncreasingPathMatrix(matrix1);
        int ans1 = instance.longestIncreasingPath(instance.theMatrix);

        System.out.println("Result 1: "+ ans1);


    }
}