/*

Subtree of a Binary Tree
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

Example 1:

*/

/*
*
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
    public boolean isSubtree(TreeNode root /* height n */, TreeNode subRoot /* height m */) {  // O(n * m)
        if (subRoot == null) return true;
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || 
               isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode root, TreeNode sub){ // O ( Math.max(n, m) )
        if (root == null && sub == null) return true;
        if (root != null && sub != null && root.val == sub.val){
            return isSameTree(root.left, sub.left) && 
                   isSameTree(root.right, sub.right);
        }
        return false;
    }
}
