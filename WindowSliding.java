import java.util.Arrays;
// O(n)
public class WindowSliding {

  public static void main(String[] args) {
//    int[] arr = { 1, 4, 2, 10, 2, 3, 1, 0, 20 };
//    int max = getMaxSumOfSubArray(arr, 4);

    String text = "forxxorfxdofr";
    String word = "for";
    System.out.print(countAnagrams(text, word));
  }

  public static int getMaxSumOfSubArray(int[] array, int k) {
    int length = array.length;
    if (length < k) {
      return -1;
    }

    int sum = 0;
    for (int i = 0; i < k; ++i) {
      sum += array[i];
    }
    int max = sum;
    for (int i = k; i < length; ++i) {
      sum += array[i] - array[i - k];
      max = Math.max(sum, max);
    }
    return max;
  }

  public static int countAnagrams(String text, String word) {
    /**
     * Input: text = gotxxotgxdogt, word = got
     * Output : 3
     * Words “got,” “otg” and “ogt” are anagrams of “got.”
     */

    // change CHARACTERS to support range of supported characters
    int CHARACTERS = 256;
    int textLength = text.length();
    int wordLength = word.length();
    int count = 0;

    if (textLength < wordLength) {
      return 0;
    }

    char[] textArr = new char[CHARACTERS];
    char[] wordArr = new char[CHARACTERS];

    // till window size
    for (int i = 0; i < wordLength; i++) {
      textArr[CHARACTERS - text.charAt(i)]++;
      wordArr[CHARACTERS - word.charAt(i)]++;
    }

    if (Arrays.equals(wordArr, textArr)) {
      count += 1;
    }

    // next window
    for (int i = wordLength; i < textLength; i++) {
      textArr[CHARACTERS - text.charAt(i)]++;
      textArr[CHARACTERS - text.charAt(i - wordLength)]--;

      if (Arrays.equals(wordArr, textArr)) {
        count += 1;
      }
    }
    return count;
  }
}
