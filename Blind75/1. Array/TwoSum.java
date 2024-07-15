/*

Given an array of integer nums and an integer target, return
indices of the two numbers such that they add up to the target.
You may assume that each input would have exactly one solution,
and you may not use the same element twice.
You can return the answer in any order.
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

*/

import java.util.*;

public class TwoSum{

    static Map<Integer, Integer> mp;

    public TwoSum(){
       
    }

    /*
    
        TC : O(n)
        SC : O(n)

    */
    public static int[] twoSum(int[] arr, int target){
        mp = new HashMap<>();
        int n = arr.length;

        for(int i = 0; i < n; i++){
            int num = arr[i];
            int diff = target - num;
            if (mp.containsKey(diff)) return new int[]{ mp.get(diff), i };
            mp.put(num, i);
        }

        return arr; // not necessary because result guaranteed
    }

     

    public static void main(String[] args){
        TwoSum ts = new TwoSum();

        int[] test1 = new int[]{2,7,11,15};

        int[] res1 = ts.twoSum(test1, 9);

        ts.printArray(res1); // [0, 1]

        int[] res2 = ts.twoSum(test1, 22); 

        ts.printArray(res2); // [1, 3]

     }

     public void printArray(int[] path){
        // System.out.println("Printing Array");

        for(int tn : path){
            System.out.print(tn + "  ");
        }
        System.out.println();
    }
}