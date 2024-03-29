/*

11. Container With Most Water
Solved
Medium
Topics
Companies
Hint
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1


*/

class Solution {
    public int maxArea(int[] height) {

        int maxA = Integer.MIN_VALUE;
        int start = 0;
        int end = height.length - 1;

        while (start < end){
            int currA = calcArea(start, height[start], end, height[end]);
            // int currA = Math.min(height[start], height[end]) * (end - start);
            maxA = Math.max(currA, maxA);
            if (height[start] < height[end]) start++;
            else end--;
        }   
        return maxA;     
    }

    public int calcArea(int x1, int y1, int x2, int y2){
       return Math.min(y1, y2) * (x2 - x1);
    }
}