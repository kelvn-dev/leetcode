package problems.prefixsum;

import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
//        int[] nums = new int[] {0, 1, 1, 1, 1, 1, 0, 0, 0};
        int[] nums = new int[] {0, 1, 0, 1};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
        sumIndexMap.put(0, -1);
        int maxLength = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;

            if (sumIndexMap.containsKey(sum)) {
                int prevIndex = sumIndexMap.get(sum);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                sumIndexMap.put(sum, i);
            }
        }

        return maxLength;
    }
}
