import java.util.PriorityQueue;
import java.util.Comparator;

public class kthSmallestLargest{

    public PriorityQueue<Integer> pq;

    public kthSmallestLargest(){}

    //  Descending Comparator for kthSmallest
    Comparator<Integer> descIntComp = new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2){ return n2 - n1; }
    };

    //  Ascending Comparator for kthLargest 
    //              --> redundant coz thats the default comparator for type <Integer>
    Comparator<Integer> ascIntComp = new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2){ return n1 - n2; }
    };



    //  TC: O(n)
    //  SC: O(n)
    public int kthSmallest(int[] arr, int k){
        pq = new PriorityQueue<Integer>(descIntComp);

        for(int num : arr){
            if (pq.size() < k) pq.add(num);
            else if (num < pq.peek()){
                pq.poll();
                pq.add(num);
            }
        }
        return pq.peek();
    }

    //  TC: O(n)
    //  SC: O(n)
    public int kthLargest(int[] arr, int k){
        // pq = new PriorityQueue<Integer>(ascIntComp);
        pq = new PriorityQueue<Integer>();

        for(int num : arr){
            if (pq.size() < k) pq.add(num);
            else if (num > pq.peek()){
                pq.poll();
                pq.add(num);
            }
            
        }
        return pq.peek();
    }
    
    // Kth Largest No Data Structures
    // Quick Select
    // Time complexity: O(n) in average, O(n^2) in worst case

    public int kthLargestNoData(int[] nums, int k){
        k = nums.length - k;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int pivot = partition(nums, left, right);
            if (pivot < k)
                left = pivot + 1;
            else if (pivot > k)
                right = pivot - 1;
            else
                break;
        }
        return nums[k];
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right], fill = left;
        for (int i = left; i < right; i++) {
            if (nums[i] <= pivot) {
                int temp = nums[fill];
                nums[fill++] = nums[i];
                nums[i] = temp;
            }
        }
        nums[right] = nums[fill];
        nums[fill] = pivot;
        return fill;
    }

    public int counterHelp(int[] arr, int mid){
        int result = 0;
        for(int n : arr){
            if (n >= mid) result++;
        }
        return result;
    }

    public static void main(String[] args){
        kthSmallestLargest sol = new kthSmallestLargest();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(" 2nd Largest  :  9 -->  " + sol.kthLargest(arr, 2));
        System.out.println(" 2nd Smallest :  2 -->  " + sol.kthSmallest(arr, 2));

        System.out.println(" 4th Largest  :  7 -->  " + sol.kthLargest(arr, 4));
        System.out.println(" 4th Smallest :  4 -->  " + sol.kthSmallest(arr, 4));

        System.out.println(" 1st Largest  : 10 --> "  + sol.kthLargest(arr, 1));
        System.out.println(" 1st Smallest :  1 -->  " + sol.kthSmallest(arr, 1));

        System.out.println("10th Largest  :  1 -->  " + sol.kthLargest(arr, 10));
        System.out.println("10th Smallest : 10 --> "  + sol.kthSmallest(arr, 10));

       



        System.out.println("\nNo data Structures \n");
        System.out.println(" 2nd Largest  :  9 -->  " + sol.kthLargestNoData(arr, 2));
        System.out.println(" 4th Largest  :  7 -->  " + sol.kthLargestNoData(arr, 4));
        System.out.println(" 1st Largest  : 10 --> "  + sol.kthLargestNoData(arr, 1));
        System.out.println("10th Largest  :  1 -->  " + sol.kthLargestNoData(arr, 10) + "\n");

        int[] arr2 = {2,3,1,5,4};
        System.out.println("       Test 2 :  4 -->  " + sol.kthLargestNoData(arr2, 2));
    
        int[] arr3 = {2,3,1,1,5,5,4};
        System.out.println("       Test 3 :  4 -->  " + sol.kthLargestNoData(arr2, 3));

    }

}

/*

class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    private static int quickSelect(int[] nums, int low, int high, int k) {
        int pi = partition(nums, low, high);
        if (pi == k) {
            return nums[pi];
        } else if (k > pi) {
            return quickSelect(nums, pi + 1, high, k);
        } else {
            return quickSelect(nums, low, pi - 1, k);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (pivot > nums[j]) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        return (i + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
} // TC: O(n), SC: O(log n)

class Solution{
    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        return quickSelect(arr, l, r, k - 1); // nums.length - k: largest element
    }
    private static int quickSelect(int[] nums, int low, int high, int k) {
        int pi = partition(nums, low, high);
        if (pi == k) {
            return nums[pi];
        } else if (k > pi) {
            return quickSelect(nums, pi + 1, high, k);
        } else {
            return quickSelect(nums, low, pi - 1, k);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (pivot > nums[j]) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, high);
        return (i + 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

*/