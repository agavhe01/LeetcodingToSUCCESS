/*

766. Toeplitz Matrix

company
Facebook
company
Bloomberg
company
Google
Given an m x n matrix, return true if the matrix is Toeplitz. Otherwise, return false.

A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.

*/

class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        System.out.println(matrix.length);
        for(int row = 0 ; row < matrix.length ; row++){
            if(!checkToeplitz(matrix , row , 0)){
                return false;
            }
        }
        for(int col = 1 ; col < matrix[0].length ; col++){
            if(!checkToeplitz(matrix , 0 , col)){
                return false;
            }
        }
        return true;
    }
    public boolean checkToeplitz(int[][] matrix , int row , int col){
        int x = matrix[row][col];
        while(row < matrix.length && col < matrix[0].length){
            if(matrix[row++][col++] != x){
                return false;
            }
        }
        return true;
    }
}