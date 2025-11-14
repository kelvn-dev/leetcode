package problems.slidingwindow.fixedsize;

import java.util.*;

public class SubstringWithConcatenationOfAllWords {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[] {"word","good","best","good"};
        List<Integer> result = findSubstring(s, words);
        result.forEach(System.out::println);
    }

    /**
     * wordSize is length of 1 word, wordLength is total length of all words
     * 1. Create a hashmap wordMap containing the frequency of each word
     * 2. For each iterating:
     * - 2.1 get substring with length equals to wordLength
     * - 2.2 to check if this substring is a permutation, get list substrings with length equals to wordSize
     * - 2.3 put these substrings to a map, then compare this map with wordMap
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        if (words.length < 1) {
            return new ArrayList<>();
        }

        int wordSize = words[0].length();
        int wordLength = wordSize * words.length;
        if (s.length() < wordLength) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        // step 1
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word: words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - wordLength; ++i) {
            // 2.1
            String string = s.substring(i, i + wordLength);
            // 2.2 + 2.3
            Map<String, Integer> stringMap = transform(string, wordSize);
            if (stringMap.equals(wordMap)) {
                result.add(i);
            }
        }

        return result;
    }

    public static Map<String, Integer> transform(String s, int size) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i += size) {
            String key = s.substring(i, i + size);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return map;
    }
}
