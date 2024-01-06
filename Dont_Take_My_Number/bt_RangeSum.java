/*

LEETCODE: 938

938. Range Sum of BST
Easy

Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].

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

    
    public int rangeSumBST(TreeNode root, int low, int high) {

        if (root == null){ return 0; }

        if(root.val >= low && root.val <= high){
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }

        else if (root.val > high){
            return rangeSumBST(root.left, low, high);
        }

        else
        /*

        In the case where the value of the current node is less than the low value of the range, 
        the method only calls itself recursively on the right child, as all nodes in the left subtree
        will also be less than low.

        */
            {return rangeSumBST(root.right, low, high);}
        }

}