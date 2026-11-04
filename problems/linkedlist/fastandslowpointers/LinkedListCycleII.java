package problems.linkedlist.fastandslowpointers;

import problems.linkedlist.ListNode;

import java.util.Map;

public class LinkedListCycleII {
    public static void main(String[] args) {
        int[] values = {3,2,0,-4};
        ListNode head = ListNode.createLinkedList(values);
        ListNode result = detectCycle(head);
        System.out.println(result != null ? result.val : null);
    }

    /**
     * According to Floyd's algorithm, after slow and fast meet, reset 1 pointer to head and advance both 1 step at a time to find start point of cycle
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
