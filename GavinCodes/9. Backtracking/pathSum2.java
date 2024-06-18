/**

113. Path Sum II
Solved
Medium
Topics
Companies
Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

 


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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        if (root == null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(result, 0, new ArrayList<Integer>(), root, targetSum);
        return result;
        
    }

    public void helper(
        List<List<Integer>> result,
        int currSum,
        List<Integer> curr,
        TreeNode root,
        int targetSum
    ){
        if (root == null) return;

        currSum += root.val;
        curr.add(root.val);
            
        if (currSum == targetSum && root.left == null && root.right == null){
            result.add(new ArrayList<>(curr));
        }
       else{
            helper(result, currSum, new ArrayList<>(curr), root.left, targetSum);
            helper(result, currSum, new ArrayList<>(curr), root.right, targetSum);
            // curr.remove(curr.size() - 1);
       }

    }

    
}