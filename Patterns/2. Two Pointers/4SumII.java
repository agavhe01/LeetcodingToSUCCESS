/*

Leetocode: 454. 4Sum II

Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:

0 <= i, j, k, l < n
nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0



*/

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                int temp = map.getOrDefault(nums1[i] + nums2[j], 0);
                map.put(nums1[i] + nums2[j], temp + 1);
            }
        }

        int count = 0;
        for(int i = 0; i < nums3.length; i++){
            for(int j = 0; j < nums4.length; j++){
                int temp = nums3[i] + nums4[j];
                if(map.containsKey(-temp)){
                    count += map.get(-temp);
                }
            }
        }
        return count;

    }
}