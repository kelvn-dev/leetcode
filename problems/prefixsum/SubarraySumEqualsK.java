package problems.prefixsum;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3, 0 , 2, 1};
        // 1, 3, 6, -3, -1, 0
        int k = 3;
        int result = subarraySum(nums, k);
        System.out.println(result);
    }

    /**
     * prefix[j] - prefix[i] = k => prefix[j] - k = prefix[i]
     * where prefix[i] is sum of previous elements => store the frequency of this and retrieve it
     */
    public static int subarraySum(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for (int num: nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
