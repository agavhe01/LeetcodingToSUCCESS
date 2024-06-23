/*

Count Good Nodes in Binary Tree
Within a binary tree, a node x is considered good if the path from the root of the tree to the node x contains no nodes with a value greater than the value of node x

Given the root of a binary tree root, return the number of good nodes within the tree.

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

    int result = 0;

    public int goodNodes(TreeNode root) {

        if (root == null) return result;
        dfsHelper(root, Integer.MIN_VALUE);
        return result;
    }

    public void dfsHelper(TreeNode root, Integer currMax){
        if (root == null) return;

        if (root.val >= currMax) result++;
        currMax = Math.max(currMax, root.val);

        dfsHelper(root.left, currMax);
        dfsHelper(root.right, currMax);
    }
}

/*

ALTERNATIVE APPROACH

class Solution {

    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        return dfsHelper(root, Integer.MIN_VALUE);
    }

    public int dfsHelper(TreeNode root, Integer currMax){
        if (root == null) return 0;

        int result = (root.val >= currMax) ? 1 : 0;
        currMax = Math.max(currMax, root.val);

        result += dfsHelper(root.left, currMax);
        result += dfsHelper(root.right, currMax);
        return result;
    }
}

*/