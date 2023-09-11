/**
 * Leetcode: 112 Path Sum
 Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.

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
class BinaryTreeRootLeafPathTargetSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if (root == null) {
            return false;
        }
        System.out.println("Node: " + root.val);
        System.out.println("Target: " + targetSum);
        
        // Check if the current node is a leaf node and its value matches the targetSum
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        
        // Recursively check the left and right subtrees with updated targetSum
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}