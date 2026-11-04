package problems.linkedlist;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5};
        int n = 2;
        ListNode head = ListNode.createLinkedList(values);
        ListNode result = removeNthFromEnd(head, n);
        ListNode.printList(result);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n; ++i) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
