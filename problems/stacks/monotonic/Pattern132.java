package problems.stacks.monotonic;

import java.util.Stack;

public class Pattern132 {
    public static void main(String[] args) {
        int[] nums = new int[] {-1,3,2,0};
        System.out.println(find132pattern(nums));
    }

    /**
     * iterate right to left
     * stack store numbers in ascending order: peek -> 1, 3, 5
     * this stack store candidates for max number, if removed, it becomes second max number
     * secondMaxNumber track the second max number
     * secondMaxNumber only != Integer.MIN_VALUE when max number exist
     */
    public static boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int secondMaxNumber = Integer.MIN_VALUE;
        for (int i = nums.length - 1; i >= 0; --i) {
            int num = nums[i];
            if (num < secondMaxNumber) {
                return true;
            }

            while (!stack.isEmpty() && stack.peek() < num) {
                secondMaxNumber = stack.pop();
            }

            stack.push(num);
        }

        return false;
    }
}
