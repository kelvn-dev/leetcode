package problems.stacks.monotonic;

import java.util.Stack;

public class Pattern132 {
    public static void main(String[] args) {
        int[] nums = new int[] {-1,3,2,0};
        System.out.println(find132pattern(nums));
    }

    public static boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; --i) {
            int num = nums[i];
            if (num < third) {
                return true;
            }

            while (!stack.isEmpty() && stack.peek() < num) {
                third = stack.pop();
            }

            stack.push(num);
        }

        return false;
    }
}
