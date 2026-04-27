package codility;

import java.util.Stack;

/**
 * https://app.codility.com/programmers/lessons/7-stacks_and_queues/brackets/
 * ensure that each closing bracket matches the most recent opening bracket
 */
public class Bracket {
    public static void main(String[] args) {

    }

    public int solution(String S) {
        if (S.length() % 2 != 0) {
            return 0;
        }
        Stack<Character> stack = new Stack<>();
        for (char ch : S.toCharArray()) {
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return 0;
                char stackTop = stack.peek();
                if (ch == '}' && stackTop != '{') return 0;
                if (ch == ']' && stackTop != '[') return 0;
                if (ch == ')' && stackTop != '(') return 0;
                stack.pop();
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
