package problems.kadane;

/**
 * at each position, ask:
 * Is it better to extend the previous subarray OR start a new subarray from here?
 * currentSum  → best sum ending at this index
 * maxSum      → best sum seen so far
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int currentMax = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            currentMax = Math.max(currentMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currentMax);
        }

        return maxSum;
    }
}
