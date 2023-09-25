/*

57. Insert Interval

Medium

Companies
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].



*/
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        int i = 0;
        int len = intervals.size();


/*
This loop iterates through the intervals in intervals until it finds an interval whose end is less than the start of newInterval. This means that the current interval does not overlap with newInterval, so it is added to the res list as is. This loop handles intervals to the left of newInterval that do not overlap with it.

*/
        while (i < len && intervals.get(i).end < newInterval.start) { 
            res.add(intervals.get(i));
            i++;
        }


/*
This loop iterates through the intervals in intervals while there is an overlap with newInterval
*/
        while (i < len && intervals.get(i).start <= newInterval.end) { 
            /*
It updates the start of newInterval to be the minimum of newInterval.start and the current interval's start.
It updates the end of newInterval to be the maximum of newInterval.end and the current interval's end.
This effectively merges overlapping intervals into newInterval.
            */
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start); 
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end); 
            i++;
        }
        res.add(newInterval);

/*
This loop adds any remaining intervals in intervals to the res list that are to the right of newInterval and do not overlap with it.

*/
        while (i < len) {                 
            res.add(intervals.get(i));
            i++;
        }
        return res;
    }
}