package medium.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FilledOrders {
    public static void main(String[] args) {
        List<Integer> order = List.of(5, 4, 6);
        int k = 3;

        System.out.println(filledOrders(order, k));
    }

    public static int filledOrders(List<Integer> order, int k) {
        if (order == null || order.isEmpty()) {
            return 0;
        }

        Collections.sort(order);

        int filledOrdersCount = 0;

        for (int ord : order) {
            if (ord <= 0) {
                continue;
            }

            if (k >= ord) {
                filledOrdersCount++;
                k -= ord;
            } else {
                break;
            }
        }

        return filledOrdersCount;
    }
}
