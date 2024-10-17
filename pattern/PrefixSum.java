package pattern;

/**
 * Prefix Sum involves preprocessing an array to create a new array where each element at index i represents the sum of the array from the start up to i.
 * Use this pattern when you need to perform multiple sum queries on a subarray
 * To find the sum between indices i and j, use the formula: P[j] - P[i-1]. If i is zero, just return P[j]
 *
 * Example:
 * Input: nums = [1, 2, 3, 4, 5, 6], i = 1, j = 3
 * Output: 9
 *
 * Explanation:
 * Preprocess the array A to create a prefix sum array: P = [1, 3, 6, 10, 15, 21]
 * To find the sum between indices i and j, use the formula: P[j] - P[i-1]
 */
public class PrefixSum {
  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 3, 4, 5, 6};
    int result = getSumOfSubArray(nums, 0, 3);
    System.out.println(result);
  }

  public static int[] preprocess(int[] nums) {
    int[] prefixSum = new int[nums.length];
    int sum = 0;
    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      prefixSum[i] = sum;
    }
    return prefixSum;
  }

  public static int getSumOfSubArray(int[] nums, int indexStart, int indexEnd) {
    int[] prefixSum = preprocess(nums);
    if (indexStart == 0) {
      return prefixSum[indexEnd];
    }
    return prefixSum[indexEnd] - prefixSum[indexStart - 1];
  }
}
