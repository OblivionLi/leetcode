package easy.arrays;

public class FindTheHighestAltitude {
    public static void main(String[] args) {
        int[] gain = {-4,-3,-2,-1,4,3,2};

        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int highestAltitude = gain[0];

        for (int i = 1; i < gain.length; i++) {
            gain[i] = gain[i - 1] + gain[i];
            highestAltitude = Math.max(highestAltitude, gain[i]);
        }

        return Math.max(highestAltitude, 0);
    }
}
