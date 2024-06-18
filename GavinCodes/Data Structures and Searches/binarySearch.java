// import java.util.*;
import java.util.Arrays;

//   Time complexity : O(log n)    log base 2 of n
//  Space complexity : O(1)        no additional space just pointers

public class binarySearch{

    public static void main(String[] args ){

        binarySearch bs = new binarySearch();

        int[] arr = {1, 4, 8, 16, 32, 64, 128};

        System.out.println( "looking for 199:  " + bs.bSearch(arr, 199));
        System.out.println( "looking for  32:   " + bs.bSearch(arr, 32));
        System.out.println( "looking for 128:   " + bs.bSearch(arr, 128));
        System.out.println( "looking for   1:   " + bs.bSearch(arr, 1));

    }

    public int bSearch(int[] arr, int target){

        int l = 0;
        int r = arr.length - 1;

        while(l <= r){
            int mid = (l + r) / 2;

            if(target < arr[mid]){
                r = mid - 1;
            }
            else if (target > arr[mid]){
                l = mid + 1;
            }
            else return mid;
        }
        return -1;
    }
}

