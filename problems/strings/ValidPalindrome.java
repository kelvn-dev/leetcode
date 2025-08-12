package problems.strings;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "0P";
        boolean result = isPalindrome(s);
        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();
        Queue<Character> queue = new ArrayDeque<>();

        char[] chars = s.toLowerCase().toCharArray();
        for(Character c: chars) {
            if (Character.isLetterOrDigit(c)) {
                stack.push(c);
                queue.add(c);
            }
        }

        for (int i = 0; i < stack.size(); ++i) {
            if (!stack.pop().equals(queue.poll())) {
                return false;
            }
        }

        return true;
    }
}
