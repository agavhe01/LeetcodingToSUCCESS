// Visit www.neon.rip for more content!

import java.util.List;
import java.util.ArrayList;

public class Combination {
    
    // Given n numbers (1 - n), return all possible combinations
    // of size k. (n choose k math problem).
    // Time: O(k * 2^n)
    public static List<List<Integer>> combinations(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        helper(1, new ArrayList<>(), combs, n, k);
        return combs;
    }

    public static void helper(int i, List<Integer> curComb, List<List<Integer>> combs, int n, int k) {
        if (curComb.size() == k) {
            combs.add(new ArrayList<>(curComb));
            return;
        }
        if (i > n) {
            return;
        }
        // decision to include i
        curComb.add(i);
        helper(i + 1, curComb, combs, n, k);
        curComb.remove(curComb.size() - 1);
        
        // decision to NOT include i
        helper(i + 1, curComb, combs, n, k);
    }


    // Time: O(k * C(n, k))     -->    n! / ( k! (n - k)! )


    public static List<List<Integer>> combinations2(int n, int k) {
        List<List<Integer>> combs = new ArrayList<>();
        helper2(1, new ArrayList<>(), combs, n, k);
        return combs;
    }

    public static void helper2(int i, List<Integer> curComb, List<List<Integer>> combs, int n, int k) {
        if (curComb.size() == k) {
            combs.add(new ArrayList<>(curComb));
            return;
        }
        if (i > n) {
            return;
        }
        for (int j = i; j < n + 1; j++) {
            curComb.add(j);
            helper2(j + 1, curComb, combs, n, k);
            curComb.remove(curComb.size() - 1);
        }
    }
}

/*

class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        helper(1, n, k, new ArrayList<>());
        return result;
    }

    public void helper(int index, int n, int k, List<Integer> curr){
        if (curr.size() == k){
            result.add(new ArrayList<>(curr));
            return;
        }

        if (curr.size() > k || index > n){
            return;
        }

        for(int i = index; i <= n; i++){
            curr.add(i);
            helper(i + 1, n, k, curr);
            curr.remove(curr.size() - 1);
        }

        /*
        curr.add(index);

        helper(index + 1, n, k, curr);

        curr.remove(curr.size() - 1);

        helper(index + 1, n, k, curr);
        */

    }
}
*/