import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Temp {
    public static void main(String[] args) {
        int a = TempInter.var;
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Collections.reverseOrder());
        String s = "ace";
        s.hashCode()
        String t = "abcde";
        System.out.println(isSubsequence(s, t));
//        for (int i: nums) {
//            System.out.print(i + " ");
//        }
    }

    public static boolean isSubsequence(String s, String t) {
        Queue<Character> stack = new ArrayDeque<>();
        for (char c: t.toCharArray()) {
            stack.add(c);
        }

        for (char c: s.toCharArray()) {
            boolean found = false;
            while (!stack.isEmpty()) {
                if (stack.remove() == c) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }
}
