/*

739. Daily Temperatures
Medium
Topics
Companies
Hint
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.

Example 1:

Input: temperatures = [73,74,75,71,69,72,76,73]
Output: [1,1,4,2,1,1,0,0]
Example 2:

Input: temperatures = [30,40,50,60]
Output: [1,1,1,0]
Example 3:

Input: temperatures = [30,60,90]
Output: [1,1,0]

*/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<Integer> stk = new Stack<Integer>();

        for(int currDay = 0; currDay < temperatures.length; currDay++){
            while ( (!stk.empty()) &&
                    ( temperatures[currDay] > temperatures[stk.peek()])
            
            ){
                int prevDay = stk.pop();
                result[prevDay] = currDay - prevDay;
            }
            stk.add(currDay);

        }
        return result;
        
    }
}


/*

O(N) space

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i = n - 2; i >= 0; i--){
            int j = i + 1;

            while ((result[j] != 0) && temperatures[j] <= temperatures[i]){
                j = j + result[j];
                /*
                    this effectively skips days whose temperatures are not warmer than the current day
                    and uses the information stored in res to efficiently jump to the next potential warmer temperature.
                */
            }

            /*

            Checking for Warmer Temperature:

                if the temperature of the day at index j is indeed warmer than the temperature of the current day 
                (temperatures[j] > temperatures[i]), 
                it means we've found a warmer temperature for the current day.
            
            Updating res[i]:

                The algorithm sets res[i] to j - i, which indicates the number of days until a warmer temperature 
                for the current day i. This is because j - i represents the difference in indices between the current day and the day with a warmer temperature (j).


            */

            if (temperatures[j] > temperatures[i]){
                result[i] = j - i;
            }
        }
        return result;
    }
}




*/