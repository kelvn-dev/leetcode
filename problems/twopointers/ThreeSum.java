package problems.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[] {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        result.forEach(r -> {
            r.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
        // [[-1,-1,2],[-1,0,1]]
        // -4, -1, -1, 0, 1, 2
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; ++i) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int head = i + 1;
                int tail = nums.length - 1;
                while (head < tail) {
                    int sum = nums[i] + nums[head] + nums[tail];
                    if (sum == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[head], nums[tail]);
                        result.add(triplet);
                        while (head < tail && nums[head] == nums[head + 1]) {
                            ++head;
                        }
                        while (head < tail && nums[tail] == nums[tail - 1]) {
                            --tail;
                        }
                        ++head;
                        --tail;
                        continue;
                    }

                    if (sum < 0) {
                        ++head;
                    } else {
                        --tail;
                    }
                }
            }
        }

        return result;
    }
}
