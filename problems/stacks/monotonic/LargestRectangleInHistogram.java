package problems.stacks.monotonic;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = new int[] {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {
        int index = 0;
        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        while (index < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] < heights[index]) {
                stack.push(index++);
            } else {
                int top = stack.pop();
                int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
                max = Math.max(max, area);
            }
        }

        while (!stack.isEmpty()) {
            int top = stack.pop();
            int area = heights[top] * (stack.isEmpty() ? index : index - stack.peek() - 1);
            max = Math.max(max, area);
        }

        return max;
    }
}
