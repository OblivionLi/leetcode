package patterns.mergeintervals.medium;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A', 'A', 'A', 'B', 'B', 'B'};
        int n = 2;

        System.out.println(leastInterval(tasks, n));
    }

    public static int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> taskCounts = new HashMap<>();
        for (char task : tasks) {
            taskCounts.put(task, taskCounts.getOrDefault(task, 0) + 1);
        }

        int maxCount = 0;
        for (int count : taskCounts.values()) {
            maxCount = Math.max(maxCount, count);
        }

        int maxTasksCount = 0;
        for (int count : taskCounts.values()) {
            if (count == maxCount) {
                maxTasksCount++;
            }
        }

        int intervalsRequired = (maxCount - 1) * (n + 1) + maxTasksCount;

        return Math.max(intervalsRequired, tasks.length);
    }
}
