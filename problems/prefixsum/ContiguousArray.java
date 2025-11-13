package problems.prefixsum;

import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
//        int[] nums = new int[] {0, 1, 1, 1, 1, 1, 0, 0, 0};
        int[] nums = new int[] {0, 1, 0, 1};
        System.out.println(findMaxLength(nums));
    }

    /**
     * maintain a prefix sum where we treat 0 as -1 and 1 as 1 and store index into map
     * if two indices have the same prefix sum, the subarray between them has an equal number of 0s and 1s
     * Note: not update index for the same sum to take the most far index
     */
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;

            if (map.containsKey(sum)) {
                int prevIndex = map.get(sum);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
