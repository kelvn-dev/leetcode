package problems.twopointers;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = new int[] {2, 1, 1, 3};
        int result = trap(height);
        System.out.println(result);
    }

    /**
     * 1. leftMaxArr[i] stores the maximum height from the start to index i.
     * 2. rightMaxArr[i] stores the maximum height from index i to the end.
     * 3. Iterate through heights and get trapped water by min(leftMaxArr[i], rightMaxArr[i]) - height[i]
     */
    public static int trap(int[] height) {
        int n = height.length;
        if (n < 3) {
            return 0;
        }
        int result = 0;

        int[] leftMaxArr = new int[n];
        leftMaxArr[0] = height[0];
        for (int i = 1; i < n; ++i) {
            leftMaxArr[i] = Math.max(height[i], leftMaxArr[i - 1]);
        }

        int[] rightMaxArr = new int[n];
        rightMaxArr[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; --i) {
            rightMaxArr[i] = Math.max(height[i], rightMaxArr[i + 1]);
        }

        for (int i = 0; i < n; ++i) {
            result += Math.min(leftMaxArr[i], rightMaxArr[i]) - height[i];
        }

        return result;
    }
}
