import java.util.List;

public class Solution1 {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] memo = new int[m][n]; // To store computed results
        
        int[] dx = {-1, 0, 1, 0}; // Directions for DFS
        int[] dy = {0, 1, 0, -1};
        
        int dfs(int i, int j) {
            if (memo[i][j] != 0) {
                return memo[i][j];
            }
            
            int maxPath = 1; // Default length, considering only the current element
            
            for (int d = 0; d < 4; d++) {
                int x = i + dx[d];
                int y = j + dy[d];
                
                if (x >= 0 && y >= 0 && x < m && y < n && matrix[x][y] > matrix[i][j]) {
                    maxPath = Math.max(maxPath, dfs(x, y) + 1);
                }
            }
            
            memo[i][j] = maxPath; // Store the computed result
            
            return maxPath;
        }
        
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }
        
        return ans;
    }
    
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {
            {9, 9, 4},
            {6, 6, 8},
            {2, 1, 1}
        };
        System.out.println(solution.longestIncreasingPath(matrix)); // Output: 4
    }
}
