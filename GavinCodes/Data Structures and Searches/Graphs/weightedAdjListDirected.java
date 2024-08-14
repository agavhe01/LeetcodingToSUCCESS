import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;


public class weightedAdjListDirected{

    Map<Integer, List<Integer[]>> adjList;
    public Integer numberOfNodes;

    public weightedAdjListDirected(){  }

    public void buildAdjList(Integer[][] wEdges, int numNodes){
        Map<Integer, List<Integer[]>> result = new HashMap<Integer, List<Integer[]>>();
        for(int i = 0; i < numNodes + 1; i++) result.put(i, new ArrayList<Integer[]>());
        for(Integer[] arr: wEdges){
            Integer src = arr[0];
            Integer dst = arr[1];
            Integer wei = arr[2];

            result.get(src).add(new Integer[]{dst, wei});
            result.get(dst).add(new Integer[]{src, wei});
        }
        this.adjList = result;
        this.numberOfNodes = numNodes;
    }

    /*
        Minimum Spanning Tree ? 

            Subset of edges that form a tree --> acyclical
                                            --> undirected
                                            --> connected (all edges reachable)
                                            --> grapj
                                    
            Will contain (n - 1) edges

        Prim's Algorithm / Prims Algorithm
        
            T(C) : O (E log V)                              --> E logE  =  E logV^2  =  E 2logV  =  E log V 
            S(C) : O (E)

                                                                                                coz E <= v^2

    */
    public List<Integer[]> findMinimumSpanningTree(){
        List<Integer[]> resultMST = new ArrayList<Integer[]>(); // node1, node2

        Comparator<Integer[]> acsWeightComp = new Comparator<Integer[]>(){
            @Override
            public int compare(Integer[] arr1, Integer[] arr2) { return arr1[0] - arr2[0]; }
        };

        Queue<Integer[]> minPQ = new PriorityQueue<Integer[]>(acsWeightComp); // < weight, src, dst >
    

        // Initialize the heap by choosing a single node
        // (in this case 1) and pushing all its neighbors.
        for(Integer[] neigh : adjList.get(1)){
            int node = neigh[0];
            int weight = neigh[1];
            minPQ.add(new Integer[]{weight, 1, node});        
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(1);

        while (visited.size() < this.numberOfNodes ){
            Integer[] curr = minPQ.poll();

            int w = curr[0];
            int n1 = curr[1];
            int n2 = curr[2];

            // if the destination has already been visited then skip it
            if (visited.contains(n2)){ continue; }

            resultMST.add(new Integer[]{n1, n2});
            visited.add(n2);

            for(Integer[] neighbor : adjList.get(n2)){
                Integer dst = neighbor[0];
                Integer weight = neighbor[1];

                if (! visited.contains(dst) ) minPQ.add(new Integer[]{weight, n2, dst});
            }
        }


        return resultMST;
    }

    public static void main(String[] args){
        weightedAdjListDirected sol = new weightedAdjListDirected();

        // source, destination, weight 
        Integer[][] wEdges = {{1, 2, 10}, {1, 3, 3}, {3, 2, 4}, {2, 4, 1}, {3, 4, 4}, {4, 5, 2}, {3, 5, 4}};

        sol.buildAdjList(wEdges, 5);
        
       List<Integer[]> mst = sol.findMinimumSpanningTree();

       for(Integer[] pair : mst){
            System.out.println(pair[0] + "  " + pair[1]);
       }

       
        System.out.println("Done");
        

    }
}