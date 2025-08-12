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

        String temp = s;
        for (char c: t.toCharArray()) {
            if (c == temp.charAt(0)) {
                temp = temp.substring(1);
                if (temp.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }
}
