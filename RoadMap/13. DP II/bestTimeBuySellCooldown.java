/*
309. Best Time to Buy and Sell Stock with Cooldown

Medium

You are given an array prices where prices[i] is the price of a given stock on the ith day.

Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

Example 1:

Input: prices = [1,2,3,0,2]
Output: 3
Explanation: transactions = [buy, sell, cooldown, buy, sell]
Example 2:

Input: prices = [1]
Output: 0

*/

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        
        int n = prices.length;
        int[] M = new int[n];
        for(int i = 0; i < n; i++){
            if(i == 0) M[0] = 0;
            else if(i == 1) M[1] = Math.max(prices[1] - prices[0], 0);
            else{
                M[i] = M[i - 1];
                // linear scan
                for(int j = 0; j < i; j++){
                    int prev = j >= 2 ? M[j - 2] : 0;
                    M[i] = Math.max(M[i], prev + prices[i] - prices[j]);
                }
            }
        }
                
        return M[n - 1];
    }
}


/*

Logic

We will focus on current day i, what kind of day it is? 3 cases:

buy day
cooldown day
sell day


If it is a buy day, then we cannot make any profit at current day, so the max profit is the max profit we have made previously, i.e. yesterday, M[i] = M[i - 1]
If It is a cooldown day, then same as above, we cannot make profit at current day =>M[i] = M[i - 1](1)
If It is a sell day, then which day is the buy day? The buy day could be any days before day i(exclusive, i.e. 0 to i - 1). Let's denote it as j, then the profit we get = + previous day's profit + nums[i] - nums[j]. The problem becomes what is the previous days' profit? To figure it out, ask youself what about the day j - 1?
3.1. j - 1 cannot be a buy day. Since you cannot have 2 continuous days(j - 1 and j) as the buy day, you must sell the stock before you buy again as required.
3.2. j - 1 cannot be a sell day as well, because if it is, day j must be a cooldown day.
3.3. Thus, day j - 1 must be a cooldown day. If it is a cooldown day, then the max profit we can get at day j - 1 is M[j - 2]
Above all, M[i] = Math.max(M[j - 2] + nums[i] - nums[j]) for j = 0 to i - 1 (2)
With (1) and (2), we know that:
M[i] = max(M[i - 1], Math.max(M[j - 2] + nums[i] - nums[j]) for j = 0 to i - 1)



*/