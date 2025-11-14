package problems.slidingwindow.fixedsize;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MaximumSumofDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 2, 3, 4, 5};
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }

    /**
     * Use HashSet to maintain distinct elements of current window. For each iterating:
     * - Remove element from left until the newly added in distinct
     * - After added, if set.size() == k, calculate sum
     */
    public static long maximumSubarraySum(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int left = 0;
        int right = 0;
        long sum = 0;
        long max = 0;

        while (right < nums.length) {
            while (set.contains(nums[right])) {
                set.remove(nums[left]);
                sum -= nums[left];
                ++left;
            }

            set.add(nums[right]);
            sum += nums[right];
            ++right;

            if (right - left == k) {
                max = Math.max(max, sum);
                set.remove(nums[left]);
                sum -= nums[left];
                ++left;
            }
        }

        return max;
    }
}
