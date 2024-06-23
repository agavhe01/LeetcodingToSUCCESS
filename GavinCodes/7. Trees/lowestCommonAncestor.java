/*

Lowest Common Ancestor in Binary Search Tree
Given a binary search tree (BST) where all node values are unique, and two nodes from the tree p and q, return the lowest common ancestor (LCA) of the two nodes.

The lowest common ancestor between two nodes p and q is the lowest node in a tree T such that both p and q as descendants. The ancestor is allowed to be a descendant of itself.

Example 1:

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (true){
            // This means both p and q must be in the right subtree of the current node.
            if ( (root.val < p.val) && (root.val < q.val) ) root = root.right;

            // This means both p and q must be in the left subtree of the current node.
            else if ( (root.val > p.val) && (root.val > q.val) ) root = root.left;

            // It means the current node is the lowest common ancestor.
            // This is because one node is in one subtree and the other node is in the other subtree, or one of them is the current node itself.
            else return root;
        } 
    }
}
