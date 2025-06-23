package problems.arrays;

/**
 * Formula is zeroCount * (zeroCount + 1) / 2
 */
public class NumberOfZeroFilledSubarrays {
    public static void main(String[] args) {
        int[] nums = new int[] {1,3,0,0,2,0,0,4};
        long result = zeroFilledSubarray(nums);
        System.out.println(result);
    }

    public static long zeroFilledSubarray(int[] nums) {
        long result = 0;
        int zeroCount = 0;

        for (int num: nums) {
            if (num == 0) {
                ++zeroCount;
            } else {
                result += (long) zeroCount * (zeroCount + 1) / 2;
                zeroCount = 0;
            }
        }
        result += (long) zeroCount * (zeroCount + 1) / 2;
        return result;
    }
}
