/*

Leetcode: 1570. Dot Product of Two Sparse Vectors

Medium

Given two sparse vectors, compute their dot product.

Implement class SparseVector:

SparseVector(nums) Initializes the object with the vector nums
dotProduct(vec) Compute the dot product between the instance of SparseVector and vec
A sparse vector is a vector that has mostly zero values, you should store the sparse vector efficiently and compute the dot product between two SparseVector.

Follow up: What if only one of the vectors is sparse?



*/


public class SparseVector {
         // Your SparseVector object will be instantiated and called as such:
        // SparseVector v1(nums1);
        // SparseVector v2(nums2);
        // int ans = v1.dotProduct(v2);
        Map<Integer,Integer> zeroIndex = new HashMap<>();
        SparseVector(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] !=0){
                    zeroIndex.put(i,nums[i]);
                }
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            int ans =0;
            for (int index : zeroIndex.keySet()) {
                if(vec.zeroIndex.containsKey(index)){
                    ans+= vec.zeroIndex.get(index)*zeroIndex.get(index);
                }
            }
            return ans;
        }
}