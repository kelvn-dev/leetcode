package problems.matrix;

/**
 * To achieve O(1) space, use matrix itself to store information
 * - Determine if the first row and first column need to be zeroed for later update
 * - Use the first row and first column to mark whether a row or column contain zero
 */
public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
//        int[][] matrix = {
//                {0,1,2,0},
//                {3,4,5,2},
//                {1,3,1,5}
//        };
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix.length < 1) {
            return;
        }
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        boolean firstRowContainZero = false;
        for (int i = 0; i < columnLength; ++i) {
            if (matrix[0][i] == 0) {
                firstRowContainZero = true;
                break;
            }
        }

        boolean firstColumnContainZero = false;
        for (int i = 0; i < rowLength; ++i) {
            if (matrix[i][0] == 0) {
                firstColumnContainZero = true;
                break;
            }
        }

        for (int i = 1; i < rowLength; ++i) {
            for (int j = 1; j < columnLength; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rowLength; ++i) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < columnLength; ++j) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < columnLength; ++i) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < rowLength; ++j) {
                    matrix[j][i] = 0;
                }
            }
        }

        if (firstRowContainZero) {
            for (int i = 0; i < columnLength; ++i) {
                matrix[0][i] = 0;
            }
        }

        if (firstColumnContainZero) {
            for (int i = 0; i < rowLength; ++i) {
                matrix[i][0] = 0;
            }
        }
    }
}
