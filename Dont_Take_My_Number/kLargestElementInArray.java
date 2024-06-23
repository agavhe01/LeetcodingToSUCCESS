/*

215. Kth Largest Element in an Array
Medium
16.2K
792
Companies
Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?

Example 1:

Input: nums = [3,2,1,5,6,4], k = 2
Output: 5
Example 2:

Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

*/

import java.util.*;


class kLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {
        //create a min heap
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

        //iterate over the array
        for (int n : nums) {
            //first add the integer to heap
            heap.add(n);
            //if size of the heap is greater than k
            if (heap.size() > k) {
                //remove the root element (lowest of all)
                heap.poll();
            }
        }
        //finally heap has k largest elements left with root as the kth largest element
        return heap.peek();
    }

    public static void printArray(int[] arr){ for(int n: arr) System.out.print(n + "  "); }

    public static void main(String[] args){
        kLargestElementInArray kL = new kLargestElementInArray();

        int[] arr1 = {3,2,1,5,6,4};
        int[] arr2 = {3,2,3,1,2,4,5,5,6};

        int res1 = kL.findKthLargest(arr1, 2);
        int res2= kL.findKthLargest(arr2, 4);

        System.out.println(res1);
        System.out.println("\n");
        System.out.println(res2);

    }
}
