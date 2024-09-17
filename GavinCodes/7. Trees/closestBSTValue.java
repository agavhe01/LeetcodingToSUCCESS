/**

270. Closest Binary Search Tree Value
Solved
Easy
Topics
Companies

Given the root of a binary search tree and a target value, 
return the value in the BST that is closest to the target. If there are multiple answers, print the smallest.

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

    double maxDiff = Double.MAX_VALUE;
    int result = -1;

    public int closestValue(TreeNode root, double target) {

        dfsHelper(root, target);
        return result;
        
    }

    public void dfsHelper(TreeNode root, double target){
        if (root == null) return;

        double diff = Math.abs(0.0 + root.val - target);

        if (diff < maxDiff){
            result = root.val;
            maxDiff = diff;
        }
        else if (diff == maxDiff) result = Math.min(result, root.val);

        dfsHelper(root.left, target);
        dfsHelper(root.right, target);
    }
}