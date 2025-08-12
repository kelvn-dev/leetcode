package problems.prefixsum;

import java.util.HashMap;

public class ContinuousSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[] {6 ,1, 5};
        int k = 6;
        boolean result = checkSubarraySum(nums, k);
        System.out.println(result);
    }

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
                if (i - map.get(remainder) > 1) {
                    return true;
                }
            }
            map.put(remainder, i);
        }
        return false;
    }
}
