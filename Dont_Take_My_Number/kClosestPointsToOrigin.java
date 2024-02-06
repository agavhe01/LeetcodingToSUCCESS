/*


Leetcode: 973. K Closest Points to Origin

Medium

Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {

        int[] origin = {0, 0};

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(int[] p1, int[] p2){
                return p1[1] - p2[1];
            }
        });

        for(int i = 0; i < points.length; i++){
            Integer distance = eucDistance(points[i], origin);
            int[] point_and_distance = {i, distance };
            pq.add(point_and_distance);
        }

        int[][] result = new int[k][2];
        
        for(int i = 0; i < k; i++){
            int[] pd = pq.poll();
            Integer index = pd[0];
            result[i] = points[index];
        }
        return result;
        
    }

    public int eucDistance(int[] p1, int[] p2){
        Integer xDiff = p1[0] - p2[0];
        Integer yDiff =  p1[1] - p2[1];
        return (xDiff * xDiff) + (yDiff * yDiff);

    }
}