package problems.stacks;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }

    public static String removeDuplicateLetters(String s) {
        int[] lastOccurrence = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i; // last occurrence of every char
        }

        boolean[] inStack = new boolean[26]; // to track if the character is in stack to avoid repetition
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (inStack[current - 'a']) continue; // if already added in result

            // Remove characters from the stack if they appear later and the current character is smaller
            while (!stack.isEmpty() && stack.peek() > current && lastOccurrence[stack.peek() - 'a'] > i) {
                inStack[stack.pop() - 'a'] = false;
            }

            stack.push(current);
            inStack[current - 'a'] = true;
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }

        return result.toString();
    }
}
