import java.util.PriorityQueue;

public class TaskPriority {

    public static int maximumPrioritySum(int[] priority, int x, int y) {
        int n = priority.length;
        int[] lastTimePerformed = new int[n];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int maxSum = 0;

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < n; j++) {
                if (lastTimePerformed[j] == 0 || i - lastTimePerformed[j] >= x) {
                    maxHeap.offer(priority[j]);
                    lastTimePerformed[j] = i;
                    break; // Break to the next second
                }
            }
            if (!maxHeap.isEmpty()) {
                maxSum += maxHeap.poll();
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] priority = {3, 1, 2};
        int x = 5;
        int y = 7;
        int result = maximumPrioritySum(priority, x, y);
        System.out.println("Maximum Priority Sum: " + result); // Output: 11
    }
}
