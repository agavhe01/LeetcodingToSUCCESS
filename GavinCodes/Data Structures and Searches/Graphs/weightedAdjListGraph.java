import java.util.*;

// DIRECTED

public class weightedAdjListGraph{

    Map<Integer, List<Integer[]>> adjList;

    public weightedAdjListGraph(){  }

    public void buildAdjList(Integer[][] wEdges, int numNodes){
        Map<Integer, List<Integer[]>> result = new HashMap<Integer, List<Integer[]>>();
        for(int i = 0; i < numNodes + 1; i++) result.put(i, new ArrayList<Integer[]>());
        for(Integer[] arr: wEdges){
            Integer src = arr[0];
            Integer dst = arr[1];
            Integer wei = arr[2];

            result.get(src).add(new Integer[]{dst, wei});
        }
        this.adjList = result;
    }

    /*

        Dijkstra's Algorithm

            Shortests Paths from a Target Source within a directed weighted graph

            T(C): O(E log E)        E --> number of edges
            S(C): O(v + e)              (v + e) adj list
                                        (  v  ) shortest MAP
                                        (  v  ) priority queue


    */

    public Map<Integer, Integer> shortestPaths(Integer src){
        Map<Integer, Integer> shortest = new HashMap<>();

        Comparator<Integer[]> ascEdgeComp = new Comparator<Integer[]>(){
            @Override
            // Sort them by cost
            public int compare(Integer[] arr1, Integer[] arr2){
                return arr1[0] - arr2[0];
            }

        };

        Queue<Integer[]> pq = new PriorityQueue<>(ascEdgeComp);   // heap <cost, A>
        /*

            Why We Use Priority Queue (PQ)

            Efficiency: The priority queue ensures that the node with the smallest current known distance is processed first, 
                        which is a key aspect of Dijkstra's algorithm. This allows the algorithm to efficiently find the shortest
                        path by always extending the shortest known path.

            Optimality: By processing the closest node first, the algorithm guarantees that once a node is processed, its shortest path is found. 
                        Using a priority queue achieves this optimal processing order.

        */

        pq.add(new Integer[]{0, src});

        while (!pq.isEmpty()){
            Integer[] curr = pq.poll();

            Integer w1 = curr[0]; // cost
            Integer n1 = curr[1]; // node

            if (shortest.containsKey(n1)) { System.out.println("contains key: " + n1); continue; } 
            /*
                Dijkstra's algorithm requires that each node is processed only once to maintain its correctness. 
                Skipping already processed nodes ensures that each node's shortest path is calculated correctly and efficiently.

            */

            shortest.put(n1, w1);

            for(Integer[] arr : adjList.get(n1)){
                Integer w2 = arr[1];
                Integer n2 = arr[0];
                pq.add(new Integer[]{w1 + w2, n2});
            }
        }

        return shortest;
    }
    

    public static void main(String[] args){
        weightedAdjListGraph sol = new weightedAdjListGraph();

        // source, destination, weight 
        Integer[][] wEdges = {{1, 2, 10}, {1, 3, 3}, {3, 2, 4}, {2, 4, 2}, {3, 4, 8}, {4, 5, 5}, {3, 5, 2}};

        sol.buildAdjList(wEdges, 5);
        
        Map<Integer, Integer> shortestPathsA = sol.shortestPaths(1);


        // Print Shortest Paths
        for(Integer key : shortestPathsA.keySet()){
            Integer val = shortestPathsA.get(key);
            System.out.println("Node Number: " + key + "  Path Length: " + val); // correct
        }

        System.out.println("Done");
        

    }



}

/*

public class WGraphNode {
    String val;
    Map<WGraphNode, Integer> neighbors;
    
    public WGraphNode(int val) {
        this.val = val;
        this.neighbors = new ArrayList<WGraphNode, Integer>();
    }
}


*/