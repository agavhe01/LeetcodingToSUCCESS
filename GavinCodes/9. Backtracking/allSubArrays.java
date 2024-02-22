class Solution {
    public int main(int n, int[][] paths) {

        int[] arr = paths[0];

        List<List<Integer>> result = new ArrayList<>();

        subArrays(arr, 0, 0, result);

        System.out.println("Result Size: " + result.size());

        return 0;
    }

    public void subArrays(int[] arr, int start, int end, List<List<Integer>> result)
    { 
        // Stop if we have reached the end of the array
        if (end == arr.length)
            return;
        // Increment the end point and start from 0
        else if (start > end)
            subArrays(arr, 0, end + 1, result);
        // Print the subarray and increment the starting
        // point
        else {
            System.out.print("[");
            List<Integer> current = new ArrayList<>();
            for (int i = start; i < end; i++){
                System.out.print(arr[i] + ", ");
                current.add(arr[i]);
            }
            result.add(current);
            System.out.println(arr[end] + "]");
            subArrays(arr, start + 1, end, result);
        }
        return;
    }
}