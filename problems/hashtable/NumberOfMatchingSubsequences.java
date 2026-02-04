package problems.hashtable;

import java.util.*;

/**
 * List maintain insertion order
 * Collections.binarySearch return negative value to differentiate between found and insertion.
 * Formula to get back insertion index is -n - 1
 */
public class NumberOfMatchingSubsequences {
    public static void main(String[] args) {
        String s = "abcbd";
        String[] words = {"acc"};
        System.out.println(numMatchingSubseq(s, words));
    }

    public static int numMatchingSubseq(String s, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            map.computeIfAbsent(c, e -> new ArrayList<>()).add(i);
        }

        int count = 0;
        for (String word: words) {
            if (isMatch(map, word)) {
                ++count;
            }
        }

        return count;
    }

    public static boolean isMatch(Map<Character, List<Integer>> map, String word) {
        int lastIndex = 0;
        for (char c: word.toCharArray()) {
            if (!map.containsKey(c)) {
                return false;
            }

            List<Integer> indexRange = map.get(c);
            int insertedPosition = Collections.binarySearch(indexRange, lastIndex);
            if (insertedPosition < 0) {
                insertedPosition = -insertedPosition - 1;
            }

            if (insertedPosition == indexRange.size()) {
                return false;
            }

            lastIndex = indexRange.get(insertedPosition) + 1;
        }

        return true;
    }
}
