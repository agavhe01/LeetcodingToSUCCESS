import java.util.*;


public class maxPointsArchery{

    Map<Integer, List<Integer>> mp;

    public maxPointsArchery(){     
        
    }

    public int[] getMax(int numArrows, int[] aliceArrows){

        mp = new HashMap<>();

        int[] bobArrows = new int[12];
        helper(0, 0, numArrows, aliceArrows, bobArrows);

        
        int currMax = Integer.MIN_VALUE;
        for(Integer n : mp.keySet()){ currMax = Math.max(currMax, n); }


        int[] result = new int[12];
        if (currMax == Integer.MIN_VALUE) return result;

        
        List<Integer> resList = mp.get(currMax); 
        for(int i = 0; i < 12; i++) result[i] = resList.get(i);
        return result;
    }

    public void helper(
        int index, int currTotal, int numArrows,
        int[] aliceArrows, int[] bobArrows
    ){

        if (numArrows == 0){
            
            // System.out.println("Total: " + currTotal + " Index: " + index) ;
            // if (currTotal == 47) { System.out.println("foundMax"); }
            // if (currTotal == 27) { System.out.println("foundMax"); }

            List<Integer> bobArrowsList = new ArrayList<>();
            for(int n : bobArrows) bobArrowsList.add(n);
            mp.put(currTotal, bobArrowsList);
            return;
        }

        if (numArrows < 0 || index >= 12) { return; } 
        else{
            int alice = aliceArrows[index];

            // bob wins
            int bob =  alice + 1;
            bobArrows[index] = bob;
            helper(index + 1, currTotal + index, numArrows - bob, aliceArrows, bobArrows);

            // bob loses
            bobArrows[index] = 0;
            helper(index + 1, currTotal, numArrows, aliceArrows, bobArrows);
        }

    }

    public void printSol(int[] arr, String act){
        int total = 0;
        System.out.print("[ ");
        for(int n : arr) { System.out.print(" " + n + " "); total += n; }
        System.out.println("] ");
        System.out.println(act);
        System.out.println("Total: " + total);
        System.out.println();
    }

    public static void main(String[] args){
        maxPointsArchery sol = new maxPointsArchery();

        int[] t1 = {1,1,0,1,0,0,2,1,0,1,2,0};
        int[] t2 = {0,0,1,0,0,0,0,0,0,0,0,2};

        int[] res1 = sol.getMax(9, t1);
        int[] res2 = sol.getMax(3, t2);

        sol.printSol(res1, "[  0  0  0  0  1  1  0  0  1  2  3  1 ]" );   // "[0,0,0,0,1,1,0,0,1,2,3,1]""
        sol.printSol(res2, "[  0  0  0  0  0  0  0  0  1  1  1  0 ]" );   // "[0,0,0,0,0,0,0,0,1,1,1,0]""


    }
}