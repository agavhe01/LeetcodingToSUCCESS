import java.util.LinkedList;
import java.util.Queue;

public class HikerTrail {

    public static int[] getResult(int[] arrival, int[] direction) {
        int n = arrival.length;
        int[] result = new int[n];
        Queue<Integer> ascendingQueue = new LinkedList<>();
        Queue<Integer> descendingQueue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (direction[i] == 0) {
                ascendingQueue.offer(i);
            } else {
                descendingQueue.offer(i);
            }
        }

        int currentTime = 0;
        int lastDirection = -1; // Initialize with an invalid direction

        while (!ascendingQueue.isEmpty() || !descendingQueue.isEmpty()) {
            if (lastDirection == -1 || lastDirection == 1) {
                if (!descendingQueue.isEmpty()) {
                    int nextHiker = descendingQueue.poll();
                    result[nextHiker] = currentTime;
                    lastDirection = 1;
                    currentTime++;
                } else {
                    int nextHiker = ascendingQueue.poll();
                    result[nextHiker] = currentTime;
                    lastDirection = 0;
                    currentTime++;
                }
            } else {
                int nextHiker = ascendingQueue.poll();
                result[nextHiker] = currentTime;
                lastDirection = 0;
                currentTime++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arrival1 = {0, 0, 1, 4};
        int[] direction1 = {0, 1, 1, 0};
        int[] result1 = getResult(arrival1, direction1);
        for (int time : result1) {
            System.out.print(time + " ");
        }
        System.out.println();

        int[] arrival2 = {0, 1, 1, 3, 3};
        int[] direction2 = {0, 1, 0, 0, 1};
        int[] result2 = getResult(arrival2, direction2);
        for (int time : result2) {
            System.out.print(time + " ");
        }
    }
}