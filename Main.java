import java.lang.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] arr = {12, 35, 1, 10, 34, 1, 34};
    System.out.println(getSecondMaxValueIndex(arr));
  }

//  public static int getSecondMaxValueIndex(int arr[]) {
//    int tempArr[] = Arrays.stream(arr).toArray();
//    Arrays.sort(tempArr);
//    int secondValue = tempArr[arr.length - 2];
//    for (int i = 0; i < arr.length; ++i) {
//     if (arr[i] == secondValue) {
//       return i;
//     }
//    }
//    return -1;
//  }

  public static int getSecondMaxValueIndex(int arr[]) {
    int[] tempArr = new int[2];

    int maxIndex;
    int secondMaxIndex;
    if (arr[0] > arr[1]) {
      tempArr[0] = arr[0];
      tempArr[1] = arr[1];
      maxIndex = 0;
      secondMaxIndex = 1;
    } else {
      tempArr[0] = arr[1];
      tempArr[1] = arr[0];
      maxIndex = 1;
      secondMaxIndex = 0;
    }

    for (int i = 2; i < arr.length; ++i) {
      if (arr[i] > tempArr[0]) {
        tempArr[1] = tempArr[0];
        tempArr[0] = arr[i];
        secondMaxIndex = maxIndex;
        maxIndex = i;
      } else if (arr[i] > tempArr[1]) {
        tempArr[1] = arr[i];
        secondMaxIndex = i;
      }
    }

    return secondMaxIndex;
  }
}

