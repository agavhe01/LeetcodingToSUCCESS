/*

Binary Tree Maximum Path Sum
Given the root of a non-empty binary tree, return the maximum path sum of any non-empty path.

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes has an edge connecting them. A node can not appear in the sequence more than once. The path does not necessarily need to include the root.

The path sum of a path is the sum of the node's values in the path.

Example 1:

*/



class Solution {

    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        dfsHelper(root);
        return result;
    }

    public int dfsHelper(TreeNode root){
        if (root == null) return 0;

        int leftMax = Math.max(dfsHelper(root.left), 0);
        int rightMax = Math.max(dfsHelper(root.right), 0);
        result = Math.max(result, root.val + leftMax + rightMax);

        return root.val + Math.max(leftMax, rightMax);
    }
}
