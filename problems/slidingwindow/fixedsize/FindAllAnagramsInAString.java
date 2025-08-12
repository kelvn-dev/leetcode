package problems.slidingwindow.fixedsize;

import java.util.*;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        String s = "cbaebabacd", p = "abc";
        List<Integer> result = findAnagrams(s, p);
        result.forEach(r -> System.out.println(r));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        int characterRange = 256;
        int[] sArray = new int[characterRange];
        int[] pArray = new int[characterRange];

        for (int i = 0; i < p.length(); ++i) {
            ++sArray[s.charAt(i)];
            ++pArray[p.charAt(i)];
        }

        List<Integer> result = new ArrayList<>();
        if (Arrays.equals(sArray, pArray)) {
            result.add(0);
        }

        for (int i = p.length(); i < s.length(); ++i) {
            ++sArray[s.charAt(i)];
            --sArray[s.charAt(i - p.length())];
            if (Arrays.equals(sArray, pArray)) {
                result.add(i - p.length() + 1);
            }
        }

        return result;
    }
}
