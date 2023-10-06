import java.util.*;


public class TaskPriority {

    public static int maximumPrioritySum(Integer[] priority, int x, int y) {
        // Sort the tasks by priority in descending order.
        Arrays.sort(priority, Collections.reverseOrder());

        // Initialize a counter to track the current time.
        int currentTime = 0;

        // Initialize a set to track the available task types.
        Set<Integer> availableTypes = new HashSet<>();
        for (int i = 0; i < priority.length; i++) {
            availableTypes.add(i);
        }

        // Initialize a map to track the last time a task of each type was performed.
        Map<Integer, Integer> lastTimePerformed = new HashMap<>();

        // Iterate over the tasks and perform the highest priority task that is available.
        int totalPriority = 0;
        while (currentTime < y) {
            if (availableTypes.isEmpty()) {
                break;
            }

            // Find the highest priority task type in the availableTypes set that is available to be performed.
            int taskType = -1;
            for (int type : availableTypes) {
                if (currentTime - lastTimePerformed.getOrDefault(type, 0) >= x) {
                    taskType = type;
                    break;
                }
            }

            // If no task type is available to be performed, break from the loop.
            if (taskType == -1) {
                break;
            }

            // Perform a task of that type.
            totalPriority += priority[taskType];

            // Update the last time a task of that type was performed.
            lastTimePerformed.put(taskType, currentTime);

            // Remove the task type from the availableTypes set.
            availableTypes.remove(taskType);

            // Update the current time.
            currentTime++;
        }

        return totalPriority;
    }

    public static void main(String[] args) {
        Integer[] priority = {3, 1, 2};
        int x = 5;
        int y = 7;

        int maxPrioritySum = maximumPrioritySum(priority, x, y);

        System.out.println(maxPrioritySum);
    }
}