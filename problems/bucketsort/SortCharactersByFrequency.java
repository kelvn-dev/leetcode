package problems.bucketsort;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s));
    }

    /**
     * 1. Count frequency of each character
     * 2. Create buckets where each index corresponds to characters that have that frequency
     */
    public static String frequencySort(String s) {
        // step 1
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // step 2
        int maxFrequency = s.length();
        List<Character>[] buckets = new List[maxFrequency + 1];
        for (char c : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(c);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(c);
        }

        // build result
        StringBuilder sb = new StringBuilder();
        for (int i = maxFrequency; i > 0; --i) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }

    /**
     * Optimal using heap
     * 1. Count frequency of each character
     * 2. Use max-heap to store frequency in decreasing order
     */
    public static String frequencySortUsingHeap(String s) {
        // step 1
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c: s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // step 2
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(Comparator.comparingInt((Map.Entry<Character, Integer> entry) -> entry.getValue()).reversed());
        for (Map.Entry<Character, Integer> entry: frequencyMap.entrySet()) {
            maxHeap.add(entry);
        }

        // build result
        StringBuilder stringBuilder = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char c = entry.getKey();
            int frequency = entry.getValue();
            for (int i = 0; i < frequency; ++i) {
                stringBuilder.append(c);
            }
        }

        return stringBuilder.toString();
    }
}
