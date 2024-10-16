public class BinarySearch {
  public static void main(String[] args) {
    int[] array = {1, 2, 4};
//    int[] array = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
    int position = search(array, 3);
    int mid = 3 / 2;
    System.out.println(mid);
//    System.out.println(position);
  }

  // O(log n)
  public static int search(int[] array, int key) {
    int length = array.length;
    int left = 0;
    int right = length - 1;
    while (left < right) {
      int pivot = (right + left) / 2;
      if (array[pivot] == key) {
        return pivot;
      }
      if (array[pivot] > key) {
        right = pivot - 1;
      }
      else {
        left = pivot + 1;
      }
    }
    return -1;
  }
}
