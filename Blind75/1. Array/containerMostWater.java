public class containerMostWater{

    public containerMostWater(){}

     /*
        PREFERRED TWO POINTER Method
        TC : O(n)
        SC : O(1)

    */

    public int mostWater(int[] arr){

        int result = Integer.MIN_VALUE;
        int n = arr.length;

        int left = 0;
        int right = n - 1;

        while (left < right){

            int currArea = calcArea(left, arr[left], right, arr[right]);
            result = Math.max(currArea, result);
            
            if (arr[left] > arr[right]) right--;
            else left++;

        }
        return result;
    }

    public int calcArea(int x1, int y1, int x2, int y2){
        int height = Math.min(y1, y2);
        int length = x2 - x1;
        return height * length;
    }

    public static void main(String[] args){
        containerMostWater sol = new containerMostWater();
       
        int[] t1 = new int[]{1,8,6,2,5,4,8,3,7};
        int r1 = sol.mostWater(t1);
        System.out.println("Solution 1: 49 --> " + r1);


        int[] t2 = new int[]{1,1};
        int r2 = sol.mostWater(t2);
        System.out.println("Solution 1:  1 -->  " + r2);

        int[][] t3 = {{1,1}, {1,1}};
        
    }


}