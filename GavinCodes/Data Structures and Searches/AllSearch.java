import java.util.Arrays;

public class AllSearch{

    /*
        Insertion Sort
            Worst: O (n^2)    --> input is in reverse order
             Best: O  (n)     --> array sorted
        Stable
    */
    public static int[] insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            int j = i - 1;
            while (j >= 0 && arr[j + 1] < arr[j]){
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
                j--;
                // printArray(arr);
            }
        }
        return arr;
    }

    /*
        Merge Sort
        Worst: O (n log n)      --> log base 2
        Best: O (n)
        Stable

    */
    public static int[] mergeSort(int[] arr, int l, int r){

        if (l < r){
            int m = (l + r) / 2;                  
            mergeSort(arr, l, m);          // sort 1st half
            mergeSort(arr, m + 1, r);      // sort 2nd hald
            merge(arr, l, m, r);           // merge sorted arrays
        }
        return arr;

    }

    public static void merge(int[] arr, int l, int m, int r){
        int l1 = m - l + 1;
        int l2 = r - m;                   // r - (m + 1) + 1;

        int[] L = new int[l1];
        int[] R = new int[l2];

        // Copy the sorted left & right halfs to temp arrays
        for(int i = 0; i < l1; i++) L[i] = arr[i + l];
        for(int j = 0; j < l2; j++) R[j] = arr[j + m + 1];

        int i = 0;                      // index for left
        int j = 0;                      // index for right
        int k = l;                      // Initial index of merged subarray array

        // Merge the two sorted halfs into the original array
        while (i < l1 && j < l2){
            if (L[i] <= R[j]){
                arr[k] = L[i];
                i++;
            }
            else{
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // One of the halfs will have elements remaining
        while (i < l1){                 // Copy remaining elements of L[] if any 
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < l2){                 // Copy remaining elements of R[] if any 
            arr[k] = R[j];
            j++;
            k++;
        }

    }

    /*
        Bucket Sort
        Worst: O (n)      --> log base 2    ---> O (2 * N)
        Best: O (n)
        Additional Space    : an array of size range of the values
                            : O (5) in my case which reduces to O(1)

        Unstable

    */
    public static int[] bucketSort(int[] arr){
        int[] counts = {0, 0, 0, 0, 0 };

        for(int n : arr) counts[n] += 1;

        int i = 0;
        for(int j = 0; j < counts.length; j++){
            for(int k = 0; k < counts[j]; k++){
                arr[i] = j;
                i++;
            }
        }
        return arr;
    }


    /*
        QuickSort
        Worst: O (n log n)      --> log base 2
        Best: O ()
        UnStable

    */

    public static int[] quickSort(int[] arr, int s, int e) {
        if (e - s + 1 <= 1) {
            return arr;
        }

        int pivot = arr[e];
        int left = s;       // pointer for left side

        // Partition: elements smaller than pivot on left side
        for (int i = s; i < e; i++) {
            if (arr[i] < pivot) {
                int tmp = arr[left];
                arr[left] = arr[i];
                arr[i] = tmp;
                left++;
            }
        }

        // Move pivot in-between left & right sides
        arr[e] = arr[left];
        arr[left] = pivot;

        // Quick sort left side
        quickSort(arr, s, left - 1);

        // Quick sort right side
        quickSort(arr, left + 1, e);

        return arr;
    }


    /*

        MAIN

    */
    public static void main(String[] args){
        AllSearch as = new AllSearch();

        int[] startArray = {40, 60, 90, 80, 10, 30, 100, 0, 50, 20, 70};
        int[] bucketStartArray = {4, 0, 3, 4, 4, 2, 3, 2, 4, 3, 2, 1, 2, 1, 0, 0, 0, 1, 2, 4, 4, 0, 1, 1, 2};

        // int[] startArray = {40, 6, 90, 0};
        
        System.out.println("\n Insertion Sort");
        int[] insertResult = as.insertionSort(startArray);
        as.printArray(insertResult);

        System.out.println("\n Merge Sort");
        int[] mergeResult = as.mergeSort(startArray, 0, startArray.length - 1);
        as.printArray(mergeResult);

        System.out.println("\n Quick Sort");
        int[] quickResult = as.quickSort(startArray, 0, startArray.length - 1);
        as.printArray(quickResult);

        System.out.println("\n Bucket Sort");
        int[] bucketResult = as.bucketSort(bucketStartArray);
        as.printArray(bucketResult);

        // Bucket Sort Start Array on Other Algorithms
        System.out.println("\n Bucket Sort Start Array on Other Algorithms \n ");
        
        System.out.println("\n Insertion Sort");
        int[] insertResult1 = as.insertionSort(bucketStartArray);
        as.printArray(insertResult1);

        System.out.println("\n Merge Sort");
        int[] mergeResult1 = as.mergeSort(bucketStartArray, 0, bucketStartArray.length - 1);
        as.printArray(mergeResult1);

        System.out.println("\n Quick Sort");
        int[] quickResult1 = as.quickSort(bucketStartArray, 0, bucketStartArray.length - 1);
        as.printArray(quickResult1);


    }

    public static void printArray(int[] arr){
        for(int n: arr) System.out.print(n + "  ");
        System.out.println();
    }
}