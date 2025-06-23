package problems.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * The underlying idea is that rotating an array is equivalent to reversing parts of the array.
 *
 * Reverse the entire array.
 * Reverse the first k elements.
 * Reverse the elements from k to the end.
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        for (int num: nums) {
            System.out.print(num + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        int countToRotate = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, countToRotate - 1);
        reverse(nums, countToRotate, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            ++start;
            --end;
        }
    }

}
