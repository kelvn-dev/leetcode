package algorithm;

/**
 * Applied for sorted array
 */
public class BinarySearch {
  public static void main(String[] args) {
    int[] array = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
    int position = search(array, 16);
    System.out.println(position);
  }

  // O(log n)
  public static int search(int[] array, int key) {
    int length = array.length;
    int left = 0;
    int right = length - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (array[mid] == key) {
        return mid;
      }
      if (array[mid] > key) {
        right = mid - 1;
      }
      else {
        left = mid + 1;
      }
    }
    return -1; // return left if find position to insert
  }
}
