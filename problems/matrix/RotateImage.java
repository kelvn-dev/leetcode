package problems.matrix;

import java.util.ArrayList;
import java.util.List;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        rotate(matrix);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void rotate(int[][] matrix) {
        if (matrix.length < 1) {
            return;
        }
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        for (int i = 0; i < rowLength; ++i) {
            for (int j = i; j < columnLength; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < rowLength; ++i) {
            int left = 0;
            int right = columnLength - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                ++left;
                --right;
            }
        }
    }
}
