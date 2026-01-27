package problems.arrays;

import java.util.Arrays;

/**
 * Place each number at its correct index (i.e., number 1 at index 0, number 2 at index 1, etc.). Numbers out of this range can be ignored.
 * Swap position so that nums[i] should be at index nums[i] - 1 (number 1 (nums[i]) at index 0 (nums[nums[i] - 1]))
 * Finally, the first place where the number is not equal to the index + 1 is the missing number.
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = new int[] {3,4,-1,1};
        int result = firstMissingPositive(nums);
        System.out.println(result);
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Swap numbers to their correct positions
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }
}
