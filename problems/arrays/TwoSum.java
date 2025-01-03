package problems.arrays;

import java.util.*;

/**
 * https://neetcode.io/problems/two-integer-sum
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2,-3,-4,-5};
        int target = -8;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::println);
    }
}
