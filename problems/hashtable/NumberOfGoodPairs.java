package problems.hashtable;

import java.util.HashMap;
import java.util.Map;

public class NumberOfGoodPairs {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1, 1};
        System.out.println(numIdenticalPairs(nums));
    }

    public static int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num: nums) {
            if (map.containsKey(num)) {
                int frequency = map.get(num);
                count += frequency;
                map.put(num, frequency + 1);
            } else {
                map.put(num, 1);
            }
        }

        return count;
    }
}
