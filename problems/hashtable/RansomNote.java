package problems.hashtable;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magazineMap = new HashMap<>();

        for (char c: magazine.toCharArray()) {
            magazineMap.put(c, magazineMap.getOrDefault(c, 0) + 1);
        }

        for (char c: ransomNote.toCharArray()) {
            if (!magazineMap.containsKey(c)) {
                return false;
            }
            int fre = magazineMap.get(c);
            if (fre == 0) {
                return false;
            }
            magazineMap.put(c, fre - 1);
        }

        return true;
    }
}
