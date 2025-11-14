package problems.slidingwindow.dynamicsize;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        String result = minWindow(s, t);
        System.out.println(result);
    }

    /**
     * 1. use map tFreq to store frequency of t
     * 2. increase right index, use windowFreq to store frequency of s
     * 3. If all characters are matched, try to shrink the window
     */
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";

        HashMap<Character, Integer> tFreq = new HashMap<>();
        HashMap<Character, Integer> windowFreq = new HashMap<>();

        // step 1
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int matched = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            // step 2
            char c = s.charAt(right);
            windowFreq.put(c, windowFreq.getOrDefault(c, 0) + 1);

            if (tFreq.containsKey(c) && tFreq.get(c).intValue() == windowFreq.get(c).intValue()) {
                ++matched;
            }

            // step 3
            while (matched == tFreq.size()) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    start = left;
                }

                // Remove the character at the left pointer from the window
                char leftChar = s.charAt(left);
                windowFreq.put(leftChar, windowFreq.get(leftChar) - 1);
                if (tFreq.containsKey(leftChar) && tFreq.get(leftChar) > windowFreq.get(leftChar)) {
                    --matched;
                }
                ++left;
            }

            ++right;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
