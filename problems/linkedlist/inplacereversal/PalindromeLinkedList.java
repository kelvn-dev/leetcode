package problems.linkedlist.inplacereversal;

import problems.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        int[] values = {1,2,3,2,1};
        ListNode head = ListNode.createLinkedList(values);
        boolean result = isPalindrome(head);
        System.out.println(result);
    }

    /**
     * Use fast slow pointer to find the middle
     * Reverse the second half and compare it with the first half
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        /**
         * At this stage, slow sit at start of second half
         * Reverse the second half (see ReverseLinkedList)
         */
        ListNode pre = null;
        ListNode current = slow;
        while (current != null) {
            ListNode next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }

        ListNode left = head;
        ListNode right = pre;
        while (right != null) {
            if (right.val != left.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }
}
