package problems.intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InsertInterval {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},
                {3,5},
                {6,7},
                {8,10},
                {12,16}
        };
        int[] newInterval = {4,8};
        int[][] result = insert(intervals, newInterval);
        for (int[] interval: result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }

    /**
     * 1. Add all intervals before the newInterval
     * 2. Merge intervals that overlap with the newInterval
     * 3. Add remaining intervals
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        int index = 0;

        // step 1
        while (index < intervals.length && intervals[index][1] < newInterval[0]) {
            result.add(intervals[index]);
            ++index;
        }

        // step 2
        while (index < intervals.length && newInterval[1] >= intervals[index][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            ++index;
        }
        result.add(newInterval);

        // step 3
        while (index < intervals.length) {
            result.add(intervals[index]);
            ++index;
        }

        return result.toArray(new int[result.size()][]);
    }
}
