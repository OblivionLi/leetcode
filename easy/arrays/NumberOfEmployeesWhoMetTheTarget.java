package easy.arrays;

public class NumberOfEmployeesWhoMetTheTarget {
    public static void main(String[] args) {
        int[] hours = {5, 1, 4, 2, 2};
        int target = 6;

        System.out.println(numberOfEmployeesWhoMetTarget(hours, target));
    }

    public static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;

        for (int hour : hours) {
            if (hour >= target) {
                count++;
            }
        }

        return count;
    }
}
