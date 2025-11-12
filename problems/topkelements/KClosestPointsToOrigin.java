package problems.topkelements;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        int[][] points = {
                {3,3},
                {5,-1},
                {-2,4}
        };
        int k = 2;
        int[][] result = kClosest(points, k);
        for (int[] i: result) {
            for (int j: i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Comparator.comparingDouble((int[] point) -> (point[0] * point[0] + point[1] * point[1])).reversed());
        for (int[] point: points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int index = 0;
        while (index < k) {
            result[index] = maxHeap.poll();
            ++index;
        }

        return result;
    }
}
