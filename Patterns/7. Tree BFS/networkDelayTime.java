/*

743. Network Delay Time
Solved
Medium
Topics
Companies
Hint

You are given a network of n nodes, labeled from 1 to n. You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. If it is impossible for all the n nodes to receive the signal, return -1.

 

Example 1:

Input: times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
Output: 2

Example 2:

Input: times = [[1,2,1]], n = 2, k = 1
Output: 1

Example 3:

Input: times = [[1,2,1]], n = 2, k = 2
Output: -1

 

Constraints:

    1 <= k <= n <= 100
    1 <= times.length <= 6000
    times[i].length == 3
    1 <= ui, vi <= n
    ui != vi
    0 <= wi <= 100
    All the pairs (ui, vi) are unique. (i.e., no multiple edges.)


*/

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        //  start  ,    target  ,  cost

        for(int[] t : times){
            int start = t[0];
            int end = t[1];
            int cost = t[2];
            map.putIfAbsent(start, new HashMap<>());
            map.get(start).put(end, cost);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {k, 0});

        while ( ! q.isEmpty() ){
            int[] curr = q.poll();
            int currNode = curr[0];
            int currWeight = curr[1];

            for( int next : map.getOrDefault(currNode, new HashMap<>()).keySet() ){
                int nextWeight = map.get(currNode).get(next);

                if (nextWeight + currWeight < distance[next]){
                    distance[next] = nextWeight + currWeight;
                    q.offer(new int[] {next, nextWeight + currWeight});
                }
            }
        }

        int result = 0;
        for(int i = 1; i <= n; i++){
            result = Math.max(result, distance[i]);
        }

        if (result == Integer.MAX_VALUE) return -1;
        else return result;

        
    }
}