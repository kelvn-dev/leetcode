package pattern;

import java.util.*;

/**
 * Used to merge or handle overlapping intervals in an array (2 intervals [a, b] and [c, d] overlap if b >= c)
 *
 * Sample Problem:
 * Given a list of intervals, merge all overlapping intervals.
 * Input: intervals = [[1, 3], [2, 6], [8, 10], [15, 18]]
 * Output: [[1, 6], [8, 10], [15, 18]]
 *
 * Explanation:
 * Sort the intervals by their start time.
 * Create an empty list called merged to store the merged intervals.
 * Iterate through the intervals and check if it overlaps with the last interval in the merged list.
 * If it overlaps, merge the intervals by updating the end time of the last interval in merged.
 * If it does not overlap, simply add the current interval to the merged list.
 */
public class OverlappingInterval {
  public static void main(String[] args) {
    List<int[]> intervals = new ArrayList<>(Arrays.asList(
      new int[]{1, 3},
      new int[]{2, 6},
      new int[]{8, 10},
      new int[]{15, 18}
    ));

    List<int[]> merged = getMergedIntervals(intervals);
    for (int[] interval : merged) {
      System.out.println(interval[0] + " " + interval[1]);
    }
  }

  public static List<int[]> getMergedIntervals(List<int[]> intervals) {
    List<int[]> merged = new ArrayList<>();
    intervals.sort(Comparator.comparingInt(arr -> arr[0]));

    for(int[] i: intervals) {
      if (merged.isEmpty()) {
        merged.add(i);
        continue;
      }

      int[] lastInterval = merged.get(merged.size() - 1);
      if (lastInterval[1] >= i[0]) {
        lastInterval[1] = i[1];
        merged.set(merged.size() - 1, lastInterval);
      } else {
        merged.add(i);
      }
    }

    return merged;
  }
}
