/*

Kth Smallest Integer in BST
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) in the tree.

A binary search tree satisfies the following constraints:

The left subtree of every node contains only nodes with keys less than the node's key.
The right subtree of every node contains only nodes with keys greater than the node's key.
Both the left and right subtrees are also binary search trees.
Example 1:

Input: root = [2,1,3], k = 1

Output: 1
Example 2:

Input: root = [4,3,5,2,null], k = 4

Output: 5

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

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

    public int kthSmallest(TreeNode root, int k) {
        // if (root == null) return 0; // ????
        dfsInOrderHelper(root, k);
        return (- pq.peek()); 
    }

    public void dfsInOrderHelper(TreeNode root, int k){
        if (root == null) return;

        else{
            
            dfsInOrderHelper(root.left, k);

            // do the stuff
            Integer currVal = root.val;
            if (pq.size() < k) pq.add(- currVal);
            else if (currVal < Math.abs(pq.peek())){
                pq.poll();
                pq.add(- currVal);
            }

            dfsInOrderHelper(root.right, k);
        }

    }
}
