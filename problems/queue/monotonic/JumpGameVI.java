package problems.queue.monotonic;

import java.util.*;

public class JumpGameVI {
    public static void main(String[] args) {
        int[] nums = new int[] {1,-1,-2,4,-7,3};
        int k = 2;
        System.out.println(maxResult(nums, k));
    }

    public static int maxResult(int[] nums, int k) {
        // Deque to keep indices of max scores in window
        Deque<Integer> deque = new LinkedList<>();
        deque.offer(0);

        // DP array to store maximum score at current index
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Remove indices that are out of the sliding window
            while (!deque.isEmpty() && deque.peek() < i - k) {
                deque.poll();
            }

            // Calculate the maximum score for current index
            dp[i] = nums[i] + dp[deque.peek()];

            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offer(i);
        }

        return dp[nums.length - 1];
    }
}
