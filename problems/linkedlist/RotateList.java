package problems.linkedlist;

public class RotateList {
    public static void main(String[] args) {
        int[] values = {1,2,3,4,5};
        int k = 2;
        ListNode head = ListNode.createLinkedList(values);
        ListNode result = rotateRight(head, k);
        ListNode.printList(result);
    }

    /**
     * Connect tail to head to create a circular linkedlist, then walk to the new tail position and break the circle there
     * New tail is node at index length - k - 1
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode temp = dummy.next;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            ++length;
        }

        k = k % length;
        if (k == 0) {
            return head;
        }

        temp.next = head;
        temp = dummy;

        int lastIndexAfterRotating = length - k;
        for (int i = 0; i < lastIndexAfterRotating; ++i) {
            temp = temp.next;
        }

        dummy.next = temp.next;
        temp.next = null;

        return dummy.next;
    }
}
