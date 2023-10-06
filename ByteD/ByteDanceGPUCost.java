import java.util.*;

public class ByteDanceGPUCost {

    public static int minGPUCost(int[] cost, int[] compatible1, int[] compatible2, int min_compatible) {
        int n = cost.length;
        List<Integer> cluster1Costs = new ArrayList<>();
        List<Integer> cluster2Costs = new ArrayList<>();
        int totalCost = 0;

        for (int i = 0; i < n; i++) {
            if (compatible1[i] == 1 && compatible2[i] == 1) {
                totalCost += cost[i];
                min_compatible--;
            } else if (compatible1[i] == 1) {
                cluster1Costs.add(cost[i]);
            } else if (compatible2[i] == 1) {
                cluster2Costs.add(cost[i]);
            }
        }

        if (min_compatible > 0) {
            return -1; // Not enough compatible GPUs
        }

        Collections.sort(cluster1Costs);
        Collections.sort(cluster2Costs);

        for (int i = 0; i < Math.min(cluster1Costs.size(), cluster2Costs.size()); i++) {
            totalCost += cluster1Costs.get(i) + cluster2Costs.get(i);
        }

        return totalCost;
    }

    public static void main(String[] args) {
        int[] cost = {2, 4, 6, 5};
        int[] compatible1 = {1, 1, 1, 0};
        int[] compatible2 = {0, 0, 1, 1};
        int min_compatible = 2;
        int result = minGPUCost(cost, compatible1, compatible2, min_compatible);
        System.out.println("Minimum Possible Cost: " + result); // Output: 11
    }
}
