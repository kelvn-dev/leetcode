package problems.slidingwindow.dynamicsize;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,1,1,1,1,1};
        int target = 11;
        int result = minSubArrayLen(target, nums);
        System.out.println(result);
    }

    /**
     * For each iterating:
     * 1. Keep calculating sum
     * 2. If sum < target => continue
     * 3. If sum >= target => try to subtract from left to get min length
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; ++right) {
            sum += nums[right];
            if (sum < target) {
                continue;
            }

            while (sum >= target) {
                min = Math.min(min, right - left + 1);
                sum -= nums[left];
                ++left;
            }

        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
