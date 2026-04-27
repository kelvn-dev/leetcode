package codility;

/**
 * https://app.codility.com/programmers/lessons/5-prefix_sums/count_div/
 * count = floor(B / K) - floor((A - 1) / K)
 *
 * For A = 6, B = 11, and K = 2:
 * floor(11/2) = floor(5.5) = 5 (multiples are 2, 4, 6, 8, 10)
 * floor(5/2) = floor(2.5) = 2 (multiples are 2, 4)
 * => 5 -2 = 3
 */
public class CountDiv {
    public static void main(String[] args) {
        System.out.println(solution(6, 11, 2));
    }

    public static int solution(int A, int B, int K) {
        int countB = B / K;
        int countA = (A == 0) ? -1 : (A - 1) / K;
        return countB - countA;
    }

}
