/*
LINTCODE: 919

Description

Given an array of meeting time intervals consisting of start and end times 
[[s1,e1],[s2,e2],...] (si < ei), find the minimum number of 
conference rooms required.)

*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    class Point {
        int type; // start: 1, end: 0
        int time;

        Point (int time, int type) {
            this.time = time;
            this.type = type;
        }   
    }

    public int minMeetingRooms(List<Interval> intervals) {
        List<Point> points = new ArrayList<>(intervals.size() * 2 + 2);

      
        for (Interval i: intervals) {
            points.add(new Point(i.start, 1));
            points.add(new Point(i.end, 0));
        }
        Comparator<Point> cmp = new Comparator<Point>() {
            @Override
            public int compare (Point a, Point b) {
                if (a.time == b.time) {
                    return a.type - b.type;
                } else {
                    return a.time - b.time;
                }
            }
        };
        Collections.sort(points, cmp);
       

        int maxOverlap = 0;
        int ongoing = 0;
        for (Point p: points) {
            System.out.println("Type: " + p.type + " and Time: " + p.time);
            if (p.type == 1)  {
                ongoing++;
            } else if (p.type == 0) {
                ongoing--;
            }
            maxOverlap = Math.max(maxOverlap, ongoing);
        }

        return maxOverlap;
    }
}