package hackerrank.easy;

import java.text.DecimalFormat;
import java.util.List;

public class PlusMinus {
    public static void main(String[] args) {
        List<Integer> arr = List.of(1, 1, 0, -1, -1);

        plusMinus(arr);
    }

    public static void plusMinus(List<Integer> arr) {
        int posCount = 0, negCount = 0, zerCount = 0;

        for (Integer num : arr) {
            if (num == 0) {
                zerCount++;
            } else if (num > 0) {
                posCount++;
            } else {
                negCount++;
            }
        }

        int length = arr.size();
        double posCountFrac = (double) posCount / length;
        DecimalFormat df = new DecimalFormat("#.000000");

        String posFormatted = df.format(posCountFrac);
        System.out.println(posFormatted);

        double negCountFrac = (double) negCount / length;
        String negFormatted = df.format(negCountFrac);
        System.out.println(negFormatted);

        double zerCountFrac = (double) zerCount / length;
        String zerFormatted = df.format(zerCountFrac);
        System.out.println(zerFormatted);
    }
}
