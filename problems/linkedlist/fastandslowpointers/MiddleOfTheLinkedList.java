package problems.linkedlist.fastandslowpointers;

import problems.linkedlist.ListNode;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        int[] values = {1,2,3,4,5};
        ListNode head = ListNode.createLinkedList(values);
        ListNode result = middleNode(head);
        ListNode.printList(result);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
