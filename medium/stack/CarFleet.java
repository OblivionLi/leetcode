package medium.stack;

import java.util.Arrays;
import java.util.Stack;

public class CarFleet {
    public static void main(String[] args) {
//        int target2 = 10;
//        int[] position2 = {3};
//        int[] speed2 = {3};
//
//        System.out.println(carFleet(target2, position2, speed2));
//
//        int target3 = 100;
//        int[] position3 = {0, 2, 4};
//        int[] speed3 = {4, 2, 1};
//
//        System.out.println(carFleet(target3, position3, speed3));
//
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};

        System.out.println(carFleet(target, position, speed));

//        int target1 = 10;
//        int[] position1 = {2, 4};
//        int[] speed1 = {3, 2};
//
//        System.out.println(carFleet(target1, position1, speed1));
//
//        int target4 = 10;
//        int[] position4 = {6, 8};
//        int[] speed4 = {3, 2};
//
//        System.out.println(carFleet(target4, position4, speed4));
    }

    public static int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i] = new int[]{position[i], speed[i]};
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        int fleets = 0;
        double currentTime = -1;

        for (int[] car : cars) {
            int carPosition = car[0];
            int carSpeed = car[1];

            double timeToTarget = (double) (target - carPosition) / carSpeed;

            if (timeToTarget > currentTime) {
                fleets++;
                currentTime = timeToTarget;
            }
        }

        return fleets;
    }
}
