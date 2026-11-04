package problems.linkedlist;

public class SwapNodesInPairs {
    public static void main(String[] args) {
        int[] values = {1};
        ListNode head = ListNode.createLinkedList(values);
        ListNode result = swapPairs(head);
        ListNode.printList(result);
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy;
        while (temp.next != null && temp.next.next != null) {
            ListNode first = temp.next;
            ListNode second = temp.next.next;
            first.next = second.next;
            second.next = first;
            temp.next = second;
            temp = first;
        }
        return dummy.next;
    }
}
