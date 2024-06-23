/*

Level Order Traversal of Binary Tree
Given a binary tree root, return the level order traversal of it as a nested list, where each sublist contains the values of nodes at a particular level in the tree, from left to right.

Example 1:

Input: root = [1,2,3,4,5,6,7]

Output: [[1],[2,3],[4,5,6,7]]
Example 2:

Input: root = [1]

Output: [[1]]
Example 3:

Input: root = []

Output: []
Constraints:

0 <= The number of nodes in both trees <= 1000.
-1000 <= Node.val <= 1000


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

    List<List<Integer>> result = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return result;
        bfsHelper(root);
        return result;
    }

    public void bfsHelper(TreeNode root){
        if (root == null) return;

        Deque<TreeNode> dq = new ArrayDeque<TreeNode>();
        dq.add(root);
 
        while (! (dq.isEmpty()) ){
            List<Integer> currLevel = new ArrayList<>();
            int currLevelLength = dq.size();
            for(int i = 0; i < currLevelLength; i++){
                TreeNode curr = dq.pollFirst();
                Integer currVal = curr.val;
                currLevel.add(currVal);
                
                if (curr.left != null) dq.add(curr.left);
                if (curr.right != null) dq.add(curr.right);
            }
            result.add(currLevel);
        }

    }
}
