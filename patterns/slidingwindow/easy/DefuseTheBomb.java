package patterns.slidingwindow.easy;

import java.util.Arrays;

public class DefuseTheBomb {
    public static void main(String[] args) {
        int[] code = {5, 7, 1, 4};
        int k = 3;

        System.out.println(Arrays.toString(decrypt(code, k)));
    }

    public static int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] decryptedCode = new int[length];

        if (k == 0) {
            Arrays.fill(decryptedCode, 0);
            return decryptedCode;
        }

        for (int i = 0; i < length; i++) {
            int sum = 0;
            if (k > 0) {
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % length];
                }
            } else {
                for (int j = -1; j >= k; j--) {
                    sum += code[(i + j + length) % length];
                }
            }

            decryptedCode[i] = sum;
        }

        return decryptedCode;
    }
}
