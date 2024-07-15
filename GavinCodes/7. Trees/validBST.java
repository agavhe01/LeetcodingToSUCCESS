/*

Valid Binary Search Tree
Given the root of a binary tree, return true if it is a valid binary search tree, otherwise return false.

A valid binary search tree satisfies the following constraints:

The left subtree of every node contains only nodes with keys less than the node's key.
The right subtree of every node contains only nodes with keys greater than the node's key.
Both the left and right subtrees are also binary search trees.
Example 1:


Input: root = [2,1,3]

Output: true
Example 2:



Input: root = [1,2,3]

Output: false
Explanation: The root node's value is 1 but its left child's value is 2 which is greater than 1.



*/

/**
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
    public boolean isValidBST(TreeNode root) {
        return isValidHelper(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValidHelper(TreeNode root, double left, double right){
        if (root == null) return true;
        if (! (left < root.val && root.val < right) ) return false;

        return isValidHelper(root.left, left, root.val) &&
               isValidHelper(root.right, root.val, right);
        
    }
}
