package easy.queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfRecentCalls {
    private static Queue<Integer> requests = new LinkedList<>();

    public static void main(String[] args) {
        System.out.println(ping(1));
        System.out.println(ping(100));
        System.out.println(ping(3001));
        System.out.println(ping(3002));
    }


    public static int ping(int t) {
        requests.add(t);

        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }

        return requests.size();
    }
}
