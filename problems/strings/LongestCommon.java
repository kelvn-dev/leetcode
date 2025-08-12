package problems.strings;

public class LongestCommon {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower","flow","flight"};
        String longestCommonPrefix = longestCommonPrefix(strs);
//        System.out.println(longestCommonPrefix);
        System.out.println(longestCommonSubstring(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        StringBuilder longestCommon = new StringBuilder(strs[0]);
        for (int i = 1; i < strs.length; ++i) {
            String str = strs[i];
            while (str.indexOf(longestCommon.toString()) != 0) {
                longestCommon.deleteCharAt(longestCommon.length() - 1);
                if (longestCommon.length() == 0) {
                    return "";
                }
            }
        }

        return longestCommon.toString();
    }

    public static String longestCommonSubstring(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String longestCommon = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            String str = strs[i];
            findCommonSubstringLoop:
            for (int len = longestCommon.length(); len > 0; len--) {
                for (int startIndex = 0; startIndex <= longestCommon.length() - len; startIndex++) {
                    String sub = longestCommon.substring(startIndex, startIndex + len);
                    if (str.contains(sub)) {
                        longestCommon = sub;
                        break findCommonSubstringLoop;
                    }
                }
            }
        }

        return longestCommon;
    }

}
