package problems.hashtable;

public class NumberOfGoodWaysToSplitAString {
    public static void main(String[] args) {
        String s = "aacaba";
        System.out.println(numSplits(s));
    }

    public static int numSplits(String s) {
        int CAPACITY = 26;

        int[] rightArray = new int[CAPACITY];
        int rightDistinct = 0;
        for (char c: s.toCharArray()) {
            if (rightArray[c - 'a'] == 0) {
                ++rightDistinct;
            }
            ++rightArray[c - 'a'];
        }

        int[] leftArray = new int[CAPACITY];
        int leftDistinct = 0;
        int count = 0;
        for (char c: s.toCharArray()) {
            if (leftArray[c - 'a'] == 0) {
                ++leftDistinct;
            }
            ++leftArray[c - 'a'];

            --rightArray[c - 'a'];
            if (rightArray[c - 'a'] == 0) {
                --rightDistinct;
            }

            if (leftDistinct == rightDistinct) {
                ++count;
            }
        }

        return count;
    }
}
