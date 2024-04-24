package medium.arrays;

public class SubrectangleQueries {
    private int[][] rectangle;

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for (int i = row1; i <= row2; i++) {
            for (int j = col1; j <= col2; j++) {
                rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return rectangle[row][col];
    }

    public void displayRectangle() {
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[i].length; j++) {
                System.out.print(rectangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}

class Run {
    public static void main(String[] args) {
        int[][] rectangle = {{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}};

        SubrectangleQueries obj = new SubrectangleQueries(rectangle);
        obj.displayRectangle();

        int param_2 = obj.getValue(0, 2);
        System.out.println("Parameter 2: " + param_2);

        obj.updateSubrectangle(0, 0, 3, 2, 5);
        obj.displayRectangle();

        int param_3 = obj.getValue(0, 2);
        System.out.println("Parameter 3: " + param_3);
        int param_4 = obj.getValue(3, 1);
        System.out.println("Parameter 4: " + param_4);

        obj.updateSubrectangle(3, 0, 3, 2, 10);
        obj.displayRectangle();

        int param_5 = obj.getValue(3, 1);
        System.out.println("Parameter 5: " + param_5);
        int param_6 = obj.getValue(0, 2);
        System.out.println("Parameter 6: " + param_6);
    }
}
