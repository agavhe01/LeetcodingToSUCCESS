/**

 * Leetcode 104: 104. Maximum Depth of Binary Tree
   Given the root of a binary tree, return its maximum depth.

   A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

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
class MaxDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        int result = Integer.MIN_VALUE;
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
                result = Math.max(depth, result);
            }
            if (left != null) {
                queue.add(new Pair(left, depth + 1));
            }
            if (right != null) {
                queue.add(new Pair(right, depth + 1));
            }
        }
        return result;
    }

    record Pair(
            TreeNode node,
            Integer val
    ) {
        
    }
}