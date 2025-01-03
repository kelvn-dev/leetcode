package problems.arrays;

import java.util.*;

/**
 * https://neetcode.io/problems/longest-consecutive-sequence
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;

    }

    public static void main(String[] args) {
//        int[] input = new int[]{0,3,2,5,4,6,1,1};
        int[] input = new int[]{2,20,4,10,3,4,5};
        int output = longestConsecutive(input);
        System.out.println(output);
    }
}
