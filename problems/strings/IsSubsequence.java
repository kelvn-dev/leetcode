package problems.strings;

public class IsSubsequence {
    public static void main(String[] args) {
        String s = "";
        String t = "ahbgdc";
        boolean result = isSubsequence(s, t);
        System.out.println(result);
    }

    public static boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }

        for (char c: t.toCharArray()) {
            if (c == s.charAt(0)) {
                s = s.substring(1);
                if (s.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }
}
