/*

Binary Tree Diameter
The diameter of a binary tree is defined as the length of the longest path between any two nodes within the tree. The path does not necessarily have to pass through the root.

The length of a path between two nodes in a binary tree is the number of edges between the nodes.

Given the root of a binary tree root, return the diameter of the tree.

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

    int result;

    public int diameterOfBinaryTree(TreeNode root) {
        dfsHelper(root); 
        return result;    
    }

    public int dfsHelper(TreeNode root){
        if (root == null) return 0;
        int leftH = dfsHelper(root.left);
        int rightH = dfsHelper(root.right);
        result = Math.max(result, leftH + rightH);
        return 1 + Math.max(leftH, rightH);
    }
}
