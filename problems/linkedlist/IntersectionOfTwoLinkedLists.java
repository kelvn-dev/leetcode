package problems.linkedlist;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        int[] A = {4, 1};
        int[] B = {5, 6, 1};
        int[] intersection = {8, 4, 5};

        ListNode intersectionHead = ListNode.createLinkedList(intersection);

//        ListNode headA = ListNode.createLinkedList(A, intersectionHead);
//        ListNode headB = ListNode.createLinkedList(B, intersectionHead);

        ListNode headA = ListNode.createLinkedList(A);
        ListNode headB = ListNode.createLinkedList(B);

        ListNode result = getIntersectionNode(headA, headB);
        System.out.println(result != null ? result.val : null);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }

}
