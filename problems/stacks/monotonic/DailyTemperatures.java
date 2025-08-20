package problems.stacks.monotonic;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = new int[] {73,74,75,71,69,72,76,73};
        int[] result = dailyTemperatures(temperatures);
        for (int i: result) {
            System.out.print(i + " ");
        }
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int result[] = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; --i) {
            int num = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] <= num) {
                stack.pop();
            }

            result[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return result;
    }
}
