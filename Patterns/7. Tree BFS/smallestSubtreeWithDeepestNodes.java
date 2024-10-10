/**

865. Smallest Subtree with all the Deepest Nodes
Medium
Topics
Companies

Given the root of a binary tree, the depth of each node is the shortest distance to the root.

Return the smallest subtree such that it contains all the deepest nodes in the original tree.

A node is called the deepest if it has the largest depth possible among any node in the entire tree.

The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.

 

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

    TreeNode result = null;
    int maxDepth = Integer.MIN_VALUE;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        bfsHelper(root, 0);
        return result;
    }

    public int bfsHelper(TreeNode root, int depth){
        if (root == null) return depth;

        int leftD = bfsHelper(root.left, depth + 1);
        int rightD = bfsHelper(root.right, depth + 1);

        int currDepth = Math.max(leftD, rightD);
        maxDepth = Math.max(currDepth, maxDepth);

        if (leftD == maxDepth && rightD == maxDepth) result = root;
        return currDepth;

    }
}