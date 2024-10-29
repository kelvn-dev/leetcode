package pattern;

import java.util.*;

/**
 * Use this pattern to find the top k largest or smallest elements in an unsorted array of data using heaps
 * Use sorting will be simpler but time complexity will be higher
 *
 * Sample Problem:
 * Find the k-th largest element in an unsorted array.
 *
 * Example:
 * Input: nums = [3, 2, 1, 5, 6, 4], k = 2
 * Output: 5
 *
 * Explanation:
 * Use a min-heap of size k to keep track of the k largest elements -> peek will be the top K largest.
 * Iterate through the array, adding elements to the heap.
 * If the heap size exceeds k, remove the smallest element from the heap.
 * The root of the heap will be the k-th largest element.
 */
public class TopKElement {
  public static void main(String[] args) {
    int[] array = new int[]{3, 2, 1, 5, 6, 4};
    int k = 2;
    int result = getTopKElementUsingHeap(array, k);
    System.out.println(result);
  }

  public static int getTopKElementUsingHeap(int[] array, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    for(int i: array) {
      minHeap.add(i);
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    return Objects.isNull(minHeap.peek()) ? -1 : minHeap.peek();
  }

  /**
   * Interview question
   */
  public static int getSecondMaxIndexWith1Loop(int[] array) {
    if (array.length == 0) {
      return -1;
    }
    if (array.length == 1) {
      return array[0];
    }
    int maxIndex = 0;
    int secondMaxIndex = 0;
    for(int i = 0; i < array.length; i++) {
      if (array[i] > array[maxIndex]) {
        secondMaxIndex = maxIndex;
        maxIndex = i;
      } else if (array[i] > array[secondMaxIndex]) {
        secondMaxIndex = i;
      }
    }
    return secondMaxIndex;
  }

  public static int getIndexOfTopKElement(int[] array, int k) {
    PriorityQueue<Integer[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
    for(int i = 0; i < array.length; i++) {
      minHeap.add(new Integer[]{array[i], i});
      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }
    return Objects.isNull(minHeap.peek()) ? -1:  minHeap.peek()[1];
  }
}
