import java.io.*;
import java.util.*;

/**
 * Example:
 *  * Input: nums = [2, 1, 2, 4, 3]
 *  * Output: [4, 2, 4, -1, -1]
 */
public class Temp {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Integer> list = Arrays.asList(1, 2, 3);
        for (int i = 0; i < list.size(); ++i) {
            int item = list.get(i);
            int num = item++ + ++item;
            System.out.println(num);
        }
    }

    public static int process(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int pivot = (start + end) / 2;
            if (nums[pivot] == k) {
                return pivot;
            }

            if (nums[start] < nums[pivot]) {
                if (nums[start] <= k && k < nums[pivot]) {
                    end = pivot - 1;
                } else {
                    start = pivot + 1;
                }
            } else {
                if (nums[pivot] < k && k <= nums[end]) {
                    start = pivot + 1;
                } else {
                    end = pivot - 1;
                }
            }

        }
        return -1;
    }
}
