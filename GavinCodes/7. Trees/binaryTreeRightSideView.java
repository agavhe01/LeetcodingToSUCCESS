/*

Binary Tree Right Side View
You are given the root of a binary tree. Return only the values of the nodes that are visible from the right side of the tree, ordered from top to bottom.

Example 1:



Input: root = [1,2,3]

Output: [1,3]
Example 2:

Input: root = [1,2,3,4,5,6,7]

Output: [1,3,7]
Constraints:

1 <= number of nodes in the tree <= 100
-100 <= Node.val <= 100


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

    List<Integer> result = new ArrayList();

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return result;
        bfsHelper(root);
        return result; 
    }

    public void bfsHelper(TreeNode root){
        
        Deque<TreeNode> dq = new ArrayDeque<TreeNode>();
        if (root != null) dq.add(root);
        while (! dq.isEmpty()){
            int levelLength = dq.size();
            TreeNode rightMostNode = null;
            for(int i = 0; i < levelLength; i++){
                TreeNode currNode = dq.pollFirst();
                rightMostNode = currNode;
                if (currNode.left != null) dq.add(currNode.left);
                if (currNode.right != null) dq.add(currNode.right);   
            }
            if (rightMostNode != null) result.add(rightMostNode.val);
        }
    }
}

/*

NO EXTRA SPACE SOLUTION

class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfsHelper(root, 0, res);
        return res;
    }

    private void dfsHelper(TreeNode node, int depth, List<Integer> res) {
        if (node == null) return;

        // If this is the first time we've reached this depth, add the node's value
        if (depth == res.size()) {
            res.add(node.val);
        }

        

        // Recurse to the right first, then to the left
        // Recurse: First recurse to the right child (node.right), then to the left child (node.left). 
        // This ensures that the rightmost node at each depth is visited first.

        // For the left side view alternative problem, you need to visit the left child before the right child.

        

        dfsHelper(node.right, depth + 1, res);
        dfsHelper(node.left, depth + 1, res);
    }
}





/*

MY SOLUTION: WASTES EXTRA SPACE

class Solution {

    List<List<Integer>> result = new ArrayList();

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        bfsHelper(root, 0);

        for(List<Integer> arr: result){
            System.out.println(arr.size());
            if (arr.size() >= 1) res.add(arr.get(arr.size() - 1));
        }
        return res;
        
    }

    public void bfsHelper(TreeNode root, int currLevel){
        if (root == null) return;
        Deque<TreeNode> dq = new ArrayDeque<TreeNode>();
        dq.add(root);
        while (! dq.isEmpty()){
            int levelLength = dq.size();
            List<Integer> currLevelNodes = new ArrayList<>();
            for(int i = 0; i < levelLength; i++){
                TreeNode currNode = dq.pollFirst();
                currLevelNodes.add(currNode.val);
                System.out.println(currNode.val);
                if (currNode.left != null) dq.add(currNode.left);
                if (currNode.right != null) dq.add(currNode.right);
               
                
            }
            result.add(currLevelNodes);
            currLevelNodes = new ArrayList<>();
            currLevel++;

        }


    }
}



*/
