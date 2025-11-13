package problems.prefixsum;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[] {2,4,3};
        int k = 6;
//        int[] nums = new int[] {5,0,0,0};
//        int k = 3;
        boolean result = checkSubarraySum(nums, k);
        System.out.println(result);
    }

    /**
     * Same as SubarraySumsDivisibleByK but Store index of remainder, when found, check currentIndex - storedIndex > 1
     * Note: not update index for the same remainder to take the most far index
     */
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;

            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i - prevIndex > 1) {
                    return true;
                }
            } else {
                map.put(remainder, i);
            }
        }
        return false;
    }
}
