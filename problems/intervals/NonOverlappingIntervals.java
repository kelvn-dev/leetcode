package problems.intervals;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,2},{2,3},{3,4},{1,3}
        };
        System.out.println(eraseOverlapIntervals(intervals));
    }

    /**
     * 1. Sort by end interval
     * 2. If current starts before the last ends, increase remove counter, otherwise update ends
     */
    public static int eraseOverlapIntervals(int[][] intervals) {
        // Step 1
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int count = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // step 2
            if (lastEnd > intervals[i][0]) {
                count++;
            } else {
                lastEnd = intervals[i][1];
            }
        }

        return count;
    }
}
