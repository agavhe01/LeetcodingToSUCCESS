/*

42. Trapping Rain Water
Hard

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

*/


class Solution {
    public int trap(int[] heights) {
    
        int left = 0, right = heights.length - 1; 
        int res = 0;
        if(left >= right)
            return res;
        int leftheight = heights[left];
        int rightheight = heights[right];
        while(left < right) {
            if(leftheight < rightheight) {
                left ++;
                    res += (leftheight - heights[left]);
                } else {
                    leftheight = heights[left];
                }
            } else {
                right --;
                if(rightheight > heights[right]) {
                    res += (rightheight - heights[right]);
                } else {
                    rightheight = heights[right];
                }
            }
        }
        return res;
    }


/*

DIFFERENT APPROACH 
    Precompute Maximum Heights: The code initializes an array maxHeights with a length of heights.length + 1. This array will store the maximum height encountered up to each position in the heights array. The first element, maxHeights[0], is set to 0 because there is no height before the first position.

    A for loop iterates through the heights array from left to right. For each position i, it calculates maxHeights[i + 1] by taking the maximum of the previous maxHeights[i] and the current heights[i]. This step ensures that maxHeights[i + 1] stores the maximum height encountered up to position i.
    Calculate Trapped Water: The code initializes two variables: max and area. max represents the maximum height encountered as the algorithm traverses the heights array from right to left, and area keeps track of the trapped rainwater.

    A for loop iterates through the heights array in reverse order (from right to left). For each position i, it calculates the trapped water in the following way:

    It calculates Math.min(max, maxHeights[i]) - heights[i]. This represents the difference between the minimum of the maximum height seen so far (max) and the maximum height encountered before position i (maxHeights[i]) and the current height at position i. If this difference is greater than 0, it means there is trapped rainwater at this position, so it is added to the area.

    The max variable is updated with the maximum of its current value and the height at position i. This step ensures that max always holds the maximum height seen as the algorithm progresses from right to left.

    Return the Result: Finally, the function returns the area, which represents the total amount of trapped rainwater in the landscape.


public class Solution {
    public int trapRainWater(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }
        
        int[] maxHeights = new int[heights.length + 1];
        maxHeights[0] = 0;
        for (int i = 0; i < heights.length; i++) {
            maxHeights[i + 1] = Math.max(maxHeights[i], heights[i]);
        }
        
        int max = 0, area = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            area += Math.min(max, maxHeights[i]) > heights[i]
                    ? Math.min(max, maxHeights[i]) - heights[i]
                    : 0;
            max = Math.max(max, heights[i]);
        }
        
        return area;
    }
}





*/