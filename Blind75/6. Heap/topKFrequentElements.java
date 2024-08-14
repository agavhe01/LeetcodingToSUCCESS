/*

347. Top K Frequent Elements

Medium

Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]

*/

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.HashMap;

// T(C): O(n)
// S(C): O(n)

class topKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {

        int[] arr = new int[k];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        Comparator<Map.Entry<Integer, Integer>> customComparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> s1, Map.Entry<Integer, Integer> s2) {
                return s2.getValue() - s1.getValue();
            }
        };

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(customComparator);
        
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            pq.add(it);
        }

        int i = 0;
        while ( !pq.isEmpty() && i < k ) {
            Map.Entry<Integer, Integer> entry = pq.poll(); 
            // System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            arr[i] = entry.getKey();  
            i++;                                  
        }                  
        
        return arr;
    }

    public static void printArray(int[] arr){ for(int n : arr) System.out.print(n + "  "); }

    public static void main(String[] args){
        topKFrequentElements topK = new topKFrequentElements();

        int[] arr1 = {1,1,1,2,2,3};
        //int[] arr2 = {1};

        int[] res1 = topK.topKFrequent(arr1, 2);
        //int[] res2 = topK.topKFrequent(arr2, 1);

        topK.printArray(res1);

        System.out.println();

        int[] res2 = topK.topKFrequent(arr1, 1);
        topK.printArray(res2);
        System.out.println();

        int[] res3 = topK.topKFrequent(arr1, 3);
        topK.printArray(res3);
        System.out.println();

        
        System.out.println("Program Done");
    }
        
    }
