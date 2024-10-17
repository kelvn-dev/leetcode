package pattern;

/**
 * Use this pattern when dealing with sorted arrays where you need to find pairs that satisfy a specific condition.
 * Sample Problem:
 * Find two numbers in a sorted array that add up to a target value.
 *
 * Example:
 * Input: nums = [1, 2, 3, 4, 6], target = 6
 * Output: [1, 3]
 *
 * Explanation:
 * Initialize two pointers, one at the start (left) and one at the end (right) of the array.
 * Check the sum of the elements at the two pointers.
 * If the sum equals the target, return the indices.
 * If the sum is less than the target, move the left pointer to the right.
 * If the sum is greater than the target, move the right pointer to the left.
 */
public class TwoPointers {
  public static void main(String[] args) {
    int[] array = {1, 2, 3, 4, 6};
    int[] indices = getPairOfIndices(array, 6);
    for (int i: indices) {
      System.out.println(i);
    }
  }

  // O(n)
  public static int[] getPairOfIndices(int[] array, int target) {
    int length = array.length;
    int left = 0;
    int right = length - 1;
    while (left < right) {
      int sum = array[left] + array[right];
      if (sum == target) {
        return new int[]{left, right};
      }
      if (sum < target) {
        ++left;
      } else {
        --right;
      }
    }
    return new int[]{-1, -1};
  }
}
