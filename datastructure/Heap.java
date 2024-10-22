package datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * a special type of binary tree where all the levels of the tree are filled completely except the lowest level nodes
 * which are filled from as left as possible (Complete Binary Tree)
 *
 *                             A
 *                            / \
 *                           B   C
 *                          / \  /
 *                         D   E F
 *
 * Max-Heap: the value of the root node must be the greatest among all its child nodes (the same thing for its left and right sub-tree)
 * Min-Heap: the value of the root node must be the smallest among all its child nodes (the same thing for its left and right sub-tree)
 *
 * No built-in for heap but it's officially told by Oracle to use Priority Queue as a Heap
 */
public class Heap {
  public static void main(String[] args) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    maxHeap.add(2);
    maxHeap.add(3);
    maxHeap.add(1);
    System.out.println(maxHeap.peek());
    maxHeap.remove(maxHeap.peek());
    System.out.println(maxHeap.peek());
  }
}
