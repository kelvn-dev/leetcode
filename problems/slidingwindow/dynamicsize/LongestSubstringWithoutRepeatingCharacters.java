package problems.slidingwindow.dynamicsize;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * Using StringBuilder, for each iterating:
     * - before adding new character, check if this character already presented, compare StringBuilder's length and max, then remove until it
     */
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            int lastOccurence = stringBuilder.indexOf(String.valueOf(c));
            if (lastOccurence != -1) {
                max = Math.max(max, stringBuilder.length());
                stringBuilder.delete(0, lastOccurence + 1);
            }

            stringBuilder.append(s.charAt(i));
        }

        return Math.max(max, stringBuilder.length());
    }
}
