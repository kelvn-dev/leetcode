package problems.slidingwindow.dynamicsize;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int result = longestOnes(nums, k);
        System.out.println(result);
    }

    /**
     * Simplified version
     */
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int max = 0;
        int zeroCount = 0;
        for (int right = 0; right < nums.length; ++right) {
            if (nums[right] == 0) {
                ++zeroCount;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    --zeroCount;
                }
                ++left;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static int longestOnes1(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int max = 0;

        for (int right = 0; right < nums.length; ++right) {
            sum += nums[right];
            while (sum + k < right - left + 1) {
                sum -= nums[left];
                ++left;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
