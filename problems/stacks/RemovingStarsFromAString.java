package problems.stacks;

import java.util.Stack;

public class RemovingStarsFromAString {
    public static void main(String[] args) {
        String s = "leet**cod*e";
        System.out.println(removeStars(s));
    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c != '*') {
                stack.add(c);
                continue;
            }

            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : stack) {
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }
}
