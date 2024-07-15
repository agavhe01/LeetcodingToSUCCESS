import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum{

    public static List<List<Integer>> result;

    public ThreeSum(){}

     /*
        PREFERRED TWO POINTER Method
        TC : O(n log n) + O(n ^ 2)
        SC : O(1)

        could use Set<Integer> ass curr and not need to check for duplicates

    */

    public List<List<Integer>> threeSum(int[] nums){

        result = new ArrayList<List<Integer>>();
        
        Arrays.sort(nums);
        int n = nums.length;
        int target = 0;
        
        for(int i = 0; i < n; i++){
            // Skip through duplicates on the i pointer
            if (i == 0 || nums[i] != nums[i - 1]){
                int left = i + 1;
                int right = n - 1;

                while (left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == target){
                        
                        List<Integer> curr = new ArrayList<Integer>();
                        curr.add(nums[i]);
                        curr.add(nums[left]);
                        curr.add(nums[right]);
                        result.add(curr);

                        // Skip Through Duplicates on the left and right pointers
                        while (left < n - 1 && nums[left] == nums[left + 1]) { /* System.out.println("here"); */ left++; } 
                        while (right > 0 && nums[right] == nums[right - 1]) { /* System.out.println("there"); */ right--; } 

                        left++;
                        right--;
                    }
                    else if (sum < target) left++;
                    else right--;
                }

            } // endif
            
        }
        return result;
    }

    
    public static void main(String[] args){
        ThreeSum sol = new ThreeSum();

        System.out.println("Solution 1:  [ [-1,-1,2] , [-1,0,1] ] ");
        int[] t1 = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> r1 = sol.threeSum(t1);
        sol.printArray(r1);

        System.out.println("Solution 2:  [ [-50  0  50 ] , [-10  0  10 ] , [-10  5  5 ] , [-5  -5  10  ] , [0  0  0 ] ] ");

        int[] t2 = new int[]{5, -5, 0, 5, -5, 0, 5, -5, 0, -10, 0, 10, 50, 50, 50, -50};
        List<List<Integer>> r2 = sol.threeSum(t2);
        sol.printArray(r2);
    }

    public void printArray(List<List<Integer>> arr){
         System.out.println();
        
        for(List<Integer> a: arr){
            System.out.print("[");
            for(Integer n : a) System.out.print(" " + n + " "); 
            System.out.print("]");
            System.out.println();
        }

    }

}