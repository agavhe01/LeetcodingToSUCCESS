import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class subsets{

    public List<List<Integer>> result;

    public subsets(){}

    /*

        Subsets with duplicates (subsets) allowed

        Time : O(n * 2^n)
        Space: O(n)

    */
    public List<List<Integer>> subsetsCallerDuplicates(int[] nums){
        result = new ArrayList<>();
        findSubsetsDuplicates(nums, 0, new ArrayList<>(), result);
        return result;
    }


    public void findSubsetsDuplicates(
        int[] nums,
        int i,
        List<Integer> curr,
        List<List<Integer>> subsets
    )
    {
        if (i >= nums.length){
            subsets.add(new ArrayList<Integer>(curr));
            return;
        }

        // decision to include i
        curr.add(nums[i]);
        findSubsetsDuplicates(nums, i + 1, curr, subsets);

        // decision not to include i
        curr.remove(curr.size() - 1);
        findSubsetsDuplicates(nums, i + 1, curr, subsets);

    }

    /*
        
        Subsets without duplicates (subsets) allowed

            Time : O(n * 2^n)
            Space: O(n)

    */
    public List<List<Integer>> subsetsCallerNoDuplicates(int[] nums){
        result = new ArrayList<>();

        Arrays.sort(nums); // sorting necessary to avoid duplicates efficiently

        findSubsetsNoDuplicates(nums, 0, new ArrayList<>(), result);
        return result;
    }

    public void findSubsetsNoDuplicates(
        int[] nums,
        int i,
        List<Integer> curr,
        List<List<Integer>> subsets
    ){
        if (i >= nums.length){
            subsets.add(new ArrayList<Integer>(curr));
            return;
        }

        // decision to include nums[i]
        curr.add(nums[i]);
        findSubsetsNoDuplicates(nums, i + 1, curr, subsets);
        curr.remove(curr.size() - 1);


        // decision NOT to include nums[i]
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;  // skip thru duplicates

        findSubsetsNoDuplicates(nums, i + 1, curr, subsets);

    }


    public static void main(String[] args){

        subsets sol = new subsets();

        int[] arr1 = {1, 2, 2, 3};
        int[] arr2 = {1,2,2,3,4,5,5};

        List<List<Integer>> res1 = sol.subsetsCallerDuplicates(arr1);
        List<List<Integer>> res2 = sol.subsetsCallerDuplicates(arr2);
        List<List<Integer>> res3 = sol.subsetsCallerNoDuplicates(arr1);
        List<List<Integer>> res4 = sol.subsetsCallerNoDuplicates(arr2);

        sol.printArrays(res1);
        sol.printArrays(res3);
        sol.printArrays(res2); 
        sol.printArrays(res4); 
    }

    public void printArrays(List<List<Integer>> arr){
        System.out.println("Arr Size: " + arr.size());
        for(List<Integer> a : arr){
            for (Integer n : a){
                System.out.print(n + "  ");
            }
            System.out.println();
        }
    }
}