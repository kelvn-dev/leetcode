package problems.topkelements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public static void main(String[] args) {
        int[] array = new int[] {1,1,1,2,2,3};
        int k = 2;
        int [] result = topKFrequent(array, k);
        for (int i: result) {
            System.out.print(i + " ");
        }
    }

    /**
     * 1. Count frequency of each character
     * 2. Use min-heap to keep track of the top k elements
     */
    public static int[] topKFrequent(int[] nums, int k) {
        // step 1
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // step 2
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(entry -> entry.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.add(entry);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // build result
        int[] result = new int[k];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry: minHeap) {
            result[index] = entry.getKey();
            ++index;
        }

        return result;
    }

}
