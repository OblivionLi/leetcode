package easy.arrays;

public class FinalValueOfVariableAfterPerformingOperations {
    public static void main(String[] args) {
        String[] operations = {"--X", "X++", "X++"};

        System.out.println(finalValueAfterOperations(operations));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int X = 0;

        for (String operation : operations) {
            switch (operation) {
                case "--X" -> --X;
                case "X--" -> X--;
                case "X++" -> X++;
                case "++X" -> ++X;
            }
        }

        return X;
    }
}
