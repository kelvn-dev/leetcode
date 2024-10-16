public class TwoPointers {
  public static void main(String[] args) {
    int[] array = {2, 3, 5, 8, 9, 10, 11};
    System.out.println(isPairSum(array, 17));
  }

  // O(n)
  public static boolean isPairSum(int[] array, int target) {
    int length = array.length;
    int left = 0;
    int right = length - 1;
    while (left < right) {
      int sum = array[left] + array[right];
      if (sum == target) {
        return true;
      }
      if (sum < target) {
        ++left;
      } else {
        --right;
      }
    }
    return false;
  }
}
