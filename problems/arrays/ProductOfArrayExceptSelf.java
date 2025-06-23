package problems.arrays;

/**
 * we can use two auxiliary arrays to store the product of all elements to the left and to the right of each index.
 * This way, we can construct the result array by multiplying the prefix and suffix products
 *
 * Create two arrays prefix and suffix, both of size n.
 * Fill the prefix array such that prefix[i] holds the product of all elements to the left of i.
 * Fill the suffix array such that suffix[i] holds the product of all elements to the right of i.
 * For the result array, multiply the corresponding values of prefix and suffix.
 *
 * To optimize our space usage, we can eliminate the suffix array and calculate the right product on the fly
 * while filling up the result array
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        for (int i: result) {
            System.out.print(i + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] result = new int[nums.length];

        prefix[0] = 1;
        for (int i = 1; i < prefix.length; ++i) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        suffix[suffix.length - 1] = 1;
        for (int i = suffix.length - 2; i >= 0; --i) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < nums.length; ++i) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}
