import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class team {

    /*
     * Complete the 'getMaxSubarrayLen' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY team_a
     *  2. INTEGER_ARRAY team_b
     */
     
     
    public static int helper(List<Integer> a, List<Integer> b){
        
        int temp1 = Integer.MIN_VALUE;
        int temp2 = Integer.MIN_VALUE;
        
        for(int i = 0; i < a.size(); i++){
            if (a.get(i) >= temp1){
                temp1 = a.get(i);
            }
            else{
                return -1;
            }
        }
        
        for(int i = 0; i < b.size(); i++){
            if (b.get(i) >= temp2){
                temp2 = b.get(i);
            }
            else{
                return -1;
            }
        }
        
        return 1;
    }
    
    public static boolean isNonDecreasing(List<Integer> a, List<Integer> b) {
                // Create a list to store the non-decreasing array.
                List<Integer> c = new ArrayList<>();

                // Iterate over the two lists.
                int i = 0;
                int j = 0;
                while (i < a.size() && j < b.size()) {
                    // If the current element in a is less than or equal to the current element in b,
                    // add the current element in a to the non-decreasing array.
                    if (a.get(i) <= b.get(j)) {
                    c.add(a.get(i));
                    i++;
                    }
                    // Otherwise, add the current element in b to the non-decreasing array.
                    else {
                    c.add(b.get(j));
                    j++;
                    }

                    // If the current element in the non-decreasing array is greater than the previous element,
                    // return false.
                    if (i > 0 && c.size() > 0 && i < c.size() && c.get(i) < c.get(i - 1)) {
                    return false;
                    }
                }

                // If we reach the end of both lists, return true.
                return i == a.size() && j == b.size();
}

    public static int getMaxSubarrayLen(List<Integer> team_a, List<Integer> team_b) {
        
    // Write your code here
    
    int result = Integer.MIN_VALUE;
    
    int current = 0;
    
    int n = team_a.size();
    
     for (int start = 0; start < n; start++) {
            // Inner loop for the end index
            for (int end = start + 1; end <= n; end++) {
                // Extract the substring from start to end
                List<Integer> subA = team_a.subList(start, end);
                List<Integer> subB = team_b.subList(start, end);
                
                //if (helper(subA, subB) == 1){
                if (isNonDecreasing(subA, subB)){
                    
                    current = end - start;
                    System.out.println("Current:" + current);
                    if (current == 3){System.out.println(start + " " + end);} 
                    result = Math.max(current, result);
                }
                
                
            }
        }
    
    return result;
    }

    public static void main(String[] args) {
        
        // int[] a1 = {5,2,4,1};
        // int[] b1 = {3,6,2,2};
        // int res1 = getMaxSubarrayLen(a1, b1);
        // assert (res1 == ): "Expected 2, actual: " + res1;



        // int[] a2 = {45,81,29,2,25,84,32,28,37,39};
        // int[] b2 = {72,47,97,75,82,17,2,56,57,18};
        // int res2 = getMaxSubarrayLen(Arrays.asList(45,81,29,2,25,84,32,28,37,39), Arrays.asList(72,47,97,75,82,17,2,56,57,18));
        // assert (res2 == 10): "Expected 10, actual: " + res2;

        // int[] a3 = {4,3,2,5,3};
        // int[] b3 = {4,10,2,8,4};
        // int res3 = getMaxSubarrayLen(a3, b3);
        // assert (res3 == 3): "Expected 2, actual: " + res3; // not 3

        int[] a4 = {2,9,7};
        int[] b4 = {2,10,8};
        int res4 = getMaxSubarrayLen(Arrays.asList(2,9,7), Arrays.asList(2,10,8));
        assert (res4 == 2): "Expected 2, actual: " + res4; 

        // int[] a5 = {2,7,3};
        // int[] b5 = {4,2,6};
        int res5 = getMaxSubarrayLen(Arrays.asList(2,7,3), Arrays.asList(4,2,6));
        assert (res5 == 2): "Expected 2, actual: " + res5; 

        // int[] a6 = {9,7};
        // int[] b6 = {10,8};
        // int res6 = getMaxSubarrayLen(a6, b6);
        // assert (res6 == 1): "Expected 1, actual: " + res6; 



        

        // int minMoves1 = minMoves(n, startRow, startCol, endRow, endCol);
        // assert(minMoves1 == 2): "Expected 2, actual: " + minMoves1;

        // int minMoves2 = minMoves(10, 0, 0, 0, 2);
        // assert(minMoves2 == 2): "Expected 2, actual: " + minMoves2;

        // int minMoves3 = minMoves(7,6,6,0,1);
        // assert(minMoves3 == 5): "Expected 5, actual: " + minMoves3;

        // int minMoves4 = minMoves(6, 5, 1, 0, 5);
        // assert(minMoves4 == 3): "Expected 3, actual: " + minMoves4;

        // int minMoves5 = minMoves(8,0,0,1,1);
        // assert(minMoves5 == 4): "Expected 4, actual: " + minMoves5;

        // int minMoves6 = minMoves(10, 9,9,5,3);
        // assert(minMoves6 == 4): "Expected 4, actual: " + minMoves6;

        // int minMoves7= minMoves(30, 25, 2, 23, 29);
        // assert(minMoves7 == 15): "Expected 15, actual: " + minMoves7;

        // int minMoves8 = minMoves(10, 9, 9, 5, 3);
        // assert(minMoves8 == 4): "Expected 4, actual: " + minMoves8;

        




    }

}
