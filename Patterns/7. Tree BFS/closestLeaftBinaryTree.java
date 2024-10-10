/**

742. Closest Leaf in a Binary Tree
Solved
Medium
Topics
Companies
Hint

Given the root of a binary tree where every node has a unique value and a target integer k, return the value of the nearest leaf node to the target k in the tree.

Nearest to a leaf means the least number of edges traveled on the binary tree to reach any leaf of the tree. Also, a node is called a leaf if it has no children.

 

Example 1:

Input: root = [1,3,2], k = 1
Output: 2
Explanation: Either 2 or 3 is the nearest leaf node to the target of 1.

Example 2:

Input: root = [1], k = 1
Output: 1
Explanation: The nearest leaf node is the root node itself.

Example 3:

Input: root = [1,2,3,4,null,null,null,5,null,6], k = 2
Output: 3
Explanation: The leaf node with value 3 (and not the leaf node with value 6) is nearest to the node with value 2.

 

Constraints:

    The number of nodes in the tree is in the range [1, 1000].
    1 <= Node.val <= 1000
    All the values of the tree are unique.
    There exist some node in the tree where Node.val == k.


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

    Map<Integer, List<Integer>> adjList = new HashMap<>();
    Set<Integer> leaves = new HashSet<>();

    public int findClosestLeaf(TreeNode root, int k) {

        dfsHelper(root, null);

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(k);

        while ( ! q.isEmpty() ){
            int size = q.size();

            for(int i = 0; i < size; i++){
                int current = q.poll();

                if (visited.contains(current)) continue;
                visited.add(current);

                if (leaves.contains(current)) return current;
                
                List<Integer> connections = adjList.get(current);
                if (connections != null) q.addAll(connections);


            }
        }

        return root.val; // should never be called
         
    }

    public void dfsHelper(TreeNode current, TreeNode parent){
        if (current == null) return;
        if (current.left == null && current.right == null) leaves.add(current.val);

        List<Integer> list = new ArrayList<>();
        if (parent != null) list.add(parent.val);
        if (current.left != null)list.add(current.left.val);
        if (current.right != null)list.add(current.right.val);

        adjList.put(current.val, list);

        dfsHelper(current.left, current);
        dfsHelper(current.right, current);
    }
}