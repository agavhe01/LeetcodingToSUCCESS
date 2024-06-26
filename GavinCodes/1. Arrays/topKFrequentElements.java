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

import java.util.*;


class topKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {

        int[] arr = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        
        Comparator<Map.Entry<Integer, Integer>> customComparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> s1, Map.Entry<Integer, Integer> s2) {
                return s1.getValue() - s2.getValue();
            }
        };

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(customComparator);

        
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            pq.add(it);
            // if (pq.size() > k) pq.poll();
        }

        int i = k;
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.peek();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
            // arr[--i] = pq.poll().getKey();
            pq.poll().getKey();
        }

        /*
        while (!pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.poll(); 
            i = i - 1;                                    
            arr[i] = entry.getKey();    
        }                  
        */
        return arr;
    }

    public static void printArray(int[] arr){ for(int n: arr) System.out.print(n + "  "); }

    public static void main(String[] args){
        topKFrequentElements topK = new topKFrequentElements();

        int[] arr1 = {1,1,1,2,2,3};
        //int[] arr2 = {1};

        int[] res1 = topK.topKFrequent(arr1, 2);
        //int[] res2 = topK.topKFrequent(arr2, 1);

        topK.printArray(res1);

        System.out.println();

        //topK.printArray(res1);

        
         System.out.println("Program Done");
    }
        
    }
