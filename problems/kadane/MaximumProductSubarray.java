package problems.kadane;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = new int[] {-2,3,-4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int max = nums[0];
        int min = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int tempMax = max;

            max = Math.max(num, Math.max(max * num, min * num));
            min = Math.min(num, Math.min(tempMax * num, min * num));

            result = Math.max(result, max);
        }
        return result;
    }
}
