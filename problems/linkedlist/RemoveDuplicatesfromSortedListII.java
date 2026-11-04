package problems.linkedlist;

public class RemoveDuplicatesfromSortedListII {
    public static void main(String[] args) {
        int[] vals = {1,1,1,2,3};
        ListNode head = ListNode.createLinkedList(vals);
        ListNode result = deleteDuplicates(head);
        ListNode.printList(result);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = dummy;
        while (fast != null) {
            if (fast.next != null && fast.val == fast.next.val) {
                while (fast.next != null && fast.val == fast.next.val) {
                    fast = fast.next;
                }
                fast = fast.next;
                continue;
            }

            slow.next = fast;
            slow = fast;
            fast = fast.next;
        }

        slow.next = fast;
        return dummy.next;
    }
}
