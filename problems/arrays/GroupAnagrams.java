package problems.arrays;

import java.util.*;

/**
 * https://neetcode.io/problems/anagram-groups
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> mapAnagrams = new HashMap<>();
        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sortedStr = Arrays.toString(chars);
            mapAnagrams.putIfAbsent(sortedStr, new ArrayList<>());
            mapAnagrams.get(sortedStr).add(s);
        }

        return new ArrayList<>(mapAnagrams.values());
    }

    public static void main(String[] args) {
        String[] input = new String[]{"act","pots","tops","cat","stop","hat"};
        List<List<String>> output = groupAnagrams(input);
        for (int i = 0; i < output.size(); ++i) {
            System.out.println(i);
            output.get(i).forEach(System.out::println);
        }
    }
}
