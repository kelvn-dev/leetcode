package problems.linkedlist;

public class FlattenMultilevelDoublyLinkedList {

    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public static void main(String[] args) {

    }

    /**
     * If there is child while iterating:
     * - Point curr.next to child and vice versa
     * - Point child's tail.next to curr.next and vice versa
     */
    public Node flatten(Node head) {
        Node curr = head;

        while (curr != null) {
            if (curr.child != null) {
                Node next = curr.next;

                Node childTail = curr.child;
                while (childTail.next != null) {
                    childTail = childTail.next;
                }
                childTail.next = next;
                if (next != null) {
                    next.prev = childTail;
                }

                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null; // clear child pointer for valid doubly linked list
            }
            curr = curr.next;
        }

        return head;
    }
}
