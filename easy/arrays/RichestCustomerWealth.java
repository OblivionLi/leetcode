package easy.arrays;

public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] accounts = {{1, 5}, {7,3}, {3, 5}};

        System.out.println(maximumWealth(accounts));
    }

    public static int maximumWealth(int[][] accounts) {
        int richestAccount = Integer.MIN_VALUE;

        for (int[] account : accounts) {
            int accountWealthSum = 0;
            for (int j : account) {
                accountWealthSum += j;
            }

            richestAccount = Math.max(richestAccount, accountWealthSum);
        }

        return richestAccount;
    }
}
