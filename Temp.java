import java.io.*;
import java.util.*;

public class Temp {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int count = 0;

        while (true) {
            int num = scanner.nextInt();
            if (num == -1) {
                break;
            }
            max = Math.max(max, num);
            sum += num;
            ++count;
        }
        double average = count != 0 ? (double) sum / count : 0;
        System.out.print(max + " " + average);
    }
}
