package problems.linkedlist;

public class AddTwoNumbers {
    public static void main(String[] args) {
        int[] values1 = {9,9,9,9,9,9,9};
        int[] values2 = {9,9,9,9};
        ListNode head1 = ListNode.createLinkedList(values1);
        ListNode head2 = ListNode.createLinkedList(values2);
        ListNode result = addTwoNumbers(head1, head2);
        ListNode.printList(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            int sum = value1 + value2 + carry;
            current.next = new ListNode(sum % 10);
            current = current.next;

            carry = sum / 10;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummy.next;
    }
}
