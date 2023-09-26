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

/*
LINTCODE: 920

Description
Given an array of meeting time intervals consisting of start and end times 
[[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.

Input: intervals = [(0,30),(5,10),(15,20)]
Output: false
Explanation: 
(0,30), (5,10) and (0,30),(15,20) will conflict

Input: intervals = [(5,8),(9,15)]
Output: true
Explanation: 
Two times will not conflict 
*/

public class Solution {
    class Point {
        int type; // start: 1, end: 0
        int time;

        Point (int time, int type) {
            this.time = time;
            this.type = type;
        }   
    }
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        int minMeetingRooms = minMeetingRooms(intervals);
        System.out.println(minMeetingRooms);
        return minMeetingRooms == 0 || minMeetingRooms == 1;
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