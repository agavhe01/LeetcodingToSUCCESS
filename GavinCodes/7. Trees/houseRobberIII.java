/**

337. House Robber III
Medium
Topics
Companies
The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.

Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.

Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.

 

Example 1:

 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {

        int[] result = dfsHelper(root);
        return Math.max(result[0], result[1]);
        
    }

    public int[] dfsHelper(TreeNode root){
        if (root == null) return new int[2]; // {0, 0};

        int[] left = dfsHelper(root.left);
        int[] right = dfsHelper(root.right);

        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        int yesRob = root.val + left[0] + right[0];

        return new int[]{notRob, yesRob};
    }
}