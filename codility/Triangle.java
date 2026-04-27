package codility;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/triangle/
 */
public class Triangle {
    public static void main(String[] args) {

    }

    public static int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; ++i) {
            if (A[i] + A[i + 1] > A[i + 2]) {
                return 1;
            }
        }
        return 0;
    }
}
