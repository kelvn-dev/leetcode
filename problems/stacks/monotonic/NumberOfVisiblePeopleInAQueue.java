package problems.stacks.monotonic;

import java.util.Stack;

public class NumberOfVisiblePeopleInAQueue {
    public static void main(String[] args) {
        int[] heights = new int[] {10,6,8,5,11,9};
        int[] result = canSeePersonsCount(heights);
        for (int i: result) {
            System.out.print(i + " ");
        }
    }

    public static int[] canSeePersonsCount(int[] heights) {
        int[] result = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = heights.length - 1; i >= 0; --i) {
            int height = heights[i];
            int count = 0;
            while (!stack.isEmpty() && stack.peek() < height) {
                ++count;
                stack.pop();
            }

            if (!stack.isEmpty()) {
                ++count;
            }
            result[i] = count;
            stack.push(height);
        }

        return result;
    }
}
