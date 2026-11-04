package problems.linkedlist.inplacereversal;

import problems.linkedlist.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        int[] values = {1,2,3,4,5};
        ListNode head = ListNode.createLinkedList(values);
        ListNode result = reverseList(head);
        ListNode.printList(result);
    }

    /**
     * null -> 1 -> 2 -> 3 -> null
     * null <- 1 <- 2 <- 3
     */
    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        return pre;
    }
}
