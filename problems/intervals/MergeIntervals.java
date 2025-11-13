package problems.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {
                {1,4},
                {0,0},

        };
        int[][] result = merge(intervals);
        for (int[] interval: result) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        for (int[] interval: intervals) {
            if (mergedIntervals.isEmpty()) {
                mergedIntervals.add(interval);
                continue;
            }

            int[] lastInterval = mergedIntervals.get(mergedIntervals.size() - 1);
            if (lastInterval[1] >= interval[0]) {
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
                mergedIntervals.set(mergedIntervals.size() - 1, lastInterval);
            } else {
                mergedIntervals.add(interval);
            }
        }

        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
