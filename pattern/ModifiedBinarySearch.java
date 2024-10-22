package pattern;

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
      int mid = (right + left) / 2;
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
