package problems.prefixsum;

import java.util.HashMap;

public class SubarraySumsDivisibleByK {
    public static void main(String[] args) {
        int[] nums = new int[] {-1, 5, 3};
        int k = 3;
        int result = subarraysDivByK(nums, k);
        System.out.println(result);
    }

    /**
     * sum[0..i] get remainder 2, sum[0..j] must be sum[0..i] + number that % k == 0 to get the same remainder 2
     */
    public static int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        int sum = 0;
        for (int num: nums) {
            sum += num;
            int remainder = sum % k;

            // convert negative remainders into a positive range [0,K-1]
            if (remainder < 0) {
                remainder += k;
            }

            if (map.containsKey(remainder)) {
                count += map.get(remainder);
            }
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }

        return count;
    }
}
