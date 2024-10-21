package pattern;

import java.util.Arrays;
import java.util.Stack;

/**
 * Use this pattern for problems that require finding the next greater or smaller element
 * by using a stack to maintain a sequence of elements in a specific order (increasing or decreasing)
 *
 * Sample Problem:
 * Find the next greater element for each element in an array. Output -1 if the greater element doesn’t exist.
 *
 * Example:
 * Input: nums = [2, 1, 2, 4, 3]
 * Output: [4, 2, 4, -1, -1]
 *
 * Explanation:
 * Initialize a result array of the same size as nums with -1
 * Traverse the nums array from right to left
 * For each element, pop elements from the stack until you find a greater element or the stack becomes empty
 * The top of the stack will be the next greater element for the current element, and push the current element to the stack for future comparisons
 */
public class MonotonicStack {
  public static void main(String[] args) {
    int[] array = new int[]{2, 1, 2, 4, 3};
    int[] result = findNextGreaterElement(array);
    for(int i: result) {
      System.out.println(i);
    }
  }

  public static int[] findNextGreaterElement(int[] array) {
    int[] result = new int[array.length];
    Arrays.fill(result, -1);
    Stack<Integer> stack = new Stack<>();  // Stack to store elements in decreasing order

    // Traverse the array from right to left
    for(int i = array.length - 1; i >= 0; --i) {

      // Pop elements from the stack until we find a greater element or stack becomes empty
      while (!stack.isEmpty() && array[i] >= stack.peek()) {
        stack.pop();
      }

      // If the stack is not empty, the top is the next greater element
      if (!stack.isEmpty()) {
        result[i] = stack.peek();
      }

      // Push the current element to the stack
      stack.push(array[i]);
    }

    return result;
  }

}
