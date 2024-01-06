/*

621. Task Scheduler

Medium

Companies
Given a characters array tasks, representing the tasks a CPU needs to do, where each letter represents a different task. Tasks could be done in any order. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

Return the least number of units of times that the CPU will take to finish all the given tasks.

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A

*/

class Solution {

    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;

        // This priority queue will store the frequencies of each task in descending order. The tasks with the highest frequency will be at the front of the queue.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        // This queue will store pairs consisting of the remaining count of tasks and the time when they can be executed again.
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();

        // to store the frequency of each task.
        int[] arr = new int[26];
        
        for (char c : tasks) arr[c - 'A']++;
        for (int val : arr) if (val > 0) pq.add(val);
        int time = 0;

        while ((!pq.isEmpty() || !q.isEmpty())) {
            time++;
            if (!pq.isEmpty()) {
                int val = pq.poll();
                val--;
                if (val > 0) q.add(new Pair(val, time + n));
            }

/*
checks if there are tasks in the queue q whose cooldown has expired and are ready to be scheduled again. If so:
Retrieves the task from the front of the queue, which has its cooldown period expired (i.e., the time value is equal to the current time).
Adds the remaining count of this task back to the priority queue pq
*/
            if (!q.isEmpty() && q.peek().getValue() == time) pq.add(
                q.poll().getKey()
            );
        }
        return time;
    }
}
