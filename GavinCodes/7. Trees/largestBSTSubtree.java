/**

333. Largest BST Subtree
Solved
Medium
Topics
Companies
Hint

Given the root of a binary tree, find the largest
subtree
, which is also a Binary Search Tree (BST), where the largest means subtree has the largest number of nodes.

A Binary Search Tree (BST) is a tree in which all the nodes follow the below-mentioned properties:

    The left subtree values are less than the value of their parent (root) node's value.
    The right subtree values are greater than the value of their parent (root) node's value.

Note: A subtree must include all of its descendants.

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
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;

        if (isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) return sizeBST(root);
        else return Math.max(largestBSTSubtree(root.left), largestBSTSubtree(root.right));
    }

    public int sizeBST(TreeNode root){
        if (root == null) return 0;
        return 1 + sizeBST(root.left) + sizeBST(root.right);
    }

    public boolean isValidBST(TreeNode root, int min, int max){
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;

        return isValidBST(root.left, min, root.val) &&
               isValidBST(root.right, root.val, max);

    }
}