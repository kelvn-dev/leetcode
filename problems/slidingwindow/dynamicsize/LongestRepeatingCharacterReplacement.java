package problems.slidingwindow.dynamicsize;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }

    /**
     * Should see MaxConsecutiveOnesIII first
     *
     * maxFrequency is frequency of a character that appeared mostly from left to current position
     * For each iterating:
     * 1. Increment the frequency of the right character and update maxFrequency
     * 2. Adjust window size to always satisfy:
     * (right - left + 1) - maxFrequency = frequency of other characters need to be replaced => this must be <= k
     *
     *     maxFrequency     k
     * |-----------------|------|
     * left                   right
     */
    public static int characterReplacement(String s, int k) {
        int left = 0, maxFrequency = 0, maxLength = 0;
        int[] frequency = new int[26];

        for (int right = 0; right < s.length(); ++right) {
            // step 1
            maxFrequency = Math.max(maxFrequency, ++frequency[s.charAt(right) - 'A']);

            /**
             * step 2
             * Window size: right - left + 1
             * Calculate if replacements exceed k
             */
            while (right - left + 1 - maxFrequency > k) {
                --frequency[s.charAt(left) - 'A'];
                ++left;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
