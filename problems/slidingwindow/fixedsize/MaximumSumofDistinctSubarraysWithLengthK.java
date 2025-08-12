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

    public static long maximumSubarraySumUsingMap(int[] nums, int k) {
        long max = 0;
        long sum = 0;
        int left = 0;
        int right = 0;
        HashMap<Integer, Integer> numToIndex = new HashMap<>();

        while (right < nums.length) {
            int lastOccurrence = numToIndex.getOrDefault(nums[right], -1);
            while (left <= lastOccurrence) {
                sum -= nums[left];
                ++left;
            }

            numToIndex.put(nums[right], right);
            sum += nums[right];
            ++right;

            if (right - left == k) {
                max = Math.max(max, sum);
                sum -= nums[left];
                ++left;
            }
        }
        return max;
    }
}
