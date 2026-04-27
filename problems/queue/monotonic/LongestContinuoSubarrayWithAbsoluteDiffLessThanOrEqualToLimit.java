package problems.queue.monotonic;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuoSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public static void main(String[] args) {
        int[] nums = new int[] {10,1,2,4,7,2};
        int limit = 5;
        System.out.println(longestSubarray(nums, limit));
    }

    /**
     * addLast == add
     * peekLast != peek
     * removeLast != remove
     */
    public static int longestSubarray(int[] nums, int limit) {
        int max = 0;
        Deque<Integer> maxQueue = new ArrayDeque<>(); // 1, 2, 3 <- head
        Deque<Integer> minQueue = new ArrayDeque<>(); // 3, 2, 1 <- head
        int left = 0;

        for (int right = 0; right < nums.length; ++right) {
            int num = nums[right];
            while (!maxQueue.isEmpty() && nums[maxQueue.peekLast()] < num) {
                maxQueue.pollLast();
            }
            maxQueue.addLast(right);

            while (!minQueue.isEmpty() && nums[minQueue.peekLast()] > num) {
                minQueue.pollLast();
            }
            minQueue.addLast(right);

            while (nums[maxQueue.peek()] - nums[minQueue.peek()] > limit) {
                ++left;
                if (maxQueue.peek() < left) {
                    maxQueue.remove();
                }

                if (minQueue.peek() < left) {
                    minQueue.remove();
                }
            }

            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
