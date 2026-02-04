package problems.hashtable;

import java.util.HashMap;
import java.util.Map;

public class ReorganizeString {
    public static void main(String[] args) {
        String s = "aaabc";
        System.out.println(reorganizeString(s));
    }

    /**
     * 1. Count frequency
     * 2. Find character with max frequency, if maxFre > (length + 1) / 2 => false
     * 3. Start filling result with even positions for maximum frequency character, then fill odd positions
     */
    public static String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char maxFrequencyCharacter = ' ';
        int maxFrequency = Integer.MIN_VALUE;
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();

            if (value > maxFrequency) {
                maxFrequency = value;
                maxFrequencyCharacter = key;
            }
        }

        if (maxFrequency > (s.length() + 1) / 2) {
            return "";
        }

        char[] result = new char[s.length()];
        int index = 0;
        for (int i = 0; i < maxFrequency; ++i) {
            result[index] = maxFrequencyCharacter;
            index += 2;
        }

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (key == maxFrequencyCharacter) {
                continue;
            }

            for (int i = 0; i < value; ++i) {
                if (index >= result.length) {
                    index = 1;
                }
                result[index] = key;
                index += 2;
            }
        }

        return String.valueOf(result);
    }
}
