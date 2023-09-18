/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }





Type: 1 and Time: 0
Type: 1 and Time: 5
Type: 0 and Time: 10
Type: 1 and Time: 15
Type: 0 and Time: 20
Type: 0 and Time: 30
Type: 0 and Time: 55
Type: 1 and Time: 55


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

    public int minMeetingRooms(Interval[] intervals) {
        List<Point> points = new ArrayList<>(intervals.length * 2);
        for (Interval i: intervals) {
            points.add(new Point(i.start, 1));
            points.add(new Point(i.end, 0));
        }
        Comparator<Point> cmp = new Comparator<Point>() {
            @Override
            public int compare (Point a, Point b /* ascending order right now, switch params for descending */) {
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