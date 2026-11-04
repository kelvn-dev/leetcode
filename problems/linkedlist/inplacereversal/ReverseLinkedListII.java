package problems.linkedlist.inplacereversal;

import problems.linkedlist.ListNode;

public class ReverseLinkedListII {
    public static void main(String[] args) {
        int[] values = {1,2,3,4,5};
        ListNode head = ListNode.createLinkedList(values);
        int left = 2;
        int right = 4;
        ListNode result = reverseBetween(head, left, right);
        ListNode.printList(result);
    }

    /**
     * Repeatedly pull the node after current out and put it in the front of the reversed section
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        int count = right - left;
        if (head == null || head.next == null || count == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        for (int i = 0; i < left - 1; ++i) {
            temp = temp.next;
        }

        ListNode preLeft = temp;
        ListNode current = temp.next;
        for (int i = 0; i < count; ++i) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = preLeft.next;
            preLeft.next = next;
        }

        return dummy.next;
    }
}
