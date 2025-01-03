package problems.arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;

/**
 * https://neetcode.io/problems/duplicate-integer
 */
public class ContainsDuplicate {
    public static boolean hasDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            set.add(nums[i]);
            if (set.size() != i + 1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(hasDuplicate(nums));
    }
}
