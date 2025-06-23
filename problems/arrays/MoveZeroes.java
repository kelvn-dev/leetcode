package problems.arrays;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 *
 * Input: nums = [0, 1, 0, 3, 12]
 * Output: [1, 3, 12 ,0 ,0]
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for(int i: nums) {
            System.out.print(i + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int positionToSwap = 0;
        for(int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[positionToSwap] = nums[i];
                nums[i] = 0;
                ++positionToSwap;
            }
        }
    }
}
