/*

733. Flood Fill
Solved
Easy
Topics
Companies
Hint

You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:

    Begin with the starting pixel and change its color to color.
    Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
    Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
    The process stops when there are no more adjacent pixels of the original color to update.

Return the modified image after performing the flood fill.

 

Example 1:

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2

Output: [[2,2,2],[2,2,0],[2,0,1]]

*/

class Solution {

    // int[][] dirs = { {0, 1} , {1, 0} , {0 , -1} , {-1, 0}, {1, 1} , {-1, -1} , {-1, 0}, {1, -1}, {-1, 1} };
    // int[][] dirs = { {0,1} , {1,0} , {0, -1} , {-1,0} , {1,1} , {-1,-1} , {1,-1}, {-1,1} };

    int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        if (image[sr][sc] == color) return image;
        dfsHelper(image, sr, sc, color, image[sr][sc]);
        return image;

    }

    public void dfsHelper(int[][] image, int i, int j, int newColor, int origColor){

        if (i < 0 || j < 0 || i >= image.length || j >= image[0].length ) return;
        if (image[i][j] != origColor) return;


        if (image[i][j] == origColor) image[i][j] = newColor;
        
        for(int[] dir : dirs){
            int x = i + dir[0];
            int y = j + dir[1];
            dfsHelper(image, x, y, newColor, origColor);
        }
    }
}

/*

BFS SOLUTION

class Solution {
    int[][] dirs = { {0, 1}, {1, 0}, {0, -1}, {-1, 0} };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;

        int origColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {sr, sc});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int i = current[0], j = current[1];

            if (i < 0 || j < 0 || i >= image.length || j >= image[0].length || image[i][j] != origColor) {
                continue;
            }

            image[i][j] = color;

            for (int[] dir : dirs) {
                queue.offer(new int[] {i + dir[0], j + dir[1]});
            }
        }

        return image;
    }
}

*/



