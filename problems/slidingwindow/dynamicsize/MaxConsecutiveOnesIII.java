package problems.slidingwindow.dynamicsize;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        int result = longestOnes(nums, k);
        System.out.println(result);
    }

    /**
     * For each iterating:
     * 1. increment zeroCount if encountered
     * 2. if zeroCount exceeds k, increment the left pointer until zeroCount is not more than k
     */
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLength = 0;
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
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
