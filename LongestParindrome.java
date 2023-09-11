// LEETCODE QUESTION #5 



class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();

       boolean[][] dp = new boolean[n][n];

       for(var j : dp){
           Arrays.fill(j, true);
       }


       int mx = 1;
       int k = 0;

       // dp[i][j] = substr(i:j)

       for(int i = n - 2; i >= 0; i--){
           for(int j = i + 1; j < n; j++){
               dp[i][j] = false;

               if(s.charAt(i) == s.charAt(j)){
                   dp[i][j] = dp[i + 1][j - 1];
                   if(dp[i][j] && mx < j - i + 1){
                       mx = j - i + 1;
                       k = i;
                       
                   }
               }
           }
       }

    //    for(int i = 0; i < n; i++){
    //        for(int j = 0; j < n; j++){
    //            boolean aVar = dp[i][j];

    //            System.out.println("booleanArray[" + i + "][" + j + "] = " + dp[i][j]);
    //        }
    //    }

      return s.substring(k, k + mx);
    }

}