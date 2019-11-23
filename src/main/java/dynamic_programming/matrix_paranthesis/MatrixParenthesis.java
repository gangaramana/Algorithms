package dynamic_programming.matrix_paranthesis;

public class MatrixParenthesis {
    public static void main(String[] args) {
        int arr[] = new int[]{6, 5, 4, 3,2};
        int size = arr.length;
        MatrixParenthesis matrixParenthesis = new MatrixParenthesis();
        System.out.println("Minimum number of multiplications is " +
                matrixParenthesis.multiplication(arr, size));
    }

    public int multiplication(int[] p, int n) {
        int[][] countsArray = new int[n][n];
        int[][] lookup = new int[n][n];
        int value = 0;
        int diagonalIterator, row, column, k, q;
        for (diagonalIterator = 1; diagonalIterator < n - 1; diagonalIterator++) {
            for (row = 1; row < n - diagonalIterator; row++) {
                column = row + diagonalIterator;
                int sum = Integer.MAX_VALUE;
                for (k = row; k <= column - 1; k++) {
                    q = countsArray[row][k] + countsArray[k + 1][column] + p[row - 1] * p[k] * p[column];
                    if (sum > q) {
                        sum = q;
                        value = k;
                        System.out.println("K    "+value);
                    }
                }
                System.out.println("row   col "+ row   +"     "+column);
                lookup[row][column] = value;
                countsArray[row][column] = sum;
            }
        }
        int n1 = lookup.length - 1;
        String s = "";
        while (n1 != 0) {
            s = s + "   " + lookup[1][n1];
            n1 = lookup[1][n1];
        }
        System.out.println(s);
        return countsArray[1][n - 1];
    }
}
