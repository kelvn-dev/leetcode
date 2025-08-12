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
     * Optimized version
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        if (s.length() == 0 || words.length == 0 || words[0].length() == 0) return results;

        int wordLength = words[0].length();
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            int left = i, count = 0;
            Map<String, Integer> seenWords = new HashMap<>();
            for (int right = left; right <= s.length() - wordLength; right += wordLength) {
                String word = s.substring(right, right + wordLength);
                if (wordCount.containsKey(word)) {
                    seenWords.put(word, seenWords.getOrDefault(word, 0) + 1);
                    count++;
                    while (seenWords.get(word) > wordCount.get(word)) {
                        String leftWord = s.substring(left, left + wordLength);
                        seenWords.put(leftWord, seenWords.get(leftWord) - 1);
                        count--;
                        left += wordLength;
                    }
                    if (count == words.length) {
                        results.add(left);
                    }
                } else {
                    left = right + wordLength;
                    seenWords.clear();
                    count = 0;
                }
            }
        }
        return results;
    }

    /**
     * Raw version
     */
    public static List<Integer> findSubstringRawVersion(String s, String[] words) {
        if (words.length < 1) {
            return new ArrayList<>();
        }

        int wordSize = words[0].length();
        int wordLength = wordSize * words.length;
        if (s.length() < wordLength) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word: words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - wordLength; ++i) {
            String string = s.substring(i, i + wordLength);
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
