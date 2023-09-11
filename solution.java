// you can also use imports, for example:
// import java.util.*;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public static int solution(int[] A) {

        int longSpike = 0;
        int i = 0;
        Arrays.sort(A);

        int [] newA = removeDuplicates(A);

    

        while (i < newA.length){
            int j = i + 1;
            while (j < newA.length && newA[j] > newA[j - 1]){
                j++;
            }

            int k = j;

            while(k < newA.length && newA[k] < newA[k - 1]){
                k++;
            }

            int spikeL = k - i;
            if(spikeL > longSpike){
                longSpike = spikeL;
            }
            i = k;

        
        }

        if (newA.length != A.length){
            return longSpike + 1;
        }
        return longSpike;

    }

    public static int[] removeDuplicates(int[]arr){
        Set<Integer> set = new LinkedHashSet<>();

        for (int num : arr){
            set.add(num);
        }
        int[] result = new int[set.size()];

        int i = 0;

        for(int num : set){
            result[i++] = num;
        }
        return result;
    }

     public static void main(String[] args){

		System.out.println("Hello, World!");
        int[] intArray = new int[]{ 1,2,3,4,5,6,7,8,9,10,9,8, 7, }; 
        int[] intArray2 = new int[]{ 1,2,3,2,1 }; 
       
        System.out.println(solution(intArray2));
	
	}
}
