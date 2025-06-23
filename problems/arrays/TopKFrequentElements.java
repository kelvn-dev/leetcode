package problems.arrays;

import java.util.*;

/**
 * https://neetcode.io/problems/top-k-elements-in-list
 */
public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<int[]> arr = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            arr.add(new int[]{entry.getValue(), entry.getKey()});
        }

        arr.sort((num1, num2) -> num2[0] - num1[0]);
        int result[] = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = arr.get(i)[1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2};
        int k = 2;
        int[] output = topKFrequent(input, k);
        for (int i: output) {
            System.out.println(i);
        }
    }
}
