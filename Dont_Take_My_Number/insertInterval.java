/*


LEETCODE: 57. Insert Interval

Medium

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.



*/



public class Interval {
    int start, end;
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<Interval> allInts = new ArrayList<>();

        for(int i = 0; i < intervals.length; i++){
            int[]arr = intervals[i];
            Interval ii = new Interval(arr[0], arr[1]);
            allInts.add(ii);
        }

        Interval newInt = new Interval(newInterval[0], newInterval[1]);
        allInts.add(newInt);

        allInts.sort(new Comparator<Interval> (){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });

        List<Interval> finale = new ArrayList<>();

        for(int i = 0; i < allInts.size(); i++){
            Interval ii = allInts.get(i);

            int currSize = finale.size();

            if (currSize == 0 || finale.get(currSize - 1).end < ii.start){
                finale.add(ii);
            }
            else{
                System.out.println("here");
                 finale.get(currSize - 1).end = Math.max(ii.end, finale.get(currSize - 1).end);
            }
        }

        int[][] finalarr = new int[finale.size()][2];

        for(int j = 0; j < finale.size(); j++){
            Interval jj = finale.get(j);
            int[] arr = {jj.start, jj.end};
            finalarr[j] = arr;
        }

        return finalarr;
        
    }
}

/*

SOLUTION REQUIRING O(1) SPACE

 public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        List<int[]> ans = new ArrayList<>();
        int i=0;

        while(i < n && intervals[i][1] < newInterval[0]) {
            ans.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval = new int[]{
                Math.min(newInterval[0], intervals[i][0]),
                Math.max(newInterval[1], intervals[i][1]),
            };
            i++;
        }

        ans.add(newInterval);

        while(i < n) ans.add(intervals[i++]);
        
        return ans.toArray(new int[0][2]);
    }

*/