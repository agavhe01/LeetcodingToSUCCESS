/*


Leetcode: 15. 3Sum


Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



optimum solution below

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> s = new HashSet<>();
        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < nums.length; i++){
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    s.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        output.addAll(s);
        return output;
    }
}
*/



class Solution {

    public boolean isDuplicate(List<List<Integer>> res, List<Integer> curr){
        for(int i = 0; i < res.size(); i++){
            List<Integer> temp = res.get(i);
            if( curr.get(0) == temp.get(0) && curr.get(1) == temp.get(1) && curr.get(2) == temp.get(2)){
                return true;
            }

        }

        return false;

    }





    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < nums.length; j++){
                for(int k = 0; k < nums.length; k++){
                    if ( nums[i] + nums[j] + nums[k] == 0){
                        if (i != j && i != k && j!= k){
                            List<Integer> curr = new ArrayList<>();
                            curr.add(nums[i]);
                            curr.add(nums[j]);
                            curr.add(nums[k]);

                            //curr.add(Arrays.asList(nums[i], nums[j], nums[k]))
                            Collections.sort(curr);
                            if (!isDuplicate(result, curr)){
                                result.add(curr);

                            }
                            
                        }
                    }
                }
            }
        }

        return result;
        
    }
}