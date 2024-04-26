package medium.arrays;

import java.util.Arrays;

public class FindTheOriginalArrayOfPrefixXor {
    public static void main(String[] args) {
        int[] pref = {5, 2, 0, 3, 1};

        System.out.println(Arrays.toString(findArray(pref)));
    }

    public static int[] findArray(int[] pref) {
        if (pref.length == 0) return pref;

        int[] arr = new int[pref.length];
        arr[0] = pref[0];

        for (int i = 1; i < pref.length; i++) {
            arr[i] = pref[i] ^ pref[i - 1];
        }

        return arr;
    }
}
