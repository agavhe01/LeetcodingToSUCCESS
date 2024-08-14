// GraphNode used for adjacency list
/* 
public class GraphNode {
    int val;
    List<GraphNode> neighbors;
    
    public GraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<GraphNode>();
    }
}
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayDeque;

public class adjacencyListGraph {

    HashMap<String, ArrayList<String>> adjList; // Graph Representation

    public adjacencyListGraph(String[][] edges){ this.adjList = buildAdjList(edges); }
    
    public  HashMap<String, ArrayList<String>> buildAdjList(String[][] edges) {
        HashMap<String, ArrayList<String>> adjList = new HashMap<>();

        HashSet<String> visit = new HashSet<>();

        adjList.put(edges[0][0], new ArrayList<String>());
        adjList.put(edges[0][1], new ArrayList<String>());

        for (String[] edge: edges) {
            String src = edge[0], dst = edge[1];
            // System.out.println("Adding Edge Src: " + src + " Dst: " + dst);
            if (!adjList.containsKey(src)) adjList.put(src, new ArrayList<String>());       
            if (!adjList.containsKey(dst)) adjList.put(dst, new ArrayList<String>());    

            adjList.get(src).add(dst);    
        }
        return adjList;
    }

    /*

        Count the number of paths from a Source Node to a Destination Node

        T(C): O(N ^ V)  where  N = avg number of edges per node and
                               V = number of nodes

    */
    public int dfsCountPaths(String node, String target, HashSet<String> visited){

        if (visited.contains(node)) return 0;
        if (node == target) return 1;

        visited.add(node);
        
        int count = 0;
        for(String n : adjList.get(node)) count += dfsCountPaths(n, target, visited);

        visited.remove(node); // backtrack

        return count;
    }

    /*

        Return the length of the shortest path from a Source to Target

        T(C): O (N * V) where   N = number of edges per node which is always < V
                                V = number of nodes / vertices  

        T(C): O (V + E) in this case because we only visit each node once because of the hashset
    */
    public int bfsShortestPathLength(String node, String target){
        int result = 0;
        if (node ==  target) return result;

        HashSet<String> visited = new HashSet<String>();
        Queue<String> dq = new ArrayDeque<String>();
        dq.add(node);
        visited.add(node);

        while (!dq.isEmpty()){
            int currLength = dq.size();

            for(int i = 0; i < currLength; i++){
                String currNode = dq.poll();

                if (currNode == target) return result;

                for(String neighbor : adjList.get(currNode) ) if (!visited.contains(neighbor)) visited.add(neighbor);

                visited.add(currNode);

            }
            result++;
        }
        return result; // should never run

    }

    public static void main(String[] args){
        /*

                    A             D
                    |             |
                    B ---------   |
                    |          \  |
                    |           \ |
                    C ----------  E


        */

        String[][] edges = {{"A", "B"}, {"B", "C"}, {"B", "E"}, {"C", "E"}, {"E", "D"}};
        adjacencyListGraph g1 = new adjacencyListGraph(edges);

        int r1 = g1.dfsCountPaths("A", "E", new HashSet<String>());
        System.out.println("      Number of Paths: 2 --> " + r1);

        int r2 = g1.dfsCountPaths("A", "E", new HashSet<String>());
        System.out.println("Shortest Path Length : 2 --> " + r2);




    }
}
