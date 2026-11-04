package problems.linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
        next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode createLinkedList(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val: vals) {
            current.next = new ListNode(val);
            current = current.next;
        }

        return dummy.next;
    }

    public static ListNode createLinkedList(int[] vals, ListNode tail) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val: vals) {
            current.next = new ListNode(val);
            current = current.next;
        }
        current.next = tail;
        return dummy.next;
    }

    public static void printList(ListNode head) {
        StringBuilder stringBuilder = new StringBuilder();
        while (head != null) {
            stringBuilder.append(head.val);
            if (head.next != null) {
                stringBuilder.append(",");
            }
            head = head.next;
        }
        System.out.println(stringBuilder.toString());
    }
}
