package hackerrank.easy;

public class Staircase {
    public static void main(String[] args) {
        int n = 6;

        staircase(n);
    }

    public static void staircase(int n) {
        int hashtags = 1;
        int spaces = n - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            int hashtagsCount = hashtags;
            while (hashtagsCount > 0) {
                System.out.print("#");
                hashtagsCount--;
            }

            System.out.println();
            hashtags++;
            spaces--;
        }
    }
}
