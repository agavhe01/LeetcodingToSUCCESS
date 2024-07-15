/*

Binary Tree from Preorder and Inorder Traversal
You are given two integer arrays preorder and inorder.

preorder is the preorder traversal of a binary tree
inorder is the inorder traversal of the same tree
Both arrays are of the same size and consist of unique values.
Rebuild the binary tree from the preorder and inorder traversals and return its root.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if (preorder.length == 0 || inorder.length == 0) return null;

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal);
        
        int mid = -1;
        for(int i = 0; i < inorder.length; i++){
            if (inorder[i] == rootVal){
                mid = i;
                break;
            }
        }

        int[] leftInOrder = Arrays.copyOfRange(inorder, 0, mid);
        int[] leftPreOrder = Arrays.copyOfRange(preorder, 1, mid + 1);
        root.left = buildTree(leftPreOrder, leftInOrder);

        int[] rightInOrder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        int[] rightPreOrder = Arrays.copyOfRange(preorder, mid + 1, preorder.length);
        root.right = buildTree(rightPreOrder, rightInOrder);

        return root;
        
    }
}
