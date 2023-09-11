/**

 * Leetcode: 129. Sum Root to Leaf Numbers

 * You are given the root of a binary tree containing digits from 0 to 9 only.

Each root-to-leaf path in the tree represents a number.

For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.

A leaf node is a node with no children.
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
class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {

        List<String> theList = new ArrayList<String>();

        int theSum = 0;

        theList = inorder(root, theList, "");

        System.out.println(theList);

        for(String str: theList){
            theSum += Integer.parseInt(str);
        }
        return theSum;
        
    }

    public List<String> inorder(TreeNode root, List<String> theList, String str){
        if(root == null){ return theList; }

        str += root.val;

        if(root.left == null && root.right == null){
            theList.add(str);
        }

        inorder(root.left, theList, str);
        inorder(root.right, theList, str);
        return theList;


    }
}