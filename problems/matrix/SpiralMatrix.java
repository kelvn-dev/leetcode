package problems.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        List<Integer> result = spiralOrder(matrix);
        for (int i: result) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length < 1) {
            return new ArrayList<>();
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        List<Integer> result = new ArrayList<>();

        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; ++i) {
                result.add(matrix[top][i]);
            }
            ++top;

            for (int i = top; i <= bottom; ++i) {
                result.add(matrix[i][right]);
            }
            --right;

            /**
             * without this, error case:
             * {1,2,3,4},
             * {5,6,7,8},
             * {9,10,11,12}
             */
            if (top <= bottom) {
                for (int i = right; i >= left; --i) {
                    result.add(matrix[bottom][i]);
                }
                --bottom;
            }

            /**
             * without this, error case:
             * {1},
             * {2},
             * {3}
             */
            if (left <= right) {
                for (int i = bottom; i >= top; --i) {
                    result.add(matrix[i][left]);
                }
                ++left;
            }
        }

        return result;
    }
}
