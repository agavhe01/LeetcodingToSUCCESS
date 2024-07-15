public class BuyStock1{

    public BuyStock1(){

    }

    /*
        PREFERRED SLIDING WINDOW
        TC : O(n)
        SC : O(1)

    */
    public static int bestTime(int[] prices){

        int left = 0;
        int profit = Integer.MIN_VALUE;

        for(int right = 1; right < prices.length; right++){
            if (prices[right] > prices[left]) profit = Math.max(profit, prices[right] - prices[left]);
            else left = right;
        }

        return profit;
    }

    /*
    
        ALTERNATE METHOD

        TC : O(n)
        SC : O(1)

    */

    public static int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE; //lowest purchase price so far
        int op = 0; // overall profit
        int pist = 0; // profit if sold today
        
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < lsf){
                lsf = prices[i];
            }
            pist = prices[i] - lsf;
            if(op < pist){
                op = pist;
            }
        }
        return op;
    }
    public static void main(String[] args){

        BuyStock1 sol = new BuyStock1();

        int[] test1 = new int[]{7,1,5,3,6,4};
        int res1 = sol.bestTime(test1);
        System.out.println("Should print 5 --> " + res1);
        int res2 = sol.maxProfit(test1);
        System.out.println("Should print 5 --> " + res2);

    }
}