/**
 * Leetcode: 543. Diameter of Binary Tree
 Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.


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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {

        myBFS(root);
        return ans;
        
    }

    public int myBFS(TreeNode root){
        if(root == null){ return 0; }

        int leftH = myBFS(root.left);
        int rightH = myBFS(root.right);
        System.out.println("Node:" + root.val);
        System.out.println("Left:" + leftH + " Right:" + rightH);
        ans = Math.max(ans, leftH + rightH);
        return 1 + Math.max(leftH, rightH);
    }
}