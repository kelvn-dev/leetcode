package problems.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 *  Given an integer array, find the number that has most occurrence
 *
 * Input: nums = [3, 2, 3]
 * Output: 3
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = new int[] {3, 3, 4};
        int result = majorityElement(nums);
        System.out.print(result);
    }

    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int max = -1;
        int maxValue = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                max = entry.getKey();
            }
        }

        return max;
    }
}
