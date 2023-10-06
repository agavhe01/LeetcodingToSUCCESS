import java.util.*;


public class gpu{

public int getMinCost(int[] cost, int[] compatible1, int[] compatible2, int minCompatible){
    int n = cost.length;
    Comparator<Integer> descendingComparator = Collections.reverseOrder();

   HashSet<Integer> crossCount = new HashSet<>();

    int[] dp1 = new int[n + 1];
    int max1 = Integer.MIN_VALUE;
    int dp1_count = 0;
    PriorityQueue<Integer> gpu1 = new PriorityQueue<Integer>(descendingComparator);

    int[] dp2 = new int[n + 1];
    int max2 = Integer.MIN_VALUE;
    int dp2_count = 0;
    PriorityQueue<Integer> gpu2 = new PriorityQueue<Integer>(descendingComparator);

    for(int i = 1; i < n + 1; i++){
        if (compatible1[i - 1] == 1 && compatible2[i - 1] == 1){
            crossCount.add(cost[i - 1]);  
        }


        if(compatible1[i - 1] == 1){
            if (dp1_count < minCompatible){
                dp1[i] = dp1[i - 1] + cost[i - 1];
                dp1_count++;
                gpu1.add(cost[i - 1]);
            }
            else{
                if (cost[i - 1] < gpu1.peek()){
                    max1 = gpu1.poll();
                    dp1[i] = dp1[i - 1] - max1 + cost[i - 1];
                    gpu1.add(cost[i - 1]);
                }
                else{
                    dp1[i] = dp1[i - 1];
                }
            }

        }
        else{
            System.out.println("Here:" + i);
            System.out.println(dp1[i - 1]);
            dp1[i] = dp1[i - 1];
        }
        if (compatible2[i - 1] == 1){
            if (dp2_count < minCompatible){
                dp2[i] = dp2[i - 1] + cost[i - 1];
                dp2_count++;
                gpu2.add(cost[i - 1]);

            }
            else{
                if(cost[i - 1] < gpu2.peek()){
                    max2 = gpu2.poll();
                    dp2[i] = dp2[i  - 1] - max2 + cost[i - 1];
                    gpu2.add(cost[i - 1]);
                }
                else{
                    dp2[i] = dp2[i - 1];
                }

            }

        }
        else{
            dp2[i] = dp2[i - 1];
        } 

    }// endfor

    // if both counts >= 3, sum all elems in the gpu1 and gpu2 and return
    // else return -1

    int result;

    if (dp2_count < minCompatible || dp1_count < minCompatible){
        result =  -1;
    }
    else{

        for(int i = 0; i < n + 1; i++){
            System.out.println("I:" + i + " dp1:" + dp1[i] +" dp2:" + dp2[i]);
        }
        result = dp1[n] + dp2[n];


        PriorityQueue<Integer> gpu1duplicate = new PriorityQueue<Integer>(descendingComparator);
        for (Integer element : gpu1) {
            gpu1duplicate.add(element);
        }
        
        PriorityQueue<Integer> gpu2duplicate = new PriorityQueue<Integer>(descendingComparator);
        for (Integer element : gpu2) {
            gpu2duplicate.add(element);
        }

        for (Integer number : crossCount) {
            if (gpu1duplicate.contains(number) ){
                result = result - gpu2.poll();
            }

            if (gpu2duplicate.contains(number)){
                result = result - gpu1.poll();
            }
            
        }
    }

    return result;

}

public static void main(String[] args) {
    int[] cost = {2,4,6,5};
    int[] comp1 = {1,1,1,0};
    int[] comp2 = {0,0,1,1};


    gpu gp = new gpu();

    int result = gp.getMinCost(cost, comp1, comp2, 2);

    System.out.println(result);


}

}