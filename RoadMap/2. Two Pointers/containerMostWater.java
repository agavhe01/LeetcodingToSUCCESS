/*

LEETCODE: 11. Container With Most Water
Medium

Companies
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.


*/


class Solution {

    public int calcArea(int x1, int y1, int x2, int y2){
        int maxY = Math.min(y1, y2);
        int lengthX = x2 - x1;
        return maxY * lengthX;
    }

    public int maxArea(int[] height) {

        int maxArea = Integer.MIN_VALUE;

        int currentArea = 0;

        int i = 0;
        int j = height.length - 1;


        /*

Finding the Shorter Side: To calculate the area of the container, you need to consider the height of the shorter side because the height of the taller side doesn't affect the area (it's limited by the shorter side).

Moving the Pointer: By comparing the heights at the left and right pointers, you can determine which side is shorter. You move the pointer pointing to the shorter side inward because, for any further movement of the other pointer, the width of the container will decrease (it becomes narrower), and the only way to potentially increase the area is by finding a taller side.



        */
        while (i <= j){
            currentArea = calcArea(i, height[i], j, height[j]);
            maxArea = Math.max(maxArea, currentArea);
            if(height[i] <= height[j]){
                i++;
            }
            else{ j--; }

        }

        /*
            This naive approach works for 98% of test cases
            more optimim approach above. considers every possible case whereas
            the above method is self-optimizing only considering possibilities with 
            larger area than the current. 

        */
        // for(int i = 0; i < height.length - 1; i++){
        //     int j = i + 1;
        //     while (j < height.length){
        //         currentArea = calcArea(i, height[i], j, height[j]);
        //         maxArea = Math.max(maxArea, currentArea);
        //         j++;
        //     }
        // }


    return maxArea;  
    }
}