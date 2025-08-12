package problems.slidingwindow.dynamicsize;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * Using StringBuilder
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

    /**
     * Using HashMap
     */
    public static int lengthOfLongestSubstringUsingMap(String s) {
        int n = s.length();
        int maxLength = 0;
        int i = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                maxLength = Math.max(maxLength, j - i);
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            map.put(s.charAt(j), j);
        }

        return Math.max(maxLength, s.length() - i);
    }
}
