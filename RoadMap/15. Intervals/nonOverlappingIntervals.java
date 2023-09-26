/*
435. Non-overlapping Intervals

Medium

Companies
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.

*/


class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) ->(a[1]-b[1]));

            /*
custom comparator that compares intervals based on their end values (a[1] - b[1]). This means that the intervals with the earliest end times will be at the front of the priority queue (min-heap).
            */
            for(int[] one: intervals){
                pq.add(one);
            }
            int end=Integer.MIN_VALUE, res=0;
            while(!pq.isEmpty()){
                int[] temp = pq.poll();
                if(temp[0]>=end){
                    /*
This condition checks whether the start time of the current interval (temp[0]) is greater than or equal to the end time of the last processed interval (end). If this condition is true, it means that the current interval does not overlap with the previous one.

end is updated to the end time of the current interval (temp[1]), and the current interval is considered as a valid, non-overlapping interval.
                    */
                    end=temp[1];

                } else
                    res++;
            }
            return res;
    }
}