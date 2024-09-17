/*

2178. Maximum Split of Positive Even Integers
Solved
Medium
Topics
Companies
Hint

You are given an integer finalSum. Split it into a sum of a maximum number of unique positive even integers.

    For example, given finalSum = 12, the following splits are valid (unique positive even integers summing up to finalSum): (12), (2 + 10), (2 + 4 + 6), and (4 + 8). Among them, (2 + 4 + 6) contains the maximum number of integers. Note that finalSum cannot be split into (2 + 2 + 4 + 4) as all the numbers should be unique.

Return a list of integers that represent a valid split containing a maximum number of integers. If no valid split exists for finalSum, return an empty list. You may return the integers in any order.

 

Example 1:

Input: finalSum = 12
Output: [2,4,6]
Explanation: The following are valid splits: (12), (2 + 10), (2 + 4 + 6), and (4 + 8).
(2 + 4 + 6) has the maximum number of integers, which is 3. Thus, we return [2,4,6].
Note that [2,6,4], [6,2,4], etc. are also accepted.

Example 2:

Input: finalSum = 7
Output: []
Explanation: There are no valid splits for the given finalSum.
Thus, we return an empty array.

Example 3:

Input: finalSum = 28
Output: [6,8,2,12]
Explanation: The following are valid splits: (2 + 26), (6 + 8 + 2 + 12), and (4 + 24). 
(6 + 8 + 2 + 12) has the maximum number of integers, which is 4. Thus, we return [6,8,2,12].
Note that [10,2,4,12], [6,2,4,16], etc. are also accepted.

*/

class Solution {

    List<List<Long>> result = new ArrayList<>();

    public List<Long> maximumEvenSplit(long finalSum) {
        if (finalSum % 2 != 0) return new ArrayList<Long>();

        helperBT(2, finalSum, new ArrayList<Long>());

        System.out.println("size:" + result.size());
        return result.get(0);

        /*

        Why the First Valid Combination is Correct:

        Distinct Even Numbers: 
            Since the backtracking starts with the smallest even number (2), 
                the first combination it finds will always consist of the smallest 
                even numbers that can sum up to finalSum. 
            This is because the backtracking process starts with 2 and incrementally 
                adds even numbers (4, 6, 8, ...), ensuring that the first valid combination 
                consists of the smallest possible distinct even numbers.

        Early Exit: 
            Once the algorithm finds the first valid combination, 
                it stops exploring further combinations due to the 
                if(res.size() > 0) return; condition. 
                This ensures that the first valid combination is returned, 
                and no further unnecessary combinations are generated.
        */
        
    }

    public void helperBT(long start, long finalSum, List<Long> curr){
        if (finalSum == 0) { result.add(new ArrayList<>(curr)); return; }
       
        for(long i = start; i <= finalSum; i+=2 ){
            curr.add(i);
            helperBT(start + 2, finalSum - i, curr);
            if (result.size() > 0) return;
            curr.remove(curr.size() - 1);
        }
        
    }
}