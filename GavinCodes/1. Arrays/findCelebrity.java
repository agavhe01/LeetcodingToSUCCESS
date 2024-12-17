/* 
Description
Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.

Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).

You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.

The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        // Write your code here

        int candI = 0;

        for(int i = 1; i < n; i++){
            if (knows(candI , i)){
                candI = i;
            }
        }

        for(int i = 0; i < n; i++){
            if (i != candI && ! knows(i, candI)) return -1;

            if (i != candI && knows(candI, i)) return -1;
        }

        return candI;
    }
}

/*

NOT GREAT SOLUTION O(n^2)

 public int findCelebrity(int n) {

        Set<Integer> potentialResults = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for(int i = 0; i < n; i++){

            map.put(i, new HashSet<>());

            for(int j = 0; j < n; j++){
                if (j == i) continue;

                if (knows(i, j)){
                    map.get(i).add(j);
                }
            }

        }

        for(int i = 0; i < n; i++){
            if (map.get(i).size() == 0) potentialResults.add(i);
        }

        Set<Integer> duplicate = new HashSet<>(potentialResults);

        for(int r : duplicate){
            for(int i = 0; i < n; i++){
                if (i == r) continue;
                Set<Integer> curr = map.get(i);
                if (! curr.contains(r)) {
                    potentialResults.remove(r);
                    break;
                }
            }
        }

        if (potentialResults.size() == 1) return potentialResults.iterator().next();
        return -1;
    }