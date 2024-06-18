/*

uses of postorder and preorder traversals???

understand java TreeMap -- python equivalent sortedDict 


*/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;

public class BinarySearchTree{

     public class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.value = val;
            this.left = null;
            this.right = null;

        }
    }

    TreeNode root;

    // Constructors
    public BinarySearchTree(int value){ root = new TreeNode(value); }
    public BinarySearchTree(){ root = null; }

    // Helpers
    public TreeNode getRoot() { return root; }

    // Time Complexity: 0 (logn)
    // Notes : duplicate values ignored automatically
    public TreeNode insertNode(TreeNode treeRoot, int value){ 
        if (treeRoot == null) return new TreeNode(value);

        if (value > treeRoot.value) treeRoot.right = insertNode(treeRoot.right, value);
        else if (value < treeRoot.value) treeRoot.left = insertNode(treeRoot.left, value);
        
        return treeRoot;
    }

    // Time Complexity: 0 (logn)
    // Notes : non-existent values ignored automatically
    public TreeNode removeNode(TreeNode treeRoot, int val){
        if (treeRoot == null) return null;

        if (val > treeRoot.value) treeRoot.right = removeNode(treeRoot.right, val);
        else if (val < treeRoot.value) treeRoot.left = removeNode(treeRoot.left, val);
        else {
            if (treeRoot.left == null) return treeRoot.right;
            else if (treeRoot.right == null) return treeRoot.left;
            else{
                TreeNode minValueNode = findMinValueNode(treeRoot.right);
                treeRoot.value = minValueNode.value;
                treeRoot.right = removeNode(treeRoot.right, minValueNode.value);
            }
        }
       
        return treeRoot;
    }

    // Time Complexity: 0 ?
    public TreeNode findMinValueNode(TreeNode treeRoot){
        TreeNode curr = treeRoot;
        while (curr != null && curr.left != null) curr = curr.left;
        return curr;
    }

    // Time Complexity: 0 (log n)
    public boolean searchNodeValue(TreeNode treeRoot, int target){
        if (treeRoot == null) { System.out.println(target + " does not exist "); return false; }

        if (target > treeRoot.value) return searchNodeValue(treeRoot.right, target);
        else if (target < treeRoot.value) return searchNodeValue(treeRoot.left, target);
        else { System.out.println(target + " does exist "); return true; }
    }

    /*

    DFS TRAVERSALS

    */
    // Time Complexity: 0 (n)
    public void dfsInOrder(TreeNode treeRoot){

        if (treeRoot == null) return;

        dfsInOrder(treeRoot.left);
        System.out.println(treeRoot.value);
        dfsInOrder(treeRoot.right);
    }

    // Time Complexity: 0 (n)
    public void dfsPostOrder(TreeNode treeRoot){

        if (treeRoot == null) return;

        dfsPostOrder(treeRoot.left);
        dfsPostOrder(treeRoot.right);
        System.out.println(treeRoot.value);
    }

    // Time Complexity: 0 (n)
    public void dfsPreOrder(TreeNode treeRoot){

        if (treeRoot == null) return;

        System.out.println(treeRoot.value);
        dfsPreOrder(treeRoot.left);
        dfsPreOrder(treeRoot.right);
       
    }

    /*

    BFS TRAVERSAL
    Time Complexity: O(n)

    */
    public void bfs(TreeNode treeRoot){
        Deque<TreeNode> q = new ArrayDeque<TreeNode>();

        if (treeRoot != null) q.add(treeRoot);
        int currLevel = 0;

        while( ! (q.isEmpty()) ){
            System.out.print("Current Level: " + currLevel + "  --> ");
            int levelLength = q.size();
            for(int i = 0; i < levelLength; i++){
                TreeNode curr = q.removeFirst();
                System.out.print(curr.value + "  ");
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            currLevel++;
            System.out.println();
        }
    }

    /*

    Determine if a path exists from root to leaf. It may not contain zeroes
    Time Complexity: O(n)

    */
    public boolean canReachLeaf(TreeNode treeRoot){
        if (treeRoot == null || treeRoot.value == 0) return false;
        if (treeRoot.left == null && treeRoot.right == null) return true;

        if (canReachLeaf(treeRoot.left)) return true;
        if (canReachLeaf(treeRoot.right)) return true;
        return false;
    }

    public boolean leafPath(TreeNode treeRoot, List<TreeNode> path){
        if (treeRoot == null || treeRoot.value == 0) return false;

        path.add(treeRoot);
        if (treeRoot.left == null && treeRoot.right == null) return true;
        if (leafPath(treeRoot.left, path)) return true;
        if (leafPath(treeRoot.right, path)) return true;

        path.remove(path.size() - 1);
        return false;
    }

    public void printArray(List<TreeNode> path){
        System.out.println("Printing Array");

        for(TreeNode tn : path){
            System.out.print(tn.value + "  ");
        }
        System.out.println();
    }


    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree(11);
        
        bst.insertNode(bst.getRoot(), 10);
        bst.insertNode(bst.getRoot(), 10);
        bst.insertNode(bst.getRoot(), 10);
        bst.dfsInOrder(bst.getRoot());
        System.out.println("Done");
        // System.out.println(bst.getRoot().value);

        bst.insertNode(bst.getRoot(), 5);
        bst.insertNode(bst.getRoot(), 20);
        bst.insertNode(bst.getRoot(), 200);
        bst.insertNode(bst.getRoot(), 201);
        bst.insertNode(bst.getRoot(), 2000);

        bst.dfsInOrder(bst.getRoot());
        System.out.println("Done");

        

        //bst.removeNode(bst.getRoot(), 5);
        bst.removeNode(bst.getRoot(), 5);
        bst.dfsInOrder(bst.getRoot());
        System.out.println("Done");

        bst.searchNodeValue(bst.getRoot(), 5);
        bst.searchNodeValue(bst.getRoot(), 20);
        bst.searchNodeValue(bst.getRoot(), 10);

        bst.bfs(bst.getRoot());
        System.out.println("Done");

        List<TreeNode> arr = new ArrayList<TreeNode>();

        boolean result1 = bst.canReachLeaf(bst.getRoot());

        boolean result2 = bst.leafPath(bst.getRoot(), arr);

        System.out.println(result1);
        System.out.println(result2);

        bst.printArray(arr);

        
        System.out.println("\n END OF PROGRAM MAIN!!! ");
    }
}