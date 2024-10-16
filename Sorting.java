public class Sorting {
  public static void main(String[] args) {
    int[] arr = new int[]{3, 4, 1, 2, 5};
    insertionSort(arr);
    for(int i: arr) {
      System.out.println(i);
    }
  }

  /**
   * Bubble sort
   * - Works by repeatedly swapping the adjacent elements if they are in the wrong order
   * - It is a stable sorting algorithm
   */
  public static void bubbleSort(int[] array) {
    for (int i = 0; i < array.length; ++i) {
      boolean swapped = false;
      for (int j = 0; j < array.length - i - 1; ++j) {
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          swapped = true;
        }
      }

      if (!swapped) {
        break;
      }
    }
  }

  /**
   * Insertion sort
   * - Works by iteratively inserting each unsorted element into its correct position in a sorted portion
   * - It is a stable sorting algorithm (elements with equal values maintain their relative order)
   */
  public static void insertionSort(int[] array) {
    for (int i = 1; i < array.length; ++i) {
      int key = array[i];
      int j = i - 1;

      /* Move elements of arr[0..i-1], that are greater than key, 1 step back of their current position */
      while (j >= 0 && array[j] > key) {
        array[j + 1] = array[j];
        --j;
      }
      array[j + 1] = key;
    }
  }

  /**
   * Selection sort
   * - repeatedly selects the smallest (or largest) element from the unsorted portion and swaps it with the first element of the unsorted part
   * - It is not a stable sorting algorithm
   */
  public static void selectionSort(int[] array) {
    for (int i = 0; i < array.length - 1; ++i) {
      int minIndex = i;
      int minValue = array[minIndex];
      for (int j = i + 1; j < array.length; ++j) {
        if (minValue > array[j]) {
          minValue = array[j];
          minIndex = j;
        }
      }
      int temp = array[i];
      array[i] = array[minIndex];
      array[minIndex] = temp;
    }
  }
}
