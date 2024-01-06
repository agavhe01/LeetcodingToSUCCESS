

 /*
56. Merge Intervals

Medium

Companies
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.


 */

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return new ArrayList<Interval>();
        }
        intervals.sort(new Comparator<Interval>() {
            public int compare(Interval interval1, Interval interval2) {
                return interval1.start - interval2.start;
            }
        });
        List<Interval> merged = new ArrayList<Interval>();
        for (int i = 0; i < intervals.size(); ++i) {
            int L = intervals.get(i).start, R = intervals.get(i).end;
            /*
            The if condition checks two things:

1) Whether the merged list is empty (i.e., there are no merged intervals yet).
2) Whether the end of the last merged interval (merged.get(merged.size() - 1).end) 
    is less than the start of the current interval (L).
* If both conditions are met, it means there is no overlap between the last merged
    interval and the current interval. In this case, a new Interval(L, R) is created and added to the merged list, effectively starting a new merged interval.
            */
            if (merged.size() == 0 || merged.get(merged.size() - 1).end < L) {
                merged.add(new Interval(L, R));
            } else {
                /*
It updates the end value of the last merged interval to be the maximum of its 
    current end value and the end value of the current interval (R). This extends the last merged interval to cover the current interval.
                */
                merged.get(merged.size() - 1).end = Math.max(merged.get(merged.size() - 1).end, R);
            }
        }
        return merged;
    }
}