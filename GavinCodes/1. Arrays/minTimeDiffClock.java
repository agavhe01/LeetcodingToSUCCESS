/*

539. Minimum Time Difference
Solved
Medium
Topics
Companies
Given a list of 24-hour clock time points in "HH:MM" format, return the minimum minutes difference between any two time-points in the list.

 

Example 1:

Input: timePoints = ["23:59","00:00"]
Output: 1

Example 2:

Input: timePoints = ["00:00","23:59","00:00"]
Output: 0

 

Constraints:

    2 <= timePoints.length <= 2 * 104
    timePoints[i] is in the format "HH:MM".


*/

class Solution {
    public int findMinDifference(List<String> timePoints) {

        int[] mins = new int[timePoints.size()];

        for(int i = 0; i < timePoints.size(); i++){

            String t = timePoints.get(i);
            Integer hr = Integer.valueOf(t.substring(0, 2));
            Integer min = Integer.valueOf(t.substring(3));

            mins[i] = (60 * hr) + min;
        }

        Arrays.sort(mins);
        int result = Integer.MAX_VALUE;

        for(int i = 0; i < mins.length - 1; i ++){
            result = Math.min(result, mins[i + 1] - mins[i]);
        }

        return Math.min(result, 60 * 24 - mins[mins.length - 1] + mins[0]);
        
    }
}