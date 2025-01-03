package problems.arrays;

import java.util.Arrays;

/**
 * https://neetcode.io/problems/products-of-array-discluding-self
 */
public class ProductsOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                ++zeroCount;
                continue;
            }
            product *= num;
        }

        int[] productExceptSelf = new int[nums.length];

        if (zeroCount > 1) {
            return productExceptSelf;
        }

        for (int i = 0; i < nums.length; ++i) {
            if (zeroCount == 0) {
                productExceptSelf[i] = product / nums[i];
            } else if (nums[i] != 0) {
                productExceptSelf[i] = 0;
            } else {
                productExceptSelf[i] = product;
            }
        }
        return productExceptSelf;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3};
        int[] output = productExceptSelf(input);
        Arrays.stream(output).forEach(System.out::println);
    }
}