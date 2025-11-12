package problems.bucketsort;

import java.util.*;

public class TopKFrequentWords {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k = 2;
        List<String> result = topKFrequent(words, k);
        result.stream().forEach(System.out::println);
    }

    /**
     * Same as topkelements.TopKFrequentElements
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word: words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((entry1, entry2) ->
                entry1.getValue().equals(entry2.getValue()) ? entry2.getKey().compareTo(entry1.getKey()) : entry1.getValue().compareTo(entry2.getValue())
        );

        for (Map.Entry<String, Integer> entry: frequencyMap.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        List<String> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(0, minHeap.poll().getKey());
        }

        return result;
    }
}
