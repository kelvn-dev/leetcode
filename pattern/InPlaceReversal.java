package pattern;

import datastructure.Node;

import java.util.Objects;

/**
 * LinkedList In-place Reversal
 * Use this pattern when you need to reverse sections of a linked list without using extra space
 *
 * Sample Problem:
 * Reverse a sublist of a linked list from position m to n.
 *
 * Example:
 *
 * Input: head = [1, 2, 3, 4, 5], m = 2, n = 4
 * Output: [1, 4, 3, 2, 5]
 */
public class InPlaceReversal {
  private Node<Integer> head = null;

  public void addFirst(int data) {
    head = new Node<>(data, head);
  }

  public void reverse() {
    if (Objects.isNull(head)) {
      return;
    }

    Node<Integer> pre = null;
    Node<Integer> current = head;
    Node<Integer> next;
    while (current != null) {
      next = current.getNext();
      current.setNext(pre);
      pre = current;
      current = next;
    }

    head = pre;
  }

  public void reverseBetween(int start, int end) {
    if (Objects.isNull(head) || start == end) {
      return;
    }

    Node<Integer> pre = null;
    Node<Integer> current = head;
    Node<Integer> next;
    for (int i = 1; i < start; i++) {
      pre = current;
      current = current.getNext();
    }

  Node<Integer> preBeforeReversedPortion = pre;
  Node<Integer> startOfReversedPortion = current;
    for (int i = start; i <= end; i++) {
      next = current.getNext();
      current.setNext(pre);
      pre = current;
      current = next;
    }

    /**
     * at this time, we only got this reversed portion: 2 <- 3 <- 4, 1 still -> 2 and there is no node point to 5
     * so we need to point from 1 (preBeforeReversedPortion) to 4, 2 (startOfReversedPortion) to 5
     */
    preBeforeReversedPortion.setNext(pre);
    startOfReversedPortion.setNext(current);
  }

  public void print() {
    Node<Integer> temp = head;
    while (Objects.nonNull(temp)) {
      System.out.print(temp.getData() + " ");
      temp = temp.getNext();
    }
  }
}
