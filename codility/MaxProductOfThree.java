package codility;

import java.util.Arrays;

/**
 * https://app.codility.com/programmers/lessons/6-sorting/max_product_of_three/
 * Three largest numbers
 * Two smallest (most negative) and one largest
 */
public class MaxProductOfThree {
    public static void main(String[] args) {

    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        int productOfThreeLargest = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int productOfLargestAndTwoSmallest = nums[n - 1] * nums[0] * nums[1];

        return Math.max(productOfThreeLargest, productOfLargestAndTwoSmallest);
    }

}
