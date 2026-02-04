package problems.hashtable;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {1,0,1,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }

        int max = Integer.MIN_VALUE;
        for (int i: set) {
            if (!set.contains(i - 1)) {
                int count = 1;
                while (set.contains(i + count)) {
                    ++count;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
