package problems.stacks;

import java.util.Stack;

class MinStack {

    private Stack<Integer> stack;
    private int min;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            min = val;
        } else if (val <= min) {
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

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top();    // return 0
        minStack.getMin(); // return -2
    }
}
