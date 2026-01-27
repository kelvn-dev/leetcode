package problems.binarysearch;

public class Search2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},{10,11,16,20},{23,30,34,60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length < 1) {
            return false;
        }
        int rowLength = matrix.length;
        int columnLength = matrix[0].length;

        int head = 0;
        int tail = rowLength * columnLength - 1;
        while (head <= tail) {
            int mid = head + (tail - head) / 2;
            int midValue = matrix[mid / columnLength][mid % columnLength];
            if (midValue == target) {
                return true;
            }

            if (midValue > target) {
                tail = mid - 1;
            } else {
                head = mid + 1;
            }
        }

        return false;
    }
}
