package problems.stacks;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack;
    private int min;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
        } else if (val < min) {
            stack.push(min);
            min = val;
        }

        stack.push(val);
    }

    public void pop() {
        if (stack.pop() == min && !stack.isEmpty()) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */