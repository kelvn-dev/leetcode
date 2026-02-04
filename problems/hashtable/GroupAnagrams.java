package problems.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        int CAPACITY = 26;
        Map<String, List<String>> map = new HashMap<>();
        for (String s: strs) {
            int[] frequencyArrray = new int[CAPACITY];
            for (char c: s.toCharArray()) {
                ++frequencyArrray[c - 'a'];
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (int frequency: frequencyArrray) {
                stringBuilder.append(frequency).append("#");
            }

            String buildedString = stringBuilder.toString();

            map.computeIfAbsent(buildedString, e -> new ArrayList<>()).add(s);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> values: map.values()) {
            result.add(values);
        }

        return result;
    }
}
