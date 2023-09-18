/*
Leetcode: 121. Best Time to Buy and Sell Stock
Easy



You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



*/


class Solution {
    public int maxProfit(int[] prices) {
        int lsf = Integer.MAX_VALUE; //lowest purchase price so far
        int op = 0; // overall prpfit
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
}