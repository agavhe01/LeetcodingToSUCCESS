/**
Leetcode 111
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.


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
class MinDepthBinaryTree {
    
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            TreeNode left = pair.node.left;
            TreeNode right = pair.node.right;
            Integer depth = pair.val;
            if (left == null && right == null) {
                return depth;
            }
            if (left != null) {
                queue.add(new Pair(left, depth + 1));
            }
            if (right != null) {
                queue.add(new Pair(right, depth + 1));
            }
        }
        throw new RuntimeException();
    }

    record Pair(
            TreeNode node,
            Integer val
    ) {
    }
}