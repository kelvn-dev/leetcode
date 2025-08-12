package problems.kadane;

public class BestSightseeingPair {
    public static void main(String[] args) {
        int[] values = new int[] {7,2,6,6,9,4,3};
        System.out.println(maxScoreSightseeingPair(values));
    }

    /**
     * values[left] + values[rigt] + left - right
     * => find max (values[left] + left) and max (values[right] - right)
     */
    public static int maxScoreSightseeingPair(int[] values) {
        int maxLeft = values[0] + 0;
        int maxScore = Integer.MIN_VALUE;
        for (int right = 1; right < values.length; ++right) {
            maxScore = Math.max(maxScore, maxLeft + values[right] - right);
            maxLeft = Math.max(maxLeft, values[right] + right);
        }
        return maxScore;
    }
}
