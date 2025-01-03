import java.io.*;
import java.util.*;

public class Temp {

    public static void main(String[] args) throws IOException {
        SortedSet<Integer> set = new TreeSet<>();
        set.add(1);
        set.add(1);
        set.add(2);

        set.forEach(System.out::println);
    }
}
