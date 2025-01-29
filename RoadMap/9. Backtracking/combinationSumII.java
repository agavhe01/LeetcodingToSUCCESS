class Solution {
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, target, 0);
        //helper(nums, 0, new ArrayList<>(), target, list);
        //List<List<Integer>> noDups = removeDuplicates(list);
        return list;
        
    }

     public static List<List<Integer>> removeDuplicates(List<List<Integer>> list) {
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> uniqueList = new ArrayList<>();

        for (List<Integer> sublist : list) {
            if (set.add(sublist)) {
                // If the set returns true (i.e., it's a unique sublist), add it to the uniqueList.
                uniqueList.add(sublist);
            }
        }

        return uniqueList;
    }

    private void helper(int[] candidates,
                        int startIndex,
                        List<Integer> combination,
                        int target,
                        List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(combination));
            return;
        }

        /*
Recursive steps:
The function proceeds with a loop that starts from the startIndex and iterates through the elements in the candidates array.
For each element candidates[i] at index i, it performs the following checks:
It skips the current element if i is not equal to startIndex and the current element is the same as the previous element (candidates[i] == candidates[i - 1]). This check helps avoid duplicate combinations.
It breaks out of the loop if the current element is greater than the remaining target since adding it would make the sum exceed the target.
Otherwise, it adds candidates[i] to the combination, marks startIndex as i + 1 to avoid using the same element in the same combination again, and then makes a recursive call to itself.
After the recursive call, it removes the last added element (candidates[i]) from the combination (backtracking) to explore other combinations.

        */

        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target < candidates[i]) {
                break;
            }
            combination.add(candidates[i]);
            helper(candidates, i + 1, combination, target - candidates[i], results);
            combination.remove(combination.size() - 1);
        }
    }


    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) list.add(new ArrayList<>(tempList));

        /*
   taken from my combination sum 1

   only change is the if statement below to make sure we do not include any duplicates

   also changed the call to backtrack to be i + i, since we do not consider duplicates in this case

        */
        else{ 
            for(int i = start; i < nums.length; i++){
                if (i != start && nums[i] == nums[i - 1]) {
                    // duplicate check
                    continue;
                }
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, remain - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}


/*

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        helper(0, candidates, target, new ArrayList<>());
        return result;
        
    }

    public void helper(int index, int[] nums, int target, List<Integer> curr){
        if (target == 0) { result.add(new ArrayList<>(curr)); return;}

        if (target < 0 || index >= nums.length) return;

        /*
        for(int i = index; i < nums.length; i++){

            if (i > index && nums[i] == nums[i - 1]) continue;
            curr.add(nums[i]);
            helper(i + 1, nums, target - nums[i], curr);
            curr.remove(curr.size() - 1);
        }
        */

        
        curr.add(nums[index]);
        helper(index + 1, nums, target - nums[index], curr);
        curr.remove(curr.size() - 1);

        int nextIndex = index + 1;
        while (nextIndex < nums.length && nums[nextIndex] == nums[index]) nextIndex++;
        helper(nextIndex, nums, target, curr);
        
    }
}
*/