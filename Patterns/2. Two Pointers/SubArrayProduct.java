/*
Leetcode: 713. Subarray Product Less Than K
Medium


Given an array of integers nums and an integer k, return the number of contiguous subarrays where the product of all the elements in the subarray is strictly less than k.



class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if (k <= 1) {       
            return 0;
        }

        int left = 0;
        int ans = 0;
        int currProduct = 1;


        for (int right = 0; right < nums.length; right++) {
            currProduct *= nums[right];

            while (currProduct >= k) {
                currProduct /= nums[left];
                left++;
            }

            ans += right - left + 1;
        }

        return ans;

        

    }
}

*/


import java.math.BigInteger;

class subArrayProduct {

    public void printArr(int[] nums){
        for(int i = 0; i < nums.length ; i++){
            System.out.print(nums[i] + " ");
        }
        System.out.println(" ");

    }

    public BigInteger subArrayProd(int[] nums){

        BigInteger prod = new BigInteger("1");
        for(int i = 0; i < nums.length ; i++){
            prod = new BigInteger("" + nums[i]).multiply(prod);
        }

        return prod;
    }


    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int[] sub;
        BigInteger constantK = new BigInteger("" + k);
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = 1 + i; j <= nums.length; j++){
                 //System.out.println("i:" + i + " j:" + j);
                
                sub = Arrays.copyOfRange(nums, i, j);
                
                
                BigInteger prod = subArrayProd(sub);
                int comp = prod.compareTo(constantK);


                System.out.println("Prod: " + prod);
                if (comp < 0){
                    result++;
                }

            }
        }
        return result;
        
    }
}