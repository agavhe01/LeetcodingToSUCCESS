

/*

Leetcode 1762: Buildings with an ocean view

Medium

There are n buildings in a line. You are given an integer array heights of size n that represents the heights of the buildings in the line.

The ocean is to the right of the buildings. A building has an ocean view if the building can see the ocean without obstructions. Formally, a building has an ocean view if all the buildings to its right have a smaller height.

Return a list of indices (0-indexed) of buildings that have an ocean view, sorted in increasing order.

*/

public int[] findBuildings(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
		// Assume that the first building can see the ocean
        stack.push(0);
		// Walk through list of buildings
        for(int i = 1; i<heights.length;i++){
			// If the height of the current building is taller than whats in the stack
			// it needs to be the first building in the stack
            while(!stack.isEmpty() && heights[i] >= heights[stack.peek()]){
                stack.pop();
            }
				// We know that we have the next tallest building in the input array
                stack.push(i);
        }
		
		//Our stack now contains only the buildings that have a view of the ocean and we need to return it in the appropriate form
        int[] result = new int[stack.size()];
        int n = stack.size();
        for(int i = n-1; i>=0; i--){
            result[i] = stack.pop();
        }
        return result;
    }