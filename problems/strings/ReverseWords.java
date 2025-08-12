package problems.strings;

public class ReverseWords {
    public static void main(String[] args) {
        String s = "a good   example";
//        "example good a"
        String result = reverseWords(s);
        System.out.println(result);
    }

    public static String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        char[] chars = s.trim().toCharArray();
        int index = 0;
        for (char c: chars) {
            if (c == ' ') {
                index = 0;
                if (result.charAt(0) != ' ') {
                    result.insert(0, c);
                }
                continue;
            }
            result.insert(index++, c);
            /**
             * result.insert(index, c);
             * ++index
             */
        }

        return result.toString();
    }

    /**
     * Built-in function approach
     */
//    public static String reverseWords(String s) {
//        String[] words = s.trim().split("\\s+");
//        StringBuilder result = new StringBuilder();
//        for (int i = words.length - 1; i >= 0; --i) {
//            result.append(words[i]);
//            result.append(" ");
//        }
//        return result.toString().trim();
//    }
}
