package pattern;

/**
 * Sample Problem:
 * Find an element in a rotated sorted array.
 * Input: nums = [4, 5, 6, 7, 0, 1, 2], target = 0
 * Output: 4
 *
 * Explanation:
 * Perform binary search with an additional check to determine which half of the array is sorted.
 * We then check if the target is within the range of the sorted half.
 * If it is, we search that half; otherwise, we search the other half.
 */
public class ModifiedBinarySearch {
  public static void main(String[] args) {
    int[] array = {4, 5, 6, 7, 0, 1, 2};
    int target = 0;
    int result = findElementInRotatedSortedArray(array, target);
    System.out.println(result);
  }

  public static int findElementInRotatedSortedArray(int[] array, int target) {
    int left = 0, right = array.length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == target) {
        return mid;
      }

      if (array[left] <= array[mid]) {
        if (array[left] <= target && target < array[mid]) {
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      } else {
        if (array[mid] < target && target <= array[right]) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
    }

    return -1;
  }
}
