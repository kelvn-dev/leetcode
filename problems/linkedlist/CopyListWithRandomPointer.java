package problems.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * When building the copy node by node, the random pointer might reference a node that haven't created yet
     * In the first pass, create a copy of every node and use hashmap to store the mapping from original to copy
     * In the second pass, translate original references into copy references
     * @param head
     * @return
     */
    public static Node copyRandomList(Node head) {
        // Pass 1: create copy nodes and build the mapping
        Map<Node, Node> map = new HashMap<>();
        Node current = head;
        while (current != null) {
            map.put(current, new Node(current.val));
            current = current.next;
        }

        // Pass 2: wire up next and random pointer
        current = head;
        while (current != null) {
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }

        return map.get(head);
    }
}
