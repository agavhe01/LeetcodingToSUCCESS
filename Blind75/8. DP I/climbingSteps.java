public class climbingSteps{

    public climbingSteps(){ }

    /*
        TC: O(n)
        SC: O(n)
    */
    public int climbStairs(int n){
        if (n <= 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /*
        TC: O(n)
        SC: O(1)
    */
    public int findSteps(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2;
        for (int i = 3; i <= n; i++) {
            int tmp = first + second;
            first = second;
            second = tmp;
        }
        return second;
    }

    public static void main(String[] args){
        climbingSteps sol = new climbingSteps();

        int r1 = sol.climbStairs(2); // 2
        int r2 = sol.climbStairs(5); // 8 
        int r3 = sol.climbStairs(4); // 5
        int r4 = sol.climbStairs(1); // 1

        System.out.println("Result 1: 2 --> " + r1);
        System.out.println("Result 2: 8 --> " + r2);
        System.out.println("Result 3: 5 --> " + r3);
        System.out.println("Result 4: 1 --> " + r4);

        System.out.println("\n No Extra Space \n");

        System.out.println("Result 1: 2 --> " + sol.findSteps(2));
        System.out.println("Result 2: 8 --> " + sol.findSteps(5));
        System.out.println("Result 3: 5 --> " + sol.findSteps(4));
        System.out.println("Result 4: 1 --> " + sol.findSteps(1));
        
    }
}