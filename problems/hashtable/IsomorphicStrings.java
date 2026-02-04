package problems.hashtable;

/**
 *  All characters in s and t must be replaceable symmetrically. For ex, 'a' already map to replace 'b', later cannot use it to replace 'c'
 */
public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "aabba";
        String t = "bbaaa";
        System.out.println(isIsomorphic(s, t));
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int CAPACITY = 256;
        int[] sArray = new int[CAPACITY];
        int[] tArray = new int[CAPACITY];

        for (int i = 0; i < s.length(); ++i) {
            char sCharacter = s.charAt(i);
            char tCharacter = t.charAt(i);

            if (sArray[tCharacter] != tArray[sCharacter]) {
                return false;
            }

            sArray[tCharacter] = i + 1;
            tArray[sCharacter] = i + 1;
        }

        return true;
    }
}
