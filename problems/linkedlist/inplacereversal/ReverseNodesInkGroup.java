package problems.linkedlist.inplacereversal;

import problems.linkedlist.ListNode;

public class ReverseNodesInkGroup {
    public static void main(String[] args) {
        int[] values = {1,2,3,4,5};
        ListNode head = ListNode.createLinkedList(values);
        int k = 2;
        ListNode result = reverseKGroup(head, k);
        ListNode.printList(result);
    }

    /**
     * Repeatedly pull the node after current out and put it in the front of the reversed section
     * Shift current to next after doing that for k time
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode temp = head;
        int length = 0;
        while (temp != null) {
            ++length;
            temp = temp.next;
        }

        int time = length / k;
        int count = 1;
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        ListNode current = pre.next;
        while (current != null && current.next != null) {
            ListNode next = current.next;
            current.next = next.next;
            next.next = pre.next;
            pre.next = next;

            ++count;
            if (count == k) {
                --time;
                if (time == 0) {
                    break;
                }

                pre = current;
                current = current.next;
                count = 1;
            }
        }

        return dummy.next;
    }
}
